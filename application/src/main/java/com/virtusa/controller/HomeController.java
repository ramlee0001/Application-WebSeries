package com.virtusa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.dao.Repo;
import com.virtusa.webseriesmodel.WebseriesModel;

@RestController
public class HomeController {
	@Autowired
	Repo repo;
	
	
	@PostMapping("/addseries")
	public WebseriesModel addseries(@RequestBody WebseriesModel wbm) {
		repo.save(wbm);
		return(wbm);
	}
	
	@GetMapping("/series")
	public List<WebseriesModel> getallseries() {
		return(repo.findAll());
		
	}
	
	@GetMapping("/series/id/{id}")
	public Optional<WebseriesModel> getseriesbyid(@PathVariable("id") int id) {
		return(repo.findById(id));
		
	}
	
	@GetMapping("/series/name/{name}")
	public List<WebseriesModel> getseriesbyname(@PathVariable("name") String name) {
		return(repo.findByName(name));
		
	}
	
	@PutMapping("/update")
	public WebseriesModel updateseries(@RequestBody WebseriesModel wbm) {
			repo.save(wbm);
			return(wbm);
		
	}
	
	@DeleteMapping("delete/{id}")
	public String deleteseries(@PathVariable("id") int id) {
		if(repo.existsById(id)) {
			repo.deleteById(id);
		}
		return("deleted");
		
	}
}
