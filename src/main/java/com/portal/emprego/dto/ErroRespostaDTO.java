package com.portal.emprego.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErroRespostaDTO {
    private LocalDateTime timestamp;
    private Integer status;
    private String erro;
    private List<String> mensagens; // Lista de mensagens amigáveis
}