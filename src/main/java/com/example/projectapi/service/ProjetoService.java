package com.example.projectapi.service;

import com.example.projectapi.dto.ProjetoDTO;
import com.example.projectapi.entity.Funcionario;
import com.example.projectapi.entity.Projeto;
import com.example.projectapi.repository.FuncionarioRepository;
import com.example.projectapi.repository.ProjetoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    public ProjetoService(ProjetoRepository projetoRepository, FuncionarioRepository funcionarioRepository) {
        this.projetoRepository = projetoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public Projeto criar(ProjetoDTO dto) {
        Projeto projeto = new Projeto();
        projeto.setNome(dto.nome());
        projeto.setDataCriacao(dto.dataCriacao());

        if (dto.funcionariosIds() != null && !dto.funcionariosIds().isEmpty()) {
            List<Funcionario> funcionarios = funcionarioRepository.findAllById(dto.funcionariosIds());
            projeto.getFuncionarios().addAll(funcionarios);
        }

        return projetoRepository.save(projeto);
    }

    public List<Projeto> listar() {
        return projetoRepository.findAll();
    }
}
