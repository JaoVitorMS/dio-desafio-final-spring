package org.zsh.biblioteca_dio.dto;

import org.springframework.stereotype.Component;

@Component
public record LivroDTO(Integer id, String titulo, String autor) {
} 
    
