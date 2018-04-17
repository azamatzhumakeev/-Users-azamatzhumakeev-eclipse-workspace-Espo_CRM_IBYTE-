Feature: Manipulate Accounts 
@manipulate @regression
Scenario: Remove the account 
	Given User logs into EspoCRM 
	And User opens accounts page 
	And User removes the first account from the list
	When User refresh the account page	 
	Then Total account numbers should be decreased.