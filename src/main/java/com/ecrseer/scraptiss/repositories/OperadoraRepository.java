package com.ecrseer.scraptiss.repositories;

import com.ecrseer.scraptiss.dto.OperadoraDTO;
import com.ecrseer.scraptiss.entities.Operadora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OperadoraRepository extends JpaRepository<Operadora,Long> {

}
