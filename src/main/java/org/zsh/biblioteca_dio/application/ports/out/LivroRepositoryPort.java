package org.zsh.biblioteca_dio.application.ports.out;

import org.springframework.stereotype.Component;
import org.zsh.biblioteca_dio.adapter.outRepository.entity.LivroEntity;

import java.util.List;

@Component
public interface LivroRepositoryPort {

    void save( LivroEntity livroEntity);
    void atualizarLivro( LivroEntity livroEntity);
    void deletarLivroPorTitulo(String titulo);
    LivroEntity buscarLivroPorAutor( String autor);
    LivroEntity buscarLivroPorTitulo(String titulo);
    List<LivroEntity> buscarLivroPorTituloAutor( String titulo, String autor);
    List<LivroEntity> buscarTodos();

}
