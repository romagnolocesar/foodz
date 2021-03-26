package com.romagnolocesar.foodz.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romagnolocesar.foodz.domain.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

	
}