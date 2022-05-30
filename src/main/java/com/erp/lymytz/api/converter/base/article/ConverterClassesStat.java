package com.erp.lymytz.api.converter.base.article;

import com.erp.lymytz.api.model.base.article.param.YvsBaseClassesStat;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterClassesStat extends StdConverter<YvsBaseClassesStat, YvsBaseClassesStat> {

	@Override
	public YvsBaseClassesStat convert(YvsBaseClassesStat value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseClassesStat result = new YvsBaseClassesStat();
			result.setId(value.getId());
			result.setDesignation(value.getDesignation());
			return result;
		}
		return new YvsBaseClassesStat();
	}

}
