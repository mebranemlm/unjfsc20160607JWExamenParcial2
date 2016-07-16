package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Alumno")
public class Alumno {
	@Id
	private int idAlumno;
	@ManyToOne
	@JoinColumn(name="idRendAcad")
	private RendAcademico RendAcademico;
	private String nombres;
	private int edad;
	private double talla;
	
	@ManyToOne
	@JoinColumn(name="idAula")
	private Aula Aula;
	
	@ManyToOne
	@JoinColumn(name="idSexo")
	private Sexo Sexo;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public RendAcademico getRendAcademico() {
		return RendAcademico;
	}

	public void setRendAcademico(RendAcademico rendAcademico) {
		RendAcademico = rendAcademico;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getTalla() {
		return talla;
	}

	public void setTalla(double talla) {
		this.talla = talla;
	}

	public Aula getAula() {
		return Aula;
	}

	public void setAula(Aula aula) {
		Aula = aula;
	}

	public Sexo getSexo() {
		return Sexo;
	}

	public void setSexo(Sexo sexo) {
		Sexo = sexo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
}
