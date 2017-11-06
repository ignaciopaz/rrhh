package edu.utn.frro.ds.reverseengineering.rrhh.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.utn.frro.ds.reverseengineering.rrhh.domain.Entrevista;
@Repository
public interface EntrevistaDao extends JpaRepository<Entrevista, Long> {

	@Query("SELECT e FROM Entrevista e WHERE e.estado='confirmado' AND e.fechaEntrevista >= ?1 ORDER by e.fechaEntrevista")
	Collection<Entrevista> buscarEntrevistas(Date fechaDesde);

}
