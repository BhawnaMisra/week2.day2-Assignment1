package week2.day2;

import java.time.Duration;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LeafGround {
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/input.xhtml");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Type your name
		driver.findElement(By.xpath("(//div[@class='col-12']/input[1])")).sendKeys("Bhawna");
		
		//Append Country to this City    //div[@class='col-12']/input[2]
		driver.findElement(By.xpath("(//div[@class='col-12']/input)[2]")).sendKeys("Delhi");
		
		//Verify if text box is disabled
		
		boolean disabled = driver.findElement(By.xpath("(//div[@class='col-12']/input)[3]")).isDisplayed();
		System.out.println(disabled);
		
		
		//clear method is not working 
		driver.findElement(By.xpath("(//div[@class='col-12']/input)[4]")).clear();
		
		//Retrieve the typed text
		String text = driver.findElement(By.xpath("(//div[@class='col-12']/input)[5]")).getAttribute("Value");
		System.out.println(text);
		
		//6. Type email and Tab. Confirm control moved to next element
		WebElement tabkey = driver.findElement(By.xpath("(//div[@class='col-12']/input)[6]"));
		tabkey.sendKeys("ABCc@gmail.com");
		tabkey.sendKeys(Keys.TAB);
		
		
		
		Point moveToElement = driver.findElement(By.xpath("(//div[@class='col-12']/input)[6]")).getLocation();
		System.out.println(moveToElement);
		
		//7. Type about yourself
		driver.findElement(By.xpath("(//div[@class='col-12']/textarea)")).sendKeys("Hello I am learning Selenium");
		
		//8. Text Editor -- do not know what to do so leavimg right now
		
		//9. Just Press Enter and confirm error message*
		driver.findElement(By.xpath("((//div[@class='grid formgrid'])/div/input)[7]")).sendKeys(Keys.ENTER);
		WebElement errorMessage = driver.findElement(By.xpath("//span[@class='ui-message-error-detail']"));
		System.out.println(errorMessage.getText());
		
		//10. 10. Click and Confirm Label Position Changes
		WebElement label = driver.findElement(By.xpath("//span[@class='ui-float-label']/input"));
		Point location1 = label.getLocation();
		label.click();
		
		Point location2 = label.getLocation();
		if(location1.equals(location2))
		{
			System.out.println("Location Changed");
		}
		
		else
		{
			System.out.println("Location Not Changed");
		}
		
		//11. Type your name and choose the third option --took help from video 
		
		WebElement type = driver.findElement(By.xpath("//h5[text()='Type your name and choose the third option']/following::input"));
		type.sendKeys("Bhawna");
		Thread.sleep(3000);
		
		WebElement mouseHover = driver.findElement(By.xpath("//span[@class='ui-autocomplete-query'][1]"));
		Actions builder = new Actions(driver);
		builder.moveToElement(mouseHover).perform();
		Thread.sleep(3000);
		
		for (int i = 0; i < 3; i++) {
			type.sendKeys(Keys.DOWN);
			
		}
		type.sendKeys(Keys.ENTER);
		
		

		//12. Click and Confirm Keyboard appears
	    driver.findElement(By.xpath("//input[contains(@class,'ui-inputfield ui-keyboard-input')]")).click();
	    System.out.println("KeyBoard Appears");
	  
	    
	    //13. Custom Toolbar
		
		driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]")).sendKeys("Entering Name in Custom Toolbar");
		
				
		
		
	}
}




