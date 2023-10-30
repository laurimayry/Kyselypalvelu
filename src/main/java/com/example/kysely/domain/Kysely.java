package com.example.kysely.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

 

@Entity
public class Kysely {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kysely;

    public Kysely() {}
   
    public Kysely(Long id, String kysely) {
    	this.id = id;
    	this.kysely = kysely;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKysely() {
		return kysely;
	}

	public void setKysely(String kysely) {
		this.kysely = kysely;
	}

	@Override
	public String toString() {
		return "Kysely [id=" + id + ", kysely=" + kysely + "]";
	}
    
}
