package server.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import server.entity.NhaCungCap;

@Repository
public interface NhaCungCapRepository extends JpaRepository<NhaCungCap, Integer> {
	@Query(value = "SELECT * FROM nha_cung_cap WHERE id = ?1", nativeQuery = true)
	NhaCungCap findSupplierByID(int id);

	@Query(value = "SELECT * FROM nha_cung_cap WHERE enable = 'true'", nativeQuery = true)
	List<NhaCungCap> findAll();

	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Transactional
	@Query(value = "UPDATE nha_cung_cap	SET enable = 'false' WHERE id = ?1", nativeQuery = true)
	void deleteSuppliernyId(int id);

}
