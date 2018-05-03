package edu.utn.frro.ds.reverseengineering.rrhh.controller;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.utn.frro.ds.reverseengineering.rrhh.dao.BusquedaLaboralDao;
import edu.utn.frro.ds.reverseengineering.rrhh.dao.CandidatoDao;
import edu.utn.frro.ds.reverseengineering.rrhh.domain.BusquedaLaboral;
import edu.utn.frro.ds.reverseengineering.rrhh.domain.Candidato;
import edu.utn.frro.ds.reverseengineering.rrhh.domain.Conocimiento;
/**
 * @author ignacio.paz
 * Este controlador permite buscar y agendar entrevistas con 
 * candidatos que tengan los conocimientos requeridos
 * para una búsqueda laboral definida en una consultora de RRHH. 
 */
@Controller
public class ControladorAgendarEntrevista {
	@Autowired private BusquedaLaboralDao busquedasDao;
	@Autowired private CandidatoDao candidatoDao;
	
	private BusquedaLaboral busquedaLaboral; //En UML2, equivalente a: bl:BusquedaLaboral
	
	@RequestMapping("/entrevista/agendar") //indica el path en la url web
	public String verBusquedasLaborales(Model model) {
		Collection<BusquedaLaboral> busquedas = busquedasDao.buscarBusquedasActivas();
		//carga en el modelo un objeto colección para que esté disponible en la vista.
		model.addAttribute("busquedas", busquedas);
		//nombre de la vista que se debe cargar y a la cual le llegan los objetos del modelo. carga resources/templates/entrevista/busquedas.html
		return "entrevista/agendar/busquedas"; 
	}
	
	@RequestMapping("/entrevista/agendar/candidatos") //indica el path en la url web
	public String buscarCandidatos(@RequestParam(value="idBusquedaLaboral", required=false, defaultValue="") Long idBusquedaLaboral, Model model) {
		busquedaLaboral = busquedasDao.getOne(idBusquedaLaboral);
		
		Collection<Conocimiento> conocimientosBuscados = busquedaLaboral.getConocimientosBuscados();
		
		Collection<Candidato> candidatos = candidatoDao.buscarPorConocimientos(conocimientosBuscados);
		
		model.addAttribute("candidatos", candidatos);
		model.addAttribute("busquedaLaboral", busquedaLaboral);
		
		return "entrevista/agendar/candidatos";		
	}
	
	//Por cada candidato que se elija, el actor llama a este método 
	//para confirmar fecha y hora de entrevista.
	@PostMapping("/entrevista/agendar/confirmar") 
	public String confirmarEntrevista(@RequestParam(value="fecha", required=true) @DateTimeFormat(pattern="dd-MM-yyyy") Date fecha, @RequestParam(value="codCandidato", required=false, defaultValue="") Long codCandidato, 
									@RequestParam(value="idBusquedaLaboral", required=true) Long idBusquedaLaboral, Model model) {
		Candidato candidato = candidatoDao.getOne(codCandidato);
		busquedaLaboral = busquedasDao.getOne(idBusquedaLaboral);
		busquedaLaboral.agregarEntrevista(candidato, fecha); //patrón creador
		busquedasDao.save(busquedaLaboral);
		
		model.addAttribute("candidato", candidato);
		model.addAttribute("busquedaLaboral", busquedaLaboral);
		model.addAttribute("fecha", fecha);
		return "entrevista/agendar/confirmacion"; 
	}
	

}
