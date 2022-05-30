package com.erp.lymytz.api.controller.base.article;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleFournisseur;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.repository.base.article.ArticleFournisseurRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCArticleFournisseurRepo;
import com.erp.lymytz.api.service.base.article.IArticleFournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedArticleFournisseur extends ManagedEntity<YvsBaseArticleFournisseur, Long> implements IArticleFournisseur {

    @Autowired
    ArticleFournisseurRepo repository;
    @Autowired
    JDBCArticleFournisseurRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBaseArticleFournisseur, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBaseArticleFournisseur, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBaseArticleFournisseur> findAll(Object article) throws Exception {
        return repository.findByArticle((YvsBaseArticles) article);
    }

}
