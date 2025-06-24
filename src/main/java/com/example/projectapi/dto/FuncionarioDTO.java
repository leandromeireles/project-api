package com.example.projectapi.dto;

import java.math.BigDecimal;

    public record FuncionarioDTO(String nome, String cpf, String email, BigDecimal salario) {}
