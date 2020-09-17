String filingStatus = currentDocument.getDocumentFieldValue("AC1065");

if (filingStatus != null && !filingStatus.isAllWhitespace() && filingStatus == "Married Filing Separately")
{
    supportingDoc.addAnyDocuments(["TaxReturnTranscript", "Spouse"], ["1040x", "Spouse"],["ForeignTaxTranscript", "Spouse"]);
}