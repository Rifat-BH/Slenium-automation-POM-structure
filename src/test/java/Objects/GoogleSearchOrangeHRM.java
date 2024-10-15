package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchOrangeHRM {

    WebDriver driver;
    WebDriverWait wait;

    public GoogleSearchOrangeHRM(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By searchBox = By.name("q");
    By searchButton = By.name("btnK");
    By searchOrangeHRM = By.xpath("//a//h3[text()='OrangeHRM Demo']");

    public void searchGoogle(String searchInput) {
        try {
            driver.findElement(searchBox).sendKeys(searchInput);
            wait.until(ExpectedConditions.elementToBeClickable(searchButton));
            driver.findElement(searchButton).click();

        } catch (Exception e){
            System.out.println("Exception searchGoogle: " + e.getMessage());
        }

    }

    public void clickOrangeHRM (){
        try {
            wait.until(ExpectedConditions.elementToBeClickable(searchOrangeHRM));
            driver.findElement(searchOrangeHRM).click();
        } catch (Exception e){
            System.out.println("Exception clickOrangeHRM: " + e.getMessage());
        }

    }
}
