package Tests.Assignment.TestNGAssignments;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestNGAssignment2 extends TestBase {
    /*
        Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
        Add 10 notes using data provider with excel
        Run it with 3 different browsers using XML file
        Run it parallel with 3 threads
    */


    @Test(dataProvider = "noteDataProvider")
    public void dataProviderTests(String title, String note) {
        bot.navigate("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

        By titleLocator = By.xpath("//input[@id='note-title-input']");
        By noteLocator = By.xpath("//textarea[@id='note-details-input']");
        By addButton = By.xpath("//button[@id='add-note']");

        driver.findElement(titleLocator).sendKeys(title);
        driver.findElement(noteLocator).sendKeys(note);
        bot.click(addButton);
    }

    @DataProvider(name = "noteDataProvider")
    public Object[][] getTestData() throws IOException {
        FileInputStream file = new FileInputStream("src/test/java/resources/notes.xls");
        Workbook workbook = new HSSFWorkbook(file);
        Sheet sheet = workbook.getSheetAt(0);

        int rowCount = sheet.getLastRowNum();
        Object[][] data = new Object[rowCount][2];

        for (int i = 0; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            data[i][0] = row.getCell(0).getStringCellValue(); // Title
            data[i][1] = row.getCell(1).getStringCellValue(); // Note
        }

        workbook.close();
        file.close();

        return data;
    }





}
