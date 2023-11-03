# Jukebox Remote Control API

## Description
This Spring Boot application provides a REST API to control Jukebox settings remotely. It allows clients to retrieve a list of Jukeboxes that support a given setting ID. The application can filter results based on Jukebox model and supports pagination through offset and limit query parameters.

## Features

- Get a paginated list of Jukeboxes supporting a specific setting ID.
- Filter results by Jukebox model.
- Pagination support for result sets.

## Running the Application

To run the application, you can either package it into a JAR file or use Spring Boot's Maven plugin.

### Commands for JAR:
```sh
mvn package
java -jar target/jukeboxremotecontrol-0.0.1-SNAPSHOT.jar
```

### Commands for Maven:
```sh
mvn spring-boot:run
```

## Testing the Application

To execute the test suite, run the following command:

### Commands for Maven testing:
```sh
mvn test
```

## Usage

Once the application is running, you can access the REST API through your web browser or a tool like curl. For example:

In the browser, go to this request example:
http://localhost:8080/api/jukeboxes/search?settingId=b43f247a-8478-4f24-8e28-792fcfe539f5

This will return a list of Jukeboxes that support the setting ID `b43f247a-8478-4f24-8e28-792fcfe539f5`.