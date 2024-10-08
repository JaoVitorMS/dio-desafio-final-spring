package org.zsh.biblioteca_dio.application.service;

import org.springframework.stereotype.Service;
import org.zsh.biblioteca_dio.adapter.outRepository.entity.LivroEntity;
import org.zsh.biblioteca_dio.application.ports.in.LivroServicePort;
import org.zsh.biblioteca_dio.application.ports.out.LivroRepositoryPort;
import org.zsh.biblioteca_dio.dto.LivroConversor;
import org.zsh.biblioteca_dio.dto.LivroDTO;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LivroServiceImpl implements LivroServicePort {

    private LivroRepositoryPort livroRepositoryPort;
    private LivroConversor livroConversor;
    
    
    
    @Override
    public void registrarLivro(LivroDTO livroDTO) {
        LivroEntity livroEntity = livroConversor.toEntity(livroDTO);
        livroRepositoryPort.save(livroEntity);
    }
    @Override
    public void atualizarLivro(LivroDTO livroDTO) {
        LivroEntity livroEntity = livroConversor.toEntity(livroDTO);
        List<LivroEntity> livros = livroRepositoryPort.buscarLivroPorTituloAutor(livroEntity.getTitulo(),livroEntity.getAutor());

        Optional<LivroEntity> livroAchado = livros.stream()
                .filter(livro -> livro.getAutor().equals(livroEntity.getAutor()))
                .findFirst();
        livroAchado.ifPresent(livro -> {
            livro.setAutor(livroEntity.getAutor());
            livro.setTitulo(livroEntity.getTitulo());

        // 4. Salvar o livro atualizado
        livroRepositoryPort.atualizarLivro(livro);
    });

        if (livroAchado.isEmpty()) {
//            throw new ResourceNotFoundException("Livro não encontrado para atualização.");
            livroRepositoryPort.save(livroEntity);
        }
    }
    @Override
    public void deletarLivroPorTitulo(String titulo) {
        livroRepositoryPort.deletarLivroPorTitulo(titulo);
    }

    @Override
    public List<LivroDTO> buscarTodosLivros () {
        List<LivroEntity> livroEntities = livroRepositoryPort.buscarTodos();
        return livroEntities.stream()
                .map(livros -> livroConversor.entityToDTO(livros) )
                .collect(Collectors.toList());
    }

    @Override
    public LivroDTO buscarLivroPorAutor(String autor) {
        LivroEntity livroEntity = livroRepositoryPort.buscarLivroPorAutor(autor);
        LivroDTO getLivro = livroConversor.entityToDTO(livroEntity);
        return getLivro;
    }
    @Override
    public LivroDTO buscarLivroPorTitulo(String titulo) {
        LivroEntity livroEntity = livroRepositoryPort.buscarLivroPorAutor(titulo);
        LivroDTO getLivro = livroConversor.entityToDTO(livroEntity);
        return getLivro;
    }
    
  
   
    
}
