package com.bookkeeper.testCases;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bookkeeper.pages.DashboardPage;
import com.bookkeeper.pages.Homepage;
import com.bookkeeper.pages.LoginPage;
import com.bookkeeper.pages.RegisterPage;
import com.bookkeeper.testBase.TestBase;
import com.bookkeeper.utils.TestUtility;

public class CustomerDashboardTest extends TestBase {
	Homepage homepage;
	LoginPage loginPage;
	RegisterPage registerPage;
	DashboardPage dashboardPage;
	TestUtility testUtil;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		testUtil = new TestUtility();
		initialization("customer");
		log.info("Application Launched Successfully");
		dashboardPage = new DashboardPage();
		dashboardPage.login();
	}

	@Test(priority = 1, enabled = true)
	public void verifySideNavOptions(Method method) {
		extentTest = extent.startTest(method.getName());
		List<String> expectLeftSideMenu = Arrays.asList("Invoices", "Payments");
		dashboardPage.getSideNavText();
		System.out.println(dashboardPage.getSideNavText());
		assertThat("some side nav items are missing", dashboardPage.getSideNavText().containsAll(expectLeftSideMenu));
	}

	@Test(priority = 2, enabled = true)
	public void verifyUserIsAbleToNavigateToInvoices(Method method) {
		extentTest = extent.startTest(method.getName());
		dashboardPage.navigateToSideMenuItem("Invoices");
		assertThat(driver.getTitle(), is(equalTo("Invoices - Max It")));
	}

	@Test(priority = 3, enabled = true)
	public void verifyUserIsAbleToNavigateToPayments(Method method) {
		extentTest = extent.startTest(method.getName());
		dashboardPage.navigateToSideMenuItem("Payments");
		assertThat(driver.getTitle(), is(equalTo("Payments - Max It")));
	}
}
