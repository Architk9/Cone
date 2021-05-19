//its a base class
package BasePkg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

//import Login_Type.Login_Type_Verify;

public class C1_TestBase 
{
	public static WebDriver driver;
	Login_Type.Login_Type_Verify lp;
	
	public C1_TestBase() throws InterruptedException
	{
		System.out.println("Base Class Constructor called");
	
	}
	
	
	}



