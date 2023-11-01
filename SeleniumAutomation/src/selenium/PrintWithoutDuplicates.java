package selenium;

import java.util.HashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintWithoutDuplicates
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) 
	{
		WebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Me/Desktop/hotel.html");
		WebElement mrtList = driver.findElement(By.id("mtr"));
		Select s=new Select(mrtList);
		List<WebElement> allOptions = s.getOptions();
		HashSet< String> hs=new HashSet<String>();
		for(int i=0; i<allOptions.size(); i++)
		{
			String text = allOptions.get(i).getText();
			hs.add(text);
		}
		for(String options:hs)
		{
			System.out.println(options);
		}
		driver.close();
	}
}
