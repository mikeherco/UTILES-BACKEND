package com.gobnl.main.controller;

import java.util.List;

import com.gobnl.main.dto.*;
import com.gobnl.main.entity.Funcionario;
import com.gobnl.main.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.core.env.Environment;

import com.gobnl.main.exception.GobNLException;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
@RestController
@RequestMapping(value="/gobnl")
@Validated
public class SolAPI {
	@Autowired
	private SolicitanteService solSer;
	@Autowired
	private EstudianteService estSer;
	@Autowired
	private EscuelaService escSer;
	@Autowired 
	private DireccionService dirSer;
	@Autowired
	Environment environment;

	@GetMapping(value = "/solicitante/{curp}")
	public ResponseEntity<SolicitanteDTO> getSolicitanteByCurp(@PathVariable String curp) throws GobNLException {
		SolicitanteDTO solResp = solSer.getSolicitanteByCurp(curp);
		return new ResponseEntity<>(solResp, HttpStatus.OK);
	}
	@PostMapping(value = "/solicitante")
	@Produces(MediaType.APPLICATION_JSON)
	public ResponseEntity<String> saveSolicitante(@Valid @RequestBody @NotNull SolicitanteDTO solicitannteDTO) throws GobNLException{
		String solicitanteCurp = solSer.saveSolicitante(solicitannteDTO);
		String successMessage = environment.getProperty("API.INSERT_SOLICITANTE_SUCCESS") + solicitanteCurp;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	
	@GetMapping(value = "/escuela")
	public ResponseEntity<List<EscuelaDTO>> getAllEscuelas() throws GobNLException{
		List<EscuelaDTO> escuelaList = escSer.getAll();
		return new ResponseEntity<>(escuelaList, HttpStatus.OK);
	}
	@GetMapping(value = "/escuela/{id}")
	public ResponseEntity<EscuelaDTO> getEscuelaById(@PathVariable String id) throws GobNLException {
		EscuelaDTO escuela = escSer.getById(id);
		return new ResponseEntity<>(escuela, HttpStatus.OK);
	}

	@GetMapping(value = "/estudiantes")
	public ResponseEntity<List<String>> getAllEstudiante() throws GobNLException{
		List<String> listaCurp = estSer.getAllCurps();
		return new ResponseEntity<>(listaCurp, HttpStatus.OK);
	}

	@GetMapping(value = "/estudiante/{curp}")
	public ResponseEntity<EstudianteDTO> getEstudianteByCurp(@PathVariable String curp) throws GobNLException{
		EstudianteDTO estudiante = estSer.getEstudianteByCurp(curp);
		return new ResponseEntity<>(estudiante, HttpStatus.OK);
	}
	@GetMapping(value = "/estudiante/solicitante/{solCurp}")
	public ResponseEntity<EstudianteDTO> getEstudianteBySolCurp(@PathVariable String solCurp) throws GobNLException{
		EstudianteDTO estudiante = estSer.getEstudianteBySolCurp(solCurp);
		return new ResponseEntity<>(estudiante, HttpStatus.OK);
	}
	@PostMapping(value = "/estudiante")
	public ResponseEntity<String> saveEstudiante(@Valid @RequestBody @NotNull EstudianteDTO estudianteDTO ) throws GobNLException{

		String estudianteCurp = estSer.saveEstudiante(estudianteDTO);
		String successMessage = environment.getProperty("API.INSERT_ESTUDIANTE_SUCCESS") + estudianteCurp;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
	@PreAuthorize("hasRole('ROLE_SUPERADMIN')")
	@PutMapping(value = "/estudiante")
	public ResponseEntity<String> upDateEstudiante(@Valid @RequestBody EstudianteDTO estudianteDTO) throws GobNLException {
		String estudianteCurp = estSer.updateEstudiante(estudianteDTO);
		String successMessage = environment.getProperty("API.SAVE_ESTUDIANTE_SUCCESS") + estudianteCurp;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}

	@GetMapping(value = "/direccion")
	public ResponseEntity<List<DireccionDTO>> getAllDireccion() throws GobNLException {
		List<DireccionDTO> dirList = dirSer.getAll();
		return new ResponseEntity<>(dirList, HttpStatus.OK);
	}
	@GetMapping(value = "/direccion/{curp}")
	public ResponseEntity<DireccionDTO> getDireccionByCurp(@PathVariable String curp) throws GobNLException{
		DireccionDTO dirRes = dirSer.getDireccionByCurp(curp);
		return new ResponseEntity<>(dirRes, HttpStatus.OK);
	}
	@PostMapping(value = "/direccion")
	public ResponseEntity<String> saveDireccion(@RequestBody DireccionDTO direccion) throws GobNLException{
		String direccionCurp = dirSer.saveDireccion(direccion);
		String successMessage = environment.getProperty("API.INSERT_DIRECCION_SUCCESS") + direccionCurp;
		return new ResponseEntity<>(successMessage, HttpStatus.OK);
	}
}