package com.gobnl.main.dto;

import java.util.List;

import com.gobnl.main.entity.Escuela;

public class EscuelaDTO {
	private String id;
	private String nombre;
	private String clave;
	private String turno;
	private String colonia;
	private String calle;
	private String numero;
	private String domicilio;
	private String region;
	private String zonaEscolar;
	private String claveZonaEscolar;
	private String nivel;
	private String subnivel;
	private String control;
	private String sostenimiento;
	private String nombreMostrar;
	private List<Double> geom;
	
	public EscuelaDTO() {	}
	
	public EscuelaDTO(Escuela escuela) {
		super();
		id = escuela.getId();
		nombre = escuela.getNombre();
		clave = escuela.getClave();
		turno = escuela.getTurno();
		colonia = escuela.getColonia();
		calle = escuela.getCalle();
		numero = escuela.getNumero();
		domicilio = escuela.getDomicilio();
		region = escuela.getRegion();
		zonaEscolar = escuela.getZonaEscolar();
		claveZonaEscolar = escuela.getClaveZonaEscolar();
		nivel = escuela.getNivel();
		subnivel = escuela.getSubnivel();
		control = escuela.getControl();
		sostenimiento = escuela.getSostenimiento();
		nombreMostrar = escuela.getNombreMostrar();
		geom = escuela.getGeom();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getZonaEscolar() {
		return zonaEscolar;
	}
	public void setZonaEscolar(String zonaEscolar) {
		this.zonaEscolar = zonaEscolar;
	}
	public String getClaveZonaEscolar() {
		return claveZonaEscolar;
	}
	public void setClaveZonaEscolar(String claveZonaEscolar) {
		this.claveZonaEscolar = claveZonaEscolar;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getSubnivel() {
		return subnivel;
	}
	public void setSubnivel(String subnivel) {
		this.subnivel = subnivel;
	}
	public String getControl() {
		return control;
	}
	public void setControl(String control) {
		this.control = control;
	}
	public String getSostenimiento() {
		return sostenimiento;
	}
	public void setSostenimiento(String sostenimiento) {
		this.sostenimiento = sostenimiento;
	}
	public String getNombreMostrar() {
		return nombreMostrar;
	}
	public void setNombreMostrar(String nombreMostrar) {
		this.nombreMostrar = nombreMostrar;
	}
	public List<Double> getGeom() {
		return geom;
	}
	public void setGeom(List<Double> geom) {
		this.geom = geom;
	}
	@Override
	public String toString() {
		return "Escuela: [id= " + id + ", nombre= " + nombre + ", clave= " + clave + ", turno= " + turno + 
				", colonia= " + colonia + ", calle= " + calle + ", numero= " + numero + ", domicilio= " + domicilio + ", region= " + region + 
				", zona escolar= " + zonaEscolar + ", clave zona escolar= " + claveZonaEscolar + ", nivel= " + nivel + ", subnivel= " + subnivel +
				", control= " + control + ", sostenimmiento= " + sostenimiento + ", nombre mostrar= " + nombreMostrar + ", geom= " + geom + "]";
	}
}