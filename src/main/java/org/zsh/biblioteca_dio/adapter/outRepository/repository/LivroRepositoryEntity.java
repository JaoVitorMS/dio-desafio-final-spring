package org.zsh.biblioteca_dio.adapter.outRepository.repository;

import org.zsh.biblioteca_dio.domain.model.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@Entity
@Table(name = "Livros")
@Getter
@Setter
public class LivroRepositoryEntity {
    
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;
    
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public LivroRepositoryEntity ( long id, String titulo, String autor ) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.status = Status.EM_ESTOQUE;
    }

    public LivroRepositoryEntity() {}
}