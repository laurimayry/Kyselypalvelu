package com.example.kysely.domain;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface KysymysRepository extends JpaRepository<Kysymys, Long> {
List<Kysymys> findByKysely(Kysely kysely);
Kysymys findByKysymys(String kysymys);
}