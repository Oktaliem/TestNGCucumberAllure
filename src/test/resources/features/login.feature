# Created by oktaliem
@Regression
Feature: Login To Akaunting
  As a User of Akaunting software
  I want to be able to login to portal

  @TC_01 @SmokeTest
  Scenario: Login with valid credential
    When I go to http://localhost:10080/auth/login
    And I login with valid the username "admin@example.com" and password "password"
    Then I can login successfully