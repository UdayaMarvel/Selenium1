package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("---headless");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html#google_vignette");

		driver.manage().window().maximize();

		List<WebElement> itable = driver.findElements(By.tagName("table"));

		for (int i = 0; i < itable.size(); i++) {
			WebElement selecttab = itable.get(i);
			WebElement tbody = selecttab.findElement(By.tagName("tbody"));

			List<WebElement> row = tbody.findElements(By.tagName("tr"));

			int targetRow = 0; 
			int targetColumn = 0;

			WebElement targetRowElement = row.get(targetRow);

			List<WebElement> cells = targetRowElement.findElements(By.tagName("th"));
			cells.addAll(targetRowElement.findElements(By.tagName("td")));

			WebElement targetCell = cells.get(targetColumn);
			String cellValue = targetCell.getText();

			System.out.println("Value at row " + targetRow + " and column " + targetColumn + ": " + cellValue);

			for (int j = 0; j < row.size(); j++) {
				WebElement irow = row.get(j);
				List<WebElement> heading = irow.findElements(By.tagName("th"));

				for (int k = 0; k < heading.size(); k++) {
					WebElement data = heading.get(k);
					String text1 = data.getText();
					System.out.println(text1);
				}
				List<WebElement> idata = irow.findElements(By.tagName("td"));

				for (int z = 0; z < idata.size(); z++) {
					WebElement last = idata.get(z);
					String text = last.getText();
					System.out.println(text);
//					if(text.equals("Canada")) {
//						System.out.println(text);
//					}

				}

			}

		}

	}
}
