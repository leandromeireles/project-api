package com.example.projectapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Funcionario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    @Column(unique = true)
    private String cpf;
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    private BigDecimal salario;
    @ManyToMany(mappedBy = "funcionarios")
    @JsonBackReference
    private List<Projeto> projetos = new ArrayList<>();
}
