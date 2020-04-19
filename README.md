# Micro-serviço de cadastro de UF

#### Execução
- `curl http://localhost:8080/api/v1/fs/all` GET
- `curl http://localhost:8080/api/v1/fs/id/{id}` GET
- `curl http://localhost:8080/api/v1/fs/create` POST
- `curl http://localhost:8080/api/v1/fs/delete/{id}` DELETE
- `curl http://localhost:8080/api/v1/fs/update` PUT


#### Entidade
- id : Long
- name : String
- initials : String 
- created : LocalDateTime


**Melhorias**
- Implementação de mensagens de retorno para o frontend, com mensagens padronizadas para erro e sucesso
- Ajustes de seguraça
- Ajustes na obrigatoriade dos campos a serem recebidos do frontend


**Acesso ao teste**
[Heroku](https://celk-app.herokuapp.com/)

**Código fonte do front-end**
[Front-end](https://github.com/kleberdamasco/celkApp)


##### Contatos :bowtie:

 [LinkedIn](https://www.linkedin.com/in/kleber-damasco-80b55728/) 😃
 
 [E-mail](mailto:kleberdamasco@hotmail.com) :envelope:
