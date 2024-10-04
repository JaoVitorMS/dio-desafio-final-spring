package org.zsh.biblioteca_dio.domain.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Livros")
@Getter
@Setter
@NoArgsConstructor
public class Livro {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.status = Status.EM_ESTOQUE;
    }

}
