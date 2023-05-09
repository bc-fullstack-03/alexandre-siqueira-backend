# Define a imagem base
FROM openjdk:17-alpine

# Define a pasta de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR do projeto para dentro do container
COPY target/alexandre-siqueira-backend-0.0.1-SNAPSHOT.jar .

# Define o comando de inicialização da aplicação
CMD ["java", "-jar", "alexandre-siqueira-backend-0.0.1-SNAPSHOT.jar"]