package com.ecrseer.scraptiss.repositories;

import com.ecrseer.scraptiss.dto.SellerDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ecrseer.scraptiss.entities.Seller;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SellerRepository extends JpaRepository<Seller,Long>{


}
