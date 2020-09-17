import org.joda.time.LocalDate;

boolean returnValue = false;
LocalDate academicCompletionDate = primaryProgram.getAcademicCompletionDate();

/* no API available for disbursements, and no way to separate out TEACH criteria based on current design */

if (academicCompletionDate != null)
{
    returnValue = true;
}
return returnValue;