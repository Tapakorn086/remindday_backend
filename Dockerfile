# ใช้ JDK 17 
FROM openjdk:17-jdk-slim

# กำหนด working directory
WORKDIR /app

# คัดลอกไฟล์ pom.xml, mvnw, .mvn directory และ source code ไปยัง container
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src ./src

# ให้สิทธิ์การทำงานแก่ mvnw
RUN chmod +x mvnw

# สร้างแอปพลิเคชัน
RUN ./mvnw clean package -DskipTests

# คัดลอก JAR ไฟล์ไปยัง working directory
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# รันแอปพลิเคชัน
ENTRYPOINT ["java", "-jar", "app.jar"]