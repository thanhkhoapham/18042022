package server.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import server.converter.NhaCungCapConverter;
import server.dto.NhaCungCapDTO;
import server.entity.NhaCungCap;
import server.repository.NhaCungCapRepository;
import server.service.NhaCungCapService;

@Service
public class NhaCungCapServiceImpl implements NhaCungCapService {

	@Autowired
	private NhaCungCapRepository repository;

	@Autowired
	private NhaCungCapConverter converter;

	@Override
	public List<NhaCungCapDTO> getAllSupplier() {
		List<NhaCungCap> dungs = repository.findAll();
		List<NhaCungCapDTO> list = new ArrayList<NhaCungCapDTO>();
		for (NhaCungCap o : dungs) {
			list.add(converter.toDTO(o));
		}
		return list;
	}

	@Override
	public NhaCungCapDTO getSupplierById(int id) {
		NhaCungCap o = repository.findById(id).orElse(null);
		NhaCungCapDTO ncc = converter.toDTO(o);
		return ncc;
	}

	@Override
	public void addSupplier(NhaCungCapDTO capDTO) {
		NhaCungCap o = converter.toEntity(capDTO);
		o.setEnable(true);
		repository.save(o);

	}

	@Override
	public void deleteSupplier(int id) {
		repository.deleteSuppliernyId(id);
	}

	@Override
	public void updateSupplier(int id, NhaCungCapDTO newSupp) {
		NhaCungCap ncc = repository.findById(id).orElse(null);
		ncc.setDiaChi(newSupp.getDiaChi());
		ncc.setSoDienThoai(newSupp.getSoDienThoai());
		ncc.setTenNhaCungCap(newSupp.getTenNhaCungCap());
		repository.save(ncc);
	}

}
