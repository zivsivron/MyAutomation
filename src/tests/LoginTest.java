package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;


public class LoginTest extends BaseTest{

	@Test(priority=1, description="Test incorect login information")
	public void loginFailed() {
		//login failed
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("ziv", "123");

		//should test getting the right message
		String expected = "Sorry, either your username or password was incorrect";
		String actual = loginPage.getErrorMsg();
		Assert.assertEquals(actual, expected);
		driver.get("https://events.eply.com/login/index.aspx");
	}
/*
	@Test(priority=2, description="Test correct login information")
	public void loginSucceed() {
		driver.get("https://www.eply.com/login/index.aspx");
		//login succeed
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("shavit1986@gmail.com", "shavitdemo123");
		String expected = "Hello, Shavit";
		String actual = loginPage.loginValidation();
		Assert.assertEquals(actual, expected);
	}
	*/

}
