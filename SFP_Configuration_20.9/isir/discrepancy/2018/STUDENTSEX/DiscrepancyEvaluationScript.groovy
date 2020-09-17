String documentField = "AC1004";
String isirStudentISIRValueForCorrection = isirRecord.getIsirFieldValue("STUDENTSEX");

String documentValue = "";

if (receivedDocuments.hasDoc("DriversLicense","Student") && receivedDocuments.get("DriversLicense","Student").isAcceptable() && receivedDocuments.get("DriversLicense", "Student").getDocumentField(documentField) != null && !receivedDocuments.get("DriversLicense", "Student").getDocumentField(documentField).isAllWhitespace())
{
    documentValue = receivedDocuments.get("DriversLicense", "Student").getDocumentField(documentField);
    if (documentValue == "Male" && isirStudentISIRValueForCorrection != "1")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "1";
        return;
    }
    if (documentValue == "Female" && isirStudentISIRValueForCorrection != "2")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "2";
        return;
    }
}

if (receivedDocuments.hasDoc("NonDriversLicenseID","Student") && receivedDocuments.get("NonDriversLicenseID","Student").isAcceptable() && receivedDocuments.get("NonDriversLicenseID", "Student").getDocumentField(documentField) != null && !receivedDocuments.get("NonDriversLicenseID", "Student").getDocumentField(documentField).isAllWhitespace())
{
    documentValue = receivedDocuments.get("NonDriversLicenseID", "Student").getDocumentField(documentField);
    if (documentValue == "Male" && isirStudentISIRValueForCorrection != "1")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "1";
        return;
    }
    if (documentValue == "Female" && isirStudentISIRValueForCorrection != "2")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "2";
        return;
    }
}


if (receivedDocuments.hasDoc("StateIssuedID","Student") && receivedDocuments.get("StateIssuedID","Student").isAcceptable() && receivedDocuments.get("StateIssuedID", "Student").getDocumentField(documentField) != null && !receivedDocuments.get("StateIssuedID", "Student").getDocumentField(documentField).isAllWhitespace())
{
    documentValue = receivedDocuments.get("StateIssuedID", "Student").getDocumentField(documentField);
    if (documentValue == "Male" && isirStudentISIRValueForCorrection != "1")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "1";
        return;
    }
    if (documentValue == "Female" && isirStudentISIRValueForCorrection != "2")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "2";
        return;
    }
}

if (receivedDocuments.hasDoc("Passport","Student") && receivedDocuments.get("Passport","Student").isAcceptable() && receivedDocuments.get("Passport", "Student").getDocumentField(documentField) != null && !receivedDocuments.get("Passport", "Student").getDocumentField(documentField).isAllWhitespace())
{
    documentValue = receivedDocuments.get("Passport", "Student").getDocumentField(documentField);
    if (documentValue == "Male" && isirStudentISIRValueForCorrection != "1")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "1";
        return;
    }
    if (documentValue == "Female" && isirStudentISIRValueForCorrection != "2")
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = "2";
        return;
    }
}