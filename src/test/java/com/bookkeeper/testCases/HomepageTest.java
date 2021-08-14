package com.bookkeeper.testCases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
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

public class HomepageTest extends TestBase {
	Homepage homepage;
	LoginPage loginPage;
	RegisterPage registerPage;
	DashboardPage dashboardPage;

	TestUtility testUtil;

	@BeforeClass(alwaysRun = true)
	public void setUp(){
		testUtil = new TestUtility();
		initialization();
		log.info("Application Launched Successfully");
		homepage = new Homepage();
	}

	@Test(priority = 1, enabled = true)
	public void verifyPageTitle(Method method) {
		extentTest = extent.startTest(method.getName());
		assertThat(driver.getTitle(), is(equalTo("Free Accounting Software - Akaunting")));
	}

	@Test(priority = 2, enabled = true)
	public void verifyDropdownOptionsDisplayed(Method method) {
		extentTest = extent.startTest(method.getName());
		homepage.clickOnProfileIcon();
		assertThat("dropdown not displayed", homepage.verifyDropdownDisplayed());
	}

	@Test(priority = 3, enabled = true)
	public void verifyAllDropdownOptionsDisplayed(Method method) {
		extentTest = extent.startTest(method.getName());
//		homepage.reloadPage();
//		homepage.clickOnProfileIcon();
		assertThat(homepage.getDropdownList(), hasItems(new String[] { "Login", "Register" }));
	}

}
