package com.erp.lymytz.api.converter.param;

import com.erp.lymytz.api.model.param.YvsAgences;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterAgence extends StdConverter<YvsAgences, YvsAgences  >{

	@Override
	public YvsAgences convert(YvsAgences value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsAgences result = new YvsAgences();
			result.setId(value.getId());
			result.setDesignation(value.getDesignation());
			return result;
		}
		return new YvsAgences();
	}

}
