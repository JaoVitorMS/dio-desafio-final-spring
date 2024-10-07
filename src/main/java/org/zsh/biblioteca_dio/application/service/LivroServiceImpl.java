package org.zsh.biblioteca_dio.application.service;

import org.springframework.stereotype.Service;
import org.zsh.biblioteca_dio.adapter.out.entity.LivroEntity;
import org.zsh.biblioteca_dio.application.ports.in.LivroServicePort;
import org.zsh.biblioteca_dio.application.ports.out.LivroRepositoryPort;
import org.zsh.biblioteca_dio.dto.LivroConversor;
import org.zsh.biblioteca_dio.dto.LivroDTO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LivroServiceImpl implements LivroServicePort {

    private LivroRepositoryPort livroRepositoryPort;
    private LivroConversor livroConversor;
    
    
    
    @Override
    public void registrarLivro(LivroDTO livroDTO) {
        LivroEntity livroEntity = new LivroEntity();
        livroEntity = livroConversor.converterParaEntity(livroDTO);

    }
    @Override
    public void atualizarLivro(LivroDTO livroDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarLivro'");
    }
    @Override
    public void deletarLivroPorTitulo(String titulo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarLivroPorTitulo'");
    }
    @Override
    public void deletarLivroPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarLivroPorId'");
    }
    @Override
    public LivroDTO buscarLivroPorId(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarLivroPorId'");
    }
    @Override
    public LivroDTO buscarLivroPorAutor(String autor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarLivroPorAutor'");
    }
    @Override
    public LivroDTO buscarLivroPorTitulo(String titulo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarLivroPorTitulo'");
    }
    
  
   
    
}
