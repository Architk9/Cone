//changes in act 2
package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import BasePkg.C1_TestBase;

public class Act2s extends C1_TestBase
{
	//int tok_cnt;
	int chks_correct_answers;
	int sums;
	String vals;
	int b;
	List<WebElement> ls1;
	public Act2s() throws InterruptedException
	{
		System.out.println("2nd Activity");
	}

	
	public void Act2s() throws InterruptedException
    {
        String title=driver.findElement(By.cssSelector("a[class='open-sidebar open-sidebar-btn']")).getText();//gets text of LO
        System.out.println(title);
        boolean t=driver.findElement(By.cssSelector("a[class='open-sidebar open-sidebar-btn']")).isDisplayed();//rubric is present
        System.out.println(t);
       
        if(t)//if progress bar is present
        {
        driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792924161");// switches to frame;
        String rubric=driver.findElement(By.cssSelector("li[class='step current']")).getText();
        System.out.println(rubric);
       
        boolean a=driver.findElement(By.cssSelector("div[id='attachments']")).isDisplayed();
        String att=driver.findElement(By.cssSelector("div[id='attachments']")).getText();
        System.out.println(att);
        System.out.println(a);
            if(a)
            {
                driver.findElement(By.cssSelector("div[id='attachments']")).click();//clicks attachments
                Thread.sleep(5000);
                driver.findElement(By.cssSelector("div[id='attachments']")).click();
            }
            else
            {
                System.out.println("attachments not displayed");
            }
        }
        else
        {
            System.out.println("title not displayed");
        }
        
      //  int rt =  verify_audiotokens();
      // 	Assert.assertEquals(rt, 4);
        
        String f_rubric=driver.findElement(By.cssSelector("div[class='rubricWrap']")).getText();//frame rubric
        boolean fr=driver.findElement(By.cssSelector("div[class='rubricWrap']")).isDisplayed();
        if(fr)
        {
        //driver.findElement(By.xpath("[@class='drag_holder']")).click();
        ls1 = driver.findElements(By.xpath("//div[@class='place_holder']"));
        driver.findElement(By.cssSelector("div[class='place_holder']")).click();
        
        driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[2]/div/div[1]/div[2]/div/div/div")).click();//plays audio
        Thread.sleep(8000);
       // driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[2]/div/div[1]")).click();
        	   
       

        
        Dimension audiobox=driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[2]/div/div[1]")).getSize();
        System.out.println(audiobox);
        //clicks the answer
        WebElement we=driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[2]/div/div[1]/div[2]/div/div"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", we);
       
       
        
       
        }
        else
        {
            System.out.println("rubric not displayed");
        }
       
        driver.switchTo().defaultContent();
        
      //*************************************************************  
        boolean chk_btn=driver.findElement(By.xpath("//a[@class='btn green-btn']")).isDisplayed();
		if(chk_btn)
		{
			driver.findElement(By.xpath("//a[@class='btn green-btn']")).click();
			Thread.sleep(3000);
			driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792924161");
			List<WebElement> cnt = driver.findElements(By.xpath("//div[@class='check correct']"));
			chks_correct_answers=cnt.size();
			System.out.println("Total correcr answers are:"+chks_correct_answers );
			if(cnt.size()==(ls1.size()))
			{
				System.out.println("All answer are correct");
			}
			else if(cnt.size()<=ls1.size() && cnt.size()>0)
			{
				System.out.println("Some answers are incorrect");
			}
		else
		{
			System.out.println("All Incorrect");
		}
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[@class='btn' and @title='Next']")).click();
		sums=sums+cnt.size();
		System.out.println("sum is:"+ sums);
									
	}
else {
		System.out.println("CHk again");
	 }


        
      //  driver.findElement(By.cssSelector("a[title='Next']")).click();
        
        
        driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792924161");
		vals = driver.findElement(By.xpath("//div[@class='canvas-score-label']/strong")).getText();
		driver.switchTo().defaultContent();
		System.out.println("++++"+vals);

		b = Integer.valueOf(vals);
	
		if(chks_correct_answers==b)
		{
			System.out.println("Both Values are equal");
		}
		

        
        driver.findElement(By.cssSelector("a[title='REVIEW']")).click();
        //driver.findElement(By.cssSelector("a[title='Next']")).click();
    }	
	
	
	
}
