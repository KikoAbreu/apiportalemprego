package com.portal.emprego.controller;

import com.portal.emprego.dto.VagaRequestDTO;
import com.portal.emprego.model.Vaga;
import com.portal.emprego.service.VagaService;

import jakarta.validation.Valid;

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

    @GetMapping
    public List<Vaga> listar() {
        return vagaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscar(@PathVariable Long id) {
        return vagaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()); // Retorna 404 Not Found se não achar
    }

    // Atualizado para receber a Entidade (ou você pode mudar para DTO depois se preferir)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vaga adicionar(@RequestBody Vaga vaga) {
        return vagaService.salvar(vaga);
    }

    // PUT /vagas/{id} - Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Vaga> atualizar(@PathVariable Long id, @Valid @RequestBody VagaRequestDTO dto) {
        Vaga vagaAtualizada = vagaService.atualizar(id, dto);
        return ResponseEntity.ok(vagaAtualizada);
    }

    // DELETE /vagas/{id} - Deletar
    // DELETE /vagas/{id} - Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        vagaService.deletar(id);
        return ResponseEntity.noContent().build(); // Retorna HTTP 204
    }
}