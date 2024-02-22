package com.gobnl.main.dto;

import com.gobnl.main.entity.Genero;

public class GeneroDTO {
	private String id;
	private String nombre;
	
	public GeneroDTO() {}
	
	public GeneroDTO(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	public GeneroDTO(Genero genero) {
		this.id = genero.getId();
		this.nombre = genero.getNombre();
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
	@Override
	public String toString() {
		return "Genero: { id= " + id + ", nombre= " + nombre + "}";
	}
}