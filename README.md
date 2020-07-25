<h1 align="center"><img src="https://user-images.githubusercontent.com/26521948/72658109-63a1d400-39e7-11ea-9667-c652586b4508.png" alt="Apache JMeter logo" /></h1>
<h4 align="center">SOFTWARE TESTING ENTHUSIAST</h4>
<br>

# CucumberTestNGAllure
PROGRAMMING LANGUAGE USED : JAVA

## Precondition

1. Java installed
```
okta@okta:~$ java --version
openjdk 13.0.2 2020-01-14
OpenJDK Runtime Environment (build 13.0.2+8)
OpenJDK 64-Bit Server VM (build 13.0.2+8, mixed mode, sharing)

```

2. Allure installed
```
okta@okta:~$ allure --version
2.13.1

```
*In order to be able to run the automated test, you have to install those precondition above.
Allure is not mandatory but you cannot see the report without it.

## How to run this automated test
1. Download this repository
2. Extract .zip file
3. Open terminal and navigate to test folder
4. Run one of the command below:

## Run All Features
```
 mvn clean test -Dcucumber.options="src/test/resources/features --plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm --tags @Regression""
```

## Run Per Test Case
```
mvn clean test -Dcucumber.options="src/test/resources/features --plugin io.qameta.allure.cucumberjvm.AllureCucumberJvm --tags @TC_02"

```

## View Automated Test Report
Once the test done, run this command to view the report.
```
allure serve
```
References : 
- https://docs.qameta.io/allure/#_installing_a_commandline
- https://cucumber.io/docs/guides/overview/
- https://testng.org/doc/
- https://www.java.com/en/download/manual.jsp
