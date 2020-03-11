# BalancedBrackets


Environment
---

1. We can run our application on the localhost. Please make sure that the used ports are available

2. We can simulate our application on localhost with docker-compose. Run the command: `docker-compose build`. We should have 1 image:
- balanced_brackets_image

3. We can run our application with the command: `docker-compose up`. We should then have 1 running container:
- balanced_brackets_service: The service responsible for running our API.

How to start the application manually (outside docker-compose)
---

1. Run `mvn clean install -DskipTests` to build your application
2. Start application with `java -jar target/balancedbrackets-0.0.1-SNAPSHOT.jar`
3. To check that your application is running enter url `http://localhost:8080`

Tests
---

There are unit tests in this project. You can run it with `mvn clean test`

Project structure
---
1. `Controllers` are responsible for handling HTTP requests
2. `Services` are responsible for handling the business logic

Endpoints
---

1. You can add verify if a string is considered to have balanced brackets with a `POST method` on the URL `http://localhost:8080/balanced_brackets`: `curl --header "Content-Type: application/json" --request POST http://localhost:8080/balanced_brackets  --data '{"input": "(){}"}'`

Contact
---
grcampos21@gmail.com | (11) 99117-6997