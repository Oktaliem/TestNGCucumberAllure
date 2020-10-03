# Created by oktaliem
@Regression
Feature: TF-2223 Login To Katalon
  As a User of Katalon software
  I want to be able to login to portal

  @TF-2346 @SmokeTest
  Scenario: TF-2346 Login with invalid credential
    When I'm landing to katalon portal
    And I'm sign in with email "test@test.com" and password "teste1234"
    Then I'm unable to sign in and error message will be displayed "Incorrect email or password. Please try again"