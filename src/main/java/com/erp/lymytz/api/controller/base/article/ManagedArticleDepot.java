package com.erp.lymytz.api.controller.base.article;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleDepot;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.repository.base.article.ArticleDepotRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCArticleDepotRepo;
import com.erp.lymytz.api.service.base.article.IArticleDepot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedArticleDepot extends ManagedEntity<YvsBaseArticleDepot, Long> implements IArticleDepot {

    @Autowired
    ArticleDepotRepo repository;
    @Autowired
    JDBCArticleDepotRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBaseArticleDepot, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBaseArticleDepot, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBaseArticleDepot> findAll(Object article) throws Exception {
        return repository.findByArticle((YvsBaseArticles) article);
    }

}
