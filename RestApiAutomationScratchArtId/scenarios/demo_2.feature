Feature: GET API Testing 
Scenario: GET API Testing Functionality
Given service is up and running
And user makes REST api call with "https://dummy.restapiexample.com/api/v1/employees" and with method "GET"
Then response should have "StatusCode"