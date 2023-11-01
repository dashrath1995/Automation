package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectListBox 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Me/Desktop/hotel.html");
		WebElement mtrList = driver.findElement(By.id("mtr"));
		Select s=new  Select(mtrList);
		s.selectByIndex(1);
		Thread.sleep(3000);
		s.selectByValue("v");
		Thread.sleep(3000);
		s.selectByVisibleText("idly");
		Thread.sleep(3000);
		s.deselectByIndex(2);
		Thread.sleep(3000);
		s.deselectByValue("i");
		Thread.sleep(3000);
		s.deselectByVisibleText("dosa");
		boolean status = s.isMultiple();
		System.out.println(status);
		driver.close();
	}
}
