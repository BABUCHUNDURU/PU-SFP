def loan = period.commonLineLoan
def periodsAssociatedToLoan = nfrConfig.evalPeriods().filter { p -> p.commonLineLoan.equals(loan) }
def allAttendedTermPeriods = acys.getTerms().filter { t -> t.isAttending() }
def periodsAssociatedToLoanBeingAttended = periodsAssociatedToLoan.filter {
    p ->
        allAttendedTermPeriods
                .filter { t -> t.startDate.equals(p.startDate) && t.endDate.equals(p.endDate) }
                .size() == 1
}

int nbPeriods = periodsAssociatedToLoanBeingAttended.size()
int periodIndex = periodsAssociatedToLoan.indexOf(period)
if (periodIndex == -1) {
    log.debug("Period index can't be found for fund {} for acy {} period {} using CLUID {}, periodsAssociatedToLoan={}",
            fundCode, acy.number, period.number, loan.commonLineUniqueId, periodsAssociatedToLoan)
    return 0
}
if (loan.recordStatus == "LOAN_TERMINATED") {
    log.debug("Setting zero amount for terminated loan, fund {} for acy {} period {} using CLUID {}, periodIndex={}, nbPeriods={}",
            fundCode, acy.number, period.number, loan.commonLineUniqueId, periodIndex, nbPeriods)
    return 0
}
def currentTerm = acys.getTerms().find { t -> t.startDate.equals(period.startDate) && t.endDate.equals(period.endDate) }
if (currentTerm == null) {
    log.debug("Setting zero amount for not found current term, fund {} for acy {} period {} using CLUID {}, periodIndex={}, nbPeriods={}",
            fundCode, acy.number, period, loan.commonLineUniqueId, periodIndex, nbPeriods)
    return 0
}
if (currentTerm.isNotAttending()) {
    log.debug("Setting zero amount for not attending term, fund {} for acy {} period {} term {} using CLUID {}, periodIndex={}, nbPeriods={}",
            fundCode, acy.number, period.number, currentTerm.number, loan.commonLineUniqueId, periodIndex, nbPeriods)
    return 0
}
int loanPeriodNumber = periodIndex+1
if (loan.isDisbursed(loanPeriodNumber)) {
    return (int) loan.getPpAmount(loanPeriodNumber)
}

int totalDisbursedAmount = 0
int disbursedPeriods = 0
for (lpNumber in 1..4) {
    if (loan.isDisbursed(lpNumber)) {
        totalDisbursedAmount += (int) loan.getPpAmount(lpNumber)
        disbursedPeriods++
    }
}

int amountLeft = loan.requestedLoanAmount - totalDisbursedAmount
int periodsLeft = nbPeriods - disbursedPeriods

if (periodsLeft == 0) {
    log.debug("No periods left for fund {} for acy {} period {} using CLUID {}, from total {} and disbursed {}, unknown period {}",
            fundCode, acy.number, period.number, loan.commonLineUniqueId, nbPeriods, disbursedPeriods, period)
    return 0
}

int roundedAmount = (int) (amountLeft / periodsLeft)
int amount = periodIndex < amountLeft % periodsLeft
        ? roundedAmount + 1
        : roundedAmount
log.debug("Setting amount for fund {} for acy {} period {} using CLUID {}, amount={}, periodIndex={}, nbPeriods={}, disbursedPeriods={}",
        fundCode, acy.number, period.number, loan.commonLineUniqueId, amount, periodIndex, nbPeriods, disbursedPeriods)

return amount
