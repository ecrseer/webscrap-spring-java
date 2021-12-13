package com.ecrseer.scraptiss.controllers;

import com.ecrseer.scraptiss.dto.OperadoraDTO;
import com.ecrseer.scraptiss.services.OperadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/operadoras")
public class OperadoraController {

    @Autowired
    private OperadoraService operadoraService;

    @GetMapping
    public ResponseEntity<List<OperadoraDTO>> listarOperadoras(){
        List<OperadoraDTO> operadoras = operadoraService.listarTodas();
        return ResponseEntity.ok(operadoras);
    }
}
