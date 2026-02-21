# Lightweight Amazon Corretto 21 image
FROM amazoncorretto:21-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR
ARG JAR_FILE=target/TallerMecanicoServerv2-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# Expose application port
EXPOSE 8080

# Container-friendly JVM settings
ENTRYPOINT ["java", \
  "-XX:+UseContainerSupport", \
  "-XX:MaxRAMPercentage=75.0", \
  "-XX:+UseG1GC", \
  "-jar", "app.jar"]