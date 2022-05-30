package com.erp.lymytz.api.controller.base.article;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleCategorieComptable;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.model.base.article.param.YvsBaseArticlesTemplate;
import com.erp.lymytz.api.repository.base.article.ArticleCategorieComptableRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCArticleCategorieComptableRepo;
import com.erp.lymytz.api.service.base.article.IArticleCategorieComptable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedArticleCategorieComptable extends ManagedEntity<YvsBaseArticleCategorieComptable, Long> implements IArticleCategorieComptable {

    @Autowired
    ArticleCategorieComptableRepo repository;
    @Autowired
    JDBCArticleCategorieComptableRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBaseArticleCategorieComptable, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBaseArticleCategorieComptable, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBaseArticleCategorieComptable> findAll(Object article) throws Exception {
        return repository.findByArticle((YvsBaseArticles) article);
    }

    @Override
    public List<YvsBaseArticleCategorieComptable> findByTemplate(Object template){
        return repository.findByTemplate((YvsBaseArticlesTemplate) template);
    }

}
