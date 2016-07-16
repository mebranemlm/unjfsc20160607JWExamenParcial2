package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Grado")
public class Grado {
	@Id
	private int idGrado;
	private String descGrado;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	public int getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(int idGrado) {
		this.idGrado = idGrado;
	}

	public String getDescGrado() {
		return descGrado;
	}

	public void setDescGrado(String descGrado) {
		this.descGrado = descGrado;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
}
