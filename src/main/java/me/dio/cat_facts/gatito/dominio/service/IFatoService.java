package me.dio.cat_facts.gatito.dominio.service;

import me.dio.cat_facts.gatito.dominio.model.Fato;

public interface IFatoService {

    Fato findById(Long id);

    Fato create(Fato fatoToCreate);
}
