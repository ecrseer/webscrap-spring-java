package com.ecrseer.scraptiss.services;

import java.util.List;
import java.util.stream.Collectors;

import com.ecrseer.scraptiss.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecrseer.scraptiss.dto.SellerDTO;
import com.ecrseer.scraptiss.entities.Seller;

@Service
public class SellerService {
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll(){
		List<Seller> resultado = repository.findAll();

		return resultado.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
		
	}
	public void adicionar(Seller seller){
		System.out.println(seller.getName());
		repository.save(seller);

	}
}
