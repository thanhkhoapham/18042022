package client.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import client.dto.GioHangDTO;
import client.service.DonHangService;

@Service
public class DonHangServiceImpl implements DonHangService{

	private RestTemplate restTemplate;
	private String restUrl;
	
	public DonHangServiceImpl(@Value("${crm.rest.url}") String restUrl, RestTemplate restTemplate) {
		this.restUrl = restUrl +"order";
		this.restTemplate = restTemplate;
	}

	@Override
	public String addOrder(GioHangDTO gioHangDTO) {
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(restUrl+"/save", gioHangDTO, String.class);
		return responseEntity.getBody();
	}

}
