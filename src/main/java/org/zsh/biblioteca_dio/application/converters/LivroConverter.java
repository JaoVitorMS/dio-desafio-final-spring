package org.zsh.biblioteca_dio.application.converters;

import org.zsh.biblioteca_dio.application.port.dto.LivroDTO;
import org.zsh.biblioteca_dio.domain.model.Livro;
import org.springframework.beans.factory.annotation.Autowired;

public class LivroConverter {

    

    public LivroDTO toDTO(Livro livro) {
        return new LivroDTO(livro.getId(), livro.getTitulo(), livro.getAutor());
    }

    public Livro toEntity(LivroDTO livroDTO) {
        return new Livro(livroDTO.id(), livroDTO.titulo(), livroDTO.autor());
    }
}
