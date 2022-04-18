package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import server.entity.SanPham;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer>{
	
	@Query(value = "SELECT loai_sanpham FROM san_pham WHERE id = ?1", nativeQuery = true)
	String getProductType(int id);
}
