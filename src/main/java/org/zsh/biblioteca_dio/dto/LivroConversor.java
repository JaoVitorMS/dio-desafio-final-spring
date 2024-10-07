package org.zsh.biblioteca_dio.dto;

import org.springframework.stereotype.Component;
import org.zsh.biblioteca_dio.domain.model.Livro;
import org.zsh.biblioteca_dio.adapter.out.entity;

@Component
public class LivroConversor {
    
    public LivroDTO converteParaLivroDTO(Livro livro){
        return new LivroDTO(livro.getTitulo(), livro.getAutor());
    }

    public Livro converteParaLivro(LivroDTO livroDTO){
        return new Livro(livroDTO.titulo(), livroDTO.autor());
    }

    public LivroEntity converterParaEntity(LivroDTO livroDTO){
        return LivroEntity(livroDTO.titulo(), livroDTO.autor());
    }

    public LivroDTO converteParaLivroDTO(LivroEntity livroEntity){
        return new LivroDTO(livroEntity.getTitulo(), livroEntity.getAutor());
    }
}