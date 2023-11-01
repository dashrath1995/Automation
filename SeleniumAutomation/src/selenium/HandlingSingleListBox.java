package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingSingleListBox 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com");
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(3000);
		WebElement monthListBox = driver.findElement(By.id("month"));
		Select s=new Select(monthListBox);
		s.selectByIndex(0);
		Thread.sleep(3000);
		s.selectByValue("6");
		Thread.sleep(3000);
		s.selectByVisibleText("Nov");

	}
}
