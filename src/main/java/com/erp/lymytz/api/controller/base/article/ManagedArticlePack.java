package com.erp.lymytz.api.controller.base.article;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.article.YvsBaseArticlePack;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.repository.base.article.ArticlePackRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCArticlePackRepo;
import com.erp.lymytz.api.service.base.article.IArticlePack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedArticlePack extends ManagedEntity<YvsBaseArticlePack, Long> implements IArticlePack {

    @Autowired
    ArticlePackRepo repository;
    @Autowired
    JDBCArticlePackRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBaseArticlePack, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBaseArticlePack, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBaseArticlePack> findAll(Object article) throws Exception {
        return repository.findByArticle((YvsBaseArticles) article);
    }

}
