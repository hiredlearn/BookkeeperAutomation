package com.bookkeeper.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bookkeeper.constants.Constants;
import com.bookkeeper.testBase.TestBase;

public class Homepage extends TestBase {

	@FindBy(xpath = "//div[@id='top-account']/a")
	WebElement profileIcon;

	@FindBy(linkText = "Login")
	WebElement login;

	@FindBy(linkText  = "Register")
	WebElement register;
	
	@FindBy(xpath="//div[@id='top-download']/a")
	WebElement getStarted;
	
	@FindBy(xpath="//span[contains(text(),'Start')]")
	WebElement startCloud;
	
	public Homepage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage navigateToLoginPage() {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(profileIcon));
		profileIcon.click();
		
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(login));
		login.click();
		return new LoginPage();
	}
	
	public RegisterPage navigateToRegisterPage() {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(profileIcon));
		profileIcon.click();
		
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.visibilityOf(register));
		register.click();
		return new RegisterPage();

	}

	public void getStarted() {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(getStarted));
		getStarted.click();
	}
	
	public void launchCloud() {
		new WebDriverWait(driver, Constants.EXPLICIT_WAIT).until(ExpectedConditions.elementToBeClickable(startCloud));
		startCloud.click();
	}

}
