package org.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartmobilesAndPrice {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-popup-blocking");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebElement search = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		search.sendKeys("redmi mobile");
		WebElement sub = driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		sub.click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> mobileNames = driver.findElements(By.xpath("//div[@class='_4rR01T']"));

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		List<WebElement> mobilePrice = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		 if (mobileNames.isEmpty()) {
//	            System.out.println("The XPath is NOT valid or did not match any elements.");
//	        } else {
//	            System.out.println("The XPath is valid and matched " + mobileNames.size() + " element(s).");
//	        }
//		 
//		 if (mobilePrice.isEmpty()) {
//	            System.out.println("The XPath is NOT valid or did not match any elements.");
//	        } else {
//	            System.out.println("The XPath is valid and matched " + mobilePrice.size() + " element(s).");
//	        }

		Map<String, Integer> mobileMap = new HashMap<>();

		for (int i = 0; i < mobileNames.size(); i++) {
			String mobileName = mobileNames.get(i).getText();
			String priceText = mobilePrice.get(i).getText();
			int mobilePriceValue = Integer.parseInt(priceText.replaceAll("[^0-9]", ""));

			mobileMap.put(mobileName, mobilePriceValue);

		}

		for (Map.Entry<String, Integer> entry : mobileMap.entrySet()) {

			System.out.println(entry.getKey() + "=" + entry.getValue());

		}

		driver.quit();

	}

}
