Feature: Create opportunities

Background: Login to app
Given I logged into EspoCRM

Scenario: Create opportunity
And: User open Opportunity page
And: User click create opportunity buttom
And: User enter name "Jason Smith"
And: User enter amount "1000"
And: User chose date
When: User click save bottom
Then: User should see Overview for "Jason Smith"

Scenario: Create opportunity
And: User open Opportunity page
And: User click create opportunity buttom
And: User enter name "Tom Cruz"
And: User enter amount "500"
And: User change probability 10 to 5
And: User chose date
When: User click save bottom
Then: User should see Overview for "Tom Cruz"

