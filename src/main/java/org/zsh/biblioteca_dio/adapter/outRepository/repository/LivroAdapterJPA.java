package org.zsh.biblioteca_dio.adapter.outRepository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zsh.biblioteca_dio.adapter.outRepository.entity.LivroEntity;

import java.util.List;

@Repository
public interface LivroAdapterJPA extends JpaRepository<LivroEntity, Integer> {
    void deleteByTitulo(String titulo);
    LivroEntity findByTitulo( String title);
    LivroEntity findByAutor ( String author);

}
