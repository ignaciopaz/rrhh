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

import edu.utn.frro.ds.reverseengineering.rrhh.dao.EntrevistaDao;
import edu.utn.frro.ds.reverseengineering.rrhh.domain.Entrevista;

/**
 * @author ignacio.paz Este controlador permite buscar y ver entrevistas agendadas..
 */
@Controller
public class ControladorConsultaEntrevistas {
	@Autowired
	private EntrevistaDao entrevistaDao; // En UML2, equivalente a: entrevistaDao:EntrevistaDao

	@RequestMapping("/entrevista/buscar") // indica el path en la url web
	public String agendarentrevista(Model model) {
		return "entrevista/buscar/buscar"; // nombre de la vista que se debe cargar.
		// carga resources/templates/entrevistasAgendadas/buscar.html
	}

	@PostMapping("/entrevista/buscar/resultados")
	public String confirmarEntrevista(
			@RequestParam(value = "fecha", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy") Date fechaDesde,
			Model model) {
		Collection<Entrevista> entrevistas = entrevistaDao.buscarEntrevistas(fechaDesde);

		model.addAttribute("entrevistas", entrevistas);
		model.addAttribute("fechaDesde", fechaDesde);
		return "entrevista/buscar/resultados";
	}

}
