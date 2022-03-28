package com.ps.mongodbdemo.service;

import org.springframework.stereotype.Service;

import com.ps.mongodbdemo.model.Details;

@Service
public interface ApiDetailsService {

	public void createApiDetails();

	public void showAllApiDetails();

	public void getApiDetailsByName(String name);

	public void updateApiDetails(String name, Details details);

	public void deleteApiDetails(String id);

	public void findCountApiDetails();
}
