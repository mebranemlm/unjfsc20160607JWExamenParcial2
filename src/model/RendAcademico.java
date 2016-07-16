package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="RendAcademico")
public class RendAcademico {
	@Id
	private int idRendAcad;
	private String descRendAcad;
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;
	public int getIdRendAcad() {
		return idRendAcad;
	}
	public void setIdRendAcad(int idRendAcad) {
		this.idRendAcad = idRendAcad;
	}
	public String getDescRendAcad() {
		return descRendAcad;
	}
	public void setDescRendAcad(String descRendAcad) {
		this.descRendAcad = descRendAcad;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	

}
