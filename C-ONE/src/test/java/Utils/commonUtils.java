package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import BasePkg.C1_TestBase;

public class commonUtils extends C1_TestBase
{
	
public commonUtils() throws InterruptedException {
		System.out.println("Utility Class");
		// TODO Auto-generated constructor stub
	}

int pBar_count;
int chk_score;
int total_sum;
static int vals;
List<WebElement> count_pBars;
List<WebElement> cnt;
List<WebElement> placeholder_list;

	
	public int count_progressBar()
	{
		List<WebElement> count_pBars = driver.findElements(By.xpath("//ul[@class='progress-bar']/li"));
		System.out.println("Number of screens in this activity: " +count_pBars.size());
		driver.switchTo().defaultContent();
		pBar_count=count_pBars.size();
		System.out.println("progress bar count is:" +pBar_count);
		return pBar_count;
		
	}
	
	public int count_placeholders() throws InterruptedException
	{
		placeholder_list = driver.findElements(By.xpath("//div[@class='place_holder']"));
		System.out.println("placeholder size"+placeholder_list.size());
			for(int j=1; j<=placeholder_list.size();j++)
			{
			boolean type = driver.findElement(By.xpath("//div[@class='drag_holder ui-droppable']")).isDisplayed();
			
				if(type)
				{
					Thread.sleep(1000);
					WebElement Sourcelocator = driver.findElement(By.xpath("//div[@class='pool ui-droppable']/div" +"[" + j + "]"));
					WebElement Target = driver.findElement(By.xpath("//div[@class='place_holder']"));
	//++++++++Index value dynamically is getting passed like below line+++++++++++
					Actions act = new Actions(driver);
					act.dragAndDrop(Sourcelocator, Target).build().perform();
					
					
					driver.switchTo().defaultContent();
					boolean ret = driver.findElement(By.xpath("//a[@class='btn green-btn']")).isDisplayed();
					if(ret)
					{	
					driver.findElement(By.xpath("//a[@class='btn green-btn']")).click();
					Thread.sleep(3000);
					driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792941647");
					System.out.println("Switching to scoring section");
					vals = check_score();
					System.out.println("Correct answers:"+ vals);
					}
					else
					{
						break;
					}
				
				break;
				
			}	
			else
			{
				System.out.println("Inside j=2 loop");
								
				boolean video_present = driver.findElement(By.xpath("//div[@class='video v_a_media with-fullscreen mediaPlayer--inactive']")).isDisplayed();
				if(video_present)
				{
					System.out.println("Video play");
					driver.findElement(By.xpath("//div[@class='video v_a_media with-fullscreen mediaPlayer--inactive']")).click(); 
					Thread.sleep(4000);
					driver.findElement(By.xpath("//div[@class='is-media-wrapper is-media-wrapper--centered']/following-sibling::div[@id='content-1']//div[@class='drop_area has_drag gap_match_gap_text_view']" +"[" + j + "]")).click();
				    WebElement wes = driver.findElement(By.xpath("//div[@class='is-media-wrapper is-media-wrapper--centered']/following-sibling::div[@id='content-1']//div[@class='drop_area has_drag gap_match_gap_text_view']/div[@class='drag_holder']/div[@class='drag_element gap_match_drag']" +"[" + j + "]"));
					
					JavascriptExecutor js = (JavascriptExecutor)driver;
			        js.executeScript("arguments[0].click();", wes);
				
				
				}
				else
					
				{
					System.out.println("Inside 3rd screen");
					driver.findElement(By.xpath("//div[@class='bottom-audio-controls']")).click();
					sourcetoken();
					sourcetokenwaudio();
					
				
				}
				
				
				driver.switchTo().defaultContent();
				boolean ret = driver.findElement(By.xpath("//a[@class='btn green-btn']")).isDisplayed();
						if(ret)
						{	
						driver.findElement(By.xpath("//a[@class='btn green-btn']")).click();
						Thread.sleep(3000);
						
						driver.switchTo().frame("iframe_1612792865068-1612792877156-1612792941647");
						
						System.out.println("Switching to scoring section");
						vals = check_score();
						
						System.out.println("value"+ vals);
						
						}
						else
						{
							System.out.println("Check Button is not available in this activity");
							break;
							
						}
			}
				break;
				
			}		
//		}
		return vals;
	}
	
	
	public void sourcetoken()
	{
		if(driver.findElement(By.xpath("//*[@class='drag_element gap_match_drag image-between-text'][contains(@data-model-id,'1618')]")).isDisplayed())
		{
			List<WebElement> lst = driver.findElements(By.xpath("//*[@class='drag_element gap_match_drag image-between-text'][contains(@data-model-id,'1618')]"));
			System.out.println("source token count is "+lst.size());
			for(int i=0;i<lst.size();i++)
			{
				lst.get(i).click();
			}
		}
		else
		{
			System.out.println("There is no tokens on the screen");
		}
	}
	
	
	public void sourcetokenwaudio()
	{
		if(driver.findElement(By.xpath("//*[@class='drag_element gap_match_drag'][contains(@data-model-id,'1618')][contains(@style,'min-width: 120px')]")).isDisplayed())
		{
			List<WebElement> lstwa = driver.findElements(By.xpath("//*[@class='drag_element gap_match_drag'][contains(@data-model-id,'1618')][contains(@style,'min-width: 120px')]"));
			System.out.println("source audio token count is "+lstwa.size());

			for(int z=0;z<lstwa.size();z++)
			{
				lstwa.get(z).click();
			}
			WebElement lstwa1 = driver.findElement(By.xpath("//*[@class='drag_element gap_match_drag'][contains(@data-model-id,'1618')][contains(@style,'min-width: 120px')]"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", lstwa1);
		}
		else
		{
			System.out.println("There is no audio tokens on the screen");
		}
	}
	
	public int check_score()
	{
		
		
			cnt = driver.findElements(By.xpath("//div[@class='check correct']"));
			chk_score=cnt.size();
			System.out.println("Total correcr answers are:"+chk_score );
			if(cnt.size()==(placeholder_list.size()))
			{
				System.out.println("All answer are correct");
			}
			else if(cnt.size()<=placeholder_list.size() && cnt.size()>0)
			{
				System.out.println("Some answers are incorrect");
			}
		else
		{
			System.out.println("All Incorrect");
		}
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//a[@class='btn' and @title='Next']")).click();
		
		return cnt.size();
	}
		



}
	

