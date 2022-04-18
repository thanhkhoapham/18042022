package client.service;

import com.paypal.base.rest.PayPalRESTException;

import client.dto.PaymentDTO;

public interface PaypalService {
	public String getPaymentUrl(PaymentDTO paymentDTO) throws PayPalRESTException;
	public String getExecuteState(String paymentId, String payerId) throws PayPalRESTException;
}
