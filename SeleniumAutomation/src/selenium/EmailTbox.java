package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EmailTbox 
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
		int eTbox1 = driver.findElement(By.id("email")).getLocation().getX();
		int eTbox2 = driver.findElement(By.id("email")).getLocation().getY();
		System.out.println("EmailTbox:"+ eTbox1+ " "+eTbox2);
		driver.close();
	}
}
