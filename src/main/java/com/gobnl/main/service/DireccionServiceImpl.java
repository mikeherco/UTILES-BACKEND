package com.gobnl.main.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gobnl.main.dto.DireccionDTO;
import com.gobnl.main.entity.Direccion;
import com.gobnl.main.exception.GobNLException;
import com.gobnl.main.repository.DireccionRepository;

@Service
public class DireccionServiceImpl implements DireccionService {
	
	@Autowired
	private DireccionRepository dirRepo;

	@Override
	public List<DireccionDTO> getAll() throws GobNLException {
		List<Direccion> dirReq = dirRepo.findAll();
		List<DireccionDTO> direccion = new ArrayList<>();
		dirReq.forEach(x -> {
			DireccionDTO dir = new DireccionDTO(x);
			direccion.add(dir);
		});
		return direccion;
	}
	@Override
	public DireccionDTO getDireccionByCurp(String curp) throws GobNLException {
		Direccion dir = dirRepo.getDireccionByCurp(curp);
		return new DireccionDTO(dir);
	}
	@Override
	public String saveDireccion(DireccionDTO direccion) throws GobNLException {
		Direccion dirReq = new Direccion(direccion);
		Direccion dirRes = dirRepo.insert(dirReq);
		return dirRes.getSolCurp();
	}
}