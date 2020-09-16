String isirValue = isirRecord.getIsirFieldValue("PERMANENTSTATE");
            String sdiState = fasStudent.addressState;

            if (isirValue == null)
            {
                isirValue = "";
            }

            if (sdiState == null)
            {
                sdiState = "";
            }

            if (isirValue == "FC" && sdiState != isirValue)
            {
                discrepancyEvaluationResult.hasDiscrepancy = true;
                discrepancyEvaluationResult.needManualReview = true;
                return;
            }