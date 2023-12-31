package com.example.kysely.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Vastaus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vastausId;
    private String vastaus;
    

    @ManyToOne
	@JoinColumn(name = "kysymysId")
	private Kysymys kysymys;

    @ManyToOne
	@JoinColumn(name = "kyselyId")
	private Kysely kysely;

    public Vastaus () {};

    

    public Vastaus(String vastaus, Kysymys kysymys, Kysely kysely) {
        super();
        this.vastaus = vastaus;
        this.kysymys = kysymys;
        this.kysely = kysely;
    }



    public Long getVastausId() {
        return vastausId;
    }

    public void setVastausId(Long VastausId) {
        this.vastausId = VastausId;
    }

    public String getVastaus() {
        return vastaus;
    }

    public void setVastaus(String vastaus) {
        this.vastaus = vastaus;
    }

    public Kysymys getKysymys() {
        return kysymys;
    }

    public void setKysymys(Kysymys kysymys) {
        this.kysymys = kysymys;
    }

    public Kysely getKysely() {
        return kysely;
    }

    public void setKysely(Kysely kysely) {
        this.kysely = kysely;
    }

    @Override
    public String toString() {
        return "Vastaus [vastausId=" + vastausId + ", vastaus=" + vastaus + ", kysymys=" + kysymys + ", kysely=" + kysely + "]";
    }

    
}
