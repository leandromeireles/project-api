package com.example.projectapi.dto;

import java.time.LocalDate;
import java.util.List;

public record ProjetoDTO(String nome, LocalDate dataCriacao, List<Long> funcionariosIds) {}
