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
	private Date fechaHoraEntrevista;
	private Date fechaCreacion;
	private String estado;
	private Double puntajeEvaluacion = null; //inicializa el puntaje en null
	
	public Entrevista() {}
	//Constructor de la clase Entrevista. Equivalente al método create
	public Entrevista(Candidato c, Date pFechaHoraEntrevista) {
		candidato=c;
		fechaHoraEntrevista=pFechaHoraEntrevista;
		//guarda la hora en la que se creo la entrevista
		fechaCreacion = new Date();
		//inicializa el estado de la entrevista
		estado = "confirmado";
	}
}
