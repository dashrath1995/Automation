package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseSpecificBrowser 
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
		String eTitle = driver.getTitle();
		System.out.println(eTitle);
		driver.findElement(By.xpath("//span[text()='Continue with Apple']")).click();
		Set<String> allWh = driver.getWindowHandles();
		for(String wh:allWh)
		{
			driver.switchTo().window(wh);
			String aTitle = driver.getTitle();
			if(aTitle.equals(eTitle))
			{
				driver.close();
			}
		}
	}
}
