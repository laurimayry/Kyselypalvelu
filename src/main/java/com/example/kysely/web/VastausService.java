package com.example.kysely.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kysely.domain.Kysely;
import com.example.kysely.domain.KyselyRepository;
import com.example.kysely.domain.Kysymys;
import com.example.kysely.domain.KysymysRepository;
import com.example.kysely.domain.Vastaus;
import com.example.kysely.domain.VastausRepository;

@Service
public class VastausService {

    @Autowired
    private VastausRepository vastausRepository;

    @Autowired
    private KysymysRepository kysymysRepository;

    @Autowired
    private KyselyRepository kyselyRepository;

    public Vastaus tallennaVastaus(Long kysymysId, Long kyselyId, String Vastaus) {
        // Etsi kysymys ja kysely tietokannasta
        Kysymys kysymys = kysymysRepository.findById(kysymysId).orElseThrow(() -> new RuntimeException("Kysymys not found"));
        Kysely kysely = kyselyRepository.findById(kyselyId).orElseThrow(() -> new RuntimeException("Kysely not found"));

        // Luo uusi Vastaus-olio ja aseta sille arvot
        Vastaus vastaus = new Vastaus();
        vastaus.setVastaus(Vastaus);
        vastaus.setKysymys(kysymys);
        vastaus.setKysely(kysely);

        // Tallenna vastaus tietokantaan
        Vastaus tallennettuVastaus = vastausRepository.save(vastaus);

        // Päivitä vastauksen viittaukset kysymykseen ja kyselyyn
        tallennettuVastaus.setKysymys(kysymys);
        tallennettuVastaus.setKysely(kysely);

        // Päivitä kysymyksen ja kyselyn vastaussarakkeisiin
        kysymys.getVastaukset().add(tallennettuVastaus);
        kysely.getVastaukset().add(tallennettuVastaus);

        // Tallenna päivitykset kysymykseen ja kyselyyn
        kysymysRepository.save(kysymys);
        kyselyRepository.save(kysely);

        return tallennettuVastaus;
    }
}





