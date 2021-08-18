package com.bookkeeper.testCases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bookkeeper.pages.DashboardPage;
import com.bookkeeper.pages.Homepage;
import com.bookkeeper.pages.LoginPage;
import com.bookkeeper.pages.RegisterPage;
import com.bookkeeper.testBase.TestBase;
import com.bookkeeper.utils.TestUtility;

public class LoginTest extends TestBase {
	Homepage homepage;
	LoginPage loginPage;
	RegisterPage registerPage;
	DashboardPage dashboardPage;

	TestUtility testUtil;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws InterruptedException {
		testUtil = new TestUtility();
		initialization("admin");
		log.info("Application Launched Successfully");
		homepage = new Homepage();
		homepage.navigateToLoginPage();
	}

	@Test(priority = 1, enabled = true)
	public void verifyPageTitle(Method method) throws InterruptedException {
		extentTest = extent.startTest(method.getName());
		assertThat(driver.getTitle(), is(equalTo("Login - Akaunting")));
	}

}
