package com.erp.lymytz.api.route.base.article;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleCategorieComptable;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.model.base.article.param.YvsBaseArticlesTemplate;
import com.erp.lymytz.api.service.base.article.IArticleCategorieComptable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/article_categorie_comptable")
public class ArticleCategorieComptableController {

    @Autowired
    IArticleCategorieComptable service;

    @GetMapping("/")
    public List<YvsBaseArticleCategorieComptable> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/by_article/{article}")
    public List<YvsBaseArticleCategorieComptable> findAll(@PathVariable("article") Long article) {
        try {
            return service.findAll(new YvsBaseArticles(article));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/by_template/{template}")
    public List<YvsBaseArticleCategorieComptable> findByTemplate(@PathVariable("template") Long template) {
        try {
            return service.findByTemplate(new YvsBaseArticlesTemplate(template));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public YvsBaseArticleCategorieComptable findOne(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResultAction<YvsBaseArticleCategorieComptable> save(@RequestBody YvsBaseArticleCategorieComptable entity) throws Exception {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResultAction<YvsBaseArticleCategorieComptable> update(@PathVariable("id") Long id, @RequestBody YvsBaseArticleCategorieComptable entity) throws Exception {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResultAction<YvsBaseArticleCategorieComptable> delete(@PathVariable("id") Long id) throws Exception {
        return service.delete(id);
    }

    @PostMapping("/updates")
    public ResultAction<List<YvsBaseArticleCategorieComptable>> updateMany(@RequestBody List<YvsBaseArticleCategorieComptable> entities) throws Exception {
        return service.updateMany(entities);
    }

    @PostMapping("/deletes")
    public ResultAction<List<YvsBaseArticleCategorieComptable>> deleteMany(@RequestBody List<YvsBaseArticleCategorieComptable> entities) throws Exception {
        return service.deleteMany(entities);
    }

}
