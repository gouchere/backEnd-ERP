package com.erp.lymytz.api.converter.base.compta;

import com.erp.lymytz.api.model.base.compta.YvsBaseCategorieComptable;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterCategorieComptable extends StdConverter<YvsBaseCategorieComptable, YvsBaseCategorieComptable> {

	@Override
	public YvsBaseCategorieComptable convert(YvsBaseCategorieComptable value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseCategorieComptable result = new YvsBaseCategorieComptable();
			result.setId(value.getId());
			result.setDesignation(value.getDesignation());
			return result;
		}
		return new YvsBaseCategorieComptable();
	}

}
