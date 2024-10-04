package org.zsh.biblioteca_dio.application.port.outRepository;

import org.zsh.biblioteca_dio.adapter.outRepository.repository.LivroRepositoryEntity;
import org.zsh.biblioteca_dio.application.port.dto.LivroDTO;
import org.zsh.biblioteca_dio.domain.model.Livro;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public Livro toModel( LivroRepositoryEntity entity) {
        return new Livro(entity.getId(), entity.getTitulo(), entity.getAutor());
    }

    public LivroRepositoryEntity toEntity(Livro model) {
        LivroRepositoryEntity entity = new LivroRepositoryEntity();
        entity.setId(model.getId());
        entity.setTitulo(model.getTitulo());
        entity.setAutor(model.getAutor());
        return entity;
    }

    public LivroDTO toDTO(Livro model) {
        return new LivroDTO(model.getId(), model.getTitulo(), model.getAutor());
    }

    public Livro toModel(LivroDTO dto) {
        return new Livro(dto.id(), dto.titulo(), dto.autor());
    }

    public LivroRepositoryEntity toEntity(LivroDTO dto) {
        LivroRepositoryEntity entity = new LivroRepositoryEntity();
        entity.setId(dto.id());
        entity.setTitulo(dto.titulo());
        entity.setAutor(dto.autor());
        return entity;
    }
}