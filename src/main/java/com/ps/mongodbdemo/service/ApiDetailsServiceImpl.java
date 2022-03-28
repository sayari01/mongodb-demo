package com.ps.mongodbdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ps.mongodbdemo.model.ApiDetails;
import com.ps.mongodbdemo.model.Details;
import com.ps.mongodbdemo.repository.ApiRepository;

@Service
public class ApiDetailsServiceImpl implements ApiDetailsService {
	
	@Autowired
	private ApiRepository apiRepository;
	
	//SAVE API DETAILS	
		public void createApiDetails(){
			System.out.println("Data creation started for ApiDetails...");
			apiRepository.save(new ApiDetails("Api 1", "sample Api 1", new Details("1233", "This Api is recommended", "HIGH")));
			apiRepository.save(new ApiDetails("Api 2", "sample Api 2", new Details("1234", "This Api is not recommended", "LOW")));
			apiRepository.save(new ApiDetails("Api 3", "sample Api 3", new Details("1235", "This Api is recommended but need further attention", "MEDIUM")));
			
		}

	//GET ALL API DETAILS	
		public void showAllApiDetails() {
			apiRepository.findAll().forEach(apiDetails -> System.out.println(getApiDetails(apiDetails)));
		}

	//GET API DETAILS BY NAME	
		public void getApiDetailsByName(String name) {
			System.out.println("Getting Api Details by name: " + name);
			ApiDetails apiDetails = apiRepository.findItemByName(name);
			System.out.println(getApiDetails(apiDetails));
		}
		
	//UPDATE	
	   public void updateApiDetails(String name, Details details) {
		   ApiDetails apiDetails = apiRepository.findItemByName(name);
		   System.out.println("Api Details before update: ");
		   System.out.println(getApiDetails(apiDetails));
		   apiDetails.setDetails(details);
		   apiRepository.save(apiDetails);
		   System.out.println("Api Details after update: ");
		   System.out.println(getApiDetails(apiDetails));
		  
	   }
	   
	// DELETE
		public void deleteApiDetails(String id) {
			apiRepository.deleteById(id);
			System.out.println("Item with id " + id + " deleted...");
		}

		public void findCountApiDetails() {
			long count =apiRepository.count();
			System.out.println("Number of documents in the collection: " + count);
		}

		  private String getApiDetails(ApiDetails apiDetails) {
			  
			  System.out.println( "API Id: " + apiDetails.getId() + ",\nAPI Name: " + apiDetails.getName() + ", \nApi Details: " +
					  apiDetails.getDetails());
			  
			  return "";
			  }


}
