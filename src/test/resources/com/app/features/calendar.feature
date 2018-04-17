#Author: Askar Musakunov
#Keywords Summary : Calendar
#Feature: Module of Calendar.
Feature: Calendar functionalities
  
  As an Espo_CRM user 
  I want to be able to create events in my calendar
  So I can keep track of my schedule
  
   #In examples table's date coloum please put a number which refers to a number of days from today...
   #In ex: 1 is tomorrow, 2 is 2 days from today
  #@smoke @regression @dev
  #@calendar @regression
  Scenario Outline: Create a meeting in calendar with required fields only
    Given User is logged in as an "Admin"
    When User double clicks on a "<date>"
    Then Create event window opens
    And User fills out "<name>", "<status>" and "<assignedUser>"
    And User can verify "<dateStart>" matches to the date selected 
    And User selects "<dateEnd>"
    And User clicks save button
    And User can verify meeting is displayed on calendar
    And User can verify all meeting description is accurate
    

    Examples: 
      | name  		      | assignedUser |dateStart| timeStart| dateEnd| timeEnd|date   | status|
      | Elon  Mask         |Tesla]        | 16      | 8:00am   |17     | 10:00am| 1      | Planned|
    	  #|Mark Zuckerberg |10X         | 18      | 10:30am  | 20    | 10:30am|2 		| Held|
    
    @smoke
      Scenario: for Smoke
      Given User is logged in as an "Admin"
    