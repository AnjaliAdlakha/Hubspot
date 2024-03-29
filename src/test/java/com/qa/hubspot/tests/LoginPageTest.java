package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.constants.Constants;
import com.qa.hubspot.listeners.pdfListener;
import com.qa.hubspot.pages.LoginPage;


@Listeners(pdfListener.class)

public class LoginPageTest {
	
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp() {
		
		basePage = new BasePage();
		
		prop = basePage.initialize_Properties();
		
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		
	}
	
		@Test(priority=1)
		public void verifyLoginPageTitleTest() {
			String title = loginPage.getLoginPageTitle();
			System.out.println("the login page title is:" + title);
	        Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
		}
		
	    @Test(priority=2)
		public void verifySignUpLinkTest() {
		     Assert.assertTrue(loginPage.verifySigupLinkDisplayed());
		}
	    @Test (priority=3)
		public void loginTestWithCorrectCredentialsTest() {
			
			loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));		
		}
		
		@Test (priority=4)
		public void loginTestWithInCorrectCredentialsTest() {
			loginPage.doLogin("test@ggg.com", "tete123");		
		}
	
		@AfterMethod
		public void tearDown() {
		
			driver.quit();
		}
		
		
		}
	
	


