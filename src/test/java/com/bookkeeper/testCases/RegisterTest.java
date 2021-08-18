package com.bookkeeper.testCases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.lang.reflect.Method;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bookkeeper.pages.DashboardPage;
import com.bookkeeper.pages.Homepage;
import com.bookkeeper.pages.LoginPage;
import com.bookkeeper.pages.RegisterPage;
import com.bookkeeper.testBase.TestBase;
import com.bookkeeper.utils.TestUtility;

public class RegisterTest extends TestBase {
	Homepage homepage;
	LoginPage loginPage;
	RegisterPage registerPage;
	DashboardPage dashboardPage;

	TestUtility testUtil;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		testUtil = new TestUtility();
		initialization("admin");
		log.info("Application Launched Successfully");
		homepage = new Homepage();
		registerPage = homepage.navigateToRegisterPage();
	}

	@Test(priority = 1, enabled = true)
	public void verifyPageTitle(Method method) {
		extentTest = extent.startTest(method.getName());
		assertThat(driver.getTitle(), is(equalTo("Register - Akaunting")));
	}

//	@Test(priority = 2, enabled = true)
//	public void verifyErrorOnBlankName(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addEmail(RandomStringUtils.randomAlphabetic(5).concat("@test.com"));
//		registerPage.enterPassword(RandomStringUtils.randomAlphabetic(5));
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The name field is required.")));
//		
//	}
//
//	@Test(priority = 3, enabled = true)
//	public void verifyErrorOnBlankSpaceInName(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName("  ");
//		registerPage.addEmail(RandomStringUtils.randomAlphabetic(5).concat("@test.com"));
//		registerPage.enterPassword(RandomStringUtils.randomAlphabetic(5));
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The name field is required.")));
//		
//	}
//
////Error Mentioned in excel is not coming
//	@Test(priority = 4, enabled = true)
//	public void verifyErrorOnlyNumricInName(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName(RandomStringUtils.randomNumeric(5));
//		registerPage.addEmail(RandomStringUtils.randomAlphabetic(5).concat("@test.com"));
//		registerPage.enterPassword(RandomStringUtils.randomAlphabetic(5));
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The g-recaptcha-response field is required.")));
//		
//	}
//
//	@Test(priority = 5, enabled = true)
//	public void verifyErrorOnBlankEmail(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName(RandomStringUtils.randomAlphabetic(5));
//
//		registerPage.enterPassword(RandomStringUtils.randomAlphabetic(5));
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The email field is required.")));
//		
//	}
//
//	@Test(priority = 6, enabled = true)
//	public void verifyErrorOnBlankSpaceInEmail(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName(RandomStringUtils.randomAlphabetic(5));
//		registerPage.addEmail(" ");
//		registerPage.enterPassword(RandomStringUtils.randomAlphabetic(5));
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The email field is required.")));
//		
//	}
//
////Client side email id valid is blocking this test case
//	@Test(priority = 7, enabled = false)
//	public void verifyErrorOnInvalidEmail(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName(RandomStringUtils.randomAlphabetic(5));
//		registerPage.addEmail(RandomStringUtils.randomAlphabetic(5).concat("@@test.com"));
//		registerPage.enterPassword(RandomStringUtils.randomAlphabetic(5));
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The g-recaptcha-response field is required.")));
//		
//	}
//
//	@Test(priority = 8, enabled = true)
//	public void verifyErrorOnLessThenFiveCharPwd(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName(RandomStringUtils.randomAlphabetic(5));
//		registerPage.addEmail(RandomStringUtils.randomAlphabetic(5).concat("@test.com"));
//		registerPage.enterPassword(RandomStringUtils.randomAlphabetic(4));
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The password must be at least 5 characters.")));
//		
//	}
//
//	@Test(priority = 9, enabled = true)
//	public void verifyErrorOnBlankPassword(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName(RandomStringUtils.randomAlphabetic(5));
//		registerPage.addEmail(RandomStringUtils.randomAlphabetic(5).concat("@test.com"));
//
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The password field is required.")));
//
//		
//	}
//
////error mentioned as excel is not coming in UI
//	@Test(priority = 10, enabled = true)
//	public void verifyErrorOnNumricPassword(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName(RandomStringUtils.randomAlphabetic(5));
//		registerPage.addEmail(RandomStringUtils.randomAlphabetic(5).concat("@test.com"));
//		registerPage.enterPassword(RandomStringUtils.randomNumeric(5));
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The g-recaptcha-response field is required.")));
//		
//	}
//
////error mentioned as excel is not coming in UI
//	@Test(priority = 11, enabled = true)
//	public void verifyErrorOnOnlyAlphabeticCharPassword(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName(RandomStringUtils.randomAlphabetic(5));
//		registerPage.addEmail(RandomStringUtils.randomAlphabetic(5).concat("@test.com"));
//		registerPage.enterPassword(RandomStringUtils.randomAlphabetic(5));
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The g-recaptcha-response field is required.")));
//
//		
//	}
//
//	// error mentioned as excel is not coming in UI
//	@Test(priority = 12, enabled = true)
//	public void verifyErrorOnOnlySplCharPassword(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName(RandomStringUtils.randomAlphabetic(5));
//		registerPage.addEmail(RandomStringUtils.randomAlphabetic(5).concat("@test.com"));
//		registerPage.enterPassword("!@#@$#^");
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The g-recaptcha-response field is required.")));
//		
//	}
//
//	@Test(priority = 13, enabled = true)
//	public void verifyErrorOnUnagreedTerms(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName(RandomStringUtils.randomAlphabetic(5));
//		registerPage.addEmail(RandomStringUtils.randomAlphabetic(5).concat("@test.com"));
//		registerPage.enterPassword(RandomStringUtils.randomAlphabetic(5));
//		registerPage.updateAgreement(false);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The agreement field is required.")));
//		
//	}
//
//	// error mentioned as excel is not coming in UI
//	@Test(priority = 14, enabled = true)
//	public void verifyErrorOnTestName(Method method) {
//		extentTest = extent.startTest(method.getName());
//		registerPage.addName("Test member");
//		registerPage.addEmail(RandomStringUtils.randomAlphabetic(5).concat("@test.com"));
//		registerPage.enterPassword(RandomStringUtils.randomAlphabetic(5));
//		registerPage.updateAgreement(true);
//		registerPage.submitForm();
//		System.out.println(registerPage.getErrorMessage());
//
//		assertThat("Error msg was not proper", registerPage.getErrorMessage().stream()
//				.anyMatch(msg -> msg.contains("Oh snap! The g-recaptcha-response field is required.")));
//	}

}
