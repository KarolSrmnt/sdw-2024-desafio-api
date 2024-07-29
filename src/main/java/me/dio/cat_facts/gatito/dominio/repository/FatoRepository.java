package me.dio.cat_facts.gatito.dominio.repository;

import me.dio.cat_facts.gatito.dominio.model.Fato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FatoRepository extends JpaRepository<Fato, Long> {

    boolean existsByAssunto(String assunto);
}