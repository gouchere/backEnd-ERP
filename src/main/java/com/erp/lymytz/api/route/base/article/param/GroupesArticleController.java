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
import com.erp.lymytz.api.model.base.article.param.YvsBaseGroupesArticle;
import com.erp.lymytz.api.service.base.article.param.IGroupesArticle;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/groupes_article")
public class GroupesArticleController {

	@Autowired
	IGroupesArticle service;

	@GetMapping("/")
	public List<YvsBaseGroupesArticle> findAll(){
		try {
			return service.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/by_societe/{societe}")
	public List<YvsBaseGroupesArticle> findAll(@PathVariable("societe") Integer societe){
		try {
			return service.findAll(new YvsSocietes(societe));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/{id}")
	public YvsBaseGroupesArticle findOne(@PathVariable("id") Long id) throws Exception{
		return service.findById(id);
	}

	@PostMapping("/")
	public ResultAction<YvsBaseGroupesArticle> save(@RequestBody YvsBaseGroupesArticle entity) throws Exception{
		return service.save(entity);
	}

	@PutMapping("/{id}")
	public ResultAction<YvsBaseGroupesArticle> update(@PathVariable("id") Long id, @RequestBody YvsBaseGroupesArticle entity) throws Exception {
		return service.update(id, entity);
	}

	@DeleteMapping("/{id}")
	public ResultAction<YvsBaseGroupesArticle> delete(@PathVariable("id") Long id) throws Exception {
		return service.delete(id);
	}

	@PostMapping("/updates")
	public ResultAction<List<YvsBaseGroupesArticle>> updateMany(@RequestBody List<YvsBaseGroupesArticle> entities) throws Exception {
		return service.updateMany(entities);
	}

	@PostMapping("/deletes")
	public ResultAction<List<YvsBaseGroupesArticle>> deleteMany(@RequestBody List<YvsBaseGroupesArticle> entities) throws Exception {
		return service.deleteMany(entities);
	}

}
