package com.ps.mongodbdemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ps.mongodbdemo.model.ApiDetails;
import com.ps.mongodbdemo.model.Details;
import com.ps.mongodbdemo.repository.ApiRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ApiDetailsServiceImplTest {

	@Mock
	ApiDetailsServiceImpl apiDetailsServiceImpl;

	@Mock
	ApiRepository apiRepository;

	@Test
	void createApiDetailsTest() {
		ApiDetails apiDetails = new ApiDetails("Api 76", "sample Api 76",
				new Details("76543", "This Api is recommended", "HIGH"));
		when(apiRepository.save(apiDetails)).thenReturn(apiDetails);
		doNothing().when(apiDetailsServiceImpl).createApiDetails();
		assertEquals("sample Api 76", apiDetails.getName());
	}

	@Test
	void showAllApiDetailsTest() {
		ApiDetails apiDetails = new ApiDetails("Api 76", "sample Api 76",
				new Details("76543", "This Api is recommended", "HIGH"));
		List<ApiDetails> respList = new ArrayList<>();
		respList.add(apiDetails);
		when(apiRepository.findAll()).thenReturn(respList);
		doNothing().when(apiDetailsServiceImpl).showAllApiDetails();
		assertEquals("Api 76", respList.get(0).getId());

	}

	@Test
	void getApiDetailsByNameTest() {
		ApiDetails apiDetails = new ApiDetails("Api 76", "sample Api 76",
				new Details("76543", "This Api is recommended", "HIGH"));
		when(apiRepository.findItemByName(Mockito.anyString())).thenReturn(apiDetails);
		doNothing().when(apiDetailsServiceImpl).getApiDetailsByName("sample Api 76");
		assertEquals("Api 76", apiDetails.getId());

	}

	@Test
	void updateApiDetailsTest() {
		ApiDetails apiDetails = new ApiDetails("Api 76", "sample Api 76",
				new Details("76543", "This Api is recommended", "HIGH"));
		Details details = new Details("134", "This is sample message", "HIGH");
		when(apiRepository.findItemByName(Mockito.anyString())).thenReturn(apiDetails);
		when(apiRepository.save(apiDetails)).thenReturn(apiDetails);
		doNothing().when(apiDetailsServiceImpl).updateApiDetails("sample Api 76", details);
		assertEquals("Api 76", apiDetails.getId());
	}

	@Test
	void deleteApiDetailsTest(){
		ApiDetails apiDetails = new ApiDetails("Api 76", "sample Api 76", new Details("76543", "This Api is recommended", "HIGH"));
		doNothing().when(apiRepository).deleteById(Mockito.anyString());
		doNothing().when(apiDetailsServiceImpl).deleteApiDetails("Api 76");
		assertEquals("Api 76", apiDetails.getId());
	}

	@Test
	void findCountApiDetailsTest() {
		ApiDetails apiDetails = new ApiDetails("Api 76", "sample Api 76", new Details("76543", "This Api is recommended", "HIGH"));
		when(apiRepository.count()).thenReturn(2l);
		doNothing().when(apiDetailsServiceImpl).findCountApiDetails();
		assertEquals("Api 76", apiDetails.getId());
	}
}
