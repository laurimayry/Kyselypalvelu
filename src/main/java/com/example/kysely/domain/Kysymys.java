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
    private Long id;
    private String kysymys;


	public Kysymys() {}
	
	@ManyToOne
	@JoinColumn(name = "kyselyId")
	private Kysely kysely;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysymys")
	private List<Vastaus> vastaukset;

    
   
    public Kysymys( String kysymys, Kysely kysely) {
		super();
    	this.kysymys = kysymys;
		this.kysely = kysely;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKysymys() {
		return kysymys;
	}

	public void setKysymys(String kysymys) {
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
		if(this.kysely!=null) {
		return "Kysymys [id=" + id + ", kysymys=" + kysymys + ", kysely=" + this.getKysely() + "]";
		}
		else {
		return "Kysymys [id=" + id + ", kysymys=" + kysymys + ", kysely="+kysely+",]";
		}
	}

	
	

	
    
}
