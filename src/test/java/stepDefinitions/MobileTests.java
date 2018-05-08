package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;


public class  MobileTests extends BaseClass{

	@Given("^Open the straitstimes application and Open drawer menu$")
	public  void  user_is_on_Home_Page() throws Exception
	{
		intilizeMobileDriver();
		System.out.print("test" + MobileDriver);
		MobileDriver.findElement(By.id("com.buuuk.st:id/btn_tnc_ok")).click();
		swipe_left();
		MobileDriver.findElement(By.id("com.buuuk.st:id/skip")).click();
	}
	
	
	@When("^User tap on user icon$")
	public void user_Navigate_to_LogIn_Page() throws Exception {
		MobileDriver.findElement(By.className("android.widget.ImageButton")).click();
		MobileDriver.findElement(By.className("android.widget.ImageButton")).click();
		MobileDriver.findElement(By.id("com.buuuk.st:id/tv_login")).click();

	}
	
	@When("^User enters username and password in Mobile$")
	public void user_enters_UserName_and_Password() throws Exception {
		MobileDriver.findElement(By.id("com.buuuk.st:id/et_ldap_login_username")).sendKeys("Digitaltest2");
		MobileDriver.findElement(By.id("com.buuuk.st:id/et_ldap_login_password")).sendKeys("Password1");
		MobileDriver.findElement(By.id("com.buuuk.st:id/btn_ldap_login_continue")).click();
	}
	
	@Then("^User should logged in straits times mobile login page$")
	public void user_Login_Successfully() throws Exception {
	
	}
	
	@Given("^User is on straits times mobile home page has article with picture or video$")
	public  void  user_is_on_Home_Page_with_picture_or_video() throws Exception
	{
		MobileDriver.findElement(By.id("com.buuuk.st:id/article_image")).click();

	}
	
	@When("^Tap on the “latest” tab and tap on the first article$")
	public void user_click_on_article() throws Exception {
		
	}
	
	@Then("^Verify that the article is loading successfully with images/videos$")
	public void user_in_article_page() throws Exception {
		
		
	}

	private void swipe_left(){
		Dimension size=MobileDriver.manage().window().getSize();
		int yAxisMid= size.height/2;
		int startPoint=(int)(size.width * 0.80);
		int endPoint=(int)(size.width * 0.20);
		int duration=200;
		TouchAction.press(startPoint, yAxisMid).waitAction(duration).moveTo(endPoint, yAxisMid).release().perform();
	}
	
}
		
	


