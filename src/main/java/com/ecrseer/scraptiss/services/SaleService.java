package com.ecrseer.scraptiss.services;

import java.util.List;

import com.ecrseer.scraptiss.dto.SaleDTO;
import com.ecrseer.scraptiss.dto.SaleSumDTO;
import com.ecrseer.scraptiss.repositories.SaleRepository;
import com.ecrseer.scraptiss.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecrseer.scraptiss.dto.SaleSuccessDTO;
import com.ecrseer.scraptiss.entities.Sale;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> resultado = repository.findAll(pageable);		
		return resultado.map(x -> new SaleDTO(x));
		
	}
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){		
		return repository.successGroupedBySeller();
	}

}
