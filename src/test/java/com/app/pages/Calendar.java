package com.app.pages;

import static com.app.utilities.Driver.getDriver;
import static com.app.utilities.Page.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Calendar {
	private LocalDate today;
	private DateTimeFormatter formatter;
	private String formattedDate;
	private WebElement calendarCell;
	
	/**
	 * Constructor initializes and formats a date for tomorrow
	 * So it can be used in choosing a date to schedule a meeting
	 */
	public Calendar() {
		PageFactory.initElements(getDriver(), this);
		today = LocalDate.now();
		
	}
	
// <!-- Login Functionality Elements -->
	@FindBy(id="field-userName")
	WebElement userName;
	
	@FindBy(xpath="//span[text()='Month']/..")
	WebElement monthLink;
	
	@FindBy(id="field-password")
	WebElement password;
	
	@FindBy(id="btn-login")
	WebElement loginButton;
// <! - - - - - - - - - - - - - - - - - - - - - - - - - - - - - >
	
	@FindBy(xpath="//a[@href='#Calendar']")
	WebElement calendarPageLink;
	
	@FindBy(xpath="//a[@href='#User/view/1']")
	WebElement userLink;
	
	@FindBy(id="nav-menu-dropdown")
	WebElement navDropdown;
	
	@FindBy(xpath="//div[@class='modal-body body']")
	WebElement createEventWindow;
	
	@FindBy(xpath="//input[@value='Meeting']")
	WebElement meetingRadioBox;
	
	@FindBy(xpath="//input[@value='Call']")
	WebElement callRadioBox;
	
	@FindBy(xpath="//input[@value='Task']")
	WebElement taskRadioBox;
	
	@FindBy(name="name")
	WebElement nameInputBox;
	
	@FindBy(name="status")
	WebElement statusSelectBox;
	Select statusSelect;
	
	@FindBy(name="assignedUserName")
	WebElement assignedUserNameInput;
	
	@FindBy(xpath="//input[@name='assignedUserName']/../span/button[1]")
	WebElement selectAssignedUserButton;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	
	
	/**
	 * This method performs login functionality
	 * 
	 * @param userName
	 * @param password
	 */
	public void login(String userName, String password) {
		this.userName.sendKeys(userName);
		this.password.sendKeys(password);
		click(loginButton);
	}
	public void goToCalendarPage() {
		click(calendarPageLink);
	}
	/**
	 * This method return a string of a user name that is displayed
	 * @return
	 */
	public String getDisplayedUsername() {
		click(navDropdown);
		return userLink.getText();
	}
	
	/**
	 * This method clicks a cell for tomorrow in the calendar
	 * @return
	 */
	public void clickCalendarCellForTomorrow() {
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formattedDate = today.plusDays(1).format(formatter);
		calendarCell = getDriver().findElement(
				By.xpath("//td[@data-date='"+formattedDate+"' and contains(@class,'fc-widget')]"));
		click(calendarCell);
	}
	
	public void clickCalendarCellForGivenDate(String daysFromToday) {
		int numDays = Integer.parseInt(daysFromToday.trim());
		formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		formattedDate = today.plusDays(numDays).format(formatter);
		calendarCell = getDriver().findElement(
				By.xpath("//td[@data-date='"+formattedDate+"' and contains(@class,'fc-widget')]"));
		click(calendarCell);
	}
	
	public void fillOutSaveRequiredFields(String fullName, String status, String assignedUser) {
		nameInputBox.sendKeys(fullName);
		statusSelect = new Select(statusSelectBox);
		statusSelect.selectByValue(status);
		click(selectAssignedUserButton);
		verifyElementIsPresent(getUser(assignedUser));
		click(getUser(assignedUser));
		click(saveButton);
	}
	
	public WebElement getUser(String assignedUser) {
		return getDriver().findElement(By.xpath("//a[text()='"+assignedUser+"']"));
	}
	
	public WebElement getCreateEventWindow() {
		return createEventWindow;
	}
	
}