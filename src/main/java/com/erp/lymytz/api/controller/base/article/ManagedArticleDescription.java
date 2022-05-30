package com.erp.lymytz.api.controller.base.article;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleDescription;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.repository.base.article.ArticleDescriptionRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCArticleDescriptionRepo;
import com.erp.lymytz.api.service.base.article.IArticleDescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedArticleDescription extends ManagedEntity<YvsBaseArticleDescription, Long> implements IArticleDescription {

    @Autowired
    ArticleDescriptionRepo repository;
    @Autowired
    JDBCArticleDescriptionRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBaseArticleDescription, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBaseArticleDescription, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBaseArticleDescription> findAll(Object article) throws Exception {
        return repository.findByArticle((YvsBaseArticles) article);
    }

}
