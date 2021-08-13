package com.bookkeeper.testCases;

import java.lang.reflect.Method;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
		initialization();
		log.info("Application Launched Successfully");
		homepage = new Homepage();
		Thread.sleep(5000);
	}

	@Test(priority = 1, enabled = true)
	public void verifyPerformLogin(Method method) {
		extentTest = extent.startTest(method.getName());
		homepage.navigateToLoginPage();
		
	}


	@DataProvider(name = "loginData")
	public String[][] getDataFromDataprovider() {
		return TestUtility.getTestData("Login");
	}

}
