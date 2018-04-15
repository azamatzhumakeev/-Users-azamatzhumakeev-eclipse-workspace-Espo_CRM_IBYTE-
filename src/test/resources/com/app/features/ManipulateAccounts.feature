Feature: Manipulate Accounts 

Scenario: Remove the account 
	Given User logs into EspoCRM 
	And User opens accounts page 
	And User puts chekmark on the first account 
	And User clicks on the actions button 
	And  User selects the remove option 
	When User clicks on the remove button on the alert window 
	And User clicks on the reset button 
	Then User should not see the first account 
	And Total account number should be less than initial case 
	
	
Scenario: Follow the account 
	Given User logs into EspoCRM 
	And User opens accounts page 
	And User puts chekmark on the first account 
	And User clicks on the actions button 
	And  User selects the follow option 
	When User clicks on the follow button on the alert window 
	And User clicks on the first account 
	Then User sould see the followed is active 
	
	
Scenario: Unfollow the account 
	Given User logs into EspoCRM 
	And User opens accounts page 
	And User puts chekmark on the first account 
	And User clicks on the actions button 
	And  User selects the unfollow option 
	When User clicks on the unfollow button on the alert window 
	And User clicks on the first account 
	Then User sould see the unfollowed is active 
	
	
	