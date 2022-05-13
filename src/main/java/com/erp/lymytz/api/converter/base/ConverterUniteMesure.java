package com.erp.lymytz.api.converter.base;

import com.erp.lymytz.api.model.base.YvsBaseUniteMesure;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterUniteMesure extends StdConverter<YvsBaseUniteMesure, YvsBaseUniteMesure> {

	@Override
	public YvsBaseUniteMesure convert(YvsBaseUniteMesure value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseUniteMesure result = new YvsBaseUniteMesure();
			result.setId(value.getId());
			result.setLibelle(value.getLibelle());
			return result;
		}
		return new YvsBaseUniteMesure();
	}

}
