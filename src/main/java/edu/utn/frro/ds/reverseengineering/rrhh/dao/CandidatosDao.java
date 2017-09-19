package edu.utn.frro.ds.reverseengineering.rrhh.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.utn.frro.ds.reverseengineering.rrhh.domain.Candidato;
import edu.utn.frro.ds.reverseengineering.rrhh.domain.Conocimiento;

@Repository
public interface CandidatosDao extends JpaRepository<Candidato, Long> {
	//busca candidatos que tengan al menos uno de los conocimientos
	@Query("SELECT DISTINCT c FROM Candidato c INNER JOIN c.conocimientosCandidato co WHERE co IN ?1 ORDER by c.apellido")
	Collection<Candidato> buscarPorConocimientos(Collection<Conocimiento> conocimientosBuscados);
	
}
