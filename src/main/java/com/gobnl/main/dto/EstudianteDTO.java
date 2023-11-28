package com.gobnl.main.dto;

import com.gobnl.main.entity.Estudiante;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class EstudianteDTO {
	private String estudianteId;
	@NotNull(message = "{estudiante.curp.absent}")
	@Pattern(regexp = "[A-Z]{4}\\d{6}[A-Z]{6}\\d{2}", message = "{estudiante.curp.invalid}")
	private String curp;
	@NotNull(message = "{estudiante.nombre.absent}")
	@Pattern(regexp = "([A-Za-z]+)( [A-Za-z]*)", message = "{estudiante.nombre.invalid}")
	private String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String sexo;
	@NotNull(message = "{estudiante.genero.absent")
	private GeneroDTO genero;
	@Pattern(regexp ="\\d{4}(-\\d{2}){2}", message = "{estudiante.fechaNacimiento.invalid}")
	private String fechaNacimiento;
	private int edad;
	private String nivelEscolar;
	private String grado;
	@NotNull(message = "{estudiante.estado.absent}")
	private EstadoDTO estado;
	@NotNull(message = "{estudiante.escuela.absent")
	private EscuelaDTO escuela;
	@NotNull(message = "{estudiante.solCurp.absent}")
	@Pattern(regexp = "[A-Z]{4}\\d{6}[A-Z]{6}\\d{2}", message = "{solicitante.curp.invalid}")
	private String solCurp;

	public EstudianteDTO() {
		/*count++;
		this.estudianteId = String.valueOf(count);*/
	}
	
	public EstudianteDTO(Estudiante estudiante) {
		super();
		this.estudianteId = estudiante.getEstudianteId();
		this.curp = estudiante.getCurp();
		this.nombre = estudiante.getNombre();
		this.primerApellido = estudiante.getPrimerApellido();
		this.segundoApellido = estudiante.getSegundoApellido();
		this.sexo = estudiante.getSexo();
		this.genero = new GeneroDTO(estudiante.getGenero());
		this.fechaNacimiento = estudiante.getFechaNacimiento();
		this.edad = estudiante.getEdad();
		this.nivelEscolar = estudiante.getNivelEscolar();
		this.grado = estudiante.getGrado();
		this.estado = new EstadoDTO(estudiante.getEstado());
		this.escuela = new EscuelaDTO(estudiante.getEscuela());
		this.solCurp = estudiante.getSolCurp();
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
	public GeneroDTO getGenero() {
		return genero;
	}
	public void setGenero(GeneroDTO genero) {
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
	public EstadoDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	public EscuelaDTO getEscuela() {
		return escuela;
	}
	public void setEscuela(EscuelaDTO escuela) {
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
				", nivel escolar= "+ nivelEscolar + ", graado= " + grado + estado.toString() + ", " + escuela.toString() + "solCurp= " + solCurp + "]";
	}
}