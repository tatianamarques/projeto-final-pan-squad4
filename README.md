<h1 align="center">
 <img src="https://ik.imagekit.io/1nwyvlydc85r/LOGObluebank_PaFzdTA64.png?updatedAt=1639239398594">
  </h1>


##  💻 Sobre o projeto
API  Rest  do banco  BlueBank  que gerencia transações  bancárias e cadastrar clientes.

versão: 1.0

#### Tecnologia implementadas

- Scrum 
- Spring Boot
- Git
- EC2 AWS
- Beanstalk AWS
- Lambda AWS
- Swagger para documentação
- RDS para o banco de dados Mysql


##### Equipe S4 – turma 2 – Gama Academi.

Arion Mathias
      -     Éric Monné Fraga de Oliveira
      -     Ronald Corradi Costa
      -    Tatiana Gomes Bezerra Marques
      -     William Francisco de Assis



###  Contendo os seguintes  endpoints


  #### Cliente-Controller
  
- Cadastro do cliente (utilizando validação);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente


- Buscar por Id (utilizando DTO para proteção dos dados referente a sua exibição);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com
/api/cliente/id


- Buscar todos os clientes (utilizando DTO para sua exibição e paginação melhorando o 
desempenho da consulta);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente

- Atualizar cliente (utilizando validação e DTO);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/id

- Deletar cliente (utilizando cascade);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/id

- Fazer a busca por CPF;
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/cpf


- Fazer a busca de cliente inativos;
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/inativos


- Salvar telefone;
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/telefone


- Deletar telefone;
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/telefone/id




  #### Agência-Controller

- Cadastrar uma agência (utilizando validação);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/agencia


- Buscar por Id (utilizando DTO);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/agencia/id


- Buscar todas as agências (utilizando DTO e paginação);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/agencia/numero/numeroAgencia


- Buscar agencia por número (utilizando DTO);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/agencia/lista


- Atualizar agência (utilizando DTO e validação);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/agencia/id




  #### Conta-Controller

- Cadastro de conta (utilizando validação);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/conta


- Buscar por Id (utilizando DTO);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/conta/id


- Busca histórico de conta por id (Utilizando DTO e paginação);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/conta/transacao/id

- Buscar todas as contas (utilizando DTO e paginação);
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/contas


  #### transação-Controller


- Depositar
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/transacao/depositar

- Sacar
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/transacao/sacar

- Transferência
http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/transacao/transferencia





