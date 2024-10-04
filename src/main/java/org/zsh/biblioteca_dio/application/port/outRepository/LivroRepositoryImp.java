package org.zsh.biblioteca_dio.application.port.outRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zsh.biblioteca_dio.adapter.outRepository.repository.LivroRepositoryEntity;
import org.zsh.biblioteca_dio.adapter.outRepository.repository.LivroRepositoryJPA;
import org.zsh.biblioteca_dio.application.port.dto.LivroDTO;
import org.zsh.biblioteca_dio.domain.model.Livro;

@Repository
public class LivroRepositoryImp implements LivroRepository{

    @Autowired
    private LivroRepositoryJPA livroRepositoryJPA;

    @Autowired
    private LivroMapper livroMapper;

    @Override
    public List<Livro> buscarTodos() {
        return livroRepositoryJPA.findAll()
                .stream()
                .map(livroMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Livro> findById(Long id) {
        return livroRepositoryJPA.findById(id)
             .map(livroMapper::toModel);
    }

    @Override
    public void salvar ( LivroDTO livroDTO ) {
        LivroRepositoryEntity livroEntity = livroMapper.toEntity(livroDTO);
        livroRepositoryJPA.save(livroEntity);
    }


    @Override
    public void remover(Long id) {
        livroRepositoryJPA.deleteById(id);

    }

    @Override
    public void atualizar ( LivroDTO livroDTO ) {
        LivroRepositoryEntity livroEntity = livroMapper.toEntity(livroDTO);
        livroRepositoryJPA.save(livroEntity);
    }


}
