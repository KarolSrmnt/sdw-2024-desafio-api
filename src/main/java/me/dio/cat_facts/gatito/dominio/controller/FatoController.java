package me.dio.cat_facts.gatito.dominio.controller;

import me.dio.cat_facts.gatito.dominio.model.Fato;

import me.dio.cat_facts.gatito.dominio.service.IFatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/fatos")
public class FatoController {

    private final IFatoService fatoService;

    public FatoController(IFatoService fatoService) {
        this.fatoService = fatoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fato> findById(@PathVariable Long id) {
        var fato = fatoService.findById(id);
        return ResponseEntity.ok(fato);
    }

    @PostMapping
    public ResponseEntity<Fato> create(@RequestBody Fato fatoToCreate) {
        var fatoCreated = fatoService.create(fatoToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(fatoCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(fatoCreated);
    }
}
