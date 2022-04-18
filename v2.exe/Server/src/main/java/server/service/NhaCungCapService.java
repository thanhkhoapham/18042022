package server.service;

import java.util.List;

import server.dto.NhaCungCapDTO;

public interface NhaCungCapService {
	List<NhaCungCapDTO> getAllSupplier();

	NhaCungCapDTO getSupplierById(int id);

	void addSupplier(NhaCungCapDTO capDTO);

	void deleteSupplier(int id);

	void updateSupplier(int id, NhaCungCapDTO newSupp);

}
