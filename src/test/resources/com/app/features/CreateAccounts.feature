Feature: Creating Accounts 
@smoke	
Scenario Outline: Creating multiple accounts with correct data 
	Given User logs into EspoCRM 
	And User opens accounts page 
	And User clicks on create account button 
	And User enters the name for the account "<name>" 
	And User enters the email for the account "<email>" 
	And User enters the website for the account "<website>" 
	And User enters the phone number for the account "<phoneNumber>" 
	And User enters the country for the account "<country>" 
	And User selects the type of the account 
	When User clicks on the save button 
	Then User should see contact information for "<name>" 
	And User should see new created account "<name>" on the accounts page
	
	Examples: 
		|name     |email             |website          |phoneNumber |country|
		|Cybertek |info@cybertek.com |cybertekshool.com|773-222-1221|USA|
		|Oracle  |info@oracle.com   |oracle.com       |333-444-1567|USA|
		|Apple   |info@apple.com    |apple.com        |555-666-2222|USA|
		|Google  |info@google.com   |google.com       |777-888-2999|USA|
		
	
Scenario Outline: Creating multiple accounts with incorrect data 
	Given User logs into EspoCRM 
	And User opens accounts page 
	And User clicks on create account button 
	And User enters the name for the account "<name>" 	
	And User enters the phone number for the account "<phoneNumber>" 
	And User enters the country for the account "<country>" 
	#And User enters the email for the account "<email>" 	
	When User clicks on the Save button 
	Then "Not valid" should be displayed 

	
	Examples: 
		|name    |email            |website          |phoneNumber |country|
		|Cybertek|info             |cybertekshool    |jjjjjjjjjjjj|55555555|
		#|Oracle  |info@oracle.com  |oracle           |kkkkkkkkkkkk|44444444|
		
		