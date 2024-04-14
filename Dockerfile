FROM openjdk:11-jdk as build

WORKDIR /app

RUN apt-get update && apt-get install -y curl

RUN curl -L "https://github.com/sbt/sbt/releases/download/v1.9.9/sbt-1.9.9.tgz" | tar xz -C /opt
ENV PATH="/opt/sbt/bin:${PATH}"

RUN curl -fLo coursier https://git.io/coursier-cli && chmod +x coursier && \
    ./coursier install scala3-compiler scala3-repl && \
    rm coursier

COPY . /app

RUN sbt clean assembly

FROM openjdk:11-jre-slim

WORKDIR /app

COPY --from=build /app/target/scala-3.4.0/*.jar ipTest.jar
CMD ["java", "-jar", "ipTest.jar"]
