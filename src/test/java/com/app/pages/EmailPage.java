package com.app.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class EmailPage {
	private WebDriver driver;

	public EmailPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(@class,'nav-link')]/span[contains(text(),'Emails')]")
	public WebElement emails;

	@FindBy(name = "textFilter")
	public WebElement search;

	@FindBy(xpath = "//button[@class='btn btn-primary search btn-icon']")
	public WebElement searchButton;

	@FindBy(xpath = "//a[@href='#Email/list/folder=all']")
	public WebElement buttonAll;

	@FindBy(xpath = "//a[@href='#Email/list/folder=inbox'][2]")
	public WebElement InboxButton;

	@FindBy(xpath = "//a[@href='#Email/list/folder=important'][2]")
	public WebElement ImportantButton;

	@FindBy(xpath = "//a[@href='#Email/list/folder=sent'][2]")
	public WebElement ButtonSent;

	@FindBy(xpath = "//a[@href='#Email/list/folder=drafts'][2]")
	public WebElement DraftButton;

	@FindBy(xpath = "//a[@href='#Email/list/folder=trash'][2]")
	public WebElement trushButton;

	@FindBy(xpath = "//button[@class='btn btn-default']")
	public WebElement resetButton;

	@FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle add-filter-button']")
	public WebElement addField;

	@FindBy(xpath = "//a[@class='btn btn-danger action']")
	public WebElement ComposeButton;

	@FindBy(xpath = "//input[@class='select-all']")
	public WebElement ButtonCheckBox;

	@FindBy(xpath = "//button[@class='btn btn-default dropdown-toggle actions-button']")
	public WebElement ButtonActions;

	@FindBy(xpath = "//div[@id='main']/div[@class='row']/div[2]/div[1]/div/ul[@class='dropdown-menu']/li[6]/a[@href='javascript:']")
	public WebElement MarkImportantButton;

	public WebElement getButtonActions() {
		return ButtonActions;

	}

	public WebElement getCompose() {
		return ComposeButton;
	}

	public WebElement getEmail() {
		return emails;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getButtonAll() {
		return buttonAll;
	}

	public WebElement getInboxButton() {
		return InboxButton;
	}

	public WebElement getImportantButton() {
		return ImportantButton;
	}

	public WebElement getButtonSent() {
		return ButtonSent;
	}

	public WebElement getDraftButton() {
		return DraftButton;
	}

	public WebElement getTrushButton() {
		return trushButton;
	}

	public WebElement getResetButton() {
		return resetButton;
	}

	public void AddFields() {
		List<WebElement> elements = Driver.getDriver()
				.findElements(By.xpath("//ul[@class=\"dropdown-menu pull-right filter-list\"]"));

		for (WebElement el : elements) {
			System.out.println(el.getText());

		}

	}

	public void ComposeDropDown() {
		List<WebElement> element = Driver.getDriver()
				.findElements(By.xpath("//div[@role='group']/button[@type='button']/span[@class='caret']"));

		for (WebElement ele : element) {
			System.out.println(ele.getText());
		}
	}

}
