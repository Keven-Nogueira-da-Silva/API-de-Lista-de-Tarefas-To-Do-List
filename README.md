# To-Do List API - Projeto Java Spring Boot

## Descrição
API RESTful para gerenciamento de tarefas simples, desenvolvida com Java e Spring Boot.  
Permite criar, listar, filtrar, atualizar e deletar tarefas, utilizando banco de dados H2 em memória.  

---

## Tecnologias Utilizadas
- Java 17+
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (in-memory)
- Bean Validation (Jakarta Validation)
- Lombok
- Maven

---

## Funcionalidades
- Criar nova tarefa (título obrigatório, descrição opcional)
- Listar todas as tarefas
- Filtrar tarefas por status (pendente ou concluída)
- Buscar tarefa por ID
- Marcar tarefa como concluída
- Deletar tarefa pelo ID

---

## Estrutura do Projeto
src/
└── main/
├── java/com/todo/todoapi/
│ ├── controller/ # Endpoints REST
│ ├── service/ # Regras de negócio
│ ├── repository/ # Acesso ao banco
│ ├── model/ # Entidade JPA
│ └── TodoApiApplication.java # Classe principal Spring Boot
└── resources/
├── application.properties # Configurações do projeto


---

## Configuração do Banco de Dados
- Banco H2 em memória configurado no `application.properties`
- Console web disponível em: `http://localhost:8080/h2-console`
- Configuração JPA com `spring.jpa.hibernate.ddl-auto=update` para atualização automática do schema

---

## Executando o Projeto
1. Clone o repositório:  
   `git clone <URL-do-repositório>`

2. Entre na pasta do projeto:  
   `cd todo-api`

3. Compile e rode com Maven:  
   `mvn spring-boot:run`

4. A API estará disponível em:  
   `http://localhost:8080/tarefas`

---

## Endpoints da API

| Método | Endpoint               | Descrição                            | Corpo da Requisição (JSON)             |
|--------|------------------------|------------------------------------|---------------------------------------|
| POST   | `/tarefas`             | Criar nova tarefa                   | `{ "titulo": "Estudar Java", "descricao": "Aula Spring" }` |
| GET    | `/tarefas`             | Listar todas as tarefas             | -                                     |
| GET    | `/tarefas/status/{concluida}` | Listar tarefas por status (true/false) | -                                     |
| GET    | `/tarefas/{id}`        | Buscar tarefa por ID                | -                                     |
| PUT    | `/tarefas/{id}/concluir` | Marcar tarefa como concluída       | -                                     |
| DELETE | `/tarefas/{id}`        | Deletar tarefa por ID               | -                                     |

---

## Validações
- O campo `titulo` é obrigatório para criação da tarefa.  
- Respostas HTTP adequadas são retornadas para erros (ex: 404 se tarefa não existe).

---

## Requisitos para Desenvolvimento
- Java 17 ou superior instalado  
- Maven instalado  
- IDE configurada com plugin Lombok e annotation processing habilitado

---

## Melhorias Futuras
- Implementar paginação e ordenação  
- Adicionar autenticação JWT  
- Criar frontend para consumir a API  
- Validar campos com mais regras (ex: tamanho máximo)

---

## Autor
Keven Nogueira da Silva  
 | [Portfólio](https://keven-nogueira-da-silva.github.io/Portifolio/)

---

## Licença
Projeto aberto para estudos e aprimoramento pessoal.

