package com.example.kysely;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kysely.domain.KyselyRepository;
import com.example.kysely.domain.Kysymys;
import com.example.kysely.domain.Kysely;

import com.example.kysely.domain.KysymysRepository;

@SpringBootApplication
public class KyselyApplication {
	
    private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner kyselydemo(KyselyRepository kyselyrepository, KysymysRepository kysymysrepository) {
		return (args) -> {
			log.info("tallenna testikyselyt");
			kyselyrepository.save(new Kysely("Kahvila"));
			kyselyrepository.save(new Kysely("Ruokala"));
			kyselyrepository.save(new Kysely("Koulu"));
			kyselyrepository.save(new Kysely("Harry"));

			
			log.info("fetch all questions");
			for (Kysymys Kysymys : kysymysrepository.findAll()) {
				log.info(Kysymys.toString());
			}
		};

}
}
