# HOTEL - BOOKING API

Rest Service for Create, modify, consul and  delete
booking information.

REQUIREMENTS
- Java 8
- Maven
- Docker
- Docker compose

NOTE:
If you want to use docker remember to install docker in the machine that
will test the service and check it with the following command:
```bash
docker --version
```
You must receive a response similar to the following:

```bash
Docker version 20.10.2, build 2291f61
```
Please check if maven is install in your machine, you can check it with the
following command:

```bash
mvn -v
```

You must receive a response similar to the following:

```bash
Apache Maven 3.6.3
Maven home: /usr/share/maven
```

## Installation

Clone this repository with the following command:

```bash
git clone https://github.com/yliss/alten-hotel.git
```


You can execute this project in local using maven or you can start
the service with  docker-compose.

## Executing with Docker-compose
This command will create two containers, the first one for the 
HotelBooking Api, and the other one for the DATABASE postgres
Execute the following command for create the jar file in the
target folder:
```bash
mvn package
```

Now execute the following command for build the containers:
```bash
docker-compose build
```

After build the containers execute one of the following commands for
start the containers:

Starting in current bash console:
```bash
docker-compose up
```

Or starting in background:
```bash
docker-compose up -d
```
## Executing with Maven

Execute the following command for start the application

```bash
mvn spring-boot:run
```

## Executing with an IDE

Execute the following java class
```bash
com.alten.services.booking.Application
```



## At runtime
The Service will run at the port 8081, the url of the service ia the following:

http://localhost:8081/altenhotel/api/v1/booking/

Import and Use the postman Collections created
```bash
/docs/Alten_Hotel_Service.postman_collection.json
```
