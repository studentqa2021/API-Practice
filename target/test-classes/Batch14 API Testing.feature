Feature: Testing all API Methods
#Description: requirement
#Background: common steps

Scenario Outline: As an API user, I am trying to check HTTP GET & DELETE Methods
Given Select HTTP Methods "<HTTP Method>" and go to URL "<URL>"
Then Validate my test
Examples:
|HTTP Method|URL|
|GET|http://localhost:3000/posts/|
|DELETE|http://localhost:3000/posts/|

Scenario Outline: As an API user, I am trying to check HTTP POST & PUT Methods
When Pass Test Data "<HTTP Method>"
Given Select HTTP Methods "<HTTP Method>" and go to URL "<URL>"
Then Validate my test
Examples:
|HTTP Method|URL|
|POST|http://localhost:3000/posts/|
|PUT|http://localhost:3000/posts/|
