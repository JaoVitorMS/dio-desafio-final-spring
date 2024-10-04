package org.zsh.biblioteca_dio.application.port.outRepository;

import java.util.List;
import java.util.Optional;

import org.zsh.biblioteca_dio.application.port.dto.LivroDTO;
import org.zsh.biblioteca_dio.domain.model.Livro;

public interface LivroRepository {
    
    List<Livro> buscarTodos();
    Optional<Livro> findById(Long id);
    void salvar( LivroDTO livroDTO );
    void remover(Long id);
    void atualizar( LivroDTO livroDTO );
}
