package com.erp.lymytz.api.route.base.article;


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
import com.erp.lymytz.api.model.base.YvsSocietes;
import com.erp.lymytz.api.model.base.article.YvsBaseArticles;
import com.erp.lymytz.api.service.base.article.IArticles;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/articles")
public class ArticlesController {

	@Autowired 
	IArticles service;
	
	@GetMapping("/")
	public List<YvsBaseArticles> findAll(){
		try {
			return service.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/by_societe/{societe}")
	public List<YvsBaseArticles> findAll(@PathVariable("societe") Integer societe){
		try {
			return service.findAll(new YvsSocietes(societe));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public YvsBaseArticles findOne(@PathVariable("id") Long id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping("/")
	public ResultAction<YvsBaseArticles> save(@RequestBody YvsBaseArticles entity) throws Exception{
		return service.save(entity);
	}
	
	@PutMapping("/{id}")
	public ResultAction<YvsBaseArticles> update(@PathVariable("id") Long id, @RequestBody YvsBaseArticles entity) throws Exception {
		return service.update(id, entity);
	}
	
	@DeleteMapping("/{id}")
	public ResultAction<YvsBaseArticles> delete(@PathVariable("id") Long id) throws Exception {
		return service.delete(id);
	}
	
	@PostMapping("/updates")
	public ResultAction<List<YvsBaseArticles>> updateMany(@RequestBody List<YvsBaseArticles> entities) throws Exception {
		return service.updateMany(entities);
	}
	
	@PostMapping("/deletes")
	public ResultAction<List<YvsBaseArticles>> deleteMany(@RequestBody List<YvsBaseArticles> entities) throws Exception {
		return service.deleteMany(entities);
	}

}
