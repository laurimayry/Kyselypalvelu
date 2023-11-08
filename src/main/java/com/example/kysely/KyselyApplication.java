package com.example.kysely;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.example.kysely.domain.KyselyRepository;
import com.example.kysely.domain.KysymysRepository;
import com.example.kysely.domain.Kysely;
import com.example.kysely.domain.Kysymys;

@SpringBootApplication
public class KyselyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);


	@Bean
    public CommandLineRunner bookDemo(KyselyRepository kyselyRepository, KysymysRepository kysymysRepository) {
        return(args) -> {
			log.info("save a couple of kyselys");
			kyselyRepository.save(new Kysely("Kulttuuri kysely"));
			

			
            kysymysRepository.save(new Kysymys("Mitä elokuvia suosittelet?", kyselyRepository.findByName("Kulttuuri kysely").get(0)));
           kysymysRepository.save(new Kysymys("Mikä on paras elokuva? ", kyselyRepository.findByName("Kulttuuri kysely").get(0)));
        };
    }

}
