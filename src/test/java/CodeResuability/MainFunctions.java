package CodeResuability;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MainFunctions {
	static WebDriver driver;

	public static void launch(String URL) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(URL);

	}

	public static void max() {
		driver.manage().window().maximize();
	}

	public static void complete(WebElement w, String str) {
		w.sendKeys(str);
	}

	public static void click(WebElement w) {
		w.click();
	}

	public static void back() {
		driver.navigate().back();
	}

	public static void TakeScreenShot() {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		File f = new File(
				"C:\\Users\\DANI\\eclipse-workspace\\AutomationTesting\\target\\ScreenshotFacebookSignUp1.png");
		try {
			FileUtils.copyFile(screenshot, f);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void quit() {
		driver.quit();
	}
}
