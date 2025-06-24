package com.example.projectapi.controller;

import com.example.projectapi.dto.ProjetoDTO;
import com.example.projectapi.entity.Projeto;
import com.example.projectapi.service.ProjetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    private final ProjetoService service;

    public ProjetoController(ProjetoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Projeto> criar(@RequestBody ProjetoDTO dto) {
        return ResponseEntity.ok(service.criar(dto));
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> listar() {
        return ResponseEntity.ok(service.listar());
    }
}
