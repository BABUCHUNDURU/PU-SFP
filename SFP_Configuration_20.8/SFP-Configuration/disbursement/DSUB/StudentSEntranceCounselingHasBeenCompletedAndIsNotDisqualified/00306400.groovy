return cod.getCrecs().firstMatch({ crec -> crec.getCounselingCompleteDate() != null; }).isPresent();