package org.zsh.biblioteca_dio.application.ports.in;

import org.springframework.stereotype.Component;
import org.zsh.biblioteca_dio.dto.LivroDTO;

import java.util.List;

@Component
public interface LivroServicePort {
    
    void registrarLivro(LivroDTO livroDTO);
    void atualizarLivro(LivroDTO livroDTO);
    void deletarLivroPorTitulo(String titulo);
    LivroDTO buscarLivroPorAutor(String autor);
    LivroDTO buscarLivroPorTitulo(String titulo);
    List<LivroDTO> buscarTodosLivros();

}
