# **Projeto TODOAPP**

Este projeto tem por objetivo criar uma simples API Java para o treinamento de Docker, ministrado pelo Fernando Nissizaki.

----

## **Como subir a aplicação...**


**1. Dentro da pasta do projeto, execute o comando para buildar a API:**

```shell
$ .\mvnw clean package -DskipTests
```

**2. Após o comando acima, será gerado na pasta ```target``` o arquivo ```todoapp.prod.release.jar```**

**3. Agora, altere o arquivo ```.env``` com os valores necessário**

**4. Já com o arquivo ```.env``` devidamente alterado, agora é executar o arquivo ```docker-compose.yml``` com o comando abaixo:**

```shell
$ docker-compose up
```

**5. Para derrubar todos os serivços e excluir os container criados, basta digitar o comando abaixo:**

```shell
$ docker-compose down
```

----

## **Melhorias para o futuro**

- Alterar o arquivo ```docker-compose.yml``` no serviço ```api``` na parte de ```environment```, passando as variáveis de ambiente com o mesmo nome de cada variável no arquivo ```application.properties```, como no exemplo abaixo:
```yaml
environment:
      - spring.datasource.url=jdbc:mysql://db/todoapp
      - spring.datasource.username=${DB_USER}
      - spring.datasource.password=${DB_PASSWORD}
```

- Pode acontecer de haver um problema de conexão com o MYSQL quando a aplicação Spring subir. Isso é porque o container MYSQL já iniciou, porém ainda não está pronto para uso. Caso aconteça na primeira vez, deve ser por conta da criação do volume e outros processos interno. Caso esse problema ainda persista, uma solução para aguardar o MYSQL subir completamente seria o ```wait-for.sh```. Mais detalhes https://github.com/eficode/wait-for.