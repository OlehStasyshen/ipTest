# ipTest
[ipTest](https://github.com/yourname/ipTest) is a project that involves making network requests to obtain IP information. The project has been implemented using `Scala` with `ZIO` for providing a purely functional approach.

## System Requirements
- Java SDK version 11
- Scala 3.4
- SBT (Scala Build Tool)
- IntelliJ IDEA 2024.1, Ultimate Edition
- Docker

## Development / Launching the project

To start working on the project or running it, please follow these steps:

1. Clone the project: https://github.com/OlehStasyshen/ipTest
2. Navigate into the project directory:
   ``cd ipTest``
3. Now you can either start developing or to run the existing project.

## Docker
To build and run the project using Docker, you need to follow the below steps:
1. Make sure Docker is running on your machine.
2. Build a Docker image for the project.
 - If you have a Dockerfile, you can simply run:
    ``    docker build -t iptest .``
 - Replace 'iptest' with the name you want to give to your Docker image.
3. Once the Docker image is built, you can run the project using the image:
    ``docker run iptest``
## Project Structure
The project mainly contains the following files:

 - IPServiceClient.scala: this is the core file, consisting of http requests to the ipification API.
 - IpServiceResponse.scala: this is where we model the expected response from the API.

## Tests
Tests are located under /src/test/scala. They use ZIO Test for all the testing purposes.