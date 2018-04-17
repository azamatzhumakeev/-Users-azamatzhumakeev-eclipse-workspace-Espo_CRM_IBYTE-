package com.app.step_definition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import com.app.pages.AccountsPage;
import com.app.pages.LoginPage;
import com.app.utilities.BrowserUtils;
import com.app.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Manipulate_accounts_step_defs {
	
	private WebDriver driver = Driver.getDriver();
	LoginPage loginPage = new LoginPage();
	AccountsPage accountsPage = new AccountsPage();
	int totalNumberBefore;
	
	@Given("^User removes the first account from the list$")
	public void user_removes_the_first_account_from_the_list() {
		BrowserUtils.waitFor(3);
	  accountsPage.checkmarkAccount.click();
	  accountsPage.actionsButton.click();
	  accountsPage.remove.click();	
	  BrowserUtils.waitFor(3);
	 accountsPage.popupRemove.click();
	  //accountsPage.popupCancel.click();
	 System.out.println( accountsPage.totalNumberOfAccounts.getText());
	 String totalNumberBeforeTemp =accountsPage.totalNumberOfAccounts.getText().substring(7);
	totalNumberBefore = Integer.parseInt(totalNumberBeforeTemp);
	System.out.println(totalNumberBefore);
	}

	@When("^User refresh the account page$")
	public void user_refresh_the_account_page(){
	    accountsPage.resetButton.click();
	}



	@Then("^Total account numbers should be decreased\\.$")
	public void total_account_numbers_should_be_decreased(){
			BrowserUtils.waitFor(3);
		 String totalNumberAfterTemp =accountsPage.totalNumberOfAccounts.getText().substring(7);
			int totalNumberAfter = Integer.parseInt(totalNumberAfterTemp);
			System.out.println(totalNumberAfter);
			assertEquals(totalNumberAfter+1, totalNumberBefore);
	}

}