String documentFieldAC1021 = "AC1021";
String isirStudentISIRValueForCorrection = isirRecord.getIsirFieldValue("STUDENTSEDUCATIONALCREDITS");
String isirStudentMaritalStatus = isirRecord.getIsirFieldValue("STUDENTMARITALSTATUS");

int isirStudentISIRValueForCorrectionValue = 0;
boolean isirStudentISIRValueForCorrectionBlank = true;
if (!isirStudentISIRValueForCorrection.isAllWhitespace())
{
    isirStudentISIRValueForCorrectionValue = isirStudentISIRValueForCorrection.toInteger();
    isirStudentISIRValueForCorrectionBlank = false;
}

int documentValue = 0;


if (isirStudentMaritalStatus == "1" || isirStudentMaritalStatus == "4" || isirStudentMaritalStatus.isAllWhitespace())
{
    if (receivedDocuments.hasDoc("TaxReturnTranscript","Student") && receivedDocuments.get("TaxReturnTranscript","Student").isAcceptable() && receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1021).toFloat().round();
        if (isirStudentISIRValueForCorrectionValue != documentValue)
        {
            discrepancyEvaluationResult.hasDiscrepancy = true;
            discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
            return;
        }
    }
}
if (isirStudentMaritalStatus == "2" || isirStudentMaritalStatus == "3")
{
    boolean hasDocumentValue = false;
    if (receivedDocuments.hasDoc("TaxReturnTranscript","Student") && receivedDocuments.get("TaxReturnTranscript","Student").isAcceptable() && receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1021).toFloat().round();
    }
    if (receivedDocuments.hasDoc("TaxReturnTranscript","Spouse") && receivedDocuments.get("TaxReturnTranscript","Spouse").isAcceptable() && receivedDocuments.get("TaxReturnTranscript", "Spouse").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("TaxReturnTranscript", "Spouse").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("TaxReturnTranscript", "Spouse").getDocumentField(documentFieldAC1021).toFloat().round();
    }
    
    if (hasDocumentValue && isirStudentISIRValueForCorrectionValue != documentValue)
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
        return;
    }
}
documentValue = 0;


if (isirStudentMaritalStatus == "1" || isirStudentMaritalStatus == "4" || isirStudentMaritalStatus.isAllWhitespace())
{
    if (receivedDocuments.hasDoc("1040","Student") && receivedDocuments.get("1040","Student").isAcceptable() && receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1021).toFloat().round();
        if (isirStudentISIRValueForCorrectionValue != documentValue)
        {
            discrepancyEvaluationResult.hasDiscrepancy = true;
            discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
            return;
        }
    }
}
if (isirStudentMaritalStatus == "2" || isirStudentMaritalStatus == "3")
{
    boolean hasDocumentValue = false;
    if (receivedDocuments.hasDoc("1040","Student") && receivedDocuments.get("1040","Student").isAcceptable() && receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1021).toFloat().round();
    }
    if (receivedDocuments.hasDoc("1040","Spouse") && receivedDocuments.get("1040","Spouse").isAcceptable() && receivedDocuments.get("1040", "Spouse").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("1040", "Spouse").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040", "Spouse").getDocumentField(documentFieldAC1021).toFloat().round();
    }
    
    if (hasDocumentValue && isirStudentISIRValueForCorrectionValue != documentValue)
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
        return;
    }
}
documentValue = 0;


if (isirStudentMaritalStatus == "1" || isirStudentMaritalStatus == "4" || isirStudentMaritalStatus.isAllWhitespace())
{
    if (receivedDocuments.hasDoc("1040x","Student") && receivedDocuments.get("1040x","Student").isAcceptable() && receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1021).toFloat().round();
        if (isirStudentISIRValueForCorrectionValue != documentValue)
        {
            discrepancyEvaluationResult.hasDiscrepancy = true;
            discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
            return;
        }
    }
}
if (isirStudentMaritalStatus == "2" || isirStudentMaritalStatus == "3")
{
    boolean hasDocumentValue = false;
    if (receivedDocuments.hasDoc("1040x","Student") && receivedDocuments.get("1040x","Student").isAcceptable() && receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1021).toFloat().round();
    }
    if (receivedDocuments.hasDoc("1040x","Spouse") && receivedDocuments.get("1040x","Spouse").isAcceptable() && receivedDocuments.get("1040x", "Spouse").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("1040x", "Spouse").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040x", "Spouse").getDocumentField(documentFieldAC1021).toFloat().round();
    }
    
    if (hasDocumentValue && isirStudentISIRValueForCorrectionValue != documentValue)
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
        return;
    }
}
documentValue = 0;

if (isirStudentMaritalStatus == "1" || isirStudentMaritalStatus == "4" || isirStudentMaritalStatus.isAllWhitespace())
{
    if (receivedDocuments.hasDoc("ForeignTaxTranscript","Student") && receivedDocuments.get("ForeignTaxTranscript","Student").isAcceptable() && receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1021).toFloat().round();
        if (isirStudentISIRValueForCorrectionValue != documentValue)
        {
            discrepancyEvaluationResult.hasDiscrepancy = true;
            discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
            return;
        }
    }
}
if (isirStudentMaritalStatus == "2" || isirStudentMaritalStatus == "3")
{
    boolean hasDocumentValue = false;
    if (receivedDocuments.hasDoc("ForeignTaxTranscript","Student") && receivedDocuments.get("ForeignTaxTranscript","Student").isAcceptable() && receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1021).toFloat().round();
    }
    if (receivedDocuments.hasDoc("ForeignTaxTranscript","Spouse") && receivedDocuments.get("ForeignTaxTranscript","Spouse").isAcceptable() && receivedDocuments.get("ForeignTaxTranscript", "Spouse").getDocumentField(documentFieldAC1021) != null && !receivedDocuments.get("ForeignTaxTranscript", "Spouse").getDocumentField(documentFieldAC1021).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("ForeignTaxTranscript", "Spouse").getDocumentField(documentFieldAC1021).toFloat().round();
    }
    
    if (hasDocumentValue && isirStudentISIRValueForCorrectionValue != documentValue)
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
        return;
    }
}
documentValue = 0;