package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingRightClick 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.vtiger.com");
		WebElement resources = driver.findElement(By.partialLinkText("Resources"));
		Actions a=new Actions(driver);
		a.moveToElement(resources).perform();
		driver.findElement(By.partialLinkText("Customers")).click();
		
	}
}
