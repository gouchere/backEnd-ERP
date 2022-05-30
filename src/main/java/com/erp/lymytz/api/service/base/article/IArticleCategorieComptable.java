package com.erp.lymytz.api.service.base.article;

import com.erp.lymytz.api.model.base.article.YvsBaseArticleCategorieComptable;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleDepot;
import com.erp.lymytz.api.service.IEntity;

import java.util.List;

public interface IArticleCategorieComptable extends IEntity<YvsBaseArticleCategorieComptable, Long>  {

    public List<YvsBaseArticleCategorieComptable> findByTemplate(Object value) throws Exception;

}
