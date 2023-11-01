package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IccCricketAutomate 
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/womens/team-rankings/odi");
		String headText = driver.findElement(By.xpath("//tr[@class='table-head']")).getText();
		System.out.println(headText);
		List<WebElement> iccList = driver.findElements(By.xpath("//tr[@class='table-body']"));
		int count=iccList.size();
		for(int i=0; i<count; i++)
		{
			String text=iccList.get(i).getText();
			System.out.println(text);
		}
		driver.close();
	}

}
