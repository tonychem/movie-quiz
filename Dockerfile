FROM amazoncorretto:19-alpine-jdk
COPY target/*.jar quiz.jar
COPY db/movies.mv.db /db/movies.mv.db
ENTRYPOINT ["java", "-jar", "quiz.jar"]
