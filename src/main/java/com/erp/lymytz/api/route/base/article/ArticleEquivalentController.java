package com.erp.lymytz.api.route.base.article;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleEquivalent;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.service.base.article.IArticleEquivalent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/article_equivalent")
public class ArticleEquivalentController {

    @Autowired
    IArticleEquivalent service;

    @GetMapping("/")
    public List<YvsBaseArticleEquivalent> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/by_article/{article}")
    public List<YvsBaseArticleEquivalent> findAll(@PathVariable("article") Long article) {
        try {
            return service.findAll(new YvsBaseArticles(article));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public YvsBaseArticleEquivalent findOne(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResultAction<YvsBaseArticleEquivalent> save(@RequestBody YvsBaseArticleEquivalent entity) throws Exception {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResultAction<YvsBaseArticleEquivalent> update(@PathVariable("id") Long id, @RequestBody YvsBaseArticleEquivalent entity) throws Exception {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResultAction<YvsBaseArticleEquivalent> delete(@PathVariable("id") Long id) throws Exception {
        return service.delete(id);
    }

    @PostMapping("/updates")
    public ResultAction<List<YvsBaseArticleEquivalent>> updateMany(@RequestBody List<YvsBaseArticleEquivalent> entities) throws Exception {
        return service.updateMany(entities);
    }

    @PostMapping("/deletes")
    public ResultAction<List<YvsBaseArticleEquivalent>> deleteMany(@RequestBody List<YvsBaseArticleEquivalent> entities) throws Exception {
        return service.deleteMany(entities);
    }

}
