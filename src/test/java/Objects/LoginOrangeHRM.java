package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginOrangeHRM {
    WebDriver driver;

    public LoginOrangeHRM(WebDriver driver){
        this.driver = driver;
    }

    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

    public void loginOrangeHRM(String orangeHRMUsername, String orangeHRMPassword){
        driver.findElement(username).sendKeys(orangeHRMUsername);
        driver.findElement(password).sendKeys(orangeHRMPassword);
        driver.findElement(loginBtn).click();
    }
}
