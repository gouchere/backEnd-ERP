package com.erp.lymytz.api.controller.base.article;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleAnalytique;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.repository.base.article.ArticleAnalytiqueRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCArticleAnalytiqueRepo;
import com.erp.lymytz.api.service.base.article.IArticleAnalytique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedArticleAnalytique extends ManagedEntity<YvsBaseArticleAnalytique, Long> implements IArticleAnalytique {

    @Autowired
    ArticleAnalytiqueRepo repository;
    @Autowired
    JDBCArticleAnalytiqueRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBaseArticleAnalytique, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBaseArticleAnalytique, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBaseArticleAnalytique> findAll(Object article) throws Exception {
        return repository.findByArticle((YvsBaseArticles) article);
    }

}
