Feature: Create opportunities


Background:
Given I logged into Espo



Scenario: Create opportunity
And User open Opportunity page
And User click create opportunity buttom
And User enter name "Mason Smith"
And User enter amount "1000"
And User chose date
When User click save bottom


@dev
Scenario: Create new opportunity
And User open Opportunity page
And User click create opportunity buttom
And User enter name "Tom Cruz"
And User enter amount "500"
And User change probability 10 to 5
And User chose date
When User click save bottom


