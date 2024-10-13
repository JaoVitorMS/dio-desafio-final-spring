package org.zsh.biblioteca_dio.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zsh.biblioteca_dio.adapter.outRepository.entity.LivroEntity;
import org.zsh.biblioteca_dio.application.ports.in.LivroServicePort;
import org.zsh.biblioteca_dio.application.ports.out.LivroRepositoryPort;
import org.zsh.biblioteca_dio.domain.model.Livro;
import org.zsh.biblioteca_dio.dto.LivroConversor;
import org.zsh.biblioteca_dio.dto.LivroDTO;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LivroServiceImpl implements LivroServicePort {

    private final Livro livro;
    private LivroRepositoryPort livroRepositoryPort;
    private LivroConversor livroConversor;

    @Override
    public void registrarLivro(LivroDTO livroDTO) {
        LivroEntity livroEntity = livroConversor.toEntity(livroDTO);
        livroRepositoryPort.save(livroEntity);
    }

    @Override
    public void atualizarLivro(LivroDTO livroDTO) {
        LivroEntity livroEntity = livroConversor.toEntity(livroDTO);
        LivroEntity livroExistente = livroRepositoryPort.buscarLivroPorTitulo(livroEntity.getTitulo());
        if (livroExistente != null) {
            livroExistente.setAutor(livroEntity.getAutor());
            livroExistente.setTitulo(livroEntity.getTitulo());
            livroRepositoryPort.atualizarLivro(livroExistente);
        }
    }

    @Transactional
    @Override
    public void deletarLivroPorTitulo(String titulo) {
        LivroEntity livroExistente = livroRepositoryPort.buscarLivroPorTitulo(titulo);
        if (livroExistente != null) {
            livroRepositoryPort.deletarLivroPorTitulo(titulo);
        }
    }

    @Override
    public List<LivroDTO> buscarTodosLivros() {
        List<LivroEntity> livroEntities = livroRepositoryPort.buscarTodos();
        return livroEntities.stream()
                .map(livros -> livroConversor.entityToDTO(livros))
                .collect(Collectors.toList());
    }

    @Override
    public LivroEntity buscarLivroPorAutor(String autor) {
        return livroRepositoryPort.buscarLivroPorAutor(autor);
    }

    @Override
    public LivroEntity buscarLivroPorTitulo(String titulo) {
        return livroRepositoryPort.buscarLivroPorTitulo(titulo);
    }
}