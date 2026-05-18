package com.portal.emprego.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private String instituição; // Quem está oferecendo o curso
    private Integer cargaHoraria; // Em horas
    private String modalidade; // Ex: Presencial, EAD, Híbrido
}