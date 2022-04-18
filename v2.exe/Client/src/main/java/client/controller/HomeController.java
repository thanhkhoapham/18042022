package client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import client.dto.GioHangDTO;
import client.dto.SanPhamDTO;
import client.dto.UserInfoDTO;
import client.dto.UserLoginDTO;
import client.form.DonHangForm;
import client.service.DonHangService;
import client.service.NguoiDungService;
import client.service.SanPhamService;
import client.utils.GioHangUtils;

@Controller
@RequestMapping("/")
public class HomeController {
	
	private final double oneDollar = 22870;
	
	@Autowired
	private SanPhamService sanPhamService;
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@Autowired
	private DonHangService donHangService;
	
	@GetMapping("")
	public String showHomePage(ModelMap modelMap) {
		List<SanPhamDTO> products = sanPhamService.getAllProduct();
		modelMap.addAttribute("products", products);
		return "client/home-page";
	}
	
	@GetMapping("/info")
	public String showInfoPage() {
		return "client/info-page";
	}
	
	@GetMapping("/product/{sanPham_id}")
	public String showProductPage(ModelMap modelMap, @PathVariable("sanPham_id") int sanpham_id) {
		SanPhamDTO sanPham = sanPhamService.getProductById(sanpham_id);
//		Object detail = sanPhamService.getProductDetail(sanpham_id);
//		String productType = sanPhamService.getProductType(sanpham_id);
		modelMap.addAttribute("product", sanPham);
//		modelMap.addAttribute("detail", detail);
//		modelMap.addAttribute("productType", productType);
		return "client/product-page";
	}
	
	/**
	 * Xử lý giỏ hàng
	 **/
	@GetMapping("/cart")
	public String showCartPage(HttpServletRequest request, ModelMap modelMap) {
		GioHangDTO gioHang = GioHangUtils.layGioHang(request);
		double tongTien = gioHang.tinhTongThanhTien();
		modelMap.addAttribute("gioHang", gioHang);
		modelMap.addAttribute("tongTien", tongTien);
		return "client/cart-page";
	}
	
	@GetMapping("/addToCart")
	public String addToCart(HttpServletRequest request, ModelMap modelMap, @RequestParam("id") int sanpham_id) {
		SanPhamDTO sanPham = sanPhamService.getProductById(sanpham_id);
//		int soLuong = Integer.parseInt(request.getParameter("soLuong"));
		
		GioHangDTO gioHang = GioHangUtils.layGioHang(request);
//		gioHang.themSanPham(sanPham, soLuong);
		gioHang.themSanPham(sanPham, 1);
		return "redirect:/cart";
	}
	
	@GetMapping("/deleteFromCart")
	public String deleteFromCart(HttpServletRequest request, ModelMap modelMap, @RequestParam("id") int sanpham_id) {
		SanPhamDTO sanPham = sanPhamService.getProductById(sanpham_id);
		GioHangDTO gioHang = GioHangUtils.layGioHang(request);
		gioHang.xoaSanPham(sanPham);
		return "redirect:/cart";
	}
	
	@PostMapping("/updateCart")
	public String updateCart(HttpServletRequest request, ModelMap modelMap,
			@ModelAttribute("gioHang") GioHangDTO gioHangNew) {
		GioHangDTO gioHang = GioHangUtils.layGioHang(request);
		gioHang.capNhatSoLuong(gioHangNew);
		return "redirect:/cart";
	}
	
	@GetMapping("/checkout")
	public String showCheckoutPage(HttpServletRequest request, ModelMap modelMap, RedirectAttributes attributes) {
		GioHangDTO gioHang = GioHangUtils.layGioHang(request);
		String thBao = "";
		
		//Kiểm tra user đã đăng nhập hay chưa, nếu chưa thì redirect sang trang login
		UserLoginDTO user = (UserLoginDTO) request.getSession().getAttribute("user");
		if (user == null) {
			thBao = "Vui lòng đăng nhập để tiếp tục!!";
			attributes.addFlashAttribute("thBao", thBao);
			return "redirect:/auth/login";
		}
		//Nếu trong giỏ chưa có sản phẩm thì redirect ra trang chủ
		else if(gioHang.getDsCT().size() <= 0) {
			return "redirect:/";
		}
		else {
			UserInfoDTO nguoiDung = nguoiDungService.getUserInfo(user.getUserId());
			double tongTien = gioHang.tinhTongThanhTien();
			
			//Chuyển thành tiền từ VND sang USD
			double formate = tongTien/oneDollar;
			double tongTien_dollar = Math.round(formate * 100) / 100.0;
			
			DonHangForm dhf = new DonHangForm();
			dhf.setPaid(false);
			
			modelMap.addAttribute("gioHang", gioHang);
			modelMap.addAttribute("nguoiDung", nguoiDung);
			modelMap.addAttribute("tongTien", tongTien);
			modelMap.addAttribute("tongTien_dollar", tongTien_dollar);
			modelMap.addAttribute("donHangForm", dhf);
		}
		return "client/checkout-page";
	}
	
	@PostMapping("/checkout")
	public String confirmOrder(HttpServletRequest request, @ModelAttribute("donHangForm") DonHangForm donHangForm, ModelMap modelMap) {
		GioHangDTO gioHang = GioHangUtils.layGioHang(request);
		gioHang.setDonHangForm(donHangForm);
		
		double tongTien = gioHang.tinhTongThanhTien();
		
		//Chuyển thành tiền từ VND sang USD
		double formate = tongTien/oneDollar;
		double tongTien_dollar = Math.round(formate * 100) / 100.0;
		
		modelMap.addAttribute("tongTien_dollar", tongTien_dollar);
		modelMap.addAttribute("gioHang", gioHang);
		return "client/checkout-confirm-page";
	}
	
	@PostMapping("/sendOrderInfo")
	public String sendOrder(HttpServletRequest request) {
		GioHangDTO gioHang = GioHangUtils.layGioHang(request);
		donHangService.addOrder(gioHang);
		
		//Xóa giỏ hàng khi đặt thành công
		GioHangUtils.xoaGioHang(request);
		
		//redirect ra trang đặt hàng thành công
		return "redirect:/";
	}
	
	
}
