package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BasePkg.C1_TestBase;
import Utils.commonUtils;

public class Activity3 extends C1_TestBase
{
	commonUtils CU = new commonUtils();
	int pro_value;
	static int total_sum=0;
	int val;

	public Activity3() throws InterruptedException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void switch2act3()
	{
		driver.findElement(By.xpath("//a[@class='open-sidebar open-sidebar-btn']")).click();
		driver.findElement(By.xpath("//span[@title='L5 Drag and drop (basic) Content only (word tokens) ']")).click();
		driver.findElement(By.xpath("//a[@aria-label='Close table of contents']")).click();
		
		
		//************Perform Activity****************
	}
	
	
	public void InsideActivity()
	{
		driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792941647");
		pro_value = CU.count_progressBar();
		System.out.println("Progress Bar Count is:" +pro_value);
	
	}
	
	public void perform_act() throws InterruptedException
	{
		System.out.println("Progress barssssss"+ pro_value);
		while(pro_value>0)
		{
			driver.switchTo().defaultContent();
			driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792941647");
			CU.count_placeholders();
			
			
			//val = CU.check_score();
			
			//pro_value--;
			
		}

		total_sum=total_sum+val;
		System.out.println("sum is:"+ total_sum);
	}
	
	
	
	
}
