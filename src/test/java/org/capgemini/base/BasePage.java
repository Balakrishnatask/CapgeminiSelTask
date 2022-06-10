package org.capgemini.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public static File configFile;
	public static FileInputStream configFis;
	public static Properties configProp;

	public static void readConfigPropFile() {

		try {
			configFile = new File("../SelPomCucumFW/src/test/java/Config.properties");
			configFis = new FileInputStream(configFile);
			configProp = new Properties();
			configProp.load(configFis);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void invokeBrowserAndEnterUrl() {
		readConfigPropFile();

		String browser = configProp.getProperty("Browser");
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "../SelPomCucumFW/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "../SelPomCucumFW/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}

		String url = configProp.getProperty("baseUrl");

		driver.get(url);

	}

	public static void waitForElementClick(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	public static void waitForElement(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public static void click(By by) {
		WebElement ele = driver.findElement(by);
		//waitForElementClick(ele);

		if (ele.isDisplayed()) {
			ele.click();
			System.out.println("Clicked element ::" + by);
		} else {
			System.out.println("Unable to click Element ::" + by);
		}
	}

	public static void setText(By by, String data) {
		WebElement ele = driver.findElement(by);
		waitForElement(ele);

		if (ele.isDisplayed()) {
			//ele.clear();
			ele.sendKeys(data);
			System.out.println("Data Entered in input field ::" + by);
		} else {
			System.out.println("Unable to enter data in input field" + by);
		}
	}
	
	public static void enterTextUsingJSScript(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].value='100';", element);
	}
	
	
	
	public static void handleDropdown(By by, String data) {
		WebElement ele=driver.findElement(by);
		waitForElement(ele);
		if(ele.isDisplayed()) {
			Select select=new Select(ele);
			select.selectByVisibleText(data);
			System.out.println("Selected Dropdown option " + by);
		}else {
			System.out.println("Unable to Select dropdown option" + by);
		}
		
	}

}
