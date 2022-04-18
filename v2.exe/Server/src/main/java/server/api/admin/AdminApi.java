package server.api.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.dto.NhaCungCapDTO;
import server.dto.UserDTO;
import server.service.NguoiDungService;
import server.service.NhaCungCapService;

@RestController
@RequestMapping("/admin")
public class AdminApi {

	@Autowired
	private NguoiDungService nguoiDungService;

	@Autowired
	private NhaCungCapService nhaCungCapService;

	// ========> User
	@GetMapping("/user")
	public Object getListUser() {
		try {
			return new ResponseEntity<List<UserDTO>>(nguoiDungService.getListUser(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
		}
	}

	// ========> Supplier
	@GetMapping("/supplier")
	public Object getListSupplier() {
		try {
			return new ResponseEntity<List<NhaCungCapDTO>>(nhaCungCapService.getAllSupplier(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/supplier/{id}")
	public Object getSupplierById(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<NhaCungCapDTO>(nhaCungCapService.getSupplierById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/supplier")
	public Object addSupplier(@RequestBody NhaCungCapDTO capDTO) {
		try {
			nhaCungCapService.addSupplier(capDTO);
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/supplier/delete/{id}")
	public Object deleteSupplier(@PathVariable("id") int id) {
		try {
			nhaCungCapService.deleteSupplier(id);
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/supplier/{id}")
	public Object updateSupplier(@PathVariable("id") int id, @RequestBody NhaCungCapDTO newS) {
		try {
			nhaCungCapService.updateSupplier(id, newS);
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
		}
	}
}
