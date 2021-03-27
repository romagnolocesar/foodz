package com.romagnolocesar.foodz.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomJpaRepository<T, Long> extends JpaRepository<T, Long>{
		
	Optional<T> buscarPrimeiro();
}
