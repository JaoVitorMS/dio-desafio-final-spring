package org.zsh.biblioteca_dio.dto;

import org.springframework.stereotype.Component;
import org.zsh.biblioteca_dio.domain.model.Livro;
import org.zsh.biblioteca_dio.entity.LivroEntity;

@Component
public class LivroConversor {
    
    public LivroDTO converteParaLivroDTO(Livro livro, Integer id){
        return new LivroDTO(id, livro.getTitulo(), livro.getAutor());
    }

    public Livro converteParaLivro(LivroDTO livroDTO){
        return new Livro(livroDTO.getTitulo(), livroDTO.getAutor());
    }

    public LivroEntity converteParaLivroEntity(LivroDTO livroDTO){
        return new LivroEntity(livroDTO.getTitulo(), livroDTO.getAutor());
    }

    public LivroDTO converteParaLivroDTO(LivroEntity livroEntity){
        return new LivroDTO(livroEntity.getId(), livroEntity.getTitulo(), livroEntity.getAutor());
    }
}