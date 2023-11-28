package com.gobnl.main.service;

import java.util.List;

import com.gobnl.main.dto.DireccionDTO;
import com.gobnl.main.exception.GobNLException;

public interface DireccionService {
	List<DireccionDTO> getAll() throws GobNLException;
	DireccionDTO getDireccionByCurp(String curp) throws GobNLException;
	String saveDireccion(DireccionDTO direccion) throws GobNLException;
}
