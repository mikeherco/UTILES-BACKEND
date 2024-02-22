package com.gobnl.main.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.gobnl.main.dto.SolicitanteDTO;

@Document(collection = "curp")
public class Solicitante {
	
	@Id
	private String solicitanteId;
	private String curp;
	private String nombre;
	@Field("primer_apellido")
	private String primerApellido;
	@Field("segundo_apellido")
	private String segundoApellido;
	private String sexo;
	private Genero genero;
	@Field("fecha_nacimiento")
	private String fechaNacimiento;
	private int edad;
	private Estado estado;
	
	public Solicitante() { }
	public Solicitante(SolicitanteDTO solicitante) {
		super();
		this.solicitanteId = solicitante.getSolicitanteId();
		this.curp = solicitante.getCurp();
		this.nombre = solicitante.getNombre();
		this.primerApellido = solicitante.getPrimerApellido();
		this.segundoApellido = solicitante.getSegundoApellido();
		this.sexo = solicitante.getSexo();
		this.genero = new Genero(solicitante.getGenero());//constructor no jala?
		this.fechaNacimiento = solicitante.getFechaNacimiento();
		this.edad = solicitante.getEdad();
		this.estado = new Estado(solicitante.getEstado());//constructor no jala?
	}
	public Solicitante(String solicitanteId, String curp, String nombre, String primerApellido,
			String segundoApellido, String sexo, Genero genero, String fechaNacimiento, int edad, Estado estado) {
		super();
		this.solicitanteId = solicitanteId;
		this.curp = curp;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.sexo = sexo;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.estado = estado;
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
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
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
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	@Override
	public int hashCode() {
		return 31;
	}
	
	@Override //falta implementacion?
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(this.getClass() != obj.getClass())
			return false;
		SolicitanteDTO other = (SolicitanteDTO) obj;
		if(this.getSolicitanteId() == null) {
			if(other.getSolicitanteId() != null)
				return false;
		} else if(!this.getSolicitanteId().equals(other.getSolicitanteId()))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Solicitante: [curp= " + curp + ", nombre= " + nombre + ", primer apellido= " + primerApellido + ", segundo apellido= " + segundoApellido + 
				", sexo= " + sexo + genero.toString() + "}, fecha nacimiento= " + fechaNacimiento + ", edad= " + edad + ", " + estado.toString() + "]";
	}
}