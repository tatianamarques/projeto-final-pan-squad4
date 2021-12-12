<h1 align="center">
 <img src="https://ik.imagekit.io/1nwyvlydc85r/LOGObluebank_PaFzdTA64.png?updatedAt=1639239398594">
  </h1>


##  💻 Sobre o projeto
API  Rest, do banco fictício BlueBank,  que gerencia transações  bancárias e faz o CRUD de clientes.
<br>
Desafio final do curso da Gama Academy em parceria com Banco Pan.

versão: 1.0

#### Tecnologias utilizadas no trabalho.
- Scrum 
- Spring Boot
- Git
- EC2 AWS
- Beanstalk AWS
- Lambda AWS
- Swagger para documentação
- RDS para o banco de dados Mysql

### Diagrama de Entidade Relacionamento(DER):
 
<img src="https://ik.imagekit.io/1nwyvlydc85r/Diagrama_de_entidade_oX9goFyH_.png?updatedAt=1639317375093">

  

### Desenvolvedores - Equipe S4 – Turma 2 – Gama / PAN Academy.

      -     Arion Mathias
      -     Éric Monné Fraga de Oliveira
      -     Ronald Corradi Costa
      -     Tatiana Gomes Bezerra Marques
      -     William Francisco de Assis

    

###  Contendo os seguintes  endpoints


  #### Cliente-Controller
  
  <table border="1">
 <tr>
 <td> Método</td>
 <td>Caminho</td>
 <td>Descrição</td>
 </tr>
 
 <tr> 
  <td> POST</td> 
  <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente</td>
   <td>Cadadstro do cliente</td>
   </tr>
 
  <tr>
 <td>GET</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/id</td>
 <td>Buscar por Id</td>
 </tr>
 
 <tr>
 <td> GET</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente</td>
 <td>Listar todos os clientes</td>
 </tr>
 
 <tr>
 <td>PUT</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/id</td>
 <td>Atualizar cliente</td>
 </tr>
 
 <tr>
 <td> DELETE</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/id</td>
 <td>Deletar cliente</td>
 </tr>
 
 <tr>
 <td>GET</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/cpf</td>
 <td>Buscar por CPF</td>
 </tr>
 
 <tr>
 <td>GET</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/inativos</td>
 <td>Buscar de clientes inativos</td>
 </tr>
 
 
 <tr>
 <td>POST</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/telefone</td>
 <td>Salvar telefone</td>
 </tr>
 
 
  <tr>
 <td>DELETE</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/telefone/id</td>
 <td>Deletar telefone</td>
 </tr>
 
  </table>
 

  #### Agência-Controller
  
  
<table border="1">
 <tr>
 <td> Método</td>
 <td>Caminho</td>
 <td>Descrição</td>
 </tr>
 
 <tr> 
  <td> POST</td> 
  <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/agencia</td>
   <td>Cadadstro da agencia</td>
   </tr>
 
  <tr>
 <td>GET</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/agencia/id</td>
 <td>Buscar por Id</td>
 </tr>
 
 <tr>
 <td> GET</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/agencia/lista</td>
 <td>Listar todas as agencias</td>
 </tr>
 
 <tr>
 <td>GET</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/agencia/numero/numeroAgencia</td>
 <td>Buscar agencia por número</td>
 </tr>
 
 <tr>
 <td> PUT</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/id</td>
 <td>Atualizar agência</td>
 </tr>
 
  </table>
  

 #### Conta-Controller
 
 <table border="1">
 <tr>
 <td> Método</td>
 <td>Caminho</td>
 <td>Descrição</td>
 </tr>
 
 <tr> 
  <td> POST</td> 
  <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/conta</td>
   <td>Cadadstro de conta</td>
   </tr>
 
  <tr>
 <td>GET</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/conta/id</td>
 <td>Buscar conta por Id</td>
 </tr>
 
 <tr>
 <td> GET</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/contas</td>
 <td>Listar todas as contas</td>
 </tr>
 
 <tr>
 <td>GET</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/conta/transacao/id</td>
 <td>Buscar historico de conta por id</td>
 </tr>
 
 <tr>
 <td> PUT</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/cliente/id</td>
 <td>Buscar histórico de conta por id</td>
 </tr>
 
  </table>



  #### Transação-Controller
  
  
   <table border="1">
 <tr>
 <td> Método</td>
 <td>Caminho</td>
 <td>Descrição</td>
 </tr>
 
 <tr> 
  <td> POST</td> 
  <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/transacao/depositar</td>
   <td>Depositar</td>
   </tr>
 
  <tr>
 <td>POST</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/transacao/sacar</td>
 <td>Sacar</td>
 </tr>
 
 <tr>
 <td> POST</td>
 <td>http://t2s4bluebankbeanstalk-env.eba-wzym39tx.us-east-2.elasticbeanstalk.com/api/transacao/transferencia</td>
 <td>Transferência/td>
 </tr>
 
  </table>







