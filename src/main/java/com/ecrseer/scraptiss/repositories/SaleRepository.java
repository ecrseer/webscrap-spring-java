package com.ecrseer.scraptiss.repositories;

import java.util.List;

import com.ecrseer.scraptiss.dto.SaleSumDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecrseer.scraptiss.dto.SaleSuccessDTO;
import com.ecrseer.scraptiss.entities.Sale;


public interface SaleRepository extends JpaRepository<Sale,Long>{

	@Query("SELECT new com.ecrseer.scraptiss.dto.SaleSumDTO(obj.seller,SUM(obj.amount) ) "+
			"FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();

	@Query("SELECT new com.ecrseer.scraptiss.dto.SaleSuccessDTO(obj.seller,SUM(obj.visited),SUM(obj.deals) ) "+
			"FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();


}
