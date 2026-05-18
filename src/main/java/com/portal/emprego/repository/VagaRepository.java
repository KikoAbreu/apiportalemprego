package com.portal.emprego.repository;

import com.portal.emprego.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
    // Métodos customizados podem ser adicionados aqui depois (ex: buscar por localização)
}