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
    private String kyselynNimi;

    public Kysely() {}

	

	public Kysely( String kyselynNimi) {
		this.kyselynNimi = kyselynNimi;
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



	@Override
	public String toString() {
		return "Kysely [id=" + id + ", kyselynNimi=" + kyselynNimi + "]";
	}
   
	
    
}
