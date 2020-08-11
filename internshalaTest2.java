import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;

public class internshalaTest2 {
	public static WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
//*************************************login**********************************************//
  @Test(priority=1)
  public void login() {
	  WebElement search_bar = driver.findElement(By.name("q"));
      search_bar.sendKeys("internshala");
      search_bar.sendKeys(Keys.ENTER);
  
      WebDriverWait wait = new WebDriverWait(driver,60);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Login")));
      WebElement login = driver.findElement(By.linkText("Login"));
      login.click();
  
      WebElement email = driver.findElement(By.id("email"));
      email.sendKeys("7aishwaryasharma@gmail.com");
      WebElement pass = driver.findElement(By.id("password"));
      pass.sendKeys("qwerty@123");
      pass.sendKeys(Keys.ENTER);  
      
  }


  
//******************************************contact****************************************//  
@Test(dataProvider = "dataprovider", priority=2)
public void contact_us(String contact_element) throws InterruptedException {	
	
	driver.navigate().to("https://internshala.com/contact");
	WebElement contact = driver.findElement(By.cssSelector(contact_element));
    contact.click();    
}



//****************************************close other tabs*********************************//
@Test(dataProvider = "dataprovider", priority=3)
public void close_tabs(String contact_element) {
	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    driver.switchTo().window(tabs2.get(1));
    driver.close();
    driver.switchTo().window(tabs2.get(0));
    
}


//************************************go to internships************************************//  
@Test(priority=4)
public void goTointernships() throws InterruptedException {
	  WebDriverWait wait1 = new WebDriverWait(driver,60);
	  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("internships_new_superscript")));
	  WebElement internships = driver.findElement(By.id("internships_new_superscript"));
      internships.click();
}



//*************************************select category*************************************//
@Test(priority=5)
public void selectCategory() throws InterruptedException {
    WebDriverWait wait3 = new WebDriverWait(driver,60);
    wait3.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.chosen-search-input.default")));
    WebElement category = driver.findElement(By.cssSelector("input.chosen-search-input.default"));
    category.click();                                  
    category.sendKeys("Computer Science");
    category.sendKeys(Keys.ENTER);
}


//**************************************search and apply*********************************//
@Test(priority=6)
public void searchAndApply() throws InterruptedException { 
	try {
    WebDriverWait wait4 = new WebDriverWait(driver,60);
    wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"individual_internship_895975\"]/div[1]/div[1]/div[1]/h4[1]/a")));
    WebElement intern_select = driver.findElement(By.xpath("//*[@id=\"individual_internship_895975\"]/div[1]/div[1]/div[1]/h4[1]/a"));
    intern_select.click();
	}
	catch(Exception e)
	{
		System.out.println("*******************************************************");
		System.out.println("The internship you are searching for is not available.");
		System.out.println("*******************************************************");
		
	}
	
    try {
    //if not already applied to the internship
    WebElement apply_now = driver.findElement(By.id("search_button"));
    apply_now.click();
    
    WebElement proceed = driver.findElement(By.cssSelector("button.btn.btn-primary.education_incomplete"));
    proceed.click();
    }
    catch(Exception e)
    {   
    	System.out.println("*****************************************************************************************");
		System.out.println("Either you have already applied for this internship or this internship is not available. ");
		System.out.println("*****************************************************************************************");
    	
    }
}


//**********************************submit form******************************************************//
 
@Test(priority=7)
public void submit() throws InterruptedException {
	try {
	  WebDriverWait wait4 = new WebDriverWait(driver,60);
    wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("cover_letter")));
    WebElement cover_letter = driver.findElement(By.id("cover_letter"));
    cover_letter.sendKeys("I am an enthusiastic coder and ready to take challanges and learn new things.");
    WebElement text2 = driver.findElement(By.id("text_1081226"));
    text2.sendKeys("Yes");
 
    try{
  	  WebElement text3 = driver.findElement(By.id("text_1081249"));
	      text3.click();                                  
	      text3.sendKeys("xyz1");
	      WebElement text4 = driver.findElement(By.id("text_1081250"));
	      text4.click();                                  
	      text4.sendKeys("xyz2");
	      }
    catch(Exception e)
    {}
    
    WebElement submit = driver.findElement(By.name("submit"));
    submit.click();
	}
	catch(Exception e)
	{}
    }


//***************************Return back to internships page**********************************//  
@Test(priority=8)
public void returnBack() throws InterruptedException {
	  try{
		  WebDriverWait wait6 = new WebDriverWait(driver,60);
        wait6.until(ExpectedConditions.visibilityOfElementLocated(By.id("backToInternshipsCta")));
        WebElement back = driver.findElement(By.id("backToInternshipsCta"));
        back.click();
        }
    catch(Exception e)
    {}
	  }


//*****************************************logout***********************************************//
@Test(priority=9)

public void logout() throws InterruptedException {
	try {
	WebDriverWait wait7 = new WebDriverWait(driver,60);
    wait7.until(ExpectedConditions.visibilityOfElementLocated(By.className("profile_icon_right")));
    WebElement account = driver.findElement(By.cssSelector("div.profile_icon_right"));
    account.click();

    WebElement more = driver.findElement(By.cssSelector("span.glyphicon.pull-right.glyphicon-menu-down") );
    more.click();
    
    WebElement logout = driver.findElement(By.linkText("Logout"));
    logout.click();
	}
	catch(Exception e)
	{}
	  }


//*********************************data providers**********************************************//
  @DataProvider(name = "dataprovider")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "i.is-icon-instagram" },      //css-selector values
      new Object[] { "i.is-icon-twitter"},
      new Object[] { "i.is-icon-youtube"},
      new Object[] { "i.is-icon-linkedin"},
      
    };
  }
  
//************************************before test************************************************//
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "/home/aishwarya/Downloads/chromedriver_linux64/chromedriver");
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.navigate().to("http://www.google.com/");
      driver.manage().window().maximize();
  }

//**********************************after test(quit window)************************************************//
  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}