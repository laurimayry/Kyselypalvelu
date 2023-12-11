package com.example.kysely.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Kysymys {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long kysymysId;
    private String kysymysteksti;


	public Kysymys() {}
	
	@ManyToOne
	@JoinColumn(name = "kyselyId")
	private Kysely kysely;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vastaus> vastaukset;

    
   
    public Kysymys( String kysymysteksti, Kysely kysely) {
		super();
    	this.kysymysteksti = kysymysteksti;
		this.kysely = kysely;
    }

	public Long getKysymysId() {
		return kysymysId;
	}

	public void setKysymysId(Long kysymysId) {
		this.kysymysId = kysymysId;
	}

	public String getKysymysteksti() {
		return kysymysteksti;
	}

	public void setKysymysteksti(String kysymysteksti) {
		this.kysymysteksti = kysymysteksti;
	}

	public Kysely getKysely() {
		return kysely;
	}

	public void setKysely(Kysely kysely) {
		this.kysely = kysely;
	}

	@Override
	public String toString() {
		if(this.kysely!=null) {
		return "Kysymys [id=" + kysymysId + ", kysymys=" + kysymysteksti + ", kysely=" + this.getKysely() + "]";
		}
		else {
		return "Kysymys [id=" + kysymysId + ", kysymys=" + kysymysteksti + ", kysely="+kysely+",]";
		}
	}

	public List<Vastaus> getVastaukset() {
		return vastaukset;
	}

	public void setVastaukset(List<Vastaus> vastaukset) {
		this.vastaukset = vastaukset;
	}

	
	

	
    
}
