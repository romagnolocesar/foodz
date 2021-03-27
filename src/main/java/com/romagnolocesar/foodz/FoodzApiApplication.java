package com.romagnolocesar.foodz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.romagnolocesar.foodz.infrastructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
//Colocando como repositorio base o respositorio customizado que estende do SimpleJpa que é a base do original JpaRepository
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class FoodzApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodzApiApplication.class, args);
	}

}
