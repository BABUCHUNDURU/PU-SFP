if (isirRecord == null)
{
    return;
}

String currentDocSignatureLastName = currentDocument.getDocumentFieldValue("AC1094");

String isirStudentLastName = isirRecord.getIsirFieldValue("STUDENTLASTNAME");

if (currentDocSignatureLastName != null && !currentDocSignatureLastName.isAllWhitespace() && isirStudentLastName != null && !isirStudentLastName.isAllWhitespace())
{
    if (!isirStudentLastName.equalsIgnoreCase(currentDocSignatureLastName))
    {
        supportingDoc.addAnyDocuments(["LegalNameChange", "Student"], ["MarriageCertificate", "Student"],["DriversLicense", "Student"],["Passport", "Student"],["NonDriversLicenseID", "Student"]);
    }
}