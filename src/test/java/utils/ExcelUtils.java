package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtils {
    public static Map<String, String> getUserDetails(String filePath, String sheetName) throws IOException {
        Map<String, String, String, String, String, String> userDetails = new HashMap<>();

        FileInputStream files = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(files);
        Sheet sheet = workbook.getSheet(sheetName);

        Row headerRow = sheet.getRow(0);

        for (int i = 1; i<= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);

            String userType = row.getCell(0).getStringCellValue();
            String employeeName = row.getCell(1).getStringCellValue();
            String status = row.getCell(2).getStringCellValue();
            String username = row.getCell(3).getStringCellValue();
            String password = row.getCell(4).getStringCellValue();
            String confirmPassword = row.getCell(5).getStringCellValue();

            userDetails.put(userType, employeeName, status, username,password,confirmPassword);

        }

        return Map.of();
    }
}
