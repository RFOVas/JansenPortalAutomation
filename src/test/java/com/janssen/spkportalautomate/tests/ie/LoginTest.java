package com.janssen.spkportalautomate.tests.ie;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.janssen.spkportalautomate.tests.SpeakerPortalUtil;

/**
 * Mary 11/09/2017s
 */
public class LoginTest {

	WebDriver driver;
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	
	private void setValue(WebElement element, String value) {
	    ((JavascriptExecutor)driver).executeScript("arguments[0].value = arguments[1]", element, value);
	}

	@Test(priority = 1)
	@Parameters(value = "broswerName")
	public void testLogin(@Optional("ie") String browser) throws Exception {
		loadDriver(browser);
		driver.get("https://janssenspeakerportal2.d2clients.com/login");
		WebElement emailInputLocator = driver.findElement(By.cssSelector("#email"));
		WebElement passwordInputLocator = driver.findElement(By.cssSelector("#password"));
		//WebElement submitLogInButtonLocator = driver.findElement(By.cssSelector("#loginButton"));

		System.out.println("email locator     " + emailInputLocator);
		System.out.println("password locator     " + passwordInputLocator);

		//emailInputLocator.sendKeys("Testmgarc204@ITS.JNJ.com");
		//passwordInputLocator.sendKeys("Password1!");
		
		/*
		 * https://stackoverflow.com/questions/3526361/firefoxdriver-how-to-disable-javascript-css-and-make-sendkeys-type-instantly
		 */
		setValue(emailInputLocator, "Testmgarc204@ITS.JNJ.com");
		setValue(passwordInputLocator, "Password1!");
		
		
		//submitLogInButtonLocator.click();
		
		WebElement submitLogInButtonLocator = driver.findElement(By.id("loginButton"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", submitLogInButtonLocator);

	}

	@SuppressWarnings({ "deprecation" })
	private void loadDriver(String broswer) throws InterruptedException {
		System.out.println("############################Driver Load Start####################################");

		if (broswer.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\MBoreddy\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (broswer.equalsIgnoreCase("ie")) {

			/*
			 * Make sure to set the IE zoom to 100% only
			 */

			/*
			 * Make sure the protected mode settings
			 * https://stackoverflow.com/questions/31134408/unable-to-find-
			 * element- on-closed-window-on-ie-11-with-selenium
			 */

			/*
			 * Make sure to use IE32 driver to solve sendKeys typing slow issue
			 */

			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
			capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

			System.setProperty("webdriver.ie.driver", "C:\\Users\\MBoreddy\\IEDriverServer.exe");
			driver = new InternetExplorerDriver(capability);
			driver.manage().window().maximize();
			// Thread.sleep(3000);

		}

		System.out.println("############################Driver Load End######################################");
	}

	@Test(priority = 2)
	public void testSelectBrand() throws Exception {

		SpeakerPortalUtil speakerPortalUtil = new SpeakerPortalUtil();
		speakerPortalUtil.customWait();
		
		//WebElement brandsDropDown = driver.findElement(By.cssSelector("#brandsDropDown"));
		//brandsDropDown.click();
		WebElement brandsDropDown = driver.findElement(By.id("brandsDropDown"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", brandsDropDown);
		
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
