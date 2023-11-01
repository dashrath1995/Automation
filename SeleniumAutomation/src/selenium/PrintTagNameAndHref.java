package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintTagNameAndHref 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/");
		String tagName= driver.findElement(By.xpath("//a[text()='Forgot your password?']")).getTagName();
		System.out.println(tagName);
		String value= driver.findElement(By.xpath("//a[text()='Forgot your password?']")).getAttribute("href");
		System.out.println(value);
		driver.close();
	}
}
