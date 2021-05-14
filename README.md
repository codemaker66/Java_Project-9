# Mediscreen

Mediscreen is a Spring Boot application that help practitioners to see their patients and their notes history and get for each one of them a diabetes assessment.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

- Java 1.8
- Maven 3.6.3
- Mysql 8.0.21
- MongoDB Community Server
- Docker

### Installing

A step by step series of examples that tell you how to get a development env running :

1.Install Java :

https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

2.Install Maven :

https://maven.apache.org/install.html

3.Install MySql :

https://dev.mysql.com/downloads/mysql/

4.Install MongoDB Community Server :

https://www.mongodb.com/try/download/community

5.Install Docker :

https://docs.docker.com/desktop/

After installing MySql and MongoDB, you can use the default `root` account and the password can be set as `p4554th3d4t4b453`. If you use another user/credentials make sure to change the same in the code.

### Running The App

After installing everything, you will have to set up the tables in each database. For this, you can use the files in the resources folder. After that make sure to run Docker than import the code into a folder of your choice and do the following steps :

1. Go to the diabetes-anticipator-microservice folder and execute the following commands :
    1. `mvn package`
    2. `docker build -t diabetes-anticipator-microservice .`
2. Go to the mediscreen folder and execute the following commands :
    1. `mvn package`
    2. `docker build -t mediscreen .`
3. Go to the patient-microservice folder and execute the following commands :
    1. `mvn package`
    2. `docker build -t patient-microservice .`
4. Go to the practitioner-microservice folder and execute the following commands :
    1. `mvn package`
    2. `docker build -t practitioner-microservice .`
5. Go back to the main folder that contains the project and execute the following command :
    1. `docker compose up`

### Testing

The app has unit and integration tests written. To run them from maven, go to the folders that contains the pom.xml then execute the below command :

`mvn site`