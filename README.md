# Lab Padrões de Projeto Spring

## Descrição

Este repositório contém um projeto de API desenvolvida em Java 11 utilizando o framework Spring Boot. A API tem como finalidade realizar operações CRUD (Create, Read, Update, Delete) de clientes, fazendo chamadas a uma API externa [(ViaCep)](https://viacep.com.br/) para obter os endereços dos clientes cadastrados.

## Tecnologias Utilizadas

- Java 11
- Spring Boot 2.5.4
- H2 Database
- JPA (Java Persistence API)
- Spring Doc OpenAPI
- Spring Cloud Starter OpenFeign

## Funcionalidades

- Cadastro de clientes
- Consulta de clientes
- Atualização de clientes
- Exclusão de clientes
- Chamada à API ViaCep para obter endereço dos clientes

## Padrões de Projeto Utilizados

### Facade

O padrão de projeto Facade é utilizado para simplificar a interação com diferentes componentes do sistema. Neste projeto, a classe `ClienteServiceImpl` atua como uma fachada para o gerenciamento de clientes, encapsulando a lógica de negócio e fornecendo uma interface simplificada para o restante da aplicação.

### Strategy

O padrão de projeto Strategy é utilizado para permitir diferentes estratégias de consulta de clientes. A interface `IClienteService` define o contrato para as estratégias de CRUD e a classe `ClienteServiceImpl` implementa essa interface, fornecendo diferentes algoritmos para lidar com as operações necessárias.

### Singleton

O padrão de projeto Singleton é aplicado na classe de serviço `ClienteServiceImpl. Ele é utilizado para garantir que exista apenas uma instância dessa classe responsável pela chamada à API ViaCep. Dessa forma, a classe ClienteServiceImpl implementa o padrão Singleton, garantindo que apenas uma instância seja criada e reutilizada em todo o sistema.

## Pré-requisitos

Certifique-se de ter o seguinte software instalado em sua máquina:

- Java 11: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
- Maven: https://maven.apache.org/install.html

## Como Executar o Projeto

1. Clone este repositório em sua máquina local usando o comando:
   ```
   git clone https://github.com/yuri-italo/lab-padroes-de-projeto-spring.git
   ```
2. Navegue até o diretório raiz do projeto:
   ```
   cd lab-padroes-de-projeto-spring
   ```
3. Compile o projeto usando o Maven:
   ```
   mvn clean install
   ```
4. Inicie a aplicação:
   ```
   mvn spring-boot:run
   ```

## Contribuição

Contribuições são bem-vindas! Se você quiser contribuir com este projeto, siga as etapas abaixo:

1. Fork este repositório
2. Crie uma branch com a sua feature:
   ```
    git checkout -b minha-feature
   ```
3. Faça commit das suas alterações:
   ```
    git commit -m 'Adicionando nova feature'
   ```
4. Faça push para a branch criada:
   ```
    git push origin minha-feature
   ```
5. Abra um pull request
