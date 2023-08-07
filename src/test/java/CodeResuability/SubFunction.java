package CodeResuability;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubFunction extends MainFunctions {
	public static void main(String[] args) {
		SubFunction.launch("https://www.facebook.com/");
		SubFunction.max();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));

//     	WebElement mail = driver.findElement(By.id("email"));
//     	email(mail, "daniel");
//     	WebElement password = driver.findElement(By.id("pass"));
//     	email(password,"dan");

		WebElement createacc = driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]"));
		wait.until(ExpectedConditions.elementToBeClickable(createacc));
		click(createacc);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[2]")));
		WebElement firstname = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		complete(firstname, "daniel");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[3]")));
		WebElement surname = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		complete(surname, "marian");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='text'])[4]")));
		WebElement mobnum = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		complete(mobnum, "9003414511");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='password'])[2]")));
		WebElement password = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		complete(password, "dan123");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='day']")));
		WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
		Select sc = new Select(day);
		sc.selectByVisibleText("8");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='month']")));
		WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
		Select sc1 = new Select(month);
		sc1.selectByVisibleText("Sep");

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='year']")));
		WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
		Select sc2 = new Select(year);
		sc2.selectByVisibleText("1997");

		WebElement gender = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
		click(gender);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[2]")));
		WebElement signup = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		click(signup);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='More options']")));
		WebElement option = driver.findElement(By.xpath("//div[@aria-label='More options']"));
		click(option);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Dark mode']")));
		WebElement darkmode = driver.findElement(By.xpath("//span[text()='Dark mode']"));
		click(darkmode);
		if (darkmode.isEnabled()) {
			System.out.println("Dark Mode is working finely ");
		} else {
			System.out.println("Dark Mode function is not working");
		}

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Download your information']")));
		WebElement download = driver.findElement(By.xpath("//span[text()='Download your information']"));
		click(download);
//		if(download.isEnabled()) {
//			System.out.println("Download your information is redirecting successfully");
//		}else {
//			System.out.println("Download your information is not redirecting successfully");
//		}

		SubFunction.back();

		WebElement logo = driver.findElement(By.xpath("//a[@aria-label='Facebook']"));
		String value = logo.getAttribute("aria-label");
		System.out.println(value);
		if (value.isEmpty()) {
			System.out.println("style is not available");
		} else {
			System.out.println("style available");
		}

		WebElement profile = driver
				.findElement(By.xpath("(//span[@class='x1lliihq x6ikm8r x10wlt62 x1n2onr6 xlyipyv xuxw1ft'])[1]"));
		String text = profile.getText();
		System.out.println(text);
		if (text.isEmpty()) {
			System.out.println("profile name not available");
		} else {
			System.out.println("profile name is available");
		}

		SubFunction.TakeScreenShot();
		SubFunction.quit();

	}

}
