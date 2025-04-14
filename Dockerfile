# Use an official JDK image
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy everything
COPY . .

# Build the project
RUN chmod +x mvnw
RUN ./mvnw clean install -DskipTests

# Run the jar
CMD ["java", "-jar", "target/todo-0.0.1-SNAPSHOT.jar"]
