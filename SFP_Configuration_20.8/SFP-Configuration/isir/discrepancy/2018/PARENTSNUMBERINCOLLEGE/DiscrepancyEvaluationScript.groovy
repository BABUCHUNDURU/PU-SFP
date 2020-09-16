String documentField = "AC1099";
String isirValueForCorrection = isirRecord.getIsirFieldValue("PARENTSNUMBERINCOLLEGE");

int isirValueForCorrectionValue = 0;
if (!isirValueForCorrection.isAllWhitespace())
{
    isirValueForCorrectionValue = isirValueForCorrection.toInteger();
}

if (receivedDocuments.hasDoc("VW-Dep","Student") && receivedDocuments.get("VW-Dep","Student").isAcceptable() && receivedDocuments.get("VW-Dep", "Student").getDocumentField(documentField) != null && !receivedDocuments.get("VW-Dep", "Student").getDocumentField(documentField).isAllWhitespace())
{
    int documentValue = receivedDocuments.get("VW-Dep", "Student").getDocumentField(documentField).toInteger();
    if (isirValueForCorrectionValue != documentValue)
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = String.format("%01d",documentValue);
        return;
    }
}