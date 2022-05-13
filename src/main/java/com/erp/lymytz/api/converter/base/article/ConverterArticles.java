package com.erp.lymytz.api.converter.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterArticles extends StdConverter<YvsBaseArticles, YvsBaseArticles> {

	@Override
	public YvsBaseArticles convert(YvsBaseArticles value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseArticles result = new YvsBaseArticles();
			result.setId(value.getId());
			result.setDesignation(value.getDesignation());
			return result;
		}
		return new YvsBaseArticles();
	}

}
