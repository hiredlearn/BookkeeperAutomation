package com.bookkeeper.testCases;

import java.lang.reflect.Method;

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
	public void setUp() throws InterruptedException {
		testUtil = new TestUtility();
		initialization();
		log.info("Application Launched Successfully");
		homepage = new Homepage();
		Thread.sleep(5000);
	}
	

	@Test(priority = 2, enabled = true)
	public void verifyAllListedAppsDisplayed(Method method) throws InterruptedException {
		extentTest = extent.startTest(method.getName());
		homepage.navigateToRegisterPage();
	}
}
