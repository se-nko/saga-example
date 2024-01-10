<h1 align="center"> Example of SAGA microservices pattern </h1> <br>

<p align="center">
  Training example of SAGA microservices pattern.
</p>


## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Requirements](#requirements)
- [Quick Start](#quick-start)
- [Testing](#testing)
- [API](#requirements)
- [Acknowledgements](#acknowledgements)




## Introduction

TODO: Replace with introduction

## Features
TODO: Description of features

* Include a list of
* all the many beautiful
* web server features


## Requirements
The application can be run locally or in a docker container, the requirements for each setup are listed below.


### EGO
A running instance of [EGO](https://github.com/overture-stack/ego/) is required to generate the Authorization tokens and to provide the verification key.

[EGO](https://github.com/overture-stack/ego/) can be cloned and run locally if no public server is available.


### Local
* [Java 17 SDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven](https://maven.apache.org/download.cgi)


### Docker
* [Docker](https://www.docker.com/get-docker)


## Quick Start
Make sure the JWT Verification Key URL is configured, then you can run the server in a docker container or on your local machine.

### Configure JWT Verification Key
Update __application.yml__. Set `auth.jwt.publicKeyUrl` to the URL to fetch the JWT verification key. The application will not start if it can't set the verification key for the JWTConverter.

The default value in the __application.yml__ file is set to connect to EGO running locally on its default port `8081`.

### Run Local
```bash
$ mvn spring-boot:run
```

Application will run by default on port `1234`

Configure the port by changing `server.port` in __application.yml__


### Run Docker

First build the images for all robot-* services:

```bash
$ cd robot-factory 
$ docker build -t robot-factory:0.0.1 ../ --file Dockerfile
```

```bash
$ cd robot-shop 
$ docker build -t robot-shop:0.0.1 ../ --file Dockerfile
```

Every Dockerfile run from each module's directory

When ready, run it:
```bash
$ docker-compose pull --ignore-pull-failures
$ docker-compose up -d
```

Services will run by default on localhost on port:

| service-name  | port  | 
|---------------|:-----:|
| robot-factory | 8081  | 
| robot-shop    | 8082  |   
| grafana       | 3000  |   
| prometheus    | 9090  |   
| rabbitmq      | 15672 |   


## Testing
TODO: Additional instructions for testing the application.


## API
TODO: API Reference with examples, or a link to a wiki or other documentation source.

## Acknowledgements
TODO: Show folks some love.