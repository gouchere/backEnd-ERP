package com.erp.lymytz.api.route.base.article;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.model.base.article.YvsBaseArticleSubstitution;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.service.base.article.IArticleSubstitution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/article_substitution")
public class ArticleSubstitutionController {

    @Autowired
    IArticleSubstitution service;

    @GetMapping("/")
    public List<YvsBaseArticleSubstitution> findAll() {
        try {
            return service.findAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/by_article/{article}")
    public List<YvsBaseArticleSubstitution> findAll(@PathVariable("article") Long article) {
        try {
            return service.findAll(new YvsBaseArticles(article));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/{id}")
    public YvsBaseArticleSubstitution findOne(@PathVariable("id") Long id) throws Exception {
        return service.findById(id);
    }

    @PostMapping("/")
    public ResultAction<YvsBaseArticleSubstitution> save(@RequestBody YvsBaseArticleSubstitution entity) throws Exception {
        return service.save(entity);
    }

    @PutMapping("/{id}")
    public ResultAction<YvsBaseArticleSubstitution> update(@PathVariable("id") Long id, @RequestBody YvsBaseArticleSubstitution entity) throws Exception {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResultAction<YvsBaseArticleSubstitution> delete(@PathVariable("id") Long id) throws Exception {
        return service.delete(id);
    }

    @PostMapping("/updates")
    public ResultAction<List<YvsBaseArticleSubstitution>> updateMany(@RequestBody List<YvsBaseArticleSubstitution> entities) throws Exception {
        return service.updateMany(entities);
    }

    @PostMapping("/deletes")
    public ResultAction<List<YvsBaseArticleSubstitution>> deleteMany(@RequestBody List<YvsBaseArticleSubstitution> entities) throws Exception {
        return service.deleteMany(entities);
    }

}
