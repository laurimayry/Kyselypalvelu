package com.example.kysely.domain;

import org.hibernate.mapping.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

 

@Entity
public class Kysely {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kyselynNimi;
	private java.util.List<String> kysymykset;

    public Kysely() {}

	

	public Kysely( String kyselynNimi, java.util.List<String> kysymykset) {
		this.kyselynNimi = kyselynNimi;
		this.kysymykset = kysymykset;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKyselynNimi() {
		return kyselynNimi;
	}

	public void setKyselynNimi(String kyselynNimi) {
		this.kyselynNimi = kyselynNimi;
	}

	public java.util.List<String> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(java.util.List<String> kysymykset) {
		this.kysymykset = kysymykset;
	}
   
    
}
