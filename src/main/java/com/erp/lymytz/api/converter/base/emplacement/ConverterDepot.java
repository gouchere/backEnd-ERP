package com.erp.lymytz.api.converter.base.emplacement;

import com.erp.lymytz.api.model.base.emplacement.YvsBaseDepots;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterDepot extends StdConverter<YvsBaseDepots, YvsBaseDepots> {

	@Override
	public YvsBaseDepots convert(YvsBaseDepots value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseDepots result = new YvsBaseDepots();
			result.setId(value.getId());
			result.setDesignation(value.getDesignation());
			return result;
		}
		return new YvsBaseDepots();
	}

}
