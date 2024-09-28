FROM maven:3.9.9-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/java-project-rain-day-1.0.jar app.jar

RUN echo '#!/bin/bash\n echo "API_KEY=${API_KEY}" > /app/config.properties\n exec java -jar app.jar' > /app/start.sh
RUN chmod +x /app/start.sh

ENTRYPOINT ["/bin/bash", "/app/start.sh"]