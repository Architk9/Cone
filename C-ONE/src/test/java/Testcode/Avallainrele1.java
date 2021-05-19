package Testcode;
	 
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	 
	//import org.apache.logging.log4j.LogManager;
	//import org.apache.logging.log4j.Logger;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;
	 
	import java.util.List;
	 
	public class Avallainrele1 {
	    public WebDriver driver;
	    //afafaf


	    public WebDriverWait w;
	    public String booklink="";


	    int chk_correct_answers;
	    int sum=0;
	    String val;
	    int b;



	    @Test(priority=0)
	      public void login() throws InterruptedException, IOException 
	      {
	          System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Madhuri\\\\Drivers\\\\chromedriver_win32_ver88\\\\chromedriver.exe");
	          driver = new ChromeDriver();
/*
	          //Object Repository
	          Properties p = new Properties();
	          FileInputStream fi = new FileInputStream ("C:\\Users\\Brugu\\eclipse-workspace\\srujana\\Cambridge1\\src\\Testcode\\Objectrep");
	          p.load(fi);
*/
	          //launching the url
	          driver.get("https://www.cambridgeone.org");//received the value from repository
	          driver.manage().window().maximize();
	          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	          driver.findElement(By.xpath("//*[@id=\"onboarding-header-login-btn\"]")).click();

	          //wait until the user name is visible

	          w = new WebDriverWait(driver,20);
	          w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gigya-loginID-56269462240752180\"]")));
	 
	          //username and password
	          driver.findElement(By.xpath("//*[@id=\"gigya-loginID-56269462240752180\"]")).sendKeys("QATeacher1@cambridgedev.org");
	          driver.findElement(By.xpath("//*[@id=\"gigya-password-56383998600152700\"]")).sendKeys("IOCQATeacher1");

	          //click on login button
	          driver.findElement(By.xpath("//*[@id=\"gigya-login-form\"]/div[2]/div[1]/input")).click();

	        //wait until the bell icon is visible

	          //w = new WebDriverWait(driver,20);
	         // w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tippyDropdownMenuButton\"]/i")));

	         driver.findElement(By.xpath("/html/body/app/div[2]/teacher/dashboard/div[1]/div/main/div/div/div[2]/ul/li[2]")).click();
	      }
	      @Test(priority=1)
	      public void dashboard() throws InterruptedException, IOException 
	      {
/*
	          Properties p = new Properties();
	          FileInputStream fi = new FileInputStream ("C:\\Users\\Brugu\\eclipse-workspace\\srujana\\Cambridge1\\src\\Testcode\\Objectrep");
	          p.load(fi);
*/
	          //click on My library

	          driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	          System.out.println("2nd module");
	          driver.findElement(By.xpath("/html/body/app/div[2]/teacher/dashboard/div[1]/div/main/div/div/div[2]/ul/li[2]/a/span")).click();

	          //WebDriverWait w1 = new WebDriverWait(driver,10);

	          //w1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"bundleName1\"]")));


	          driver.findElement(By.xpath("//*[@id=\"bundleName1\"]")).sendKeys("QA Automation RDP 1");
	          driver.findElement(By.xpath("//*[@id=\"bundleName1\"]")).sendKeys(Keys.DOWN);
	          driver.findElement(By.xpath("//*[@id=\"bundleName1\"]")).sendKeys(Keys.DOWN);
	          driver.findElement(By.xpath("//*[@id=\"bundleName1\"]")).sendKeys(Keys.ENTER);

	          //selecting the book

	          driver.findElement(By.xpath("/html/body/app/div[2]/teacher/dashboard/div[1]/div/main/div/div/div[4]/div[3]/div[2]/div/div/div/a/p")).click();

	          driver.findElement(By.xpath("(//div[text()='Practice Extra'])[1]")).click();

	      }

	      @Test(priority=2)
	      public void openactivity() throws InterruptedException 
	      {
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         System.out.println("module 3");
	         w = new WebDriverWait(driver,20);
	         w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='brand-img']")));

	         //switch to the frame

	         driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792901467");

	        //validate progress bar 1

	         boolean prog = driver.findElement(By.xpath("//*[@id=\"activity-header\"]/ul")).isDisplayed();
	         if(prog==true)
	         {
	             System.out.println("The activity progress bar is in the first screen");
	         }
	         else
	         {
	             System.out.println("The activity progress bar is not in the first screen");
	         }

	         List<WebElement> ls = driver.findElements(By.xpath("//div[@class='place_holder']"));
	         System.out.println(ls.size()); 

	         driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[1]/div/p[2]/span[1]/div/div[2]/div")).click();//clicks on empty box1
	         driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[2]/div/div[1]/div[2]/div/div")).click();//clicks first ans
	         driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[1]/div/p[3]/span[1]/div/div[2]/div")).click();//clicks on empty box2
	         driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[2]/div/div[2]/div[2]/div/div")).click();//Clicks second ans
	         driver.switchTo().defaultContent();//switches back to default content
	         driver.findElement(By.xpath("//a[@title='Check']")).click();//clicks check


	         driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792901467");
	         List<WebElement> cnt = driver.findElements(By.xpath("//div[@class='check correct']"));
	         chk_correct_answers=cnt.size();
	         System.out.println("Total correcr answers are:"+chk_correct_answers );
	         if(cnt.size()==(ls.size()))
	         {
	         System.out.println("All answer are correct");
	         }
	         else if(cnt.size()<=ls.size() && cnt.size()>0)
	         {
	         System.out.println("Some answers are incorrect");
	         }
	         else
	         {
	         System.out.println("All Incorrect");
	         }
	 
	         driver.switchTo().defaultContent();
	 
	         driver.findElement(By.xpath("//a[@class='btn' and @title='Next']")).click();
	         sum=sum+cnt.size();
	         System.out.println("sum is:"+ sum);

	         int c=verifyscore();
	         System.out.println(c);

	         driver.findElement(By.cssSelector("a[title='REVIEW']")).click();//clicks review
	         driver.findElement(By.cssSelector("a[title='Next']")).click();//clicks next
	         driver.findElement(By.cssSelector("a[class='nextActivityBtn btn']")).click();//clicks next
	         driver.findElement(By.cssSelector("a[title=''Check']")).click();



	      }

	      public int verifyscore()
	        {
	        driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792901467");
	        val = driver.findElement(By.xpath("//div[@class='canvas-score-label']/strong")).getText();
	        driver.switchTo().defaultContent();
	        System.out.println("++++"+val);
	 
	 
	        b = Integer.valueOf(val);
	 
	        if(chk_correct_answers==b)
	        {
	        System.out.println("Both Values are equal");
	        }
	 
	        return b;
	        }



	    }


