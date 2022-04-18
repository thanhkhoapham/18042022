package client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import client.dto.UserDTO;
import client.dto.UserInfoDTO;
import client.service.NguoiDungService;

@Service
public class NguoiDungServiceImpl implements NguoiDungService {

	private String restUrl;
	private RestTemplate restTemplate;

	public NguoiDungServiceImpl(@Value("${crm.rest.url}") String restUrl, RestTemplate restTemplate) {
		this.restUrl = restUrl;
		this.restTemplate = restTemplate;
	}

	@Override
	public UserInfoDTO getUserInfo(int id) {
		ResponseEntity<UserInfoDTO> responseEntity = restTemplate.exchange(restUrl + "/user/info/" + id, HttpMethod.GET,
				null, new ParameterizedTypeReference<UserInfoDTO>() {
				});
		return responseEntity.getBody();
	}

	@Override
	public List<UserDTO> getListUser() {
		ResponseEntity<List<UserDTO>> responseEntity = restTemplate.exchange(restUrl + "/admin/user", HttpMethod.GET,
				null, new ParameterizedTypeReference<List<UserDTO>>() {
				});
		return responseEntity.getBody();
	}

}
