# Agregador

Simulando um cenário de vários sistemas e bases de dados legadas, esse projeto tem como intuito agregar as informações de cada base em uma estrutura nova que possibilite a construção de novos sistemas em tecnologias mais modernas.

Cada nova transação de dados também é exposta em tempo real através de mensageria para que novos sistemas possam ser notificados instantaneamente.

O projeto está escrito em `Java 8` utilizando o framework [Quarkus](https://quarkus.io/). A base de dados que simula o novo repositório é uma instancia `MongoDB` e o `Kafka` é utilizado como provedor de mensageria.

Para construção do ambiente antes da execução do projeto:

```bash
docker-compose up
```

Isso irá criar 4 instancias Docker:

- `MySQL` (Simulando uma base de dados legada)
- `MongoDB` (A nova base de dados)
- `Zookeper` (Banco de dados para o Kafka)
- `Kafka` (Servidor de mensageria)

Execute o projeto com:

```bash
./mvnw compile quarkus:dev
```

Uma tabela com as últimas transações processadas pode ser visualizada no endereço [http://localhost:8080](http://localhost:8080).

## API

Através do endereço [http://localhost:8080/api/trasacoes](http://localhost:8080/api/trasacoes) é possível obter uma lista com 1000 transações ordenadas por Data em forma decrescente.
