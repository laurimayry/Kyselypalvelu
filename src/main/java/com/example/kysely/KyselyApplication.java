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
import com.example.kysely.domain.Vastaus;
import com.example.kysely.domain.VastausRepository;
import com.example.kysely.domain.Kysely;
import com.example.kysely.domain.Kysymys;

@SpringBootApplication
public class KyselyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KyselyApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(KyselyApplication.class);


	@Bean
    public CommandLineRunner bookDemo(KyselyRepository kyselyRepository, KysymysRepository kysymysRepository, VastausRepository vastausRepository) {
        return(args) -> {
			log.info("save a couple of kyselys");
			kyselyRepository.save(new Kysely("Kulttuuri kysely"));
			kyselyRepository.save(new Kysely("Urheilu kysely"));
			
			log.info("save a couple of vastaus");
			
		   vastausRepository.save(new Vastaus("Batman", kysymysRepository.findByKysymys("Mitä elokuvia suosittelet?"), kyselyRepository.findByName("Kulttuuri kysely").get(0)));
		   
			log.info("save a couple of kysymys");
            kysymysRepository.save(new Kysymys("Mitä elokuvia suosittelet?", kyselyRepository.findByName("Kulttuuri kysely").get(0)));
           kysymysRepository.save(new Kysymys("Mikä on paras elokuva? ", kyselyRepository.findByName("Kulttuuri kysely").get(0)));


		   kysymysRepository.save(new Kysymys("Kuka on lempi urheilijasi?", kyselyRepository.findByName("Urheilu kysely").get(0)));
		   
           kysymysRepository.save(new Kysymys("Kuka voitti jääkiekon mm kisat vuonna 2012?", kyselyRepository.findByName("Urheilu kysely").get(0)));
        };
    }

}
