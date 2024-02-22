package com.gobnl.main.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import com.gobnl.main.dto.DireccionDTO;
@Document(collection = "direccion")
public class Direccion {
	
	private String solCurp;
	private String municipio;
	private String colonia;
	private String calle;
	private int numeroExt;
	private int numeroInt;
	private int codigoPostal;
	private String telefono;
	
	public Direccion() {	}
	public Direccion(DireccionDTO direccion) {
		super();
		this.solCurp = direccion.getSolCurp();
		this.municipio = direccion.getMunicipio();
		this.colonia = direccion.getColonia();
		this.calle = direccion.getCalle();
		this.numeroExt = direccion.getNumeroExt();
		this.numeroInt = direccion.getNumeroInt();
		this.codigoPostal = direccion.getCodigoPostal();
		this.telefono = direccion.getTelefono();
	}
	public Direccion(String solCurp, String municipio, String colonia, String calle, int numeroExt, int numeroInt, int codigoPostal, String telefono) {
		super();
		this.solCurp = solCurp;
		this.municipio = municipio;
		this.colonia = colonia;
		this.calle = calle;
		this.numeroExt = numeroExt;
		this.numeroInt = numeroInt;
		this.codigoPostal = codigoPostal;
		this.telefono = telefono;
	}
	public String getSolCurp() {
		return solCurp;
	}

	public void setSolCurp(String solCurp) {
		this.solCurp = solCurp;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
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
	public int getNumeroExt() {
		return numeroExt;
	}
	public void setNumeroExt(int numeroExt) {
		this.numeroExt = numeroExt;
	}
	public int getNumeroInt() {
		return numeroInt;
	}
	public void setNumeroInt(int numeroInt) {
		this.numeroInt = numeroInt;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Override
	public String toString() {
		return "Direccion: { municipio= " + municipio + ", colonia= " + colonia + ", calle= " + calle + 
				", numero exterior= " + numeroExt + ", numero interior" + numeroInt + ", codigo postal= " + codigoPostal + ", telefono= " + telefono + "}";
	}
}
