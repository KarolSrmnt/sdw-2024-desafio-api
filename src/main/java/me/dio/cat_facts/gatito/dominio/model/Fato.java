package me.dio.cat_facts.gatito.dominio.model;

import jakarta.persistence.*;

@Entity
@Table(name = "fatosGatito_tb")
public class Fato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String assunto;

    public Fato() {
    }

    public Fato(Long id, String assunto) {
        this.id = id;
        this.assunto = assunto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    @Override
    public String toString() {
        return assunto;
    }
}
