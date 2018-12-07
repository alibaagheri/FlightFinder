# CheapFlightFinder REST API

This project contains proper source code as well as test units to call Amadeus flight services and display top 3 cheapest flights to the client. For more information about the endpoints please refer to http://localhost:8888/swagger-ui.html


## Getting Started

To run the project, please clone the repository to your local machine. Then open the project using your IDE of choice.
As it is a Maven project, it can be built and ran uning any of the major java IDEs.
After running the application, you can use the follwoing paatern to call the service and get the 3 cheapest flights for the given origin, destination and departure date:
    http://localhost:8888/api/cheapest-flights/<origin>/<destination>/<departure-date-in-yyyy-mm-dd>
	for example: http://localhost:8888/api/cheapest-flights/fra/fra/2018-12-02

### Prerequisites
Java 8.0
spring boot 2.1, 
maven 3.3.9
tomcat 9

## Running the tests

To run the test, you can use Maven commad "mvn test".

## Author

* **Ali Bagheri**
