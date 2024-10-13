package org.zsh.biblioteca_dio.dto;

import org.springframework.stereotype.Component;
import org.zsh.biblioteca_dio.adapter.outRepository.entity.LivroEntity;
import org.zsh.biblioteca_dio.domain.model.Livro;

@Component
public class LivroConversor {
    
    public LivroDTO toDTO(Livro livro) {
        return new LivroDTO(livro.getTitulo(), livro.getAutor());
    }
    public Livro toLivro(LivroDTO livroDTO) {
        return new Livro(livroDTO.titulo(), livroDTO.autor());
    }
    public LivroDTO entityToDTO(LivroEntity livroEntity) {
        return new LivroDTO(livroEntity.getTitulo(), livroEntity.getAutor());
    }
    public LivroEntity toEntity( LivroDTO livroDTO) {
        return new LivroEntity(livroDTO.titulo(), livroDTO.autor());
    }
}
