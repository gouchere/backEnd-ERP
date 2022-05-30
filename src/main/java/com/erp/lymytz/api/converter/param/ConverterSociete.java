package com.erp.lymytz.api.converter.param;

import com.erp.lymytz.api.model.param.YvsSocietes;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterSociete extends StdConverter<YvsSocietes, YvsSocietes  >{

	@Override
	public YvsSocietes convert(YvsSocietes value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsSocietes result = new YvsSocietes();
			result.setId(value.getId());
			result.setName(value.getName());
			return result;
		}
		return new YvsSocietes();
	}

}
