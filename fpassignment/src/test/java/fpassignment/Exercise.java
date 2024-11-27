package fpassignment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Exercise {
	@Test
	public void newmethod() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to the FitPeo Homepage
		String HomePage = "https://www.fitpeo.com/";
		driver.get(HomePage);

		// Navigate to the Revenue Calculator Page
		driver.get("https://fitpeo.com/revenue-calculator");

		// Scroll Down to the Slider section
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)");

		// Adjust the Slider
		WebElement Slider = driver.findElement(By.xpath(
				"//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(Slider, 94, 0).perform();

		// Update the Text Field
		action.click(driver.findElement(By.xpath("//input[@id=':R57alklff9da:']"))).keyDown(Keys.CONTROL).sendKeys("a")
				.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("560").build().perform();
		Thread.sleep(2000);

		// Select CPT Codes
		jse.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/label/span[1]/input")).click();
		driver.findElement(By.xpath("//div[@class='MuiBox-root css-1p19z09']//div[2]//label[1]//span[1]//input[1]"))
				.click();
		driver.findElement(By.xpath("//div[3]//label[1]//span[1]//input[1]")).click();
		jse.executeScript("window.scrollBy(0,250)");
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[8]/label/span[1]/input")).click();
		Thread.sleep(1000);

		// Validate Total Recurring Reimbursement
		jse.executeScript("window.scrollBy(0,-900)");
		action.click(driver.findElement(By.xpath("//input[@id=':R57alklff9da:']"))).keyDown(Keys.CONTROL).sendKeys("a")
				.keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys("820").build().perform();
		jse.executeScript("window.scrollBy(0,700)");
		Thread.sleep(3000);
		driver.quit();
	}
}
