# API Gerenciamento de Pacientes

![Capa do Projeto](https://picsum.photos/850/280)

# Sobre o Projeto

Este projeto implementa uma API de gerenciamento de pacientes utilizando Java e Spring Boot. O propósito deste projeto é fornecer um sistema robusto para o gerenciamento de dados de pacientes, incluindo operações de CRUD e métodos para cálculo de peso ideal, IMC e outras informações do paciente.

# Índice/Sumário

- [Sobre](#sobre-o-projeto)
- [Sumário](#índice/sumário)
- [Requisitos Funcionais](#requisitos-funcionais)
- [Arquitetura](#arquitetura)
- [Instruções de Uso](#instruções-de-uso)
- [Tecnologias Usadas](#tecnologias-usadas)
- [Testes](#testes)
- [Contribuição](#contribuição)
- [Autores](#autores)
- [Licença](#licença)
- [Agradecimentos](#agradecimentos)

# Requisitos Funcionais

- [x] Cadastrar pacientes
- [x] Retornar todos os pacientes
- [x] Retornar paciente por ID
- [x] Editar um paciente
- [x] Deletar um paciente
- [x] Calcular IMC e outras medidas do paciente

# Arquitetura

A arquitetura do sistema é baseada em uma API Rest utilizando Spring Boot. A API é dividida nos seguintes componentes:

- Controller: Camada responsável por expor os endpoints e lidar com as requisições HTTP.
- Service: Camada onde reside a lógica de negócio.
- Repository: Camada de acesso aos dados, interage com o banco de dados.
- Domain: Representação das entidades do sistema.

# Instruções de Uso

1. Clone o repositório:

   `git clone https://github.com/GabrielLimaDeSouza/tp-gerencia-configuracao.git`

2. Navegue para a pasta:

   `cd api-pacientes` 

3. Rode a aplicação:

   `mvn spring-boot:run`

4. A aplicação estará disponível em:

   `http://localhost:3000`

5. Teste a criação de paciente na rota:

   `http://localhost:3000/api/v1/paciente`

# Tecnologias Usadas

- [Java](https://www.java.com/pt-BR/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [JUnit](https://junit.org/junit5/)
- [Cucumber](https://cucumber.io/)
- [Docker](https://www.docker.com/)
- [Docker Hub](https://hub.docker.com/)

# Testes

- Testes Unitários: Os testes unitários cobrem a lógica de negócios e validações dos modelos. Foram implementados com JUnit.

- Testes de Integração: Os testes de integração verificam a interação entre diferentes componentes do sistema. Foram implementados com JUnit.

- Testes de Aceitação: Os testes de aceitação validam os requisitos funcionais da API, implementados utilizando Cucumber para a definição dos cenários de teste.

# Contribuição

Leia o arquivo [CONTRIBUTING.md](CONTRIBUTING.md) para saber detalhes sobre o nosso código de conduta e o processo de envio de solicitações _pull_ (_Pull Request_) para nós.

# Autores

[Gabriel Lima de Souza](https://github.com/GabrielLimaDeSouza)

# Licença

Este projeto está licenciado sob a Licença MIT, consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

# Agradecimentos

Obrigado por visitar o meu repositório!
