String IssueAgency= currentDocument.getDocumentFieldValue("AC1065");
if (IssueAgency != null && !IssueAgency.isAllWhitespace())
{   
    if (IssueAgency == "Other")
    {
        returnList.get(0).setScriptReturnErrorString("Document must be reviewed manually");
        return;
    }    
}