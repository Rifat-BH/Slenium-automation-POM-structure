package Test_Scenarios;

import Objects.AddEmployee;
import Objects.GoogleSearchOrangeHRM;
import Objects.LoginOrangeHRM;
import Objects.RemoveEmployee;
import com.sun.jdi.ThreadGroupReference;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.UserDetailsFromExcel;

import javax.swing.text.html.HTMLDocument;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchAndLogin {
    WebDriver driver;
    GoogleSearchOrangeHRM googleSearch;
    AddEmployee addEmployee;
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.google.com/");
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void searchOperation() throws InterruptedException {
        googleSearch = new GoogleSearchOrangeHRM(driver);
        googleSearch.searchGoogle("orangehrm demo");
        Thread.sleep(1000);
    }
    @Test (priority = 2)
    public void accessOrangeHRM() throws InterruptedException {
        googleSearch = new GoogleSearchOrangeHRM(driver);
        googleSearch.clickOrangeHRM();
        Thread.sleep(3000);
    }

    @Test (priority = 3)
    public void loginOrangeHRM() throws InterruptedException {
        LoginOrangeHRM orangeHRM = new LoginOrangeHRM(driver);
        orangeHRM.loginOrangeHRM("Admin", "admin123");
        Thread.sleep(1000);
    }
    @Test (priority = 4)
    public void testAddEmployee() throws InterruptedException, IOException {
        addEmployee = new AddEmployee(driver);
        addEmployee.ClickToAddEmployee();
        String filePath = "/home/upay/Documents/Automation/OrangeHRM_Automation/TestData/OrangeHRMuserdetails.xlsx";
        String sheetName = "Sheet1";

        List<List<String>> userDetailsList = UserDetailsFromExcel.getUserDetails(filePath,sheetName);

        for(List<String>userDetails : userDetailsList){
            addEmployee.ClickToAddEmployee();
            String userType = userDetails.get(0);
            String employeeName = userDetails.get(1);
            String status = userDetails.get(2);
            String username = userDetails.get(3);
            String password = userDetails.get(4);
            String confirmPassword = userDetails.get(5);
            addEmployee.userDetails(userType, employeeName, status, username, password,confirmPassword); //provide user type
            Thread.sleep(2000);
        }
//        addEmployee.userDetails("Admin", "Ranga  Akunuri", "Enabled", "rifat03","ABCxyz#123", "ABCxyz#123"); //provide user type


        Thread.sleep(1000);
    }
    @Test (priority = 5)
    public void removeEmployeeTest() throws InterruptedException {
        RemoveEmployee removeEmployee = new RemoveEmployee(driver);
        String employeeName = "rifat03";
        removeEmployee.searchEmployee(employeeName);
        Thread.sleep(1000);
        removeEmployee.removeEmployeeFunc(employeeName);
        Thread.sleep(5000);
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        if (driver != null) {
            Thread.sleep(2000);
            driver.quit();
        }
    }
}
