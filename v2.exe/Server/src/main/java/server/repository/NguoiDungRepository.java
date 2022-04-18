package server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import server.entity.NguoiDung;

@Repository
public interface NguoiDungRepository extends JpaRepository<NguoiDung, Integer>{
	
	@Query(value = "SELECT * FROM nguoi_dung WHERE email = ?1", nativeQuery = true)
	NguoiDung findUserByEmail(String email);
	
	@Query(value = "SELECT * FROM nguoi_dung WHERE verification_code = ?1", nativeQuery = true)
	NguoiDung findByVerificationCode(String code);
	
}
