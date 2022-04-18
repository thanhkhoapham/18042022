package server.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.dto.GioHangDTO;
import server.service.DonHangService;

@RestController
@RequestMapping("/order")
public class DonHangApi {
	
	@Autowired
	private DonHangService donHangService;
	
	@PostMapping("/save")
	public Object saveOrder(@RequestBody GioHangDTO gioHangDTO) {
		try {
			donHangService.addOrder(gioHangDTO);
			return new ResponseEntity<Object>("Order Success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>("Order Failed", HttpStatus.BAD_REQUEST);
		}
	}

}
