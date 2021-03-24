//package com.romagnolocesar.foodz.jpa;
//
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.stereotype.Component;
//import org.apache.catalina.core.ApplicationContext;
//
//import com.romagnolocesar.foodz.FoodzApiApplication;
//import com.romagnolocesar.foodz.domain.model.Cozinha;
//import com.romagnolocesar.foodz.domain.repository.CozinhaRepository;
//
//import java.util.List;
//
//
//public class ConsultaCozinhaMain {
//	public static void main(String[] args) {
//		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(FoodzApiApplication.class)
//				.web(WebApplicationType.NONE)
//				.run(args);
//		
//		CozinhaRepository cozinhas = applicationContext.getBean(CadastroCozinha.class);
//		
//		List<Cozinha> todasCozinhas = cozinhas.todas();
//		
//		for(Cozinha cozinha: todasCozinhas) {
//			System.out.println(cozinha.getNome());
//		}
//		
//		System.out.println("CEEEEESSSSAAARRRR");
//	}
//}
