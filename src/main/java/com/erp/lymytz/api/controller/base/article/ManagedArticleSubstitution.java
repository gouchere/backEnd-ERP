package com.erp.lymytz.api.controller.base.article;

import com.erp.lymytz.api.controller.ManagedEntity;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleSubstitution;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.repository.base.article.ArticleSubstitutionRepo;
import com.erp.lymytz.api.repository.jdbc.JDBCEntityRepo;
import com.erp.lymytz.api.repository.jdbc.base.article.JDBCArticleSubstitutionRepo;
import com.erp.lymytz.api.service.base.article.IArticleSubstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagedArticleSubstitution extends ManagedEntity<YvsBaseArticleSubstitution, Long> implements IArticleSubstitution {

    @Autowired
    ArticleSubstitutionRepo repository;
    @Autowired
    JDBCArticleSubstitutionRepo jdbc;

    @Override
    public JDBCEntityRepo<YvsBaseArticleSubstitution, Long> getJdbc() {
        return jdbc;
    }

    @Override
    public JpaRepository<YvsBaseArticleSubstitution, Long> getRepository() {
        return repository;
    }

    @Override
    public List<YvsBaseArticleSubstitution> findAll(Object article) throws Exception {
        return repository.findByArticle((YvsBaseArticles) article);
    }

}
