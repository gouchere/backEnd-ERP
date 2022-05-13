package com.erp.lymytz.api.route.base.emplacement;


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
import com.erp.lymytz.api.model.base.YvsAgences;
import com.erp.lymytz.api.model.base.YvsSocietes;
import com.erp.lymytz.api.model.base.emplacement.YvsBaseDepots;
import com.erp.lymytz.api.service.base.emplacement.IDepots;

@RestController
@CrossOrigin("*")
@RequestMapping("lymytz_erp/depots")
public class DepotsController {

	@Autowired 
	IDepots service;
	
	@GetMapping("/")
	public List<YvsBaseDepots> findAll(){
		try {
			return service.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/by_societe/{societe}")
	public List<YvsBaseDepots> findAll(@PathVariable("societe") Integer societe){
		try {
			return service.findAll(new YvsSocietes(societe));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/by_agence/{agence}")
	public List<YvsBaseDepots> findByAgence(@PathVariable("agence") Long agence){
		try {
			return service.findByAgence(new YvsAgences(agence));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/{id}")
	public YvsBaseDepots findOne(@PathVariable("id") Long id) throws Exception{
		return service.findById(id);
	}
	
	@PostMapping("/")
	public ResultAction<YvsBaseDepots> save(@RequestBody YvsBaseDepots entity) throws Exception{
		return service.save(entity);
	}
	
	@PutMapping("/{id}")
	public ResultAction<YvsBaseDepots> update(@PathVariable("id") Long id, @RequestBody YvsBaseDepots entity) throws Exception {
		return service.update(id, entity);
	}
	
	@DeleteMapping("/{id}")
	public ResultAction<YvsBaseDepots> delete(@PathVariable("id") Long id) throws Exception {
		return service.delete(id);
	}
	
	@PostMapping("/updates")
	public ResultAction<List<YvsBaseDepots>> updateMany(@RequestBody List<YvsBaseDepots> entities) throws Exception {
		return service.updateMany(entities);
	}
	
	@PostMapping("/deletes")
	public ResultAction<List<YvsBaseDepots>> deleteMany(@RequestBody List<YvsBaseDepots> entities) throws Exception {
		return service.deleteMany(entities);
	}

}
