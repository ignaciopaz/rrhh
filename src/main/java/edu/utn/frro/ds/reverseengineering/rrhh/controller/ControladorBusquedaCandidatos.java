package edu.utn.frro.ds.reverseengineering.rrhh.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.utn.frro.ds.reverseengineering.rrhh.dao.BusquedaLaboralDao;
import edu.utn.frro.ds.reverseengineering.rrhh.dao.CandidatosDao;
import edu.utn.frro.ds.reverseengineering.rrhh.dao.ConocimientoDao;
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
public class ControladorBusquedaCandidatos {
	@Autowired private BusquedaLaboralDao busquedasDao;
	@Autowired private CandidatosDao candidatosDao;
	
	private BusquedaLaboral busquedaLaboral; //En UML2, equivalente a: bl:BusquedaLaboral
	
	@RequestMapping("/entrevista/busquedas") //indica el path en la url web
	public String agendarentrevista(Model model) {
		Collection<BusquedaLaboral> busquedas = busquedasDao.buscarBusquedasActivas();
		model.addAttribute("busquedas", busquedas); //carga en el modelo un objeto colección para que esté disponible en la vista.
		return "entrevista/busquedas"; //nombre de la vista que se debe cargar. carga resources/templates/entrevista/busquedas.html
	}
	
	@RequestMapping("/entrevista/candidatos") //indica el path en la url web
	public String buscarCandidatos(@RequestParam(value="idBusquedaLaboral", required=false, defaultValue="") Long idBusquedaLaboral, Model model) {
		busquedaLaboral = busquedasDao.getOne(idBusquedaLaboral);
		
		Collection<Conocimiento> conocimientosBuscados = busquedaLaboral.getConocimientosBuscados();
		
		Collection<Candidato> candidatos = candidatosDao.buscarPorConocimientos(conocimientosBuscados);
		
		model.addAttribute("candidatos", candidatos);
		model.addAttribute("busquedaLaboral", busquedaLaboral);
		
		return "entrevista/candidatos";		
	}
	
	//Por cada candidato que se elija, el actor llama a este método 
	//para confirmar fecha y hora de entrevista. Este CU permite confirmar entrevistas con muchos candidatos 
	@PostMapping("/entrevista/confirmar") 
	public String confirmarEntrevista(@RequestParam(value="fecha", required=true) @DateTimeFormat(pattern="dd-MM-yyyy") Date fecha, @RequestParam(value="codCandidato", required=false, defaultValue="") Long codCandidato, 
									@RequestParam(value="idBusquedaLaboral", required=true) Long idBusquedaLaboral, RedirectAttributes redir) {
		Candidato candidato = candidatosDao.getOne(codCandidato);
		busquedaLaboral = busquedasDao.getOne(idBusquedaLaboral);
		busquedaLaboral.agregarEntrevista(candidato, fecha); //patrón creador
		busquedasDao.save(busquedaLaboral);
		
		redir.addFlashAttribute("candidato", candidato);
		redir.addFlashAttribute("busquedaLaboral", busquedaLaboral);
		redir.addFlashAttribute("fecha", fecha);
		return "redirect:confirmacion"; //redirige para evitar que se guarde dos veces al refrescar el browser
	}
	
	@RequestMapping("/entrevista/confirmacion") 
	public String mostrarConfirmacion(Model model, RedirectAttributes redir) {
		return "/entrevista/confirmacion";
	}
}
