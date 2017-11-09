package com.janssen.tests.SpkPortalAutomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * Mary 11/08/2017
 */
public class Login {

	@Test
	public void testLogin() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MBoreddy\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://janssenspeakerportal2.d2clients.com/login");
		WebElement emailInputLocator = driver.findElement(By.cssSelector("#email"));
		WebElement passwordInputLocator = driver.findElement(By.cssSelector("#password"));
		WebElement submitLogInButtonLocator = driver.findElement(By.cssSelector("#loginButton"));

		System.out.println("email locator     " + emailInputLocator);
		System.out.println("password locator     " + passwordInputLocator);

		emailInputLocator.sendKeys("Testmgarc204@ITS.JNJ.com");
		passwordInputLocator.sendKeys("Password1!");
		submitLogInButtonLocator.click();

		Thread.sleep(2000);
		WebElement brandsDropDown = driver.findElement(By.cssSelector("#brandsDropDown"));
		brandsDropDown.click();
		Thread.sleep(1000);
		// brandsDropDown.visible() = 'Y'
		Select dropdown = new Select(brandsDropDown);
		dropdown.selectByIndex(1);

		driver.findElement(By.xpath(".//*[@id='dLabel']")).click();
		Thread.sleep(1000);

		WebElement Logout = driver.findElement(By.linkText("Logout"));
		Logout.click();
	}

	@Test
	public void exampleOfTestNgMaven() {
		System.out.println("Mary This is TestNG-Maven Example");
	}
}
