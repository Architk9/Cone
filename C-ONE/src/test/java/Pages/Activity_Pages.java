package Pages;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import BasePkg.C1_TestBase;
//import Login_Type.Login_Type_Verify;

public class Activity_Pages extends C1_TestBase
{
	boolean status= true;
	int bar_count=0;
	int b,k;
	int chk_correct_answers;
	int sum=0;
	
	public Activity_Pages() throws InterruptedException
	{
		//super();
	}
	
	public int validate_progbar()
	{
		driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792901467");
		List<WebElement> cnt_bars = driver.findElements(By.xpath("//ul[@class='progress-bar']/li"));
		System.out.println("Number of screens in this activity: " +cnt_bars.size());
		driver.switchTo().defaultContent();
		bar_count=cnt_bars.size();
		return bar_count;
		
	}
	
	public boolean default_settings() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		status = driver.findElement(By.xpath("//a[@class='btn green-btn']")).isDisplayed();
		System.out.println(status);
		return status;
	}
	
	
	/*
	public boolean num_act(int z)
	{
		driver.findElement(By.xpath("//i[@class='fa toc-arrow-btn mr-auto open-sidebar-btn fa-caret-down']")).click();
		//for(k=1;k<=6;k++)
		{
		driver.findElement(By.xpath("//div[@class='card-body']/a"+"[" + z + "]")).click();
		driver.findElement(By.xpath("//a[@class='ml-auto close-sidebar']")).click();
		//return true;
		}
		return true;
		
	}*/
		
/*
		List<WebElement> num_of_act = driver.findElements(By.xpath("//div[@class='card-body']/a"));
		System.out.println("Number of activity under dropdown: "+num_of_act.size() );
		for(k=1;k<=6;k++)
		driver.findElement(By.xpath("//div[@class='card-body']/a" +"[" + k + "]" )).click();
	}
	*/
	
	public int navi_units() throws InterruptedException
	{
		String val="";
		
		
		//String att_val = driver.findElement(By.xpath("//div[@class='container layout-01A']")).getAttribute(val);
		//if(att_val.equalsIgnoreCase("container layout-01A"))
		
		//List<WebElement> num_of_act = driver.findElements(By.xpath("//div[@class='card-body']/a"));
		//System.out.println("Number of activity under dropdown: "+num_of_act.size() );
		
			int bar_counts = validate_progbar();
			
			System.out.println("Bar count value: "+bar_counts);
				while(bar_counts>=1)
					{
					System.out.println("Inside Loops after bar count");
					driver.switchTo().defaultContent();
					driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792901467");
					//boolean act_type = driver.findElement(By.xpath("//div[@class='interaction om-text-gap package package-editable editor ic-speaking-and-recording drag-drop multiple-destinations status-input wordpool-bottom wordpool fixed-gaps']")).isDisplayed();
					//if(act_type)	
					List<WebElement> ls = driver.findElements(By.xpath("//div[@class='place_holder']"));
							System.out.println(ls.size());
							for(int i=1; i<=ls.size();i++)
								{
									Thread.sleep(1000);
					//++++++++Index value dynamically is getting passed like below line+++++++++++
									driver.findElement(By.xpath("//div[@class='pool ui-droppable']/div" +"[" + i + "]")).click();
								}
					
							driver.switchTo().defaultContent();
							boolean chk_btn=driver.findElement(By.xpath("//a[@class='btn green-btn']")).isDisplayed();
							if(chk_btn)
							{
								driver.findElement(By.xpath("//a[@class='btn green-btn']")).click();
								Thread.sleep(3000);
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
														
						}
					else {
							System.out.println("CHk again");
						 }
				
				
							bar_counts--;				
						}
		
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
			
			
			
			
			//Thread.sleep(3000);
			
			
		
		
				
				
		}
	
	
	public boolean review() throws InterruptedException
	{
		boolean review_button = driver.findElement(By.xpath("//a[@Title='REVIEW']")).isEnabled();	
		if(review_button)
			{
				driver.findElement(By.xpath("//a[@Title='REVIEW']")).click();
				for(int j=1; j<=1;j++)
				{
				int next = cnt_next();
				Assert.assertEquals(next, 2);
				driver.findElement(By.xpath("//a[@class='btn' and @title='Next']"+"[" + 2 + "]")).click();
				}
			return review_button;
			}
		
		else
		{
			System.out.println("You are either not on end screen or the Review button is not enable");
			return review_button;
		}
	}
	
	public int cnt_next()
	{
		List<WebElement> Next_buttons = driver.findElements(By.xpath("//div/a[@title='Next']"));
			if(Next_buttons.size()>1)
				{
					System.out.println("2 Next buttons are getting displayed which is Incorrect");
					return Next_buttons.size();
				}
			else
				{
					System.out.println("Only 1 Next button while reviewing");
					return Next_buttons.size();
				}
	}
	
	
	public boolean next_activity() throws InterruptedException
	{
		boolean nxt_act = driver.findElement(By.xpath("//a[@class='nextActivityBtn btn']")).isEnabled();
		if(nxt_act)
		{
			
			driver.findElement(By.xpath("//a[@class='nextActivityBtn btn']")).click();
			
		//	validate_progbar();
			//navi_units();
			
		}
		else
		{
			System.out.println("You are possibly on the last page");
		}
		return nxt_act;
		
	}
	

}


