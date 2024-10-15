package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class RemoveEmployee {
    WebDriver driver;
    WebDriverWait wait;

    public RemoveEmployee(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
    }

    By clickAdmin = By.xpath("//a//span[text()='Admin']");
    By searchUser = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    By searchBtn = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    By deleteBtn = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[1]/i");
    By confirmDeleteBtn = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]");
//    By C = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div/div/div/div/div[2]/div[1]/div/div[2]");
By usernameLocator = By.xpath("//div[@class='oxd-table-cell oxd-padding-cell' and div[@data-v-6c07a142='']][1]");

    public void searchEmployee(String username){
        driver.findElement(clickAdmin).click();
        driver.findElement(searchUser).sendKeys(username);
        driver.findElement(searchBtn).click();
    }


    public void removeEmployeeFunc(String username) throws InterruptedException {

        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        wait.until(ExpectedConditions.elementToBeClickable(usernameLocator));
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));

        String actualUsername = usernameElement.getText().trim();

        if (Objects.equals(actualUsername, username)) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(deleteBtn));
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn));
        driver.findElement(deleteBtn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmDeleteBtn));
        wait.until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn));
        driver.findElement(confirmDeleteBtn).click();

        } else {
            System.out.println("Username not found");
        }
    }
}
