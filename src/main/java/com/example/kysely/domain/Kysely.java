package com.example.kysely.domain;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import com.fasterxml.jackson.annotation.JsonIgnore;

 

@Entity
public class Kysely {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kyselyId;
    private String name;
	

    public Kysely() {}
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
	private List<Kysymys> kysymykset;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kysely")
	private List<Vastaus> vastaukset;

	

	public Kysely( String name) {
		super();
		this.name = name;
		
	}

	public void setKyselyId(Long kyselyId) {
		this.kyselyId = kyselyId;
	}

	public Long getKyselyId() {
		return kyselyId;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return  name ;
	}

   
    
}
