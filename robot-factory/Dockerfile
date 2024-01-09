FROM eclipse-temurin:17-jdk-alpine AS builder

ARG JAR_FILE=robot-factory/target/*.jar

COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM eclipse-temurin:17-jdk-alpine

RUN addgroup -S demo && adduser -S demo -G demo
USER demo

VOLUME /tmp

COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./

ENTRYPOINT ["java", "org.springframework.boot.loader.launch.JarLauncher"]

# запуск
# docker run -p 8080:8080 robot-shop:0.0.1

# IF BUILD JAR IN DOCKER

#FROM apachedirectory/maven-build:jdk-17 AS build
#ARG PROJECT=robot-factory
#ARG WORKSPACE=/workspace/app
#
#WORKDIR ${WORKSPACE}
#
#COPY ./ ${WORKSPACE}/

#RUN mvn clean install -pl ${PROJECT}