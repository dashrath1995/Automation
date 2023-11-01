package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintAllLinks
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int count = links.size();
		System.out.println(count);
		for(int i=0; i<count; i++)
		{
			String text = links.get(i).getText();
			System.out.println(text);
		}
		driver.close();

	}
}
