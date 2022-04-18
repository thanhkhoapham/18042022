package client.utils;

import javax.servlet.http.HttpServletRequest;

import client.dto.GioHangDTO;

public class GioHangUtils {
	
	public static GioHangDTO layGioHang(HttpServletRequest request) {
		GioHangDTO gioHang = (GioHangDTO) request.getSession().getAttribute("myCart");
		
		if (gioHang == null) {
			gioHang = new GioHangDTO();
			request.getSession().setAttribute("myCart", gioHang);
		}
		return gioHang;
	}
	
	public static void xoaGioHang(HttpServletRequest request) {
		request.getSession().removeAttribute("myCart");
	}
}
