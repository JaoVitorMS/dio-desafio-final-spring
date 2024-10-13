package org.zsh.biblioteca_dio.adapter.inRest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zsh.biblioteca_dio.adapter.outRepository.entity.LivroEntity;
import org.zsh.biblioteca_dio.application.service.LivroServiceImpl;
import org.zsh.biblioteca_dio.dto.LivroDTO;

import java.util.List;

@RestController
@RequestMapping("livros/")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5500")
public class LivroController {

    private final LivroServiceImpl livroServiceImpl;

    @GetMapping("/catalogo")
    public ResponseEntity<List<LivroDTO>> listCatalogo() {
        List<LivroDTO> livros = livroServiceImpl.buscarTodosLivros();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    @GetMapping("/buscar/{titulo}")
    public LivroEntity buscarTitulo(@PathVariable String titulo) {
        return livroServiceImpl.buscarLivroPorTitulo(titulo);
    }

    @GetMapping("/buscarAutor/{autor}")
    public LivroEntity buscarAutor(@PathVariable String autor) {
        return livroServiceImpl.buscarLivroPorAutor(autor);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<LivroDTO> adicionarLivro(@RequestBody LivroDTO livro) {
        livroServiceImpl.registrarLivro(livro);
        return new ResponseEntity<>(livro, HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{titulo}")
    public ResponseEntity<LivroDTO> putLivro(@PathVariable String titulo, @RequestBody LivroDTO livro) {
        livroServiceImpl.atualizarLivro(livro);
        return new ResponseEntity<>(livro, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/remover/{titulo}")
    public ResponseEntity<HttpStatus> removerLivro(@PathVariable String titulo) {
        livroServiceImpl.deletarLivroPorTitulo(titulo);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}