package edu.utn.frro.ds.reverseengineering.rrhh.dao;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.utn.frro.ds.reverseengineering.rrhh.domain.Conocimiento;
@Repository
public interface ConocimientoDao extends JpaRepository<Conocimiento, Long> {

}
