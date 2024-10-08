package org.zsh.biblioteca_dio.adapter.in;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zsh.biblioteca_dio.application.ports.in.LivroServicePort;
import org.zsh.biblioteca_dio.application.ports.out.LivroRepositoryPort;
import org.zsh.biblioteca_dio.application.service.LivroServiceImpl;
import org.zsh.biblioteca_dio.dto.LivroDTO;

import java.util.List;

@RestController
@RequestMapping("livros/")
@AllArgsConstructor
public class LivroController {

    private final LivroRepositoryPort livroRepositoryPort;
    private final LivroServiceImpl livroServiceImpl;

    @GetMapping("/catalogo")
    public ResponseEntity<List<LivroDTO>> listCatalogo() {
        List<LivroDTO> livros = livroServiceImpl.buscarTodosLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);  // Corrigido: uso correto de ResponseEntity
    }

    @PostMapping("/adicionar")
    public ResponseEntity<LivroDTO> adicionar(@RequestBody LivroDTO livro) {
        livroServiceImpl.registrarLivro(livro);
        return new ResponseEntity<>(livro, HttpStatus.CREATED);
    }
}
