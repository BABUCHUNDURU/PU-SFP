import com.oracle.sfp.scripting.api.IAcademicTermPeriodsAPI
import com.oracle.sfp.scripting.api.ICommonLineLoanAPI
import com.oracle.sfp.scripting.api.ICommonLineUniqueId
import com.oracle.sfp.scripting.api.NfrPeriod

// Replace this code with your code
def alternativeLoanProgramTypeCode = "091"

def getCLUIDsDisbursedInOtherFunds() {
    Set<ICommonLineUniqueId> otherFundsDisbursedCLUIDs = [];
    if (financialPlan.version > 1) {
        otherFundsDisbursedCLUIDs = previousFinancialPlan
                .withVersion(financialPlan.version - 1)
                .filterFunds { f -> !f.equals(fundCode) && isDisbursed(f) }
                .getCommonLineUniqueIds()
    }
    otherFundsDisbursedCLUIDs
}

/**
 * Indicate if the fund has already been disbursed across all academic years
 */
def isDisbursed(String fundCode) {
    disbursements
            .getWithFundCode(fundCode)
            .getWithStatus("DISBURSED")
            .getTotalDisbursementAmount() > 0
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


// Get the list of all CLUIDs that are already disbursed
def otherFundsDisbursedCLUIDs = getCLUIDsDisbursedInOtherFunds()
int loanIndex = -1;
return commonLineLoans
        .filter { loan -> loan.processingStatus != "COMMON_LINE_UNIQUE_ID_CHANGED" }
        .filter { loan -> !otherFundsDisbursedCLUIDs.contains(loan.commonLineUniqueId) }
        .filter { loan ->
            loan.getAlternativeLoanProgramTypeCode().equals(alternativeLoanProgramTypeCode) && loan.getRequestedLoanAmount() > 0
        }
        .filter { loan -> hasTermsInCurrentAcademicYear(loan) }
        .orderedBy(new OrderBy([{ it.startDate }, { it.commonLineUniqueId }]))
        .collectMany { loan ->
            loanIndex++;
            def loanTerms = getAllLoanTermsAcrossPackage(loan)
            loanTerms
                    .collect { period ->
                        int periodNumber = loanIndex * 10 + period.number;
                        log.debug("Associating fund {} for period {} starting on {} with CLUID {}",
                                fundCode, periodNumber, period.startDate, loan.commonLineUniqueId)
                        new NfrPeriod(periodNumber, period)
                                .withCommonLineLoan(loan)
                    }
        }