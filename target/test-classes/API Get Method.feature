Feature: API Get Method Testing
#Description: requirement
#Background: common steps

Scenario: As an API user, I am trying to practice HTTP Get Method
Given Pass the URL
Then validate status code
And validate data format is JSON 
And validate response time
And validate response should not be null