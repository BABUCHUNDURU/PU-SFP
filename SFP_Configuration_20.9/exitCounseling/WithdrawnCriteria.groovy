boolean returnValue = false;

/* no API available for disbursements, and no way to separate out TEACH criteria based on current design */

if (primaryProgram.getEnrollmentStatus() == "W")
{
    returnValue = true;
}
return returnValue;