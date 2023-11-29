package com.example.kysely;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.kysely.domain.Kysely;
import com.example.kysely.domain.KyselyRepository;
import com.example.kysely.domain.Kysymys;
import com.example.kysely.domain.KysymysRepository;
import com.example.kysely.domain.Vastaus;
import com.example.kysely.domain.VastausRepository;

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

			kyselyRepository.save(new Kysely("Haaga-Helian kahvila kysely"));

			
		   vastausRepository.save(new Vastaus("Batman", kysymysRepository.findByKysymysteksti("Mitä elokuvia suosittelet?"), kyselyRepository.findByName("Kulttuuri kysely").get(0)));
		   
			log.info("save a couple of kysymys");
            kysymysRepository.save(new Kysymys("Mitä elokuvia suosittelet?", kyselyRepository.findByName("Kulttuuri kysely").get(0)));
           kysymysRepository.save(new Kysymys("Mikä on paras elokuva? ", kyselyRepository.findByName("Kulttuuri kysely").get(0)));

		   kysymysRepository.save(new Kysymys("Kuka on lempi urheilijasi?", kyselyRepository.findByName("Urheilu kysely").get(0)));
           kysymysRepository.save(new Kysymys("Kuka voitti jääkiekon mm kisat vuonna 2012?", kyselyRepository.findByName("Urheilu kysely").get(0)));
       
           kysymysRepository.save(new Kysymys("Oletko koskaan asioinut Haaga-Helian kahvilassa?", kyselyRepository.findByName("Haaga-Helian kahvila kysely").get(0)));
           kysymysRepository.save(new Kysymys("Oletko ollut yleisesti tyytyväinen kahvilaan?", kyselyRepository.findByName("Haaga-Helian kahvila kysely").get(0)));
           kysymysRepository.save(new Kysymys("Jos et, niin miksi?", kyselyRepository.findByName("Haaga-Helian kahvila kysely").get(0)));
           kysymysRepository.save(new Kysymys("Onko kahvilan hinnoittelu mielestäsi kohtuullinen?", kyselyRepository.findByName("Haaga-Helian kahvila kysely").get(0)));
           kysymysRepository.save(new Kysymys("Onko kahvilan valikoima mielestäsi hyvä ja kattava?", kyselyRepository.findByName("Haaga-Helian kahvila kysely").get(0)));
           kysymysRepository.save(new Kysymys("Jos ei, niin mitä haluaisit muuttaa kahvilan valikoimassa?", kyselyRepository.findByName("Haaga-Helian kahvila kysely").get(0)));
           kysymysRepository.save(new Kysymys("Onko kahvilan tilat mielestäsi viihtyisät?", kyselyRepository.findByName("Haaga-Helian kahvila kysely").get(0)));
           kysymysRepository.save(new Kysymys("Jos ei, niin miten muuttaisit niitä?", kyselyRepository.findByName("Haaga-Helian kahvila kysely").get(0)));
           kysymysRepository.save(new Kysymys("Oletko ollut tyytyväinen saamaasi asiakaspalveluun kahvilassa?", kyselyRepository.findByName("Haaga-Helian kahvila kysely").get(0)));
           kysymysRepository.save(new Kysymys("Monennen vuoden opiskelija olet?", kyselyRepository.findByName("Haaga-Helian kahvila kysely").get(0)));
           
        };
    }

}
