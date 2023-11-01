package com.example.kysely.domain;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KyselyRepository extends JpaRepository<Kysely, Long> {

}

