package com.gobnl.main.dto;

import com.gobnl.main.entity.Estado;

public class EstadoDTO {
	private String claveGeoestadistica;
	private String nombre;
	private String claveEntidad;
	
	public EstadoDTO() {}
	
	public EstadoDTO(String claveGeoestadistica, String nombre, String claveEntidad) {
		super();
		this.claveGeoestadistica = claveGeoestadistica;
		this.nombre = nombre;
		this.claveEntidad = claveEntidad;
	}
	public EstadoDTO(Estado estado){
		this.claveGeoestadistica = estado.getClaveGeoestadistica();
		this.nombre = estado.getNombre();
		this.claveEntidad = estado.getClaveEntidad();
	}
	
	public String getClaveGeoestadistica() {
		return claveGeoestadistica;
	}
	public void setClaveGeoestadistica(String claveGeoestadistica) {
		this.claveGeoestadistica = claveGeoestadistica;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getClaveEntidad() {
		return claveEntidad;
	}
	public void setClaveEntidad(String claveEntidad) {
		this.claveEntidad = claveEntidad;
	}
	@Override
	public String toString() {
		return "Estado: { clage geoestadistica= " + claveGeoestadistica + ", nombre= " + nombre + ", clave entidad= " + claveEntidad + "}"; 
	}
}