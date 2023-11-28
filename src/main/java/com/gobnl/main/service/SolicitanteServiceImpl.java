package com.gobnl.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gobnl.main.dto.SolicitanteDTO;
import com.gobnl.main.entity.Solicitante;
import com.gobnl.main.exception.GobNLException;
import com.gobnl.main.repository.SolicitanteRepository;

@Service
public class SolicitanteServiceImpl implements SolicitanteService{
	
	@Autowired
	private SolicitanteRepository solRepo;

	@Override
	public SolicitanteDTO getSolicitanteByCurp(String curp) throws GobNLException {
		Solicitante solReq = solRepo.getSolicitanteByCurp(curp);
		return new SolicitanteDTO(solReq);
	}

	@Override
	public String saveSolicitante(SolicitanteDTO solicitante) throws GobNLException {
		Solicitante solReq = new Solicitante(solicitante);
		Solicitante solRes = solRepo.insert(solReq);
		return solRes.getCurp();
	}
}
