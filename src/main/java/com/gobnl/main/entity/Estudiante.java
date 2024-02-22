package com.gobnl.main.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.gobnl.main.dto.EstudianteDTO;

@Document(collection = "estudiantes")
public class Estudiante {
	
	@Id
	private String estudianteId;
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
	private String nivelEscolar;
	private String grado;
	private Estado estado;
	private Escuela escuela;
	private String solCurp;
	
	public Estudiante() { }
	
	public Estudiante(EstudianteDTO estudiante) {
		super();
		this.estudianteId = estudiante.getEstudianteId();
		this.curp = estudiante.getCurp();
		this.nombre = estudiante.getNombre();
		this.primerApellido = estudiante.getPrimerApellido();
		this.segundoApellido = estudiante.getSegundoApellido();
		this.sexo = estudiante.getSexo();
		this.genero = new Genero(estudiante.getGenero());
		this.fechaNacimiento = estudiante.getFechaNacimiento();
		this.edad = estudiante.getEdad();
		this.nivelEscolar = estudiante.getNivelEscolar();
		this.grado = estudiante.getGrado();
		this.estado = new Estado(estudiante.getEstado());
		this.escuela = new Escuela(estudiante.getEscuela());
		this.solCurp = estudiante.getSolCurp();
	}
	
	public Estudiante(String estudianteId, String curp, String nombre, String primerApellido,
			String segundoApellido, String sexo, Genero genero, String fechaNacimiento, 
			int edad, String nivelEscolar, String grado, Estado estado, Escuela escuela, String solCurp) {
		super();
		this.estudianteId = estudianteId;
		this.curp = curp;
		this.nombre = nombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.sexo = sexo;
		this.genero = genero;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.nivelEscolar = nivelEscolar;
		this.grado = grado;
		this.estado = estado;
		this.escuela = escuela;
		this.solCurp = solCurp;
	}

	public String getEstudianteId() {
		return estudianteId;
	}
	public void setEstudianteId(String estudianteId) {
		this.estudianteId = estudianteId;
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

	public String getNivelEscolar() {
		return nivelEscolar;
	}
	public void setNivelEscolar(String nivelEscolar) {
		this.nivelEscolar = nivelEscolar;
	}

	public String getGrado() {
		return grado;
	}
	public void setGrado(String grado) {
		this.grado = grado;
	}

	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Escuela getEscuela() {
		return escuela;
	}
	public void setEscuela(Escuela escuela) {
		this.escuela = escuela;
	}

	public String getSolCurp() {
		return solCurp;
	}
	public void setSolCurp(String solCurp) {
		this.solCurp = solCurp;
	}

	@Override
	public String toString() {
		return "Estudiante: [curp= " + curp + ", nombre= " + nombre + ", primer apellido= " + primerApellido + ", segundo apellido= " + segundoApellido + 
				", sexo= " + sexo + ", " + genero.toString() + ", fecha nacimiento= " + fechaNacimiento + ", edad= " + edad +", " + 
				", nivel escolar= "+ nivelEscolar + ", grado= " + grado + estado.toString() + ", " + escuela.toString() + ", solCurp= " + solCurp + "]";
	}
}