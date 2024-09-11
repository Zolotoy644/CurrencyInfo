FROM openjdk:17
ADD ./target/currencyinfo-0.0.1-SNAPSHOT.jar /usr/src/currencyinfo-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java", "-jar", "currencyinfo-0.0.1-SNAPSHOT.jar"]