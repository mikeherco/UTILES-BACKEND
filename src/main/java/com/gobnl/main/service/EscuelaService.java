package com.gobnl.main.service;

import java.util.List;

import com.gobnl.main.dto.EscuelaDTO;
import com.gobnl.main.exception.GobNLException;

public interface EscuelaService {
	List<EscuelaDTO> getAll() throws GobNLException;
	EscuelaDTO getById(String id) throws GobNLException;
}
