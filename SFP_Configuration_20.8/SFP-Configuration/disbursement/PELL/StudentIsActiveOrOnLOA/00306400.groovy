if (term != null)
{
    String packagingEnrollmentStatus = term.getStatus();
    if (packagingEnrollmentStatus == "FULL_TIME" || packagingEnrollmentStatus == "HALF_TIME" || packagingEnrollmentStatus == "LESS_THAN_HALF_TIME" || packagingEnrollmentStatus == "THREE_QUARTER_TIME")
    {
        return true;
    }
    String programEnrollmentStatus = program.getEnrollmentStatus();
    if (programEnrollmentStatus == "A")
    {
        return true;
    }
}
else
{
   String programEnrollmentStatus = program.getEnrollmentStatus();
    if (programEnrollmentStatus == "F" || programEnrollmentStatus == "H" || programEnrollmentStatus == "L" || programEnrollmentStatus == "A")
    {
        return true;
    }
}
return false;