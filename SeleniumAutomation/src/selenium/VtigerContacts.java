package selenium;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VtigerContacts
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException 
	{

		WebDriver driver=new ChromeDriver(); //Open the browse
		driver.manage().window().maximize(); //Maximize the browser
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //Synchronization 
		driver.get("http://localhost:8888/"); //Go to URL
		driver.findElement(By.name("user_name")).sendKeys("admin"); // Enter the UN
		driver.findElement(By.name("user_password")).sendKeys("manager"); // Enter the PW
		driver.findElement(By.id("submitButton")).click(); //Click on Login Button
		driver.findElement(By.xpath("//a[text()='Contacts']/parent::td[@class='tabUnSelected']")).click(); //Click on Contacts tab
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click(); // Click on new Contacts button

		WebElement firstNameType = driver.findElement(By.xpath("//select[@name='salutationtype']")); 
		Select s=new Select(firstNameType);
		s.selectByVisibleText("Mr."); //Select first name type like Mr.
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Dashrath"); //First name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Pradhan"); //Last name
		
		
		//----------------------Handling Window pop-up---------------------------------------------------------------
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click(); //Click on organization window button
		String pwh = driver.getWindowHandle(); //holding "parent" window
		Set<String> allwh = driver.getWindowHandles(); // holding "parent and child" windows
		for(String cwh: allwh)
		{
			if(!(pwh.equals(cwh)))
			{
			driver.switchTo().window(cwh); // Going to child window
			driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys("IndianApple");
			driver.findElement(By.xpath("//input[@name='search']")).click();
			driver.findElement(By.xpath("//a[text()='IndianApple']")).click();
			}	
		}
		driver.switchTo().window(pwh);// Come back to parent window control(It is important)
		driver.findElement(By.id("title")).sendKeys("IndianFool");
		
		//----------------------------Handling Birthday Calendar pop-up---------------------------------------------------------------
		driver.findElement(By.xpath("//img[@id='jscal_trigger_birthday']")).click(); //Click on birth day calendar button
		String birthMonthYear="December, 2019";
		String bDay="10";
		while(true)
		{
			String monthYearText= driver.findElement(By.xpath("//div[@class='calendar'][1]/descendant::td[2]")).getText();
			if(monthYearText.equals(birthMonthYear))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//div[@class='calendar'][1]/descendant::tr[@class='headrow']/td[2]")).click();
			}
		}
		driver.findElement(By.xpath("//tr[@class='daysrow']/td[@class='day'and contains(text(),"+bDay+")]")).click();

      //----------------------------------Handling Start date Calendar pop-up-------------------------------------------
		driver.findElement(By.xpath("//img[@id='jscal_trigger_support_start_date']")).click(); //click on start date calendar button
		String startMonthYear="September, 2021";
		String sDay="10";
		while(true)
		{
			String monthYearText= driver.findElement(By.xpath("//div[@class='calendar'][2]/descendant::td[2]")).getText(); //current month year
			if(monthYearText.equals(startMonthYear))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//div[@class='calendar'][2]/descendant::tr[@class='headrow']/td[2]")).click();
			}
		}
		driver.findElement(By.xpath("//tr[@class='daysrow']/td[@class='day'and contains(text(),"+sDay+")]")).click();
		
		File f=new File("./data/photo.jpg");
		String absPath = f.getAbsolutePath();	
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(absPath);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
	}
}
