package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingSingleListBoxDOB
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
		WebElement day = driver.findElement(By.id("day"));
		Select d=new Select(day);
		d.selectByValue("27");
		Thread.sleep(3000);
		WebElement month = driver.findElement(By.id("month"));
		Select m=new Select(month);
		m.selectByVisibleText("Jul");
		Thread.sleep(3000);
		WebElement year = driver.findElement(By.id("year"));
		Select y=new Select(year);
		y.selectByValue("1995");
	}
}
