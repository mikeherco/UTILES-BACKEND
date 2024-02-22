package com.gobnl.main.dto;

import com.gobnl.main.entity.Direccion;

public class DireccionDTO {
	
	private String solCurp;
	private String municipio;
	private String colonia;
	private String calle;
	private int numeroExt;
	private int numeroInt;
	private int codigoPostal;
	private String telefono;
	
	public DireccionDTO() {	}
	
	public DireccionDTO(Direccion direccion) {
		super();
		solCurp = direccion.getSolCurp();
		municipio = direccion.getMunicipio();
		colonia = direccion.getColonia();
		calle = direccion.getCalle();
		numeroExt = direccion.getNumeroExt();
		numeroInt = direccion.getNumeroInt();
		codigoPostal = direccion.getCodigoPostal();
		telefono = direccion.getTelefono();
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
