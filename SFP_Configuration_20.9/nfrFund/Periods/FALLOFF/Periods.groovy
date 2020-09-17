import com.oracle.sfp.scripting.api.IAcademicTermPeriodsAPI
import com.oracle.sfp.scripting.api.ICommonLineLoanAPI
import com.oracle.sfp.scripting.api.ICommonLineUniqueId
import com.oracle.sfp.scripting.api.NfrPeriod

/**
 * Get the list of CLUIDs that were associated to a previous package version of the current fund code.
 */
Set<ICommonLineUniqueId> getCLUIDsUsedByPreviousPackageVersion() {
    Set<ICommonLineUniqueId> usedCLUIDs = [];
    if (financialPlan.version > 1) {
        // Reuse the same loan in case this fund code is already associated to a fund code that was used on a previous package version
        usedCLUIDs = previousFinancialPlan
                .withVersion(financialPlan.version - 1)
                .getWithFundCode(fundCode)
                .getCommonLineUniqueIds()
        if (!usedCLUIDs.isEmpty()) {
            // Make sure the loan is not used by another fund in the new package version
            Set<ICommonLineUniqueId> otherFundsCLUID = financialPlan
                    .filterFunds { f -> !f.equals(fundCode) }
                    .getCommonLineUniqueIds()
            usedCLUIDs.removeAll(otherFundsCLUID)

            if (!usedCLUIDs.isEmpty()) {
                log.debug("Reusing CLUID {} for fund {} from previous package version", usedCLUIDs, fundCode)
            }
        }
    }
    usedCLUIDs
}

/**
 * Get the list of CLUIDs that are already associated to the current fund code in a prior academic year of that package.
 * This will allow a CLUID to span multiple academic years.
 */
Set<ICommonLineUniqueId> getCLUIDsUsedInPreviousAcademicYears() {
    // Reuse the same loan in case this fund code is already associated to a fund code that might span multiple academic years
    Set<ICommonLineUniqueId> usedCLUIDs = financialPlan
            .filterFunds(fundCode.&equals)
            .getCommonLineUniqueIds();
    if (!usedCLUIDs.isEmpty()) {
        log.debug("Reusing CLUID {} for fund {} from previous academic years", usedCLUIDs, fundCode)
    }
    usedCLUIDs
}

/**
 * Find the CL Loan API object that can be reused from the list of usedCLUIDs
 */
ICommonLineLoanAPI selectAlreadyUsedCLUID(Set<ICommonLineUniqueId> usedCLUIDs) {
    if (usedCLUIDs.isEmpty()) {
        return null;
    }
    commonLineLoans
            .filter { loan -> loan.processingStatus != "COMMON_LINE_UNIQUE_ID_CHANGED" }
            .filter { loan -> loan.getRequestedLoanAmount() > 0 }
            .filter { loan -> usedCLUIDs.contains(loan.getCommonLineUniqueId()) }
            .filter { loan -> hasTermsInCurrentAcademicYear(loan) }
            .max { loan -> loan.getRequestedLoanAmount() }
}

/**
 * Select the available CLUID with the maximum requested loan amount.
 */
ICommonLineLoanAPI selectNewCLUID() {
    commonLineLoans
            .filter { loan -> loan.processingStatus != "COMMON_LINE_UNIQUE_ID_CHANGED" }
            .filter { loan -> loan.getRequestedLoanAmount() > 0 }
            .filter { loan -> financialPlan.isUnmatchedCommonLineLoan(loan) }
            .filter { loan -> hasTermsInCurrentAcademicYear(loan) }
            .max { loan -> loan.getRequestedLoanAmount() }
}

/**
 * Get the list of terms that can be associated with the given loan.
 * All loan / term matching logic should happen here.
 */
IAcademicTermPeriodsAPI getLoanTerms(IAcademicTermPeriodsAPI terms, ICommonLineLoanAPI loan) {
    terms.getOverlappingWith(loan)
}

/**
 * Get the list of terms that can be associated to the given loan across all academic years of the current package.
 */
IAcademicTermPeriodsAPI getAllLoanTermsAcrossPackage(ICommonLineLoanAPI loan) {
    getLoanTerms(acys.getTerms(), loan)
}

/**
 * Indicate if the loan can be associated with the current academic year.
 */
boolean hasTermsInCurrentAcademicYear(ICommonLineLoanAPI loan) {
    !getLoanTerms(acy.getTerms(), loan).isEmpty()
}


Set<ICommonLineUniqueId> usedCLUIDs = getCLUIDsUsedByPreviousPackageVersion()
if (usedCLUIDs.isEmpty()) {
    usedCLUIDs = getCLUIDsUsedInPreviousAcademicYears()
}

ICommonLineLoanAPI selectedLoan = selectAlreadyUsedCLUID(usedCLUIDs)
if (selectedLoan == null) {
    selectedLoan = selectNewCLUID()
}

if (selectedLoan != null) {
    def loanTerms = getAllLoanTermsAcrossPackage(selectedLoan)
    return loanTerms
            .collect { period ->
                log.debug("Associating fund {} for period {} starting on {} with CLUID {}",
                        fundCode, period.number, period.startDate, selectedLoan.commonLineUniqueId)
                new NfrPeriod(period.getNumber(), period)
                        .withCommonLineLoan(selectedLoan)
            }
}
return []