package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintAllSelectedOptions 
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
		WebElement cpList = driver.findElement(By.id("cp"));
		Select s=new Select(cpList);
		 List<WebElement> fsOption = s.getAllSelectedOptions();
		int count = fsOption.size();
		for(int i=0; i<count; i++)
		{
			String text=fsOption.get(i).getText();
			System.out.println(text);
		}
		driver.close();
	}
}
