package com.gobnl.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gobnl.main.repository.EstudianteRepository;
import com.gobnl.main.dto.EstudianteDTO;
import com.gobnl.main.entity.Estudiante;
import com.gobnl.main.exception.GobNLException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService{
	@Autowired
	private EstudianteRepository estRepo;

	@Override
	public List<String> getAllCurps() throws GobNLException{
		List<Estudiante> listEst = estRepo.findAll();
		if(!listEst.isEmpty()){
			List<String> listCurps = new ArrayList<>();
			listEst.forEach(x -> listCurps.add(x.getCurp()));
			return listCurps;
		}
		return null;
	}
	@Override
	public EstudianteDTO getEstudianteByCurp(String curp) throws GobNLException {
		Estudiante estResp = estRepo.getEstudianteByCurp(curp);

		return new EstudianteDTO(estResp);
	}	
	@Override
	public EstudianteDTO getEstudianteBySolCurp(String curp) throws GobNLException {
		Estudiante estResp = estRepo.getEstudianteBySolCurp(curp);
		return new EstudianteDTO(estResp);
	}
	@Override
	public String saveEstudiante(EstudianteDTO estudiante) throws GobNLException {
		Estudiante estReq = new Estudiante(estudiante);
		Estudiante solRes = estRepo.insert(estReq);
		return solRes.getCurp();
	}
	@Override
	public String updateEstudiante(EstudianteDTO estudiante) throws GobNLException {
		Estudiante estReq = new Estudiante(estudiante);
		Estudiante solRes = estRepo.save(estReq);
		return solRes.getCurp();
	}
}