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
import com.erp.lymytz.api.model.base.article.YvsBaseFamilleArticle;
import com.erp.lymytz.api.service.base.article.IFamilleArticle;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/familles_article")
public class FamilleArticleController {

	@Autowired 
	IFamilleArticle service;
	
	@GetMapping("/")
	public List<YvsBaseFamilleArticle> findAll(){
		try {
			return service.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/by_societe/{societe}")
	public List<YvsBaseFamilleArticle> findAll(@PathVariable("societe") Integer societe){
		try {
			return service.findAll(new YvsSocietes(societe));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public YvsBaseFamilleArticle findOne(@PathVariable("id") Long id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping("/")
	public ResultAction<YvsBaseFamilleArticle> save(@RequestBody YvsBaseFamilleArticle entity) throws Exception{
		return service.save(entity);
	}
	
	@PutMapping("/{id}")
	public ResultAction<YvsBaseFamilleArticle> update(@PathVariable("id") Long id, @RequestBody YvsBaseFamilleArticle entity) throws Exception {
		return service.update(id, entity);
	}
	
	@DeleteMapping("/{id}")
	public ResultAction<YvsBaseFamilleArticle> delete(@PathVariable("id") Long id) throws Exception {
		return service.delete(id);
	}
	
	@PostMapping("/updates")
	public ResultAction<List<YvsBaseFamilleArticle>> updateMany(@RequestBody List<YvsBaseFamilleArticle> entities) throws Exception {
		return service.updateMany(entities);
	}
	
	@PostMapping("/deletes")
	public ResultAction<List<YvsBaseFamilleArticle>> deleteMany(@RequestBody List<YvsBaseFamilleArticle> entities) throws Exception {
		return service.deleteMany(entities);
	}

}
