Feature: Create emailLogin
Background: Login to app
Given I logged into EspoCRM

@email @regression
Scenario: Create emailLogin
When User clicks email button
Then all buttons should be displayed
Then User clicks sent button
Then User clicks marks is Important
Then Important massage is displayed in Important box

@smoke
Scenario: for Smoke
When User clicks email button