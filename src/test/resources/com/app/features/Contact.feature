Feature: Creating contacts funtionality 

Background: Login to app 
	Given User logged into EspoCRM 
@contact @regression
Scenario: Create contact using CREATE page
    And User opens the create contact page
   	And user enters the Name
    And User enters the first Name "Sarah" and the last Name "Connor"
    #And user selects the account "oracle"
    And User enters the email address "@sarah@gmail.com"
    And User enters the phone number "312-9032457"
    When User clicks on the Save Button
    Then User should see Contact Information for "Sarah Connor"
@asdf	                                                                                                    
Scenario Outline: Creating more contacts 

	When User clicks on Create contact 
	And User should create a contact with given credetials
		|  Name*    | firstName   | lastName   | email  |Account   | Phone      |
		|   Mr.    | <firstName> | <lastname> | <email> |<account> | <officePhone>    |
	
	Then User should see Overview for "<Name><firstName> <lastName> <email><officePhone>" 
	
	Examples: 
		| Name   | firstName | lastName |email                     | account          | office   |
		|  Ms.   | Zia       | Miakhel  | test@cybertekshcool.com  | user'sName       | 77389076 |
		|  Dr.   | John      | Smith    | icefrog@valve.com        | user'sName       |13453445  |
		
		@smoke
		Scenario: for Smoke
		And User opens the create contact page