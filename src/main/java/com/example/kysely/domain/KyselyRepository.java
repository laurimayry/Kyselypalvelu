package com.example.kysely.domain;
import java.util.Locale.Category;
import java.util.Optional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KyselyRepository extends JpaRepository<Kysely, Long> {
    List<Kysely> findByName(String name);

}