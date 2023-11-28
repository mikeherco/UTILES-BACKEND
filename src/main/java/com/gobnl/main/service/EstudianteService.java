package com.gobnl.main.service;

import com.gobnl.main.dto.EstudianteDTO;
import com.gobnl.main.exception.GobNLException;

import java.util.List;

public interface EstudianteService {
	List<String> getAllCurps() throws GobNLException;
	EstudianteDTO getEstudianteByCurp(String curp)	throws GobNLException;
	EstudianteDTO getEstudianteBySolCurp(String curp) throws GobNLException;
	String saveEstudiante(EstudianteDTO estudiante) throws GobNLException;
	String updateEstudiante(EstudianteDTO estudiante) throws GobNLException;
}
