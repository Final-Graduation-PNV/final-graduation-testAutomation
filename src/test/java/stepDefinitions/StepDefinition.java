package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class StepDefinition {
    WebDriver driver = null;

    String projectPath = System.getProperty("user.dir");
    @Given("^user is on login page$")
    public void user_is_on_login_page() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:3000/");
        Thread.sleep(2000);
    }

    @And("verify login page")
    public void verify_login_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //Verify url
        String loginPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginPageUrl, "http://localhost:3000/");
        driver.manage().window().maximize();
        //Verify title
        String loginPageTitle = driver.getTitle();
        Assert.assertEquals(loginPageTitle, "React App");
        Thread.sleep(2 * 1000);

    }


    @And("^input valid and invalid value for (.+) field$")
    public void input_valid_and_invalid_value_for_email_field(String email) throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/form/input[1]")).sendKeys(email);
        Thread.sleep(2*1000);
    }
    @And("^input valid and invalid data for (.+) field$")
    public void input_valid_and_invalid_data_for_password_field(String password) throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/form/input[2]")).sendKeys(password);
        Thread.sleep(2*1000);
    }
    @When("^click on login button$")
    public void click_on_login_button() throws Throwable {
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/form/input[3]")).click();
        Thread.sleep(2*1000);
    }

    @Then("^(.+) is displayed$")
    public void message_is_displayed(String message){
        driver.quit();
        System.out.println(message);
//        driver.close();
    }

    // ---------------------------------verify login successfully and then log out successfully
    @And("^input valid value for (.+) field$")
    public void input_valid_value_for_email_field() throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/form/input[1]")).sendKeys("duyet.ho23@student.passerellesnumeriques.org");
        Thread.sleep(2*1000);
    }

    @And("^input valid data for (.+) field$")
    public void input_valid_data_for_password_field() throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/form/input[2]")).sendKeys("D210902@m");
        Thread.sleep(2*1000);
    }
    @Given("user login successfully")
    public void user_login_successfully() throws Throwable{
        user_is_on_login_page();
        verify_login_page();
        input_valid_value_for_email_field();
        input_valid_data_for_password_field();
        click_on_login_button();

    }
    @And("Click on Avatar image")
    public void Click_on_Avatar_image() throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"container-header\"]/div[2]/div[2]/div[2]/img")).click();
    }
    @When("click on Log out button")
    public void click_on_Log_out_button() throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div[3]/p[2]")).click();
    }
    // --------------Add To cart
    @And("click on addtocart button")
    public void click_on_addtocart_button() throws Throwable{
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/div[4]/button")).click();
        Thread.sleep(1000);
    }
    // ----------Add product
    @Given("verify admin shop page")
    public void verify_admin_shop_page() throws InterruptedException {
        String adminShopPageUrl = driver.getCurrentUrl();
        Assert.assertEquals(adminShopPageUrl, "http://localhost:3000/shopOnnwer");
        Thread.sleep(2*1000);
    }
    @And("click on Addproduct button")
    public void click_on_Addproduct_button(){
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/button")).click();
    }
//    @And("click on choose file")
//    public void click_on_choose_file(){
//        driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div[1]/div/input")).sendKeys("C:\\Users\\admin\\Pictures\\mtp.JPG");
//    }

}