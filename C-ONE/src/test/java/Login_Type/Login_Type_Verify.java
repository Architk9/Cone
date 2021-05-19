package Login_Type;




import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasePkg.C1_TestBase;
import Pages.Act2s;
import Pages.Activity2;
import Pages.Activity3;
import Pages.Activity_Pages;

public class Login_Type_Verify extends C1_TestBase
{
	
	
	public static Activity_Pages AP;
	C1_TestBase base = new C1_TestBase();
	Activity_Pages ap = new Activity_Pages();
	Act2s a2 = new Act2s();
	Activity3 act3 = new Activity3();
	//Activity2 a = new Activity2();
	//C1_TestBase bs = new C1_TestBase();
	public Login_Type_Verify() throws InterruptedException
	{
		//super();
		
	}
	
	@Parameters({"browser"})
	@BeforeTest
	public void conti(String str) throws InterruptedException {
		//browser(str);
		if (str.equalsIgnoreCase("EDGE")) 
		{ 
			System.out.println("Edge Browser Opens");
			
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Madhuri\\Drivers\\edgedriver_win64_ver89\\msedgedriver.exe");
			driver =new EdgeDriver();
			
		
	}
	
		else if(str.equalsIgnoreCase("chrome")) 
		{ 

			System.out.println("Chrome driver opens");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Madhuri\\Drivers\\chromedriver_win32_ver88\\chromedriver.exe");
			driver = new ChromeDriver();		
			}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.cambridgeone.org/");
		driver.findElement(By.xpath("//a[@id='onboarding-header-login-btn']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-white-bg accept-btn']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Enter your email address *']")).sendKeys("QATeacher1@cambridgedev.org");
		driver.findElement(By.xpath("//input[@placeholder='Enter your password *']")).sendKeys("IOCQATeacher1");
		driver.findElement(By.xpath("//input[@value='Log in']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='dashboard-menu']/ul/li[2]")).click();
		driver.findElement(By.xpath("//input[@id='bundleName1']")).sendKeys("QA Automation RDP 1");
		driver.findElement(By.xpath("//div[@class='no-image-container']")).click();
		driver.findElement(By.xpath("//a[@qid='pView-3-0']")).click();



				}
	
	

	@Test(priority=0)
	public void progress_bar() throws InterruptedException
		{
		//init();
		ap.validate_progbar();
		}
	
	
	
	@Test(priority=1)
	public void defaultchecks() throws InterruptedException
	{

		
		boolean catchs = ap.default_settings();
		System.out.println("Default Value is: " +catchs);
		Assert.assertEquals(catchs, false);
		
	}
	
	@Test(priority=2)
	public void UnitWise() throws InterruptedException
	{
	
		
		
		int result = ap.navi_units();
		System.out.println("Returning Results"+ result);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(result, 0, "Scored Nothing");
		sa.assertEquals(result, 1, "Scored 1");
		sa.assertEquals(result, 2, "Scored 2");
		
		
		
	}
	
	
	@Test(priority=3)
	public void review_screens() throws InterruptedException
	{
		//ap.review();
		boolean review_result = ap.review();
		Assert.assertEquals(review_result, true);
		
	}
	@Test(priority=4)
	public void New_Acti_btn() throws InterruptedException
	{
		Assert.assertEquals(ap.next_activity(), true);
		
	}
	
	@Test(priority=5)
	public void Act2() throws InterruptedException
	{

		a2.Act2s();
		
	}
	
	@Test(priority=6)
	public void Act3() throws InterruptedException
	{

		act3.switch2act3();
		act3.InsideActivity();
		act3.perform_act();
		
	}

	
	@AfterTest()
	public void close()
	{
		System.out.println("close");
		//driver.close();
	}
		
/*
	@Test(priority=5)
	public void call_num_act()
	{
		ap.num_act();
	}*/
}

