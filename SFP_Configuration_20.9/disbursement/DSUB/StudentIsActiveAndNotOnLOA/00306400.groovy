if (term != null)
{
    String packagingEnrollmentStatus = term.getStatus();
    if (packagingEnrollmentStatus == "FULL_TIME" || packagingEnrollmentStatus == "HALF_TIME" || packagingEnrollmentStatus == "LESS_THAN_HALF_TIME" || packagingEnrollmentStatus == "THREE_QUARTER_TIME")
    {
        return true;
    }
}
else
{
   String programEnrollmentStatus = program.getEnrollmentStatus();
    if (programEnrollmentStatus == "F" || programEnrollmentStatus == "H" || programEnrollmentStatus == "L")
    {
        return true;
    }
}
return false;