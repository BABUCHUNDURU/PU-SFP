String documentFieldAC1019 = "AC1019";
String isirStudentISIRValueForCorrection = isirRecord.getIsirFieldValue("STUDENTSIRAPAYMENTS");
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
    if (receivedDocuments.hasDoc("TaxReturnTranscript","Student") && receivedDocuments.get("TaxReturnTranscript","Student").isAcceptable() && receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1019).toFloat().round();
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
    if (receivedDocuments.hasDoc("TaxReturnTranscript","Student") && receivedDocuments.get("TaxReturnTranscript","Student").isAcceptable() && receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("TaxReturnTranscript", "Student").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    if (receivedDocuments.hasDoc("TaxReturnTranscript","Spouse") && receivedDocuments.get("TaxReturnTranscript","Spouse").isAcceptable() && receivedDocuments.get("TaxReturnTranscript", "Spouse").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("TaxReturnTranscript", "Spouse").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("TaxReturnTranscript", "Spouse").getDocumentField(documentFieldAC1019).toFloat().round();
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
    if (receivedDocuments.hasDoc("1040","Student") && receivedDocuments.get("1040","Student").isAcceptable() && receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1019).toFloat().round();
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
    if (receivedDocuments.hasDoc("1040","Student") && receivedDocuments.get("1040","Student").isAcceptable() && receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040", "Student").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    if (receivedDocuments.hasDoc("1040","Spouse") && receivedDocuments.get("1040","Spouse").isAcceptable() && receivedDocuments.get("1040", "Spouse").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040", "Spouse").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040", "Spouse").getDocumentField(documentFieldAC1019).toFloat().round();
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
    if (receivedDocuments.hasDoc("1040x","Student") && receivedDocuments.get("1040x","Student").isAcceptable() && receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1019).toFloat().round();
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
    if (receivedDocuments.hasDoc("1040x","Student") && receivedDocuments.get("1040x","Student").isAcceptable() && receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040x", "Student").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    if (receivedDocuments.hasDoc("1040x","Spouse") && receivedDocuments.get("1040x","Spouse").isAcceptable() && receivedDocuments.get("1040x", "Spouse").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("1040x", "Spouse").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("1040x", "Spouse").getDocumentField(documentFieldAC1019).toFloat().round();
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
    if (receivedDocuments.hasDoc("ForeignTaxTranscript","Student") && receivedDocuments.get("ForeignTaxTranscript","Student").isAcceptable() && receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        documentValue = receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1019).toFloat().round();
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
    if (receivedDocuments.hasDoc("ForeignTaxTranscript","Student") && receivedDocuments.get("ForeignTaxTranscript","Student").isAcceptable() && receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("ForeignTaxTranscript", "Student").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    if (receivedDocuments.hasDoc("ForeignTaxTranscript","Spouse") && receivedDocuments.get("ForeignTaxTranscript","Spouse").isAcceptable() && receivedDocuments.get("ForeignTaxTranscript", "Spouse").getDocumentField(documentFieldAC1019) != null && !receivedDocuments.get("ForeignTaxTranscript", "Spouse").getDocumentField(documentFieldAC1019).isAllWhitespace())
    {
        hasDocumentValue = true;
        documentValue = documentValue + receivedDocuments.get("ForeignTaxTranscript", "Spouse").getDocumentField(documentFieldAC1019).toFloat().round();
    }
    
    if (hasDocumentValue && isirStudentISIRValueForCorrectionValue != documentValue)
    {
        discrepancyEvaluationResult.hasDiscrepancy = true;
        discrepancyEvaluationResult.correctedValue = String.format("%07d",documentValue);
        return;
    }
}
documentValue = 0;


float totalBox12Amount = 0.0;

boolean hasW2Student = false;
if (receivedDocuments.hasDoc("W2", "Student") && receivedDocuments.get("W2", "Student").isAcceptable())
{
    hasW2Student = true;
    def w2DocsStudent = receivedDocuments.getDocumentsForDocCode("W2", "Student");
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

if (hasW2Student && !isirStudentISIRValueForCorrectionBlank && totalBox12Amount.round() != isirStudentISIRValueForCorrectionValue)
{
    discrepancyEvaluationResult.hasDiscrepancy = true;
    discrepancyEvaluationResult.correctedValue = String.format("%07d",totalBox12Amount.round());
    return;
}