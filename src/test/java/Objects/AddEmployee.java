package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

public class AddEmployee {

    WebDriver driver;
    WebDriverWait wait;

    public AddEmployee(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    By clickAdmin = By.xpath("//a//span[text()='Admin']");
    By clickAdd = By.xpath("//button[text()=' Add ']");

    By clickUserRole = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
    By adminOption = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]");
    By essOption  = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[3]");

    By clickEmployeeName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input");
    By selectEmployeeName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div");
    //*[@id="app"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div/span
    By clickStatus = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[1]/div[1]");
    By selectEnabledStatus = By.xpath("<div data-v-d130bb63=\"\" data-v-13cf171c=\"\" role=\"option\" class=\"oxd-select-option\"><span data-v-13cf171c=\"\">Enabled</span></div>");
    By selectDisabledStatus = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[3]");

    By provideUsername = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]");
    By providePassword = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]");
    By provideConfirmPassword = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]");

    By saveEmployee = By.xpath("//button[text()]=' Save '");

    public void ClickToAddEmployee(){
        driver.findElement(clickAdmin).click();
        driver.findElement(clickAdd).click();

    }
    public void userDetails(String selectUserType, String employeeName, String selectStatus, String username, String password, String confirmPassword){
        driver.findElement(clickUserRole).click();
        if(Objects.equals(selectUserType, "Admin")){
            wait.until(ExpectedConditions.elementToBeClickable(adminOption));
            driver.findElement(adminOption).click();
        } else if (Objects.equals(selectUserType, "ESS")) {
            wait.until(ExpectedConditions.elementToBeClickable(essOption));
            driver.findElement(essOption).click();
        }else {
            System.out.println("Option not found");
        }

        driver.findElement(clickEmployeeName).sendKeys(employeeName);
        wait.until(ExpectedConditions.elementToBeClickable(selectEmployeeName));
        driver.findElement(selectEmployeeName).click();

        driver.findElement(clickStatus).click();
        if (Objects.equals(selectStatus, "Enabled")){
            wait.until(ExpectedConditions.elementToBeClickable(selectEnabledStatus));
            driver.findElement(selectEnabledStatus).click();
        }else  if (Objects.equals(selectStatus, "Disabled")){
            wait.until(ExpectedConditions.elementToBeClickable(selectDisabledStatus));
            driver.findElement(selectDisabledStatus).click();
        }else {
            System.out.println("Select status failed");
        }

        driver.findElement(provideUsername).sendKeys(username);
        driver.findElement(providePassword).sendKeys(password);
        driver.findElement(provideConfirmPassword).sendKeys(confirmPassword);
        driver.findElement(saveEmployee).click();

    }


}
