package server.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;


public class AuthFilter extends BasicAuthenticationFilter{
	
	private UserDetailsService userDetailsService;

	public AuthFilter(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
		super(authenticationManager);
		this.userDetailsService = userDetailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		if(request.getServletPath().startsWith("/api/auth/register")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(request.getServletPath().startsWith("/api/auth/login")) {
			chain.doFilter(request, response);
			return;
		}
		
		if(request.getServletPath().startsWith("/api/auth/verify")) {
			chain.doFilter(request, response);
			return;
		}

		if(request.getServletPath().startsWith("/api/product")) {
			chain.doFilter(request, response);
			return;
		}
		
		// B1. LẤY TOKEN TỪ REQUEST
		String tokenHeader = request.getHeader("Authorization");
		
		if(tokenHeader != null && !tokenHeader.isEmpty() && tokenHeader.startsWith("Bearer ")) {
			// lấy token chuẩn
			String token = tokenHeader.replace("Bearer ", "");
			// GIẢI MÃ TOKEN LẤY EMAIL
			String email = Jwts.parser()
			.setSigningKey("ABC_EGH")
			.parseClaimsJws(token)
			.getBody()
			.getSubject();
			
			// GỌI PHƯƠNG THỨC LẤY THÔNG TIN USER (UserDetailDTO)
			UserDetails userDetails = userDetailsService.loadUserByUsername(email);
			
			// email, pw: null, quyền
			Authentication authentication = 
					new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			
			// SET THÔNG TIN USER VÀO CONTEXT => ĐỂ PHÂN QUYỀN
			SecurityContextHolder.getContext().setAuthentication(authentication);
			chain.doFilter(request, response);
		}
		else {
			response.sendError(401, "Chưa đăng nhập!");
		}
		
	}
}