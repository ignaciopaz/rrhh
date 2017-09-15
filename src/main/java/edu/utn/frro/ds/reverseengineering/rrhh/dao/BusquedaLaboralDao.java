package edu.utn.frro.ds.reverseengineering.rrhh.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.utn.frro.ds.reverseengineering.rrhh.domain.BusquedaLaboral;
@Repository
public interface BusquedaLaboralDao extends JpaRepository<BusquedaLaboral, Long> {

	@Query("SELECT b FROM BusquedaLaboral b WHERE b.estado = 'activo'")
	Collection<BusquedaLaboral> buscarBusquedasActivas();

}
