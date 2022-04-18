package server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**") // CẤU HÌNH NÀY CHỈ CÓ TÁC DỤNG VỚI url BẮT ĐẦU BẰNG /api/
		.allowedOrigins("*") // CÁC TÊN MỀN ĐƯỢC PHÉP TRUY CẬP
		.allowedMethods("GET", "POST", "PUT", "DELETE") // CÁC PHƯƠNG THỨC ĐƯỢC PHÉP TRUY CẬP
		.allowCredentials(false) // KHÔNG SỬ DỤNG COOKIE
		.maxAge(4800); // LƯU VÀO BỘ NHỚ ĐỆM 4800s
		
	}
}
