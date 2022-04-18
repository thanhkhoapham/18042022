package server.api.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.dto.SanPhamDTO;
import server.service.SanPhamService;

@RestController
@RequestMapping("/product")
public class SanPhamApi {
	
	@Autowired
	private SanPhamService pService;
	
	@GetMapping("")
	public List<SanPhamDTO> getAllProduct(){
		return pService.getAllProduct();
	}
	
//	@GetMapping("/category/{type}")
//	public List<SanPhamDTO> getProductsByType(@PathVariable String type){
//		return pService.getProductsByType(type);
//	}
	
	@GetMapping("/init")
	public String init(){
		pService.initData();
		return "Data inited?";
	}
	
	@GetMapping("/{id}")
	public SanPhamDTO getProduct(@PathVariable int id){
		return pService.getProductById(id);
	}
	
//	@GetMapping("/type/{id}")
//	public String getProductType(@PathVariable int id){
//		return pService.getProductType(id);
//	}
//	
//	@GetMapping("/{type}/{id}")
//	public Object getProductDetail(@PathVariable String type, @PathVariable int id){
//		return pService.getProductDetail(type, id);
//	}
}