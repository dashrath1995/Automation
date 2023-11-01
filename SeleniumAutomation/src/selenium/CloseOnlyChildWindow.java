package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseOnlyChildWindow
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://secure.indeed.com");
		driver.findElement(By.xpath("//span[text()='Continue with Google']")).click();
		driver.findElement(By.xpath("//span[text()='Continue with Apple']")).click();
		String pwh = driver.getWindowHandle();
		Thread.sleep(5000);
		Set<String> allWh = driver.getWindowHandles();
		for(String wh:allWh)
		{
			driver.switchTo().window(wh);	
			if(pwh.equals(wh))
			{
				
			}
			else
			{
				driver.close();
			}
		}
	}
}
