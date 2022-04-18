package server.dto;

import server.enums.PaypalPaymentIntent;
import server.enums.PaypalPaymentMethod;

public class PaymentDTO {
	private Double total;
	private String currency;
	private PaypalPaymentMethod method;
	private PaypalPaymentIntent intent;
	private String description;
	private String cancelUrl;
	private String successUrl;
	
	public PaymentDTO() {
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public PaypalPaymentMethod getMethod() {
		return method;
	}

	public void setMethod(PaypalPaymentMethod method) {
		this.method = method;
	}

	public PaypalPaymentIntent getIntent() {
		return intent;
	}

	public void setIntent(PaypalPaymentIntent intent) {
		this.intent = intent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCancelUrl() {
		return cancelUrl;
	}

	public void setCancelUrl(String cancelUrl) {
		this.cancelUrl = cancelUrl;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}

	@Override
	public String toString() {
		return "PaymentDTO [total=" + total + ", currency=" + currency + ", method=" + method + ", intent=" + intent
				+ "]";
	}
	
	
}
