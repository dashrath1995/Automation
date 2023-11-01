package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateTimesOfIndia 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://timesofindia.indiatimes.com/?from=mdr");
		List<WebElement> lnews = driver.findElements(By.xpath("//div[@class='atWBy Q6d5H grid_wrapper']/descendant::figure"));
		for(int i=0; i<lnews.size(); i++)
		{
			String text=lnews.get(i).getText();
			System.out.println(text);
		}
	}
}
