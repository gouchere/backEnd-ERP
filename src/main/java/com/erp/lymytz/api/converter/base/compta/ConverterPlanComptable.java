package com.erp.lymytz.api.converter.base.compta;

import com.erp.lymytz.api.model.base.compta.YvsBasePlanComptable;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterPlanComptable extends StdConverter<YvsBasePlanComptable, YvsBasePlanComptable> {

    @Override
    public YvsBasePlanComptable convert(YvsBasePlanComptable value) {
        // TODO Auto-generated method stub
        if (value != null) {
            YvsBasePlanComptable result = new YvsBasePlanComptable();
            result.setId(value.getId());
            result.setNumCompte(value.getNumCompte());
            result.setIntitule(value.getIntitule());
            return result;
        }
        return new YvsBasePlanComptable();
    }

}
