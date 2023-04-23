FROM openjdk:17
COPY ./target/budgetapp-0.0.1-SNAPSHOT.jar budgetapp.jar
ENTRYPOINT ["java","-jar","/budgetapp.jar"]