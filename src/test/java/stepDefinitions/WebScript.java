package stepDefinitions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class  WebScript extends BaseClass{
	private static final String PROP_FILE="TestData/InputData.properties";
	Properties prop = new Properties();


	@Given("^User is on straits times home page$")
	public  void  user_is_on_Home_Page() throws Exception
	{
		intilizeDriver();
		InputStream in = new FileInputStream(PROP_FILE);
		prop.load(in);
		String PortalURL = prop.getProperty("Portal_URL");
		Driver.navigate().to(PortalURL);
		Driver.manage().window().maximize();
		closeTheAd();
		
	}
	
	@When("^User naviagtes to Login page$")
	public void user_Navigate_to_LogIn_Page() throws Exception {
		
		Driver.findElement(By.className("nav-login")).click();
	}
	
	@When("^User enters username and password$")
	public void user_enters_UserName_and_Password() throws Exception {
		Driver.findElement(By.id("j_username")).sendKeys(prop.getProperty("UserName")); 	 
		Driver.findElement(By.id("j_password")).sendKeys(prop.getProperty("Password"));
		Driver.findElement(By.className("btn")).click();
	}
	
	@Then("^User should logged in straits times login page$")
	public void user_Login_Successfully() throws Exception {
	Thread.sleep(5000);
		Driver.findElement(By.xpath("//a[text()='digitaltest1']")).isDisplayed();
	}
	
	@Given("^User is on straits times home page has article with picture or video$")
	public  void  user_is_on_Home_Page_with_picture_or_video() throws Exception
	{
		Driver.findElement(By.xpath("//div[@data-vr-zone='Top Stories 0']//img")).isDisplayed();
	}
	
	@When("^User click on the  article$")
	public void user_click_on_article() throws Exception {
		Driver.findElement(By.xpath("//div[@data-vr-zone='Top Stories 0']")).click();
	}
	
	@Then("^User navigates to the main article and picture/video is present in the article$")
	public void user_in_article_page() throws Exception {
		
		Driver.findElement(By.xpath("//figure[@class='group-image-frame field-group-html-element']")).isDisplayed();
	}
	public void closeTheAd(){
        List<WebElement> iframList = new ArrayList<WebElement>();
            iframList =Driver.findElements(By.xpath("//iframe"));
            if(iframList.size()>0) {
                for (WebElement temp : iframList) {
                    if (temp.isDisplayed()) {
                        try {
                            Driver.switchTo().frame(temp).findElement(By.xpath("//*[contains(@id, 'close')]")).click();
                            Driver.switchTo().defaultContent();
                            break;
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
	
}
		
	

