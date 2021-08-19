package com.bookkeeper.testCases;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.bookkeeper.pages.DashboardPage;
import com.bookkeeper.pages.Homepage;
import com.bookkeeper.pages.LoginPage;
import com.bookkeeper.pages.RegisterPage;
import com.bookkeeper.testBase.TestBase;
import com.bookkeeper.utils.TestUtility;

public class BookkeeperDashboardTest extends TestBase {
	Homepage homepage;
	LoginPage loginPage;
	RegisterPage registerPage;
	DashboardPage dashboardPage;
	TestUtility testUtil;

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		testUtil = new TestUtility();
		initialization("bookkeeper");
		log.info("Application Launched Successfully");
		dashboardPage = new DashboardPage();
		dashboardPage.login();
	}
//captcha is involved, hence commenting
//	@Test(priority = 1, enabled = false)
//	public void verifyUserIsAbleToLoginToDashboard(Method method) {
//		extentTest = extent.startTest(method.getName());
//		dashboardPage = homepage.navigateToDashboardPage("Max iT 2");
//		assertThat(driver.getTitle(), is(equalTo("Free Accounting Software - Akaunting")));
//	}

	@Test(priority = 2, enabled = true)
	public void verifyAvailableRoles(Method method) {
		extentTest = extent.startTest(method.getName());
		List<String> expectRoles = Arrays.asList("Customer", "Manager", "Client");
		System.out.println(dashboardPage.getRoles());
		assertThat("some side nav items are missing", dashboardPage.getRoles().containsAll(expectRoles));
	}

	@Test(priority = 3, enabled = true)
	public void verifyLogOut(Method method) {
		extentTest = extent.startTest(method.getName());
		dashboardPage.profileDropDown("Logout");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertThat(driver.getTitle(), is(equalTo("Login")));
	}

}
