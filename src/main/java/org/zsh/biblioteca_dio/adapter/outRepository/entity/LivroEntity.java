package org.zsh.biblioteca_dio.adapter.outRepository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "tb_livros")
@Getter
@Setter
public class LivroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    public LivroEntity() {}
    public LivroEntity(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }
}
