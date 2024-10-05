package org.zsh.biblioteca_dio.adapter.outRepository.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.zsh.biblioteca_dio.domain.model.Livro;

public interface LivroRepositoryJPA extends JpaRepository<LivroRepositoryEntity, Long> {
        
        Optional<LivroRepositoryEntity> findByTitulo(String titulo);
        Optional<LivroRepositoryEntity> findByAutor(String autor);
}
