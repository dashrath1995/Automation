package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VtigerOrganizations
{
	static
	{
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Organizations']/parent::td[@class='tabUnSelected']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		String newOrgName="IndianLion";
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(newOrgName);
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys("www.indianlion.com");
		driver.findElement(By.xpath("//input[@id='employees']")).sendKeys("10");
		WebElement industryListBox = driver.findElement(By.xpath("//select[@name='industry']"));
		Select s1=new Select(industryListBox);
		s1.selectByVisibleText("Electronics");
		WebElement industryType = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select s2=new Select(industryType);
		s2.selectByVisibleText("Customer");
		driver.findElement(By.xpath("//input[@value='T']")).click();
		driver.findElement(By.xpath("//input[@id='bill_city']")).sendKeys("Bengalore");
		String orgNo = driver.findElement(By.xpath("//input[@id='account_no']")).getText();
		System.out.println(orgNo);
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("+919876543210");
		driver.findElement(By.xpath("//input[@id='fax']")).sendKeys("+911234");
		driver.findElement(By.xpath("//input[@id='otherphone']")).sendKeys("+919988776655");
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
         
		if(newOrgName.isEmpty()||newOrgName.equals("IndianLion"))
		{
			Thread.sleep(3000);
			String alertText = driver.switchTo().alert().getText();
			System.out.println(alertText);
			driver.switchTo().alert().accept();		
		}
		else
		{
		String newOrgText = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		System.out.println(newOrgText+" "+"is successfully created");
		driver.findElement(By.xpath("//a[text()='Organizations']/parent::td[@class='tabSelected']")).click();
		Thread.sleep(5000);
		List<WebElement> orgList = driver.findElements(By.xpath("//span[@vtfieldname='accountname']/preceding-sibling::a"));
		int orgCount = orgList.size();
		System.out.println(orgCount);
		for(int i=0; i<orgCount; i++)
		{
			String orgText=orgList.get(i).getText();   
			System.out.println(orgText);
		}
		}
		driver.close();
		
	}	
} 

