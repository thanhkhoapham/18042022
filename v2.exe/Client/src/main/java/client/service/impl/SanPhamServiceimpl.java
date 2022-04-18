package client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import client.dto.SanPhamDTO;
import client.service.SanPhamService;

@Service
public class SanPhamServiceimpl implements SanPhamService{
	private RestTemplate restTemplate;
	private String restUrl;
	
	
	@Autowired
	public SanPhamServiceimpl(RestTemplate restTemplate, @Value("${crm.rest.url}") String restUrl) {
		this.restTemplate = restTemplate;
		this.restUrl = restUrl +"product";
	}

	//	/product
	@Override
	public List<SanPhamDTO> getAllProduct() {
		ResponseEntity<List<SanPhamDTO>> responseEntity = restTemplate.exchange(restUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<SanPhamDTO>>() {});
		return responseEntity.getBody();
	}

	
	//	/product/id
	@Override
	public SanPhamDTO getProductById(int id) {
		ResponseEntity<SanPhamDTO> responseEntity = restTemplate.exchange(restUrl+"/"+id, HttpMethod.GET, null, new ParameterizedTypeReference<SanPhamDTO>() {});
		return responseEntity.getBody();
	}

}
