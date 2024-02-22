package com.gobnl.main.entity;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.gobnl.main.dto.EscuelaDTO;

@Document(collection="escuelas")
public class Escuela {
	
	@Id
	private String id;
	private String nombre;
	private String clave;
	private String turno;
	private String colonia;
	private String calle;
	private String numero;
	private String domicilio;
	private String region;
	@Field("zona_escolar")
	private String zonaEscolar;
	@Field("clave_zona_escolar")
	private String claveZonaEscolar;
	private String nivel;
	private String subnivel;
	private String control;
	private String sostenimiento;
	@Field("nombre_mostrar")
	private String nombreMostrar;
	private List<Double> geom;
	
	public Escuela() {	}
	
	public Escuela(EscuelaDTO escuela) {
		super();
		this.id = escuela.getId();
		this.nombre = escuela.getNombre();
		this.clave = escuela.getClave();
		this.turno = escuela.getTurno();
		this.colonia = escuela.getColonia();
		this.calle = escuela.getCalle();
		this.numero = escuela.getNumero();
		this.domicilio = escuela.getDomicilio();
		this.region = escuela.getRegion();
		this.zonaEscolar = escuela.getZonaEscolar();
		this.claveZonaEscolar = escuela.getClaveZonaEscolar();
		this.nivel = escuela.getNivel();
		this.subnivel = escuela.getSubnivel();
		this.control = escuela.getControl();
		this.sostenimiento = escuela.getSostenimiento();
		this.nombreMostrar = escuela.getNombreMostrar();
		this.geom = escuela.getGeom();//puede marcar error por null
	}
	//realmente es necesario? lo usa para obtner de la DB?
	public Escuela(String id, String nombre, String clave, String turno,
			String colonia, String calle, String numero, String domicilio, String region, String zonaEscolar, String claveZonaEscolar, 
			String nivel, String subnivel, String control, String sostenimiento, String nombreMostrar, List<Double> geom) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.clave = clave;
		this.turno = turno;
		this.colonia = colonia;
		this.calle = calle;
		this.numero = numero;
		this.domicilio = domicilio;
		this.region = region;
		this.zonaEscolar = zonaEscolar;
		this.claveZonaEscolar = claveZonaEscolar;
		this.nivel = nivel;
		this.subnivel = subnivel;
		this.control = control;
		this.sostenimiento = sostenimiento;
		this.nombreMostrar = nombreMostrar;
		this.geom = geom;
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