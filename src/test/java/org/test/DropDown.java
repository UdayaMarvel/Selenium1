package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");

		driver.manage().window().maximize();

		WebElement drop = driver.findElement(By.xpath("//select[@id='first']"));

		Select sec = new Select(drop);
		sec.selectByIndex(2);
		sec.selectByValue("Yahoo");
		sec.selectByVisibleText("Google");
		boolean multi = sec.isMultiple();
		System.out.println(multi);

		List<WebElement> list = sec.getOptions();

		for (WebElement x : list) {
			System.out.println(x.getText());
		}

		WebElement multidrop = driver.findElement(By.xpath("//select[@id='second']"));
		Select sec1 = new Select(multidrop);
		sec1.selectByIndex(1);
		sec1.selectByIndex(2);
		sec1.selectByIndex(3);
		sec1.deselectByIndex(2);

		boolean multi1 = sec1.isMultiple();
		System.out.println(multi1);

		List<WebElement> list1 = sec1.getOptions();

		for (WebElement x : list1) {
			System.out.println(x.getText());
		}
		
		WebElement first = sec1.getFirstSelectedOption();
		System.out.println(first.getText());
		
		List<WebElement> all = sec1.getAllSelectedOptions();
		for(WebElement x:all) {
			System.out.println(x.getText());
		}
//		for(int i=0;i<list.size();i++) {
//			WebElement text = list.get(i);
//			String t1 = text.getText();
//			System.out.println(t1);
//		}

//		WebElement cl = driver.findElement(By.xpath("//option[text()='Iphone']"));
//		cl.click();
	}

}
