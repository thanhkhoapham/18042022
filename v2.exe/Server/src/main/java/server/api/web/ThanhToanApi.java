package server.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;

import server.dto.PaymentDTO;
import server.service.PaypalService;

@RestController
@RequestMapping("/payment")
public class ThanhToanApi {
	
	@Autowired
	private PaypalService paypalService;
	
	//Gửi về client đường dẫn dến trang thanh toán paypal
	@PostMapping("/create")
	public Object createPayment(@RequestBody PaymentDTO paymentDTO){
		try {
			String redirectUrl = "";
			Payment payment = paypalService.createPayment(paymentDTO.getTotal(), paymentDTO.getCurrency(), paymentDTO.getMethod(), 
					paymentDTO.getIntent(), paymentDTO.getDescription(), paymentDTO.getCancelUrl(), paymentDTO.getSuccessUrl());
			for(Links links : payment.getLinks()){
				if(links.getRel().equals("approval_url")){
					redirectUrl = "redirect:" + links.getHref();
				}
			}
			return new ResponseEntity<Object>(redirectUrl, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//Gửi về client payment state khi tiến hành thanh toán
	@GetMapping("/execute/{paymentId}/{payerID}")
	public Object executePayment(@PathVariable String paymentId, @PathVariable String payerID){
		try {
			Payment payment = paypalService.executePayment(paymentId, payerID);
			return new ResponseEntity<Object>(payment.getState(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
	}
}
