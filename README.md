# Get book by subject
This application has one endpoint ("/subjects/{subjectName") that fetches books from the Open Library Subjects API. 
Replace "subjectName" with the desired book subject.

# Build
./gradlew build

# Run
./gradlew run

# Run in Docker
1. Create jar file by running jar task: ./gradlew jar
2. Test jar file:  java -jar build/libs/books-1.0-SNAPSHOT.jar
3. Create Docker image: docker build -t getting-started .   
4. Run Docker container: docker run -it --rm -p 8080:8080 getting-started:latest
5. Test endpoint using command line tool: curl http://localhost:8080/subjects/scary