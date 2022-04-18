package server.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import server.dto.UserInfoDTO;
import server.service.NguoiDungService;

@RestController
@RequestMapping("/user")
public class NguoiDungApi {
	
	@Autowired
	private NguoiDungService nguoiDungService;
	
	@GetMapping("/info/{id}")
	public UserInfoDTO getUserInfo(@PathVariable int id){
		return nguoiDungService.getUserInfoById(id);
	}
}
