package com.gobnl.main.entity;

import org.springframework.data.mongodb.core.mapping.Field;

import com.gobnl.main.dto.GeneroDTO;

public class Genero {
	@Field("id")
	private String id;
	private String nombre;
	
	public Genero() {}

	public Genero(GeneroDTO genero) {
		super();
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