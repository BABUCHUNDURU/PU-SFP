/* Baseline - Award Overriding Criteria for DSUB DUNSUB - combined Term and Non-Term */
import org.joda.time.LocalDate;

optimizer
	.setCumulativeGradeLevelLimitApplicable(
		(term == null || term.isStandard())
		&& (program.isUndergraduate() || !isLastAcy))
	.setFundingForPeriodFilter {fundCode, fundType -> fundCode != "DISCOUNT"};

if (program.getEnrollmentStatus() == "X" || pp.getStatus() == "CANCELED")
{
    return awardInfo.withMaxAmount(0).withRetainedAmount(0);
}
if (program.isTerm())
{
    def overlappingTerms = primaryProgram.getTerms().getOverlappingWith(term);
    /* Methods returning collection, as well as filters, will be plural; otherwise singular */
    if (overlappingTerms.getStudentsTermStatuses().contains("WITHDRAWN")) 
    {
        log.debug("STUDENT TERM IS WITHDRAWN");
    
        def r2t4OverlappingTerms = r2t4.getOverlappingWith(term)
                .getWithProcessStatuses(["NOT_REQUIRED", "COMPLETED"])
                .getWithOldas(overlappingTerms.getOldas());
            
        if (!r2t4OverlappingTerms.isEmpty())
        {
            log.debug("R2T4 Overlapping Terms is not empty, FREEZING!");
        
            def sum = disbursements.getInAcademicYear(acyNo)
                    .getWithFundCode(fundCode)
                    .getInAwardYear(awy)
                    .getInLoanPeriod(lpNo)
                    .getInPaymentPeriod(ppNo)
                    .filterStatuses { status -> status != "DISBURSEMENT_CANCELED" }
                    .getPpMaxDisbursementAmount();
                
            return awardInfo.withMaxAmount(sum).withRetainedAmount(sum);
        } 
        else
        {
            log.debug("R2T4 PROCESS NOT YET IN A FREEZING STATE");
        }
    }
    
    if (enrollmentStatus == "NOT_ATTENDING" || enrollmentStatus == "LESS_THAN_HALF_TIME" || (sapStatus != null && sapStatus == "FD_FINANCIAL_AID_DISQUALIFICATION"))
    {
		log.debug("ZEROING - enrollmentStatus={}, sapStatus={} ", enrollmentStatus, sapStatus);
        return awardInfo.withMaxAmount(0).withRetainedAmount(0);
    }
    
	def freezingDateForStandard = acy.getTerms()
		.filter {t -> t.isSummerTrailer() && t.isAttending() } 
		.min() // get the earliest (yields an optional value)
		.map {t -> t.getStartDate()} // map optional to its start date
		.getOrElse(lp.getEndDate()); // if optional absent (no summer trailers) take lp.getEndDate

def now = LocalDate.now();

    if (log.debug(lp.getEndDate() <= now, "LOAN PERIOD IN THE PAST") // Update this line to determine when to freeze the standard terms and roll over unused funds to summer terms
    	|| log.debug(term.isStandard() && freezingDateForStandard <= now, "SUMMER TRAILER STARTING")
    	|| log.debug(term.isSummerHeader(), "SUMMER HEADER")
    	|| log.debug(term.isSummerTrailer() && now < freezingDateForStandard, "TOO EARLY FOR SUMMER TRAILER"))
    {
        def sum = disbursements.getInAcademicYear(acyNo)
               .getWithFundCode(fundCode)
               .getInAwardYear(awy)
               .getInLoanPeriod(lpNo)
               .getInPaymentPeriod(ppNo)
               .filterStatuses { status -> status != "DISBURSEMENT_CANCELED" }
               .getTotalDisbursementAmount();
    	log.debug("FREEZING TO {}", sum);               
       	return awardInfo.withMaxAmount(sum).withRetainedAmount(sum);
    }
}
return awardInfo;