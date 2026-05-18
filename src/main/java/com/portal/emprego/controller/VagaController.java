package com.portal.emprego.controller;

import com.portal.emprego.model.Vaga;
import com.portal.emprego.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vagas")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    // Rota para listar todas as vagas (GET /vagas)
    @GetMapping
    public List<Vaga> listar() {
        return vagaService.listarTodas();
    }

    // Rota para buscar uma vaga específica (GET /vagas/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscar(@PathVariable Long id) {
        return vagaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Rota para cadastrar uma nova vaga (POST /vagas)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vaga adicionar(@RequestBody Vaga vaga) {
        return vagaService.salvar(vaga);
    }
}