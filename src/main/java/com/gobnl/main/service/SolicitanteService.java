package com.gobnl.main.service;

import com.gobnl.main.dto.SolicitanteDTO;
import com.gobnl.main.exception.GobNLException;

public interface SolicitanteService {
	SolicitanteDTO getSolicitanteByCurp(String curp) throws GobNLException;
	String saveSolicitante(SolicitanteDTO solicitante) throws GobNLException;
}
