package edu.utn.frro.ds.reverseengineering.rrhh.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Conocimiento {
	@Id @GeneratedValue 
	private Long codConocimiento;
	private String descripcion;
	
	public Conocimiento() {}
	
	public Conocimiento(String descripcion) {
		this.descripcion=descripcion;
	}
	public Long getCodConocimiento() {
		return codConocimiento;
	}
	public void setCodConocimiento(Long pCodConocimiento) {
		codConocimiento = pCodConocimiento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String pDescripcion) {
		descripcion = pDescripcion;
	}
	
	public boolean equals(Object o) {
		if (o != null && o instanceof Conocimiento) {
			Conocimiento other = (Conocimiento) o;
			if (other.getCodConocimiento().equals(getCodConocimiento())) {
				return true;
			}
		}
		return false;
	}
}
