package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import BasePkg.C1_TestBase;

public class Activity2 extends C1_TestBase
{
	public Activity2() throws InterruptedException
	{
		System.out.println("2nd Activity");
	}

	public void Activity2s() throws InterruptedException
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
        String f_rubric=driver.findElement(By.cssSelector("div[class='rubricWrap']")).getText();//frame rubric
        boolean fr=driver.findElement(By.cssSelector("div[class='rubricWrap']")).isDisplayed();
        if(fr)
        {
        //driver.findElement(By.xpath("[@class='drag_holder']")).click();
        driver.findElement(By.cssSelector("div[class='place_holder']")).click();
        driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[2]/div/div[1]/div[2]/div/div/div")).click();//plays audio
        Thread.sleep(8000);
        driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[2]/div/div[1]")).click();
        Dimension audiobox=driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[2]/div/div[1]")).getSize();
        System.out.println(audiobox);
        //clicks the answer
        WebElement we=driver.findElement(By.xpath("//*[@id=\"content-0\"]/div/div/div/div[2]/div/div[1]/div[2]/div/div"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", we);
       
       
        /*Screen s = new Screen();
        if(s.exists("C:\\Users\\sgattu\\audioicon.png")!=null)
        {
            s.click("C:\\Users\\sgattu\\audioicon.png");
        }
        s.click("C:\\Users\\sgattu\\audioedgeclick.png");
        s.mouseMove(500,500);*/
       
        }
        else
        {
            System.out.println("rubric not displayed");
        }
       
        driver.switchTo().defaultContent();
        driver.findElement(By.cssSelector("a[title='Check']")).click();
        driver.findElement(By.cssSelector("a[title='Next']")).click();
        driver.findElement(By.cssSelector("a[title='REVIEW']")).click();
        driver.findElement(By.cssSelector("a[title='Next']")).click();
    }	
	
}
