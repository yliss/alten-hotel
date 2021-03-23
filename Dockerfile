FROM java:8

WORKDIR /

ADD ./target/alten-hotel-service.jar /alten-hotel-service.jar

EXPOSE 8088

CMD java -Dserver.port=8081 -Dspring.datasource.url=$DB1_URL -jar alten-hotel-service.jar