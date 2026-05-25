package com.portal.emprego.service;

import com.portal.emprego.dto.VagaRequestDTO;
import com.portal.emprego.exception.RecursoNaoEncontradoException;
import com.portal.emprego.model.Vaga;
import com.portal.emprego.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public List<Vaga> listarTodas() {
        return vagaRepository.findAll();
    }

    public Optional<Vaga> buscarPorId(Long id) {
        return vagaRepository.findById(id);
    }

    public Vaga salvar(Vaga vaga) {
        // colocar validações no futuro (ex: validar se a empresa existe)
        return vagaRepository.save(vaga);
    }
    // UPDATE
    public Vaga atualizar(Long id, VagaRequestDTO dto) {
        Vaga vagaExistente = vagaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Vaga não encontrada com o ID: " + id));

        vagaExistente.setTitulo(dto.getTitulo());
        vagaExistente.setDescricao(dto.getDescricao());
        vagaExistente.setEmpresa(dto.getEmpresa());
        vagaExistente.setSalario(dto.getSalario());
        vagaExistente.setLocalizacao(dto.getLocalizacao());

        return vagaRepository.save(vagaExistente);
    }
    // DELETE: Remove a vaga se ela existir
    public void deletar(Long id) {
        if (!vagaRepository.existsById(id)) {
            throw new RecursoNaoEncontradoException("Não foi possível deletar. Vaga não encontrada com o ID: " + id);
        }
        vagaRepository.deleteById(id);
    }
}