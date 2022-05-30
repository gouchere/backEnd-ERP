package com.erp.lymytz.api.route.base.article.param;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erp.lymytz.api.model.ResultAction;
import com.erp.lymytz.api.model.param.YvsSocietes;
import com.erp.lymytz.api.model.base.article.param.YvsBaseArticlesTemplate;
import com.erp.lymytz.api.service.base.article.param.IArticleTemplate;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/article_template")
public class ArticleTemplateController {

	@Autowired
	IArticleTemplate service;

	@GetMapping("/")
	public List<YvsBaseArticlesTemplate> findAll(){
		try {
			return service.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/by_societe/{societe}")
	public List<YvsBaseArticlesTemplate> findAll(@PathVariable("societe") Integer societe){
		try {
			return service.findAll(new YvsSocietes(societe));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/{id}")
	public YvsBaseArticlesTemplate findOne(@PathVariable("id") Long id) throws Exception{
		return service.findById(id);
	}

	@PostMapping("/")
	public ResultAction<YvsBaseArticlesTemplate> save(@RequestBody YvsBaseArticlesTemplate entity) throws Exception{
		return service.save(entity);
	}

	@PutMapping("/{id}")
	public ResultAction<YvsBaseArticlesTemplate> update(@PathVariable("id") Long id, @RequestBody YvsBaseArticlesTemplate entity) throws Exception {
		return service.update(id, entity);
	}

	@DeleteMapping("/{id}")
	public ResultAction<YvsBaseArticlesTemplate> delete(@PathVariable("id") Long id) throws Exception {
		return service.delete(id);
	}

	@PostMapping("/updates")
	public ResultAction<List<YvsBaseArticlesTemplate>> updateMany(@RequestBody List<YvsBaseArticlesTemplate> entities) throws Exception {
		return service.updateMany(entities);
	}

	@PostMapping("/deletes")
	public ResultAction<List<YvsBaseArticlesTemplate>> deleteMany(@RequestBody List<YvsBaseArticlesTemplate> entities) throws Exception {
		return service.deleteMany(entities);
	}

}
