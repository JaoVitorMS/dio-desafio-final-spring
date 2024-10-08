package org.zsh.biblioteca_dio.adapter.outRepository.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zsh.biblioteca_dio.adapter.outRepository.entity.LivroEntity;

import java.util.List;

public interface LivroAdapterJPA extends JpaRepository<LivroEntity, Integer> {
    LivroEntity deleteByTitulo(String titulo);
    LivroEntity deleteByAutor(String autor);
    LivroEntity findByTitulo( String title);
    LivroEntity findByAutor ( String author);
    List<LivroEntity> findByTituloAndAutor ( String title, String author);
//gfbd
    //
}
