package org.zsh.biblioteca_dio.application.port.outRepository;

import org.zsh.biblioteca_dio.domain.model.Livro;

public interface LivroRepository {

    void salvar( Livro livro);
    Livro buscarPorId(Long id);
    void remover(Long id);
    void atualizar(Livro livro);
}
