package com.erp.lymytz.api.converter.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseFamilleArticle;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterFamillesArticle extends StdConverter<YvsBaseFamilleArticle, YvsBaseFamilleArticle> {

	@Override
	public YvsBaseFamilleArticle convert(YvsBaseFamilleArticle value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseFamilleArticle result = new YvsBaseFamilleArticle();
			result.setId(value.getId());
			result.setDesignation(value.getDesignation());
			return result;
		}
		return new YvsBaseFamilleArticle();
	}

}
