import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadingFromExcel {
    WebDriver driver;
    public ReadingFromExcel(WebDriver driver)
    {
        this.driver=driver;
    }
    public String ReadingExcel(int rowNumber , int colNumber) throws IOException {
        //Read vfrom excell (victim message and victimUrl)
        File src=new File("C:\\Users\\lenovo\\MyFrameWork\\src\\main\\resources\\facebookdata.xlsx");
        FileInputStream fis=new FileInputStream(src);
        XSSFWorkbook wb=new XSSFWorkbook(fis);
        XSSFSheet sh1= wb.getSheetAt(0);
        String Data = sh1.getRow(rowNumber).getCell(colNumber).getStringCellValue();
        return Data;
       // String VictimUrl = sh1.getRow(1).getCell(0).getStringCellValue();
    }
}
