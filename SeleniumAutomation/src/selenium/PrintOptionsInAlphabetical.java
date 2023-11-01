package selenium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintOptionsInAlphabetical 
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
		WebElement mtrListbox = driver.findElement(By.id("mtr"));
		Select s=new Select(mtrListbox);
		List<WebElement> allOtions = s.getOptions();
		ArrayList<String> al=new ArrayList<String>();
		for(int i=0; i<allOtions.size(); i++)
		{
			String text = allOtions.get(i).getText();
			al.add(text);
		}
		Collections.sort(al);
		for(String options:al)
		{
			System.out.println(options);
		}
		driver.close();
	}
}
