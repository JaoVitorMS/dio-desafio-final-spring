/* package org.zsh.biblioteca_dio.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.zsh.biblioteca_dio.adapter.outRepository.repository.LivroRepositoryJPA;
import org.zsh.biblioteca_dio.application.port.outRepository.LivroRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = LivroRepositoryJPA.class)
public class AppConfig {

   @Bean
   public LivroService livroService(LivroRepository livroRepository){
       return new LivroService(livroRepository);
   }

} */
