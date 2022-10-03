package com.qa.bridzelabz;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Chrome_And_Edge_Parallel_Test {

	static {
		System.setProperty("webdriver.edge.driver","C:\\Users\\hp\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
	}
	WebDriver driver;

	@Test
	@Parameters("browser")
	public void browserSetup(String browserName) throws InterruptedException {

		if (browserName.equals("msedge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		Properties prop = new Properties();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement un = driver.findElement(By.xpath("//input[@id='email']"));
		for (int i = 0; i < 10; i++) {
			un.sendKeys("872200444" + i);

			Thread.sleep(2000);
			un.clear();
		}
		driver.close();
	}

}
