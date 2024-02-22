package com.gobnl.main.service;

import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import com.gobnl.main.exception.GobNLException;
import org.springframework.stereotype.Service;
import com.gobnl.main.repository.EscuelaRepository;
import com.gobnl.main.dto.EscuelaDTO;
import com.gobnl.main.entity.Escuela;


@Service
public class EscuelaServiceImpl implements EscuelaService {

	@Autowired
	private EscuelaRepository escuelaRepository;
	
	@Override
	public List<EscuelaDTO> getAll() throws GobNLException {
		List<Escuela> escReq = escuelaRepository.findAll();
		List<EscuelaDTO> escuelas = new ArrayList<>();
		escReq.forEach(x -> {
			EscuelaDTO esc = new EscuelaDTO(x);
			escuelas.add(esc);
		});
 		return escuelas;
	}

	@Override
	public EscuelaDTO getById(String id) throws GobNLException {
		Escuela escRes = escuelaRepository.getEscuela(id);
		return new EscuelaDTO(escRes);
	}

}
