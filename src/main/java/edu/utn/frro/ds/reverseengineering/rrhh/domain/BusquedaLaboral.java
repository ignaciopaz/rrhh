package edu.utn.frro.ds.reverseengineering.rrhh.domain;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class BusquedaLaboral {
	@Id @GeneratedValue
	private Long idBusquedaLaboral;
	private String descripcion;
	private String estado;
	@ManyToMany
    @JoinTable(name="busqueda_conocimientos")
	private Collection<Conocimiento> conocimientosBuscados = new ArrayList<Conocimiento>();
	//En UML2, el siguiente atributo sería equivalente a: entrevistas:Entrevista[*]
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="id_busqueda") 
	private Collection<Entrevista> entrevistas;
	
	public BusquedaLaboral() {
		this.estado="activo";
		entrevistas = new ArrayList<Entrevista>();
	}
	public BusquedaLaboral(String descripcion) {
		this();
		this.descripcion=descripcion;
	}

	public Long getIdBusquedaLaboral() {
		return idBusquedaLaboral;
	}

	public Collection<Conocimiento> getConocimientosBuscados() {
		return conocimientosBuscados;
	}

	public void agregarEntrevista(Candidato c, Date fechaHoraEntrevista) {
		//Patrón Creador
		Entrevista e = new Entrevista(c, this, fechaHoraEntrevista);
		entrevistas.add(e);
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void agregarConocimiento(Conocimiento conocimiento) {
		conocimientosBuscados.add(conocimiento);		
	}
	public void desactivar() {
		estado="inactivo";
	}
	
}
