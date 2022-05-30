package com.erp.lymytz.api.converter.base.tiers.param;

import com.erp.lymytz.api.model.base.tiers.param.YvsBaseCategorieClient;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterCategorieClient extends StdConverter<YvsBaseCategorieClient, YvsBaseCategorieClient> {

	@Override
	public YvsBaseCategorieClient convert(YvsBaseCategorieClient value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseCategorieClient result = new YvsBaseCategorieClient();
			result.setId(value.getId());
			result.setLibelle(value.getLibelle());
			return result;
		}
		return new YvsBaseCategorieClient();
	}

}
