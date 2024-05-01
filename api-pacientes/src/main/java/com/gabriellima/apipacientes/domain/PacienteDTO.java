package com.gabriellima.apipacientes.domain;

import java.time.LocalDate;

public record PacienteDTO(String nome, String sobrenome, char sexo, LocalDate nascimento, short altura, double peso, String cpf) {
    
}
