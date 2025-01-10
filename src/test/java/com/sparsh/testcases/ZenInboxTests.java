package com.sparsh.testcases;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentReporter;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;

public class ZenInboxTests {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@Test(dataProvider = "data-provider")
	public void testLoginWithValidCredentials(String username, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://staging.zeninbox.ai");

		WebElement usernameField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));

		WebElement passwordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));

		WebElement loginButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();

		wait.until(ExpectedConditions.titleContains("ZenInbox"));
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "ZenInbox");

	}

	@Test
	public void testLoginWithInvalidCredentials() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://staging.zeninbox.ai");
		WebElement usernameField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));

		WebElement passwordField = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));

		WebElement loginButton = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));

		usernameField.sendKeys("invalidUser@gmx.com");
		passwordField.sendKeys("wrongPassword123");
		loginButton.click();

		WebElement errorMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Invalid email or password')]")));
		Assert.assertTrue(errorMessage.isDisplayed());

	
	}

	@DataProvider(name = "data-provider")
	public Object[][] dpMethod() {
		return new Object[][] { 
			{ "jontyFergurson@gmx.com", "JT7_%eZ>AHV" },
			{ "anacooonda@outlook.co", "Testing1234" } 
		};
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
