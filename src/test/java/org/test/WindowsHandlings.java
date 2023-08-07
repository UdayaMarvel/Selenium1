package org.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandlings {
	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();

		try {
			WebElement close = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
			close.click();

		} catch (Exception e) {

		}

		try {
			WebElement search = driver.findElement(By.xpath("//input[@class='_3704LK']")); // _3704LK // Pke_EE
			search.sendKeys("redmi mobiles");

		} catch (Exception e) {
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click(); // L0Z3Pu //_2iLD__

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		String window = driver.getWindowHandle();
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]")).click();
		driver.switchTo().window(window);
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[2]")).click();
		driver.switchTo().window(window);
		driver.findElement(By.xpath("(//div[@class='_4rR01T'])[3]")).click();
		driver.switchTo().window(window);

		Set<String> windows = driver.getWindowHandles();

		System.out.println(window);
		System.out.println(windows);

		List<String> l1 = new ArrayList<>(windows);

		driver.switchTo().window(l1.get(2));
		WebElement text = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
		String t1 = text.getText();
		System.out.println(t1);

//		for(String x:windows) {
//			if(!window.equals(x)) {
//			driver.switchTo().window(x);
//			 WebElement text = driver.findElement(By.xpath("//span[@class='B_NuCI']"));
//			String t1 = text.getText();
//			System.out.println(t1);
//			}
//		}

	}

}
