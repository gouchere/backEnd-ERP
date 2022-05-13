package com.erp.lymytz.api.converter.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseGroupesArticle;
import com.fasterxml.jackson.databind.util.StdConverter;

public class ConverterGroupesArticle extends StdConverter<YvsBaseGroupesArticle, YvsBaseGroupesArticle> {

	@Override
	public YvsBaseGroupesArticle convert(YvsBaseGroupesArticle value) {
		// TODO Auto-generated method stub
		if (value != null) {
			YvsBaseGroupesArticle result = new YvsBaseGroupesArticle();
			result.setId(value.getId());
			result.setDesignation(value.getDesignation());
			return result;
		}
		return new YvsBaseGroupesArticle();
	}

}
