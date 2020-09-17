String isirStudentISIRValueForCorrection = isirRecord.getIsirFieldValue("HSDIPLOMAOREQUIVALENT");

if (receivedDocuments.hasDoc("HSDiploma","Student") && receivedDocuments.get("HSDiploma","Student").isAcceptable())
{
    if (isirStudentISIRValueForCorrection != "1")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "1";
        return;
    }
}


if (receivedDocuments.hasDoc("HSTranscript","Student") && receivedDocuments.get("HSTranscript","Student").isAcceptable())
{
    if (isirStudentISIRValueForCorrection != "1")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "1";
        return;
    }
}

if (receivedDocuments.hasDoc("GEDCert","Student") && receivedDocuments.get("GEDCert","Student").isAcceptable())
{
    if (isirStudentISIRValueForCorrection != "2")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "2";
        return;
    }
}

if (receivedDocuments.hasDoc("GEDTranscript","Student") && receivedDocuments.get("GEDTranscript","Student").isAcceptable())
{
    if (isirStudentISIRValueForCorrection != "2")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "2";
        return;
    }
}

if (receivedDocuments.hasDoc("HomeSchoolCert","Student") && receivedDocuments.get("HomeSchoolCert","Student").isAcceptable())
{
    if (isirStudentISIRValueForCorrection != "3")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "3";
        return;
    }
}