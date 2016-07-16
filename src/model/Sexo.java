package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Sexo")
public class Sexo {

	@Id
	private int idSexo;
	private String descSexo;
	
	@Temporal(TemporalType.DATE)
	private Date fechaRegistro;

	public int getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
	}

	public String getDescSexo() {
		return descSexo;
	}

	public void setDescSexo(String descSexo) {
		this.descSexo = descSexo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	
	
}
