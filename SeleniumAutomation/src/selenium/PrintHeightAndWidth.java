package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintHeightAndWidth 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https:www.facebook.com");
		WebElement emailTbox = driver.findElement(By.id("email"));
		int height = emailTbox.getSize().getHeight();
		int width = emailTbox.getSize().getWidth();
		System.out.println("height:"+height+" "+"width:"+width);
		driver.close();
	}
}
