package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class AbstarctTest {

	protected WebDriver driver;
	@BeforeTest
	public void setDriver() {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}

	@AfterTest
	public void quiteDriver() {
		this.driver.quit();
	}
}
