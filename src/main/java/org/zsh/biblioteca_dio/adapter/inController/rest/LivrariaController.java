package org.zsh.biblioteca_dio.adapter.inController.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zsh.biblioteca_dio.application.port.outRepository.LivroRepositoryImp;

@RestController
@RequestMapping("/livraria")
public class LivrariaController {
    
    @Autowired
    private final LivroService livroService;
    @Autowired
    private final LivroRepositoryImp;

    
}
