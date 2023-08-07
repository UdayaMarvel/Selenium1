package org.test;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MethodOverridingRealTimeEx {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Browser Name:  ");
		String browser = sc.nextLine();

		WebDriver driver = null;

		if (browser.equals("chrome")) {

			System.setProperty("Webdriver.chrome.driver",
					"C:\\Users\\DANI\\eclipse-workspace\\AutomationTesting\\target");

			driver = new ChromeDriver();

			driver.get("https://www.facebook.com/");
		} else if (browser.equals("edge")) {

			System.setProperty("Webdriver.edge.driver",
					"C:\\Users\\DANI\\eclipse-workspace\\AutomationTesting\\target");

			driver = new EdgeDriver();

			driver.get("https://www.facebook.com/");
		} else if (browser.equals("firefox")) {

			System.setProperty("Webdriver.firefox.driver",
					"C:\\Users\\DANI\\eclipse-workspace\\AutomationTesting\\target");

			driver = new FirefoxDriver();

			driver.get("https://www.facebook.com/");
		} else {
			System.out.println("Invalid browser name");
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		driver.close();
		sc.close();

	}

}
