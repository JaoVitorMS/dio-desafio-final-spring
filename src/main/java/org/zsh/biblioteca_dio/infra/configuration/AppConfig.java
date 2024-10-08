package org.zsh.biblioteca_dio.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.zsh.biblioteca_dio.adapter.outRepository.repository.LivroAdapterJPA;
import org.zsh.biblioteca_dio.domain.model.Livro;
import org.zsh.biblioteca_dio.dto.LivroConversor;

@Configuration
@EnableJpaRepositories(basePackageClasses = LivroAdapterJPA.class)
public class AppConfig {

   @Bean
    public LivroConversor livroConversor() {
        return new LivroConversor();
    }

    @Bean
    public Livro livro() {
       return new Livro();
    }


}
