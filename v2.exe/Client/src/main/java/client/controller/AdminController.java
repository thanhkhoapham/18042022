package client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import client.dto.UserDTO;
import client.service.NguoiDungService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private NguoiDungService nguoiDungService;

	@GetMapping("")
	public String loadAdminPage() {
		return "admin/admin-page";
	}

	@GetMapping("/user")
	public String loadAdminClientPage(ModelMap map) {
		map.addAttribute("users", nguoiDungService.getListUser());
		return "admin/admin-client";
	}

	@GetMapping("/user/add")
	public String showFormAddUser(ModelMap map) {
		map.addAttribute("user", new UserDTO());
		return "admin/admin-client-form-add";
	}
}
