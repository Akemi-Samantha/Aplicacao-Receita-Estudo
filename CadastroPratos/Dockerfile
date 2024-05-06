# Etapa de build
# Usar a imagem oficial do Maven para compilar o código fonte
FROM maven:3.8.4-openjdk-11 as builder

# Copiar o código fonte para o contêiner de build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

# Definir o diretório de trabalho para o diretório onde o código fonte foi copiado
WORKDIR /usr/src/app

# Executar o Maven build
RUN mvn clean package

# Etapa de execução
# Usar a imagem base do Java (JDK) para a execução
FROM openjdk:11

# Copiar o artefato do build da etapa anterior para o contêiner de execução
COPY --from=builder /usr/src/app/target/*.jar /app.jar

# Comando para executar a aplicação
ENTRYPOINT ["java","-jar","/app.jar"]


## Usar a imagem base do Java (JDK)
#FROM openjdk:11
#
## Argumento para passar a versão do artefato
#ARG JAR_FILE=target/*.jar
#
## Copiar o artefato do build para o contêiner
#COPY ${JAR_FILE} app.jar
#
## Comando para executar a aplicação
#ENTRYPOINT ["java","-jar","/app.jar"]
