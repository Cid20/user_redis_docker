# Java 17 uchun asosiy image
FROM eclipse-temurin:17-jdk-alpine

# Ishchi katalogni o'rnatish
WORKDIR /app

# Maven wrapper va pom.xml faylini konteynerga nusxalash
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Qaramliklarni yuklab olish
RUN ./mvnw dependency:resolve

# Manba kodini nusxalash va paketlash
COPY src ./src
RUN ./mvnw package -DskipTests

# Portni ochish
EXPOSE 8080

# Spring Boot ilovasini ishga tushirish
ENTRYPOINT ["java", "-jar", "target/user_redis-0.0.1-SNAPSHOT.jar"]
