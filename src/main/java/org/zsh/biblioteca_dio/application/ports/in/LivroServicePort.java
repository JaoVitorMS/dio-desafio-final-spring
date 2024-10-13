package org.zsh.biblioteca_dio.application.ports.in;

import org.springframework.stereotype.Component;
import org.zsh.biblioteca_dio.adapter.outRepository.entity.LivroEntity;
import org.zsh.biblioteca_dio.dto.LivroDTO;

import java.util.List;

@Component
public interface LivroServicePort {
    
    void registrarLivro(LivroDTO livroDTO);
    void atualizarLivro(LivroDTO livroDTO);
    void deletarLivroPorTitulo(String titulo);
    LivroEntity buscarLivroPorAutor(String autor);
    LivroEntity buscarLivroPorTitulo( String titulo);
    List<LivroDTO> buscarTodosLivros();

}
