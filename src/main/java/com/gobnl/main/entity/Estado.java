package com.gobnl.main.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import com.gobnl.main.dto.EstadoDTO;

public class Estado {
	@Field("clave_geoestadistica")
	private String claveGeoestadistica;
	private String nombre;
	@Field("clave_entidad")
	private String claveEntidad;
	
	public Estado() {}
	
	public Estado(EstadoDTO estado) {
		super();
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