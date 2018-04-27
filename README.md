# planets-starwars
API para CRUD planetas

Necessita: <br>
 1 - Iniciar MongoDB na porta 27017 (Padrão);<br>
 2 - Internet para poder recuperar informações da API SWAPI.<br>
 
 Baixe o projeto <br>
 Via terminal acesse a pasta raiz do projeto "/desafio" <br>
 Execulte: "./mvnw spring-boot:run"<br>
 
 <br>
 OU
 <br>
 
 Baixe as e dependencias e gere o .jar executando: "./mvnw clean package" <br>
 Para iniciar a API: "java -jar target/starwars-0.1.0.jar"
 
=================================================================================

URL's: <br><br>

- Adicionar um planeta (body -> nome, clima e terreno): http://localhost:8080/starwars/planet/create <br>
- Listar planetas: http://localhost:8080/starwars/planet/findAll <br>
- Buscar por ID: http://localhost:8080/starwars/planet/find?id=5ae245acaa26a041b76c2b64 <br>
- Buscar por nome: http://localhost:8080/starwars/planet/findByName?name=Marte <br>
- Remover planeta: http://localhost:8080/starwars/planet/delete?id=5ae243fdaa26a041b1387068 <br>

Segue no repository o script "starwars.postman_collection.json" gerado para teste via Postman.
