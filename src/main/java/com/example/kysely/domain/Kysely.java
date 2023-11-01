package com.example.kysely.domain;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import java.util.ArrayList;
 

@Entity
public class Kysely {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String kyselyNimi;

    @ElementCollection
    private List<String> kysymykset = new ArrayList<>();

    public Kysely() {}

    public Kysely(Long id, String kyselyNimi, List<String> kysymykset) {
        this.id = id;
        this.kyselyNimi = kyselyNimi;
        this.kysymykset = kysymykset;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKyselyNimi() {
		return kyselyNimi;
	}

	public void setKyselyNimi(String kyselyNimi) {
		this.kyselyNimi = kyselyNimi;
	}

	public List<String> getKysymykset() {
		return kysymykset;
	}

	public void setKysymykset(List<String> kysymykset) {
		this.kysymykset = kysymykset;
	}

	@Override
	public String toString() {
		return "Kysely [id=" + id + ", kyselyNimi=" + kyselyNimi + ", kysymykset=" + kysymykset + "]";
	}
    
}
