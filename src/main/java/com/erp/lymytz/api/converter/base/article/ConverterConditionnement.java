package com.erp.lymytz.api.converter.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseConditionnement;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterConditionnement extends StdConverter<YvsBaseConditionnement, YvsBaseConditionnement> {

	@Override
	public YvsBaseConditionnement convert(YvsBaseConditionnement value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseConditionnement result = new YvsBaseConditionnement();
			result.setId(value.getId());
			return result;
		}
		return new YvsBaseConditionnement();
	}

}
