FROM openjdk:23-oracle
WORKDIR /app
RUN microdnf install findutils
COPY gradlew settings.gradle build.gradle .
COPY ./gradle ./gradle
COPY ./src ./src
CMD ["./gradlew", "bootRun"]
