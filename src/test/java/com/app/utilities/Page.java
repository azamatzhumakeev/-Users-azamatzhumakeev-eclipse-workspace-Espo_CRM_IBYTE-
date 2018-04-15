package com.app.utilities;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Page {
	static WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
	public static void sleep(long millis) {
		try {
			Thread.sleep(millis);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void verifyElementIsPresent(WebElement el) {
		el = wait.until(ExpectedConditions.visibilityOf(el));
		Assert.assertTrue(el.isDisplayed(), "Verify Element is present failed");
	}
	
	public static void waitUntilDisplayed(WebElement el) {
		el = wait.until(ExpectedConditions.visibilityOf(el));
		if(!el.isDisplayed()) {
			System.err.println(el +  " is not displayed");
		}
	}
	
	public static void click(WebElement el) {
		el = wait.until(ExpectedConditions.elementToBeClickable(el));
		el.click();
	}
}