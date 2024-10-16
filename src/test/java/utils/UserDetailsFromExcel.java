package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UserDetailsFromExcel {
//
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public UserDetailsFromExcel(WebDriver driver){
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//    }

    public static List<List<String>> getUserDetails (String filePath, String sheetName) throws IOException {

        List<List<String>> userDetailsList = new ArrayList<>();
        FileInputStream files = null;

        try {
            files = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(files);
            Sheet sheet = workbook.getSheet(sheetName);
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                List<String> userDetails = new ArrayList<>();

                for (int j = 0; j < row.getLastCellNum(); j++) {
                    userDetails.add(row.getCell(j).getStringCellValue());
                }
                userDetailsList.add(userDetails);
            }
        } finally {
            if (files != null){
                files.close();
            }
        }


        return userDetailsList;
    }
}
