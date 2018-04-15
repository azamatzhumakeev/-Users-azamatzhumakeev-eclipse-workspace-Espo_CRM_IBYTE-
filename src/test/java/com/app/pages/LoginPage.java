
package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="field-userName")
	public WebElement username;
	
	@FindBy(id="field-password")
	public WebElement password;
	
	
	@FindBy(id="btn-login")
	public WebElement login;
	
	public void login(String userName, String pwd) {
		username.sendKeys(userName);
		password.sendKeys(pwd);
		login.click();
	}

}

package com.app.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage() {
		this.driver=Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="field-userName")
	public WebElement username;
	
	@FindBy(id="field-password")
	public WebElement password;
	
	@FindBy(id="btn-login")
	public WebElement loginBtn;
	
	public void login(String userName, String pwd) {
		username.sendKeys(userName);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
}

