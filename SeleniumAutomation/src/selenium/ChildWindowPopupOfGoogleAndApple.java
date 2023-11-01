package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChildWindowPopupOfGoogleAndApple
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
		Thread.sleep(7000);
		driver.findElement(By.xpath("//span[text()='Continue with Apple']")).click();
		Set<String> allWh = driver.getWindowHandles();
		int count =allWh.size();
		System.out.println(count);
		for(String wh:allWh)
		{
			driver.switchTo().window(wh);
			System.out.println(wh);
			Thread.sleep(5000);
			driver.close();
		}

	}
}
