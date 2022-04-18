package client.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.paypal.base.rest.PayPalRESTException;

import client.dto.PaymentDTO;
import client.service.PaypalService;

@Service
public class PaypalServiceImpl implements PaypalService{

	private RestTemplate restTemplate;
	private String restUrl;
	
	@Autowired
	public PaypalServiceImpl(RestTemplate restTemplate, @Value("${crm.rest.url}") String restUrl) {
		this.restTemplate = restTemplate;
		this.restUrl = restUrl +"payment";
	}

	@Override
	public String getPaymentUrl(PaymentDTO paymentDTO)  throws PayPalRESTException{
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(restUrl+"/create", paymentDTO, String.class);
		return responseEntity.getBody();
	}

	@Override
	public String getExecuteState(String paymentId, String payerId) throws PayPalRESTException {
		ResponseEntity<String> responseEntity = restTemplate.exchange(restUrl+"/execute/"+paymentId+"/"+payerId, HttpMethod.GET, null, new ParameterizedTypeReference<String>() {});
		return responseEntity.getBody();
	}

}
