FROM maven AS builder
WORKDIR /tirerest/
COPY . .
RUN mvn clean package



FROM openjdk:17.0.1-jdk-buster
COPY --from=builder /tirerest/target/demo-0.0.1-SNAPSHOT.jar /TireRest-1.0.jar
ADD /src/main/resources/files  src/main/resources/files/
ENTRYPOINT ["java", "-Xmx128m", "-XX:+UseZGC", "-XX:ZUncommitDelay=60", "-XX:MaxHeapFreeRatio=30", "-XX:MinHeapFreeRatio=10", "-jar", "TireRest-1.0.jar"]