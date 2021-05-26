package com.virtusa.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.webseriesmodel.WebseriesModel;

public interface Repo extends JpaRepository<WebseriesModel,Integer> {
		public List<WebseriesModel> findByName(String name);
}
