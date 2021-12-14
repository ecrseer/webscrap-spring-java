package com.ecrseer.scraptiss.controllers;

import com.ecrseer.scraptiss.entities.webscrap.TabelaQuadro;
import com.ecrseer.scraptiss.services.WebScrapingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@Slf4j
@RequestMapping(value = "/scrap/")
public class WebScrapingController {

    @Autowired
    private WebScrapingService webScrapingService;

    @RequestMapping(value = "/quadro/{numeroQuadro}", method = RequestMethod.GET)
    public TabelaQuadro getQuadro(@PathVariable("numeroQuadro") int numeroQuadro) throws IOException{
        TabelaQuadro quadro = webScrapingService.getQuadro(numeroQuadro);
        if(quadro!=null){
                return quadro;
            }else{
            return new TabelaQuadro("gov br offline");
        }
    }


}
