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
@Table(name="Aula")
public class Aula {

	@Id
	private int idAula;
	@ManyToOne
	@JoinColumn(name="idGrado")
	private Grado Grado;
	
	private String descAula;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	public int getIdAula() {
		return idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public Grado getGrado() {
		return Grado;
	}

	public void setGrado(Grado grado) {
		Grado = grado;
	}

	public String getDescAula() {
		return descAula;
	}

	public void setDescAula(String descAula) {
		this.descAula = descAula;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
}
