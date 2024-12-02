# Projeto CRUD com Spring Boot, Thymeleaf e MySQL

Este é um projeto de aplicação web para gerenciamento de **Clientes**, **Produtos** e **Pedidos**, implementando as operações de CRUD (**Criar**, **Ler**, **Atualizar** e **Excluir**) para cada uma dessas entidades. O objetivo é fornecer uma introdução prática ao uso do Spring Boot, Thymeleaf e MySQL.

---

## 📋 Funcionalidades

- Gerenciar **Clientes**: Adicionar, listar, editar e excluir.
- Gerenciar **Produtos**: Adicionar, listar, editar e excluir.
- Gerenciar **Pedidos**: Associar clientes e produtos, adicionar, listar, editar e excluir.

---

## 🛠 Tecnologias Utilizadas

- **Spring Boot**: Framework Java para criar aplicações web.
- **Thymeleaf**: Motor de templates para renderizar páginas HTML dinâmicas.
- **MySQL**: Banco de dados relacional para armazenamento de informações.
- **Maven**: Gerenciador de dependências.
- **Java**: Linguagem principal do projeto.

---

## 🖥 Pré-requisitos

Antes de começar, você precisará:

1. **Java 11 ou superior**: Verifique a versão instalada com:
   ```bash
   java -version


🚀 Como Rodar o Projeto
1. Clone o Repositório
Faça o clone do projeto para sua máquina local:

bash
Copiar código
git clone https://github.com/seu-usuario/crud-thymeleaf.git
cd crud-thymeleaf
2. Configure o Banco de Dados
Abra o terminal do MySQL ou uma ferramenta como MySQL Workbench.

Crie o banco de dados chamado crud_thymeleaf:

sql
Copiar código
CREATE DATABASE crud_thymeleaf;
Edite o arquivo src/main/resources/application.properties com suas credenciais de banco de dados:

properties
Copiar código
spring.datasource.url=jdbc:mysql://localhost:3306/crud_thymeleaf
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
3. Compile as Dependências
Execute o comando para instalar as dependências do projeto usando o Maven:

bash
Copiar código
mvn install
4. Execute a Aplicação
Inicie a aplicação com o comando:

bash
Copiar código
mvn spring-boot:run
Se tudo estiver configurado corretamente, você verá mensagens no console indicando que a aplicação foi iniciada. Por padrão, ela estará disponível em:

arduino
Copiar código
http://localhost:8080
🌐 Como Usar a Aplicação
Acesse a URL inicial no navegador: http://localhost:8080.
Use as seguintes URLs para acessar as páginas de cada funcionalidade:
Clientes: http://localhost:8080/cliente
Produtos: http://localhost:8080/produto
Pedidos: http://localhost:8080/pedido
Siga os links das páginas para cadastrar, editar ou excluir registros.
🗂 Estrutura do Projeto
O projeto possui a seguinte estrutura:

bash
Copiar código
src
├── main
│   ├── java
│   │   └── com.example.crud_thymeleaf
│   │       ├── controller        # Controladores que gerenciam as requisições
│   │       ├── model             # Entidades que representam as tabelas do banco
│   │       └── repository        # Interfaces para interação com o banco
│   ├── resources
│   │   ├── templates             # Arquivos HTML Thymeleaf
│   │   └── application.properties # Configuração da aplicação
