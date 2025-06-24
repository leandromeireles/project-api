package com.example.projectapi.service;

import com.example.projectapi.dto.ProjetoDTO;
import com.example.projectapi.entity.Projeto;
import com.example.projectapi.repository.FuncionarioRepository;
import com.example.projectapi.repository.ProjetoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ProjetoServiceTest {

    @Mock
    private ProjetoRepository projetoRepository;

    @Mock
    private FuncionarioRepository funcionarioRepository;

    @InjectMocks
    private ProjetoService projetoService;

    public ProjetoServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCriarProjeto() {
        ProjetoDTO dto = new ProjetoDTO("Projeto Teste", LocalDate.now(), List.of());
        Projeto projeto = new Projeto();
        projeto.setNome(dto.nome());

        when(projetoRepository.save(any())).thenReturn(projeto);

        Projeto salvo = projetoService.criar(dto);

        assertEquals("Projeto Teste", salvo.getNome());
        verify(projetoRepository, times(1)).save(any());
    }
}
