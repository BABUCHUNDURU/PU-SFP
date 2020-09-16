String documentFieldAC1019 = "AC1019";
String isirParentISIRValueForCorrection = isirRecord.getIsirFieldValue("PARENTSIRAPAYMENTS");
String isirParentMaritalStatus = isirRecord.getIsirFieldValue("PARENTSMARITALSTATUS");
 
int isirParentISIRValueForCorrectionValue = 0;
boolean isirParentISIRValueForCorrectionBlank = true;
if (!isirParentISIRValueForCorrection.isAllWhitespace())
{
    isirParentISIRValueForCorrectionValue = isirParentISIRValueForCorrection.toInteger();
    isirParentISIRValueForCorrectionBlank = false;
}

int documentValue = 0;


if (isirParentMaritalStatus == "4" || isirParentMaritalStatus.isAllWhitespace())
{
    if (receivedDocuments.hasDoc("TaxReturnTranscript","Parent1") && receivedDocuments.get("TaxReturnTranscript","Parent1").isAcceptable() && receivedDocuments.get("TaxReturnTranscript", "Parent1").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("TaxReturnTranscript", "Parent1").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("TaxReturnTranscript", "Parent1").getDocumentField(documentFieldAC1019).toFloat().round();
        if (isirParentISIRValueForCorrectionValue != documentValue)
        {
            discrepancyEvaluationResult.hasDiscrepancy = true;
            discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
            return;
        }
    }
}
if (isirParentMaritalStatus == "1" || isirParentMaritalStatus == "2" || isirParentMaritalStatus == "3" || isirParentMaritalStatus == "5")
{
    boolean hasDocumentValue = false;
    if (receivedDocuments.hasDoc("TaxReturnTranscript","Parent1") && receivedDocuments.get("TaxReturnTranscript","Parent1").isAcceptable() && receivedDocuments.get("TaxReturnTranscript", "Parent1").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("TaxReturnTranscript", "Parent1").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("TaxReturnTranscript", "Parent1").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    if (receivedDocuments.hasDoc("TaxReturnTranscript","Parent2") && receivedDocuments.get("TaxReturnTranscript","Parent2").isAcceptable() && receivedDocuments.get("TaxReturnTranscript", "Parent2").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("TaxReturnTranscript", "Parent2").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("TaxReturnTranscript", "Parent2").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    
    if (hasDocumentValue && isirParentISIRValueForCorrectionValue != documentValue)
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
        return;
    }
}
documentValue = 0;


if (isirParentMaritalStatus == "4" || isirParentMaritalStatus.isAllWhitespace())
{
    if (receivedDocuments.hasDoc("1040","Parent1") && receivedDocuments.get("1040","Parent1").isAcceptable() && receivedDocuments.get("1040", "Parent1").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040", "Parent1").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("1040", "Parent1").getDocumentField(documentFieldAC1019).toFloat().round();
        if (isirParentISIRValueForCorrectionValue != documentValue)
        {
            discrepancyEvaluationResult.hasDiscrepancy = true;
            discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
            return;
        }
    }
}
if (isirParentMaritalStatus == "1" || isirParentMaritalStatus == "2" || isirParentMaritalStatus == "3" || isirParentMaritalStatus == "5")
{
    boolean hasDocumentValue = false;
    if (receivedDocuments.hasDoc("1040","Parent1") && receivedDocuments.get("1040","Parent1").isAcceptable() && receivedDocuments.get("1040", "Parent1").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040", "Parent1").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040", "Parent1").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    if (receivedDocuments.hasDoc("1040","Parent2") && receivedDocuments.get("1040","Parent2").isAcceptable() && receivedDocuments.get("1040", "Parent2").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040", "Parent2").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040", "Parent2").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    
    if (hasDocumentValue && isirParentISIRValueForCorrectionValue != documentValue)
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
        return;
    }
}
documentValue = 0;


if (isirParentMaritalStatus == "4" || isirParentMaritalStatus.isAllWhitespace())
{
    if (receivedDocuments.hasDoc("1040x","Parent1") && receivedDocuments.get("1040x","Parent1").isAcceptable() && receivedDocuments.get("1040x", "Parent1").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040x", "Parent1").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("1040x", "Parent1").getDocumentField(documentFieldAC1019).toFloat().round();
        if (isirParentISIRValueForCorrectionValue != documentValue)
        {
            discrepancyEvaluationResult.hasDiscrepancy = true;
            discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
            return;
        }
    }
}
if (isirParentMaritalStatus == "1" || isirParentMaritalStatus == "2" || isirParentMaritalStatus == "3" || isirParentMaritalStatus == "5")
{
    boolean hasDocumentValue = false;
    if (receivedDocuments.hasDoc("1040x","Parent1") && receivedDocuments.get("1040x","Parent1").isAcceptable() && receivedDocuments.get("1040x", "Parent1").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040x", "Parent1").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040x", "Parent1").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    if (receivedDocuments.hasDoc("1040x","Parent2") && receivedDocuments.get("1040x","Parent2").isAcceptable() && receivedDocuments.get("1040x", "Parent2").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040x", "Parent2").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040x", "Parent2").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    
    if (hasDocumentValue && isirParentISIRValueForCorrectionValue != documentValue)
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
        return;
    }
}
documentValue = 0;

