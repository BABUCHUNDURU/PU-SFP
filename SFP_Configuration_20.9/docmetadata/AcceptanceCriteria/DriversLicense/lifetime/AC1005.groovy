import java.util.Date;

String docDateString = currentDocument.getDocumentFieldValue("AC1005");
if (docDateString != null && !docDateString.isAllWhitespace())
{
    Date today = new Date().clearTime();
    Date docDate = groovyScriptHelper.getIsirDate(docDateString.replaceAll("-","")).clearTime();
    
    if (!(docDate > today))
    {
        returnList.get(0).setScriptReturnErrorString("Document must be reviewed manually");
        return;
    }    
}