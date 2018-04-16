package com.app.step_definition;

import static com.app.utilities.ConfigurationReader.*;

import static org.testng.Assert.*;

import com.app.pages.Calendar;
import com.app.utilities.BrowserUtils;

import static  com.app.utilities.Page.*;
import static com.app.utilities.Driver.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class calendar_step_defs {
	Calendar cl = new Calendar();
	@Given("^User is on calendar page$")
	public void user_is_on_calendar_page() {
	    
	    
	}

	@Given("^User is logged in as an \"([^\"]*)\"$")
	public void user_is_logged_in_as_an(String userName) {
		getDriver().get(getProperty("url"));
	    cl.login(getProperty("username"), getProperty("password"));
	    assertEquals(cl.getDisplayedUsername(), userName, "Invalid User");
	    cl.goToCalendarPage();
	    BrowserUtils.waitFor(3);
	}

	@When("^User double clicks on a \"([^\"]*)\"$")
	public void user_double_clicks_on_a(String numOfdays) {
		BrowserUtils.waitFor(2);
	    cl.clickCalendarCellForGivenDate(numOfdays);
	    BrowserUtils.waitFor(2);
	}

	@Then("^Create event window opens$")
	public void create_event_window_opens() {
	    verifyElementIsPresent(cl.getCreateEventWindow());
	    
	}

	@Then("^User fills out \"([^\"])\", \"([^\"])\" and \"([^\"]*)\"$")
	public void user_fills_out_and(String name, String status, String assignedUser) {
		cl.fillOutSaveRequiredFields(name, status, assignedUser);
	    
	}

	@Then("^User can verify \"([^\"]*)\" matches to the date selected$")
	public void user_can_verify_matches_to_the_date_selected(String arg1) {
	    
	    
	}

	@Then("^User selects \"([^\"]*)\"$")
	public void user_selects(String arg1) {
	    
	    
	}

	@Then("^User clicks save button$")
	public void user_clicks_save_button() {
	    
	}

	@Then("^User can verify meeting is displayed on calendar$")
	public void user_can_verify_meeting_is_displayed_on_calendar() {
	    
	    
	}

	@Then("^User can verify all meeting description is accurate$")
	public void user_can_verify_all_meeting_description_is_accurate() {
	    
	    
	}

	@When("^User double clicks on today$")
	public void user_double_clicks_on_today() {
	    
	    
	}

	@Then("^User fills out all required fields with \"([^\"])\" , \"([^\"])\", \"([^\"]*)\"$")
	public void user_fills_out_all_required_fields_with(String arg1, String arg2, String arg3) {
	    
	    
	}

	@Then("^User fills out \"([^\"])\", \"([^\"])\" ,\"([^\"])\", \"([^\"])\", \"([^\"]*)\"$")
	public void user_fills_out(String arg1, String arg2, String arg3, String arg4, String arg5) {
	    
	    
	}

	@Then("^User adds \"([^\"])\", \"([^\"])\", and \"([^\"]*)\"$")
	public void user_adds_and(String arg1, String arg2, String arg3) {
	    
	    
	}

	@Then("^User can verify dateStart matches the date selected$")
	public void user_can_verify_dateStart_matches_the_date_selected() {
	    
	    
	}

	@Then("^User can verify all meeting description is displayed and accurate$")
	public void user_can_verify_all_meeting_description_is_displayed_and_accurate() {
	    
	    
	}

	@Then("^User selects \"([^\"])\" and \"([^\"])\"$")
	public void user_selects_and(String arg1, String arg2) {
	    
	    
	}


}