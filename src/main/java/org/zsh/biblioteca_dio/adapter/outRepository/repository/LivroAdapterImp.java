package org.zsh.biblioteca_dio.adapter.outRepository.repository;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.zsh.biblioteca_dio.adapter.outRepository.entity.LivroEntity;
import org.zsh.biblioteca_dio.application.ports.out.LivroRepositoryPort;

import java.util.List;
//ff
//
@Repository
@AllArgsConstructor
public class LivroAdapterImp implements LivroRepositoryPort {

    private final LivroAdapterJPA livroAdapterJPA;

    @Override
    public void save ( LivroEntity livroEntity ) {
        livroAdapterJPA.save(livroEntity);
    }

    @Override
    public void atualizarLivro ( LivroEntity livroEntity ) {
        livroAdapterJPA.save(livroEntity);
    }

    @Override
    public void deletarLivroPorTitulo ( String titulo ) {
        livroAdapterJPA.deleteByTitulo(titulo);
    }

    @Override
    public LivroEntity buscarLivroPorAutor ( String autor ) {
        return livroAdapterJPA.findByAutor(autor);
    }

    @Override
    public LivroEntity buscarLivroPorTitulo ( String titulo ) {
        return livroAdapterJPA.findByTitulo(titulo);
    }

    @Override
    public List<LivroEntity> buscarLivroPorTituloAutor ( String titulo, String autor ) {
        return livroAdapterJPA.findByTituloAndAutor(titulo, autor);
    }

    @Override
    public List<LivroEntity> buscarTodos () {
        return livroAdapterJPA.findAll();
    }
}
