package com.example.kysely.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KyselyRepository extends JpaRepository<Kysely, Long> {

    List<Kysely> findByKyselyNimi(String kyselyNimi);

    

}

