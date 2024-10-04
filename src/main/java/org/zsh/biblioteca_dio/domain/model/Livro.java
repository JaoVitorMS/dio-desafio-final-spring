package org.zsh.biblioteca_dio.domain.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;


public class Livro {
    
    private long id;
    private String titulo;
    private String autor;
    private Status status;


    public Livro(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
        this.status = Status.EM_ESTOQUE;
    }


    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    

}
