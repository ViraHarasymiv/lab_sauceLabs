# Lab 1: Page Object Model & TestNG & Selenium Grid 4.0
The project is made by using Page Object Model, TestNG framework and Selenium Grid 4.0. 

The target website is [BPB PUBLICATIONS](http://practice.bpbonline.com/index.php).

Automated tests: positive test case for the creating new account

## Run tests in Selenium Grid 4.0

**1. Configure Selenium Grid 4.0**

- Download selenium-server jar-file ([Selenium Downloads](https://www.selenium.dev/downloads/))
- Rename the jar-file in "selenium-server" on order to make easier to run the cmd commands
- Run the next command in cmd (where the "selenium-server" jar-file is saved) in order to run EVENT BUS. It is the communication channel between all the other components.
```shell
java -jar selenium-server.jar event-bus
```
- Run the next command in the separate cmd window (where the "selenium-server" jar-file is saved) in order to run SESSION MAP. It maps the relationship between a given node and the session in which it’s running.
```shell
java -jar selenium-server.jar sessions
```
- Run the next command in the separate cmd window (where the "selenium-server" jar-file is saved) in order to run NEW SESSION QUEUE. It’s the queue where requests for new sessions wait until they get picked by the distributor.
```shell
java -jar selenium-server.jar sessionqueue
```
- Run the next command in the separate cmd window (where the "selenium-server" jar-file is saved) in order to run DISTRIBUTOR. It registers and manages the nodes. It also queries the new session queue for requests for new sessions, then finds a suitable node for it.
```shell
java -jar selenium-server.jar distributor --sessions http://localhost:5556 --sessionqueue http://localhost:5559 --bind-bus false
```
- Run the next command in the separate cmd window (where the "selenium-server" jar-file is saved) in order to run ROUTER. It is the component that receives the requests and dispatches them to the appropriate place: requests for an existing session are sent to the session map, where the id for the node is retrieved and then the request is sent to the node; requests for a new session are sent to the new session queue, where they wait to be picked up
```shell
java -jar selenium-server.jar router --sessions http://localhost:5556 --distributor http://localhost:5553 --sessionqueue http://localhost:5559
```
- Run the next command in the separate cmd window (where the "selenium-server" jar-file is saved) in order to run NODE. Nodes are the “agents” that run on the given machines. Six separate cmd windows are opened: Event Bus, Session Map, New Session Queue, Distributor, Router and Node.
```shell
java -jar selenium-server.jar node --detect-drivers true
```
**2. Run test case in Selenium Grid 4.0**
- GridFactory class is used to initialize RemoteWebDriver in Selenium Grid 4.0
- "Parameter" annotation is used in BaseTest class in order to select the environment (local or grid) and the browser type.
- positiveCreateAccountTestSuiteOnGrid.xml is used to run the tests in Selenium Grid. You can also use the next command:
```shell
mvn clean test
```