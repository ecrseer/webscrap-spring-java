package com.ecrseer.scraptiss.services;

import com.ecrseer.scraptiss.dto.OperadoraDTO;
import com.ecrseer.scraptiss.entities.Operadora;
import com.ecrseer.scraptiss.repositories.OperadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OperadoraService {
    @Autowired
    private OperadoraRepository operadoraRepository;

    public List<OperadoraDTO> listarTodas(){
        List<Operadora> operadoras = operadoraRepository.findAll();
        List<OperadoraDTO> operadoraDTOS = operadoras.stream()
                .map(operadora -> new OperadoraDTO(operadora))
                .collect(Collectors.toList());


        return  operadoraDTOS;
    }


}
