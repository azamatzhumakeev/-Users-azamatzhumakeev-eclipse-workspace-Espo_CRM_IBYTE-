package com.app.step_definition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.app.pages.Create_Opportunity_Page;
import com.app.pages.LoginPage;
import com.app.utilities.ConfigurationReader;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Create_opportunity_step_def {
	private WebDriver driver = Driver.getDriver();
	LoginPage login = new LoginPage();
	Create_Opportunity_Page createOpporPage = new Create_Opportunity_Page();
	
	@Given("^I logged into Espo$")
	public void i_logged_into_Espo() {
		driver.get(ConfigurationReader.getProperty("url"));
		login.login(ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
	}
	
	@Given("^User open Opportunity page$")
	public void user_open_Opportunity_page() {
		createOpporPage.opportunities.click();
	}

	@Given("^User click create opportunity buttom$")
	public void user_click_create_opportunity_buttom() {
		createOpporPage.createOpportunitiesBtn.click();
	}

	@Given("^User enter name \"([^\"]*)\"$")
	public void user_enter_name(String arg1) {
		createOpporPage.name.sendKeys("Mason Smith");
	}

	@Given("^User enter amount \"([^\"]*)\"$")
	public void user_enter_amount(String arg1) {
	   createOpporPage.amount.sendKeys("1000");
	}

	@Given("^User chose date$")
	public void user_chose_date() {
	   createOpporPage.closeDate.sendKeys("05/05/2018");
	}

	@When("^User click save bottom$")
	public void user_click_save_bottom() {
	    createOpporPage.saveBtn.click();
	}

	
	}


