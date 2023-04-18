package com.erp.lymytz.api.route.base.article;


import java.util.List;

import com.erp.lymytz.api.route.AController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.service.base.article.IArticles;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/articles")
public class ArticlesController extends AController<YvsBaseArticles, Long> {

    @Autowired
    IArticles service;

    @Override
    protected IArticles getRepository() {
        return service;
    }

    @GetMapping("/by_societe/{societe}")
    public List<YvsBaseArticles> findAll(@PathVariable("societe") Integer societe) {
        try {
            return service.findAll(new YvsSocietes(societe));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
