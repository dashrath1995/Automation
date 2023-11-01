package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UnAndPwEqual
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
		
		WebElement eTbox = driver.findElement(By.id("email"));
		int eHeight= eTbox.getSize().getHeight();
		int eWidth= eTbox.getSize().getWidth();
		System.out.println("eHeight:"+eHeight+" "+"eWidth:"+eWidth);

		WebElement pTbox = driver.findElement(By.id("pass"));
		int pHeight= pTbox.getSize().getHeight();
		int pWidth= pTbox.getSize().getWidth();
		System.out.println("pHeight:"+pHeight+" "+"pWidth:"+pWidth);
		
		if(eHeight==pHeight && eWidth==pWidth)
		{
			System.out.println("Height & Width is equal");
		}
		else
		{
			System.out.println("Not equal");
		}
	}
}
