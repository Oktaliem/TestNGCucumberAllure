# Created by oktaliem
@Regression
Feature: Manage Items
  As a User of Akaunting software
  I want to be able to manage items

  Background: User has landed on Homepage
    Given login to "http://localhost:10080/auth/login" with username "admin@example.com" and password "password"

  @TC_02 @SmokeTest
  Scenario: And new items
    When I fill out the form
    Then I am able to create new item