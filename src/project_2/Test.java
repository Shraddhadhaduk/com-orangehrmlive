package project_2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        String baseUrl = " https://opensource-demo.orangehrmlive.com/";

        //Launch the Chrome browser
        WebDriver driver = new ChromeDriver();

        //open the url into the browser
        driver.get(baseUrl);

        //Maximize the browser
        driver.manage().window().maximize();

        //we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //get the title of the page
        String title = driver.getTitle();
        System.out.println(title);

        //print current url
        String loginUrl = " https://opensource-demo.orangehrmlive.com/";
        driver.navigate().to(loginUrl);
        System.out.println("Get current url " + driver.getCurrentUrl());

        //Get a page source
        System.out.println(driver.getPageSource());

        //Find forgot password link and click on it
        WebElement forgotPasswordLink = driver.findElement(By.className("orangehrm-login-forgot"));
        forgotPasswordLink.click();
        Thread.sleep(2000);

        //print current Url
        String currentUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode";
        driver.navigate().to(currentUrl);
        System.out.println("Get current url " + driver.getCurrentUrl());
        Thread.sleep(2000);

        //Back to login page
        driver.navigate().back();

        //refresh the browser page
        driver.navigate().refresh();

        //Find email field element and type the email
        WebElement userNameField = driver.findElement(By.name("username"));
        userNameField.sendKeys("Admin");
        Thread.sleep(3000);

        //Find password field element and type the email
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");
        Thread.sleep(3000);


        //Find login link element and click on it
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(3000);

        //close browser
        driver.quit();
    }
    }