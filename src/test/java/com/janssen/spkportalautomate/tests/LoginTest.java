package com.janssen.spkportalautomate.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * Mary 11/09/2017s
 */
public class LoginTest {

	WebDriver driver;

	@Test(priority = 1)
	public void testLogin() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MBoreddy\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://janssenspeakerportal2.d2clients.com/login");
		WebElement emailInputLocator = driver.findElement(By.cssSelector("#email"));
		WebElement passwordInputLocator = driver.findElement(By.cssSelector("#password"));
		WebElement submitLogInButtonLocator = driver.findElement(By.cssSelector("#loginButton"));

		System.out.println("email locator     " + emailInputLocator);
		System.out.println("password locator     " + passwordInputLocator);

		emailInputLocator.sendKeys("Testmgarc204@ITS.JNJ.com");
		passwordInputLocator.sendKeys("Password1!");
		submitLogInButtonLocator.click();

	}

	@Test(priority = 2)
	public void testSelectBrand() throws Exception {

		SpeakerPortalUtil speakerPortalUtil = new SpeakerPortalUtil();
		speakerPortalUtil.customWait();
		WebElement brandsDropDown = driver.findElement(By.cssSelector("#brandsDropDown"));
		brandsDropDown.click();
		speakerPortalUtil.customWait();
		// brandsDropDown.visible() = 'Y'
		Select dropdown = new Select(brandsDropDown);
		dropdown.selectByIndex(1);

		driver.findElement(By.xpath(".//*[@id='dLabel']")).click();
		speakerPortalUtil.customWait();

	}

	@Test(priority = 3)
	public void testLogout() throws Exception {
		WebElement Logout = driver.findElement(By.linkText("Logout"));
		Logout.click();
	}

	@Test(priority = 4)
	public void exampleOfTestNgMaven() {
		System.out.println("Mary This is TestNG-Maven Example");
	}
}
