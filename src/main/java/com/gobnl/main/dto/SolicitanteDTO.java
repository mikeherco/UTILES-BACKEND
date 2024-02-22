package com.gobnl.main.dto;

import com.gobnl.main.entity.Solicitante;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class SolicitanteDTO {
	private String solicitanteId;
	@NotNull(message = "{solicitante.curp.absent}")
	@Pattern(regexp = "[A-Z]{4}\\d{6}[A-Z]{6}\\d{2}", message = "{solicitante.curp.invalid}")
	private String curp;
	@NotNull(message = "{solicitante.nombre.absent}")
	@Pattern(regexp = "([A-Za-z]+)( )?[A-Za-z]*", message = "{solicitante.nombre.invalid}")
	private String nombre;
	@NotNull(message = "{solicitante.apellido.absent}")
	private String primerApellido;
	@NotNull(message = "{solicitante.segundoApellido.absent}")
	private String segundoApellido;
	@NotNull(message = "{solicitante.sexo.absent}")
	private String sexo;
	@NotNull(message = "{solicitante.genero.absent}")
	private GeneroDTO genero;
	@Pattern(regexp ="\\d{4}(-\\d{2}){2}", message = "{solicitante.fechaNacimiento.invalid}")
	private String fechaNacimiento;
	@NotNull(message = "{solicitante.edad.absent}")
	private int edad;
	@NotNull(message = "{solicitante.estado.absent}")
	private EstadoDTO estado;
	
	public SolicitanteDTO() {
		this.genero = new GeneroDTO();
		this.estado = new EstadoDTO();
	}
	public SolicitanteDTO(Solicitante solicitante) {
		super();
		this.solicitanteId = solicitante.getSolicitanteId();
		this.curp = solicitante.getCurp();
		this.nombre = solicitante.getNombre();
		this.primerApellido = solicitante.getPrimerApellido();
		this.segundoApellido = solicitante.getSegundoApellido();
		this.sexo = solicitante.getSexo();
		this.genero = new GeneroDTO(solicitante.getGenero());
		this.fechaNacimiento = solicitante.getFechaNacimiento();
		this.edad = solicitante.getEdad();
		this.estado = new EstadoDTO(solicitante.getEstado());
	}

	public String getSolicitanteId() {
		return solicitanteId;
	}
	public void setSolicitanteId(String solicitanteId) {
		this.solicitanteId = solicitanteId;
	}
	public String getCurp() {
		return curp;
	}
	public void setCurp(String curp) {
		this.curp = curp;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public GeneroDTO getGenero() {
		return genero;
	}
	public void setGenero(GeneroDTO genero) {
		this.genero.setId(genero.getId());
		this.genero.setNombre(genero.getNombre());
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public EstadoDTO getEstado() {
		return estado;
	}

	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	
	@Override
	public int hashCode() {
		return 31;
	}
	@Override //falta implementacion
	public boolean equals(Object obj) {
		return false;
	}
	@Override
	public String toString() {
		return "Solicitante: [curp= " + curp + ", nombre= " + nombre + ", primer apellido= " + primerApellido + ", segundo apellido= " + segundoApellido + 
				", sexo= " + sexo + genero.toString() + "}, fecha nacimiento= " + fechaNacimiento + ", edad= " + edad + ", " + estado.toString() + "]";
	}
}