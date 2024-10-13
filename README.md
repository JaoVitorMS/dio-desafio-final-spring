Aqui está uma versão melhorada e estilizada do markdown com os tópicos que você mencionou:

---

# 📚 **Biblioteca DIO - Projeto de Gerenciamento de Livros**

Projeto desenvolvido para gerenciamento de livros com funcionalidades de CRUD (Criar, Ler, Atualizar e Deletar). Este projeto foi implementado usando **Spring Boot** e segue a **Arquitetura Hexagonal**, permitindo integração fácil com diferentes componentes e sistemas externos.

---

## 🚀 **Tecnologias Usadas**

- **Linguagem:** Java
- **Framework:** Spring Boot
- **Arquitetura:** Hexagonal
- **Banco de Dados:** H2 (em memória para desenvolvimento e testes)
- **Frontend:** Integração básica com interface frontend
- **CORS:** Configuração de Cross-Origin Resource Sharing para permitir comunicação segura entre frontend e backend

---

## 📐 **Arquitetura Hexagonal**

A arquitetura hexagonal (também conhecida como Ports and Adapters) facilita a separação de responsabilidades, permitindo que a lógica central da aplicação seja desacoplada das implementações técnicas. Assim, diferentes componentes podem ser substituídos sem afetar a lógica principal.

### Componentes principais:

- **Domínio:** Contém as regras de negócio e entidades centrais.
- **Portas (Interfaces):** Define contratos que outras partes do sistema devem implementar.
- **Adaptadores (Implementações):** Integra o domínio com serviços externos, como repositórios e APIs.

![Arquitetura Hexagonal](https://miro.medium.com/v2/resize:fit:1400/format:webp/1*-JGHYgkKP_37nPO5_eb4dg.png)

---

## 🗄️ **Integração com Banco de Dados H2**

Para simplificar o desenvolvimento e testes, o projeto utiliza o **H2 Database**, um banco de dados leve e em memória. Ele é ideal para desenvolvimento rápido e é facilmente substituível por bancos de dados como MySQL ou PostgreSQL em ambientes de produção.

### Configuração no `application.properties`:

```properties
spring.datasource.url=jdbc:h2:mem:biblioteca
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

Acesse o console do H2 para visualizar e gerenciar dados: [H2 Console](http://localhost:8080/h2-console)

---

## 🌐 **Configuração de CORS**

Para permitir que o frontend acesse a API backend, é importante configurar o **CORS**. Isso pode ser feito na classe de configuração do Spring:

```java
package org.zsh.biblioteca_dio.infra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://127.0.0.1:5500/")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
```

---

## 🖥️ **Integração Básica com Frontend**

A aplicação é projetada para ser facilmente integrada com um frontend baseado em frameworks modernos como **React**, **Vue**, ou **Angular**. A comunicação é feita via **API RESTful**, permitindo operações de CRUD em endpoints como:

### Exemplos de Endpoints:

- `GET /catalogo` - Retorna a lista de todos os livros
- `POST /adicionar` - Adiciona um novo livro
- `PUT /atualizar/{titulo}` - Atualiza as informações de um livro existente
- `DELETE /remover/{titulo}` - Remove um livro pelo titulo

---

## 🎯 **Como Executar o Projeto**

1. Clone o repositório:
   ```bash
   git clone https://github.com/usuario/biblioteca-dio.git
   ```
2. Navegue para o diretório do projeto:
   ```bash
   cd biblioteca-dio
   ```
3. Execute o projeto:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Acesse o sistema via [http://localhost:8080](http://localhost:8080)

---
