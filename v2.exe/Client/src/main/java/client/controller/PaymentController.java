package client.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.paypal.base.rest.PayPalRESTException;

import client.dto.GioHangDTO;
import client.dto.PaymentDTO;
import client.dto.UserLoginDTO;
import client.enums.PaypalPaymentIntent;
import client.enums.PaypalPaymentMethod;
import client.service.DonHangService;
import client.service.NguoiDungService;
import client.service.PaypalService;
import client.utils.GioHangUtils;
import client.utils.PaypalUtils;

@Controller
public class PaymentController {
	
	public static final String URL_PAYPAL_SUCCESS = "/pay/success";
	public static final String URL_PAYPAL_CANCEL = "/pay/cancel";
	
	@Autowired
	private PaypalService paypalService;
	
	@Autowired
	private DonHangService donHangService;
	
	@PostMapping("/createPayment")
	public String createPayment(HttpServletRequest request,@RequestParam("price") double price ){
		//localhost:8080/pay/cancel
		String cancelUrl = PaypalUtils.getBaseURL(request) + URL_PAYPAL_CANCEL;
		//localhost:8080/pay/success
		String successUrl = PaypalUtils.getBaseURL(request) + URL_PAYPAL_SUCCESS;
		
		try {
			PaymentDTO paymentDTO = new PaymentDTO();
			paymentDTO.setTotal(price);
			paymentDTO.setCurrency("USD");
			paymentDTO.setMethod(PaypalPaymentMethod.paypal);
			paymentDTO.setIntent(PaypalPaymentIntent.sale);
			paymentDTO.setDescription("Thanh toán hóa đơn!");
			paymentDTO.setCancelUrl(cancelUrl);
			paymentDTO.setSuccessUrl(successUrl);
			
			//paymentUrl = redirect:{link trang thanh toán};
			String paymentUrl = paypalService.getPaymentUrl(paymentDTO);
			return paymentUrl;
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@GetMapping(URL_PAYPAL_CANCEL)
	public String cancelPay(){
		return "redirect:/checkout?error=true";
	}
	
	//Thanh toán thành công thì lưu đơn hàng vào db
	@GetMapping(URL_PAYPAL_SUCCESS)
	public String successPay(HttpServletRequest request, ModelMap modelMap, @RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
		try {
			String paymentState = paypalService.getExecuteState(paymentId, payerId);
			if (paymentState.equals("approved")) {
				//Lưu đơn hàng vào db
				GioHangDTO gioHang = GioHangUtils.layGioHang(request);
				gioHang.getDonHangForm().setPaid(true);
				donHangService.addOrder(gioHang);
				
				//Xóa giỏ hàng khi đặt thành công
				GioHangUtils.xoaGioHang(request);
				
				//Chuyển sang trang thông báo thành công
				return "test/success";
			}
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
		
		
		return "redirect:/";
		
	}
	
}
