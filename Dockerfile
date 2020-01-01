FROM adoptopenjdk/openjdk8:latest
RUN mkdir /opt/app
COPY targt/birthday-service*.jar /opt/app
EXPOSE 8080
CMD ["java", "-jar", "-Dspring.profiles.active=prod", "/opt/app/birthday-service*.jar"]
