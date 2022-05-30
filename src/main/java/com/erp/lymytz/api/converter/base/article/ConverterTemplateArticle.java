package com.erp.lymytz.api.converter.base.article;

import com.erp.lymytz.api.model.base.article.param.YvsBaseArticlesTemplate;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterTemplateArticle extends StdConverter<YvsBaseArticlesTemplate, YvsBaseArticlesTemplate> {

	@Override
	public YvsBaseArticlesTemplate convert(YvsBaseArticlesTemplate value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseArticlesTemplate result = new YvsBaseArticlesTemplate();
			result.setId(value.getId());
			result.setDesignation(value.getDesignation());
			return result;
		}
		return new YvsBaseArticlesTemplate();
	}

}
