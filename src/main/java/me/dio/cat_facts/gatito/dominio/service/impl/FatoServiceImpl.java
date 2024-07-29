package me.dio.cat_facts.gatito.dominio.service.impl;

import me.dio.cat_facts.gatito.dominio.model.Fato;
import me.dio.cat_facts.gatito.dominio.repository.FatoRepository;
import me.dio.cat_facts.gatito.dominio.service.IFatoService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class FatoServiceImpl implements IFatoService {

    private final FatoRepository repository;

    public FatoServiceImpl(FatoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Fato findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Fato create(Fato fatoToCreate) {
        if(repository.existsByAssunto(fatoToCreate.getAssunto())) {
            throw new IllegalArgumentException("Ops! Fato já existente");
        }
        return repository.save(fatoToCreate);
    }

}