if (isirParentMaritalStatus == "4" || isirParentMaritalStatus.isAllWhitespace())
{
    if (receivedDocuments.hasDoc("ForeignTaxTranscript","Parent1") && receivedDocuments.get("ForeignTaxTranscript","Parent1").isAcceptable() && receivedDocuments.get("ForeignTaxTranscript", "Parent1").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("ForeignTaxTranscript", "Parent1").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("ForeignTaxTranscript", "Parent1").getDocumentField(documentFieldAC1019).toFloat().round();
        if (isirParentISIRValueForCorrectionValue != documentValue)
        {
            discrepancyEvaluationResult.hasDiscrepancy = true;
            discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
            return;
        }
    }
}
if (isirParentMaritalStatus == "1" || isirParentMaritalStatus == "2" || isirParentMaritalStatus == "3" || isirParentMaritalStatus == "5")
{
    boolean hasDocumentValue = false;
    if (receivedDocuments.hasDoc("ForeignTaxTranscript","Parent1") && receivedDocuments.get("ForeignTaxTranscript","Parent1").isAcceptable() && receivedDocuments.get("ForeignTaxTranscript", "Parent1").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("ForeignTaxTranscript", "Parent1").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("ForeignTaxTranscript", "Parent1").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    if (receivedDocuments.hasDoc("ForeignTaxTranscript","Parent2") && receivedDocuments.get("ForeignTaxTranscript","Parent2").isAcceptable() && receivedDocuments.get("ForeignTaxTranscript", "Parent2").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("ForeignTaxTranscript", "Parent2").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("ForeignTaxTranscript", "Parent2").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    
    if (hasDocumentValue && isirParentISIRValueForCorrectionValue != documentValue)
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
        return;
    }
}
documentValue = 0;


float totalBox12Amount = 0.0;

boolean hasW2Student = false;
if (receivedDocuments.hasDoc("W2", "Parent1") && receivedDocuments.get("W2", "Parent1").isAcceptable())
{
    hasW2Student = true;
    def w2DocsStudent = receivedDocuments.getDocumentsForDocCode("W2", "Parent1");
    for (doc in w2DocsStudent)
    {
        String ac1085 = "";
        String ac1086 = "";
        String ac1087 = "";
        String ac1088 = "";
        String ac1089 = "0.0";
        String ac1090 = "0.0";
        String ac1091 = "0.0";
        String ac1092 = "0.0";
        
        if (doc.getDocumentField("AC1085") != null)
        {
            ac1085 = doc.getDocumentField("AC1085");
        }
        if (doc.getDocumentField("AC1086") != null)
        {
            ac1086 = doc.getDocumentField("AC1086");
        }
        if (doc.getDocumentField("AC1087") != null)
        {
            ac1087 = doc.getDocumentField("AC1087");
        }
        if (doc.getDocumentField("AC1088") != null)
        {
            ac1088 = doc.getDocumentField("AC1088");
        }
        if (doc.getDocumentField("AC1089") != null)
        {
            ac1089 = doc.getDocumentField("AC1089");
        }
        if (doc.getDocumentField("AC1090") != null)
        {
            ac1090 = doc.getDocumentField("AC1090");
        }
        if (doc.getDocumentField("AC1091") != null)
        {
            ac1091 = doc.getDocumentField("AC1091");
        }
        if (doc.getDocumentField("AC1092") != null)
        {
            ac1092 = doc.getDocumentField("AC1092");
        }
        
        if (ac1085 == "D" || ac1085 == "E" || ac1085 == "F" || ac1085 == "G" || ac1085 == "H" || ac1085 == "S")
        {
            totalBox12Amount = totalBox12Amount + ac1089.toFloat();
        }
        if (ac1086 == "D" || ac1086 == "E" || ac1086 == "F" || ac1086 == "G" || ac1086 == "H" || ac1086 == "S")
        {
            totalBox12Amount = totalBox12Amount + ac1090.toFloat();
        }
        if (ac1087 == "D" || ac1087 == "E" || ac1087 == "F" || ac1087 == "G" || ac1087 == "H" || ac1087 == "S")
        {
            totalBox12Amount = totalBox12Amount + ac1091.toFloat();
        }
        if (ac1088 == "D" || ac1088 == "E" || ac1088 == "F" || ac1088 == "G" || ac1088 == "H" || ac1088 == "S")
        {
            totalBox12Amount = totalBox12Amount + ac1092.toFloat();
        }
    }
}

if (hasW2Student && !isirParentISIRValueForCorrectionBlank && totalBox12Amount.round() != isirParentISIRValueForCorrectionValue)
{
    discrepancyEvaluationResult.hasDiscrepancy = true;
    discrepancyEvaluationResult.correctedValue = String.format("%07d",totalBox12Amount.round());
    return;
}