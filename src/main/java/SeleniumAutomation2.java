//==================SOURCE CODE==============================//
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAutomation2 {
	public static void main(String[] args) throws IOException {
		automate();
	}
	public static void automate() throws IOException {
		int count=1;
		System.setProperty("webdriver.chrome.driver", "A:\\SELENIUM\\chromedriver.exe");
		WebDriver webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		
		webDriver.get("https://www.saucedemo.com/");
		
		WebElement eleByCssId = webDriver.findElement(By.cssSelector("#user-name"));
		eleByCssId.sendKeys("standard_user");
		
		WebElement eleByCssAttribute = webDriver.findElement(By.cssSelector("input[name=password]"));
		eleByCssAttribute.sendKeys("secret_sauce");
		takeScreenshot(webDriver, count++);
		WebElement eleByCssClass = webDriver.findElement(By.cssSelector("input.submit-button"));
		eleByCssClass.click();
		takeScreenshot(webDriver, count++);
		WebElement eleByAbsXpath = webDriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[3]/div[2]/div[1]/a/div"));
		takeScreenshot(webDriver, count++);
		eleByAbsXpath.click();
		
		WebElement eleByRelXpath = webDriver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-bolt-t-shirt\"]"));
		takeScreenshot(webDriver, count++);
		eleByRelXpath.click();
		
		webDriver.close();
	}
	public static void takeScreenshot(WebDriver wd, int number) throws IOException {
		File file = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("C:\\Users\\aksh1\\Documents\\workspace-spring-tool-suite-4-4.18.0.RELEASE\\SELENIUM-DEMO\\src\\images\\img_"+number+".png"));
	}
}

