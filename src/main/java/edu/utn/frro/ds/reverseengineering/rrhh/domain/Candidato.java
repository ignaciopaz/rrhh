package edu.utn.frro.ds.reverseengineering.rrhh.domain;

import java.util.*;

import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
@Entity
public class Candidato {
	@Id @GeneratedValue
	private Long idCandidato;
	private String nombre;
	private String apellido;
	private String email;
	private String telefono;
	@ManyToMany
	@JoinTable(name="candidatos_conocimientos")	
	private Collection<Conocimiento> conocimientosCandidato = new ArrayList<Conocimiento>();
	
	public Candidato() {
		
	}
	
	public Candidato(String nombre, String apellido) {
		this();
		this.nombre=nombre;
		this.apellido=apellido;
	}

	/** Retorna true si el Candidato conoce sobre todos los conocimientos
	 * en el parámetro colección conocimientosBuscados */
	public boolean sabe(Collection<Conocimiento> conocimientosBuscados) {
		//Si el candidato tiene todos los conocimientosBuscados en su lista
		//de conocimientos (conocimientosCandidato) devuelve true
		//llama al método de colección containsAll para ver si todos los objetos
		//conocimiento están dentro de la colección
		if (conocimientosCandidato.containsAll(conocimientosBuscados)) {
			return true;
		}
		return false;
	}

	public Long getIdCandidato() {
		return idCandidato;
	}

	public String getNombreApellido() {
		return nombre + " " + apellido;
	}
	
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public void agregarConocimiento(Conocimiento conocimiento) {
		conocimientosCandidato.add(conocimiento);
		
	}

	public void agregarConocimientos(Collection<Conocimiento> conocimientos) {
		conocimientosCandidato.addAll(conocimientos);
	}
	
	public int getCantidadConocimientos() {
		return conocimientosCandidato.size();
	}
}
