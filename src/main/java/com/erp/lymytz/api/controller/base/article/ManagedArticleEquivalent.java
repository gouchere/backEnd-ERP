package com.erp.lymytz.api.controller.base.article;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleEquivalent;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.repository.base.article.ArticleEquivalentRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCArticleEquivalentRepo;
import com.erp.lymytz.api.service.base.article.IArticleEquivalent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedArticleEquivalent extends ManagedEntity<YvsBaseArticleEquivalent, Long> implements IArticleEquivalent {

    @Autowired
    ArticleEquivalentRepo repository;
    @Autowired
    JDBCArticleEquivalentRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBaseArticleEquivalent, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBaseArticleEquivalent, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBaseArticleEquivalent> findAll(Object article) throws Exception {
        return repository.findByArticle((YvsBaseArticles) article);
    }

}
