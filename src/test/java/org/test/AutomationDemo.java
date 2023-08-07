package org.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationDemo {
	public static void main(String[] args) {
//		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\DANI\\eclipse-workspace\\AutomationTesting\\target");
		WebDriverManager.chromedriver();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.youtube.com/");

		String gc = driver.getCurrentUrl();
		System.out.println(gc);

		String gt = driver.getTitle();
		System.out.println(gt);

		driver.manage().window().maximize();
//		driver.manage().window().minimize();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.navigate().refresh();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.navigate().back();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		driver.navigate().forward();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.switchTo().newWindow(WindowType.TAB);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.close();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.quit();

	}

}
