String latestIsirTransactionDataSourceCode = latestIsirRecord.getIsirFieldValue("TRANSACTIONDATASOURCETYPECODE");

if (!latestIsirTransactionDataSourceCode.isAllWhitespace())
{
    return true;
}