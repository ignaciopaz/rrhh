package edu.utn.frro.ds.reverseengineering.rrhh.domain;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Entrevista {
	@Id @GeneratedValue Long id;
	@ManyToOne private Candidato candidato;
	@ManyToOne private BusquedaLaboral busquedaLaboral;
	private Date fechaEntrevista;
	private Date fechaCreacion;
	private String estado;
	private Double puntajeEvaluacion = null; //inicializa el puntaje en null
	
	public Entrevista() {}
	//Constructor de la clase Entrevista. Equivalente al método create de UML y Larman
	public Entrevista(Candidato c, BusquedaLaboral bl, Date pFechaEntrevista) {
		candidato=c;
		busquedaLaboral= bl;
		fechaEntrevista=pFechaEntrevista;
		//guarda la hora en la que se creo la entrevista
		fechaCreacion = new Date();
		//inicializa el estado de la entrevista
		estado = "confirmado";
	}
	
	public Candidato getCandidato() {
		return candidato;
	}
	
	public BusquedaLaboral getBusquedaLaboral() {
		return busquedaLaboral;
	}
	
	public Date getFechaEntrevista() {
		return fechaEntrevista;
	}
}
