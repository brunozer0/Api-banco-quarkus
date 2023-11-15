# Api Banco 🏦

Essa é uma api construída em Java utilizando o framework Quarkus, onde você pode realizar as seguintes transações bancárias:
- Criar conta
- Depositar
- Sacar
- Transferir
- Listar todas as contas 

# Executar o projeto

- Instale o maven, e o quarkus.
- Para executar o projeto, basta você rodar o comando **quarkus dev** via terminal.




# Como usar?

A partir da rota raiz: [localhost:8080](http://localhost:8080/), você pode:

| Método | Endpoint | Parâmetros                             | Ação
| ------ | ------ |----------------------------------------|------ |
| POST | /contacorrente/criarconta | "nome" e "cpf"                         |  Cria a conta
| POST | /contacorrente/depositar | "numeroConta" e "valor"                | Deposita valor
| PATCH |/contacorrente/sacar | numeroConta e valor                    | Realiza saque
| PATCH | /contacorrente/transferir | "contaOrigem", "contaDestino", "valor" | Transfere um valor para outra conta
| GET | /contacorrente/listarcontas| -                                      |Lista todas as contas.


# Client para os testes

- insomnia
- postman

Você pode executar os testes utilizando qualquer client para testes de api. 

