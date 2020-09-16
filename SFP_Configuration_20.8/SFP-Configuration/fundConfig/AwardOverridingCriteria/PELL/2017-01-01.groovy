/* Baseline - Award Overriding Criteria for All Other TIV Funds - combined Term & Non-Term */

import org.joda.time.LocalDate;

if (program.getEnrollmentStatus() == "X")
{
    return awardInfo.withMaxAmount(0).withRetainedAmount(0);
}
if (program.isTerm())
{
    def overlappingTerms = primaryProgram.getTerms().getOverlappingWith(term);

    /* Methods returning collection, as well as filters, will be plural; otherwise singular */

    if (overlappingTerms.getStudentsTermStatuses().contains("WITHDRAWN")) 
    {
        log.debug("AWARD FREEZING CRITERIA - STUDENT TERM IS WITHDRAWN");
    
        def r2t4OverlappingTerms = r2t4.getOverlappingWith(term)
                .getWithProcessStatuses(["NOT_REQUIRED", "COMPLETED"])
                .getWithOldas(overlappingTerms.getOldas());
            
        if (!r2t4OverlappingTerms.isEmpty())
        {
            log.debug("AWARD FREEZING CRITERIA - R2T4 Overlapping Terms is not empty, FREEZING!");
        
            def sum = disbursements.getInAcademicYear(acyNo)
                    .getWithFundCode(fundCode)
                    .getInAwardYear(awy)
                    .getInLoanPeriod(lpNo)
                    .getInPaymentPeriod(ppNo)
                    .getCancelled(false)
					.getPpMaxDisbursementAmount();
                
            return awardInfo.withMaxAmount(sum); // withRetainedAmount cannot be used for grants currently
        } 
        else
        {
            log.debug("AWARD FREEZING CRITERIA - R2T4 PROCESS NOT YET IN A FREEZING STATE");
        }
    }
    if (sapStatus != null && sapStatus == "FD_FINANCIAL_AID_DISQUALIFICATION")
    {
        return awardInfo.withMaxAmount(0).withRetainedAmount(0);
    }
    
    //Preventing Summer Terms from being Awarded until Academic Year has ended
    def freezingDateForStandard = acy.getTerms()
		.filter {t -> t.isSummerTrailer() && t.isAttending() } 
		.min() // get the earliest (yields an optional value)
		.map {t -> t.getStartDate()} // map optional to its start date
		.getOrElse(acy.getEndDate()); // if optional absent (no summer trailers) take acy.getEndDate
	
	def now = LocalDate.now();

    if (log.debug(acy.getEndDate() <= now, "ACADEMIC YEAR PERIOD IN THE PAST") // Update this line to determine when to freeze the standard terms and roll over unused funds to summer terms
    	|| log.debug(term.isStandard() && freezingDateForStandard <= now, "SUMMER TRAILER STARTING")
    	|| log.debug(term.isSummerHeader(), "SUMMER HEADER")
    	|| log.debug(term.isSummerTrailer() && now < freezingDateForStandard, "TOO EARLY FOR SUMMER TRAILER"))
    {
        def sum = disbursements.getInAcademicYear(acyNo)
               .getWithFundCode(fundCode)
               .getInAwardYear(awy)
			   .getInLoanPeriod(lpNo) // This can be used for grants. Has no effect.
               .getInPaymentPeriod(ppNo)
               .getCancelled(false)
		       .getTotalDisbursementAmount();
    	log.debug("FREEZING TO {}", sum);               
       	return awardInfo.withMaxAmount(sum); // withRetainedAmount cannot be used for grants currently
    }		
		
}
return awardInfo;