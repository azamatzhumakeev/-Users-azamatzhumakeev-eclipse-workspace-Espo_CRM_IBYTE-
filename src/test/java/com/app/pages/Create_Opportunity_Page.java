package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class Create_Opportunity_Page {
	
	private WebDriver driver;

	public Create_Opportunity_Page() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@class, 'nav-link')]/span[contains(text(),'Opportunities')]")
	public WebElement opportunities;
	
	@FindBy(xpath="//div[@class='header-buttons btn-group pull-right' ]/a")
	public WebElement createOpportunitiesBtn;
	
	@FindBy(xpath="//input[@name='name']")
	public WebElement name;
	
	@FindBy(xpath="//input[@name='amount']")
	public WebElement amount;
	
	@FindBy(xpath="//input[@name='closeDate']")
	public WebElement closeDate;
	
	@FindBy(xpath="//button[@class='btn btn-primary action']")
	public WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='probability']")
	public WebElement probability;
	
	@FindBy(xpath="//h4[contains(text(),'Overview')]")
	public WebElement overviewPage;
	
	
	

}
