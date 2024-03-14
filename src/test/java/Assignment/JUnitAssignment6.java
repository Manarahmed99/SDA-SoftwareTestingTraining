package Assignment;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class JUnitAssignment6 {
    /*
        Store the path of the file as string and open the file.
        Open the workbook.
        Open the first worksheet.
        Go to the first row.
        Create a cell on the 3rd column (2nd index) on the first row.
        Write “POPULATION” on that cell.
        Create a cell on the 2nd row 3rd cell(index2), and write data.
        Create a cell on the 3rd row 3rd cell(index2), and write data.
        Create a cell on the 4th row 3rd cell(index2), and write data.
        Write and save the workbook.
        Close the file.
        Close the workbook.

        The 3rd column on excel file must be empty before running.
        Otherwise, new data will be written on the old data
     */
    @Test
    public void ExcelTests() throws IOException {

        FileInputStream file = new FileInputStream("src/test/java/resources/ExcelFileTest.xls");

        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");



        Row firstRow = sheet.getRow(0);
        if (firstRow == null) firstRow = sheet.createRow(0);
        Cell cell0 = firstRow.createCell(0);
        cell0.setCellValue("Country");
        Cell cell1 = firstRow.createCell(1);
        cell1.setCellValue("City");
        Cell cell = firstRow.createCell(2);
        cell.setCellValue("POPULATION");

        Row secondRow = sheet.getRow(1);
        if (secondRow == null) secondRow = sheet.createRow(1);
        Cell countryCell2 = secondRow.createCell(0);
        countryCell2.setCellValue("USA");
        Cell cityCell2 = secondRow.createCell(1);
        cityCell2.setCellValue("New York");
        Cell populationCell2 = secondRow.createCell(2);
        populationCell2.setCellValue("2000000");

        Row thirdRow = sheet.getRow(2);
        if (thirdRow == null) thirdRow = sheet.createRow(2);
        Cell countryCell3 = thirdRow.createCell(0);
        countryCell3.setCellValue("France");
        Cell cityCell3 = thirdRow.createCell(1);
        cityCell3.setCellValue("Paris");
        Cell populationCell3 = thirdRow.createCell(2);
        populationCell3.setCellValue("5000000");

        Row fourthRow = sheet.getRow(3);
        if (fourthRow == null) fourthRow = sheet.createRow(3);
        Cell countryCell4 = fourthRow.createCell(0);
        countryCell4.setCellValue("japan ");
        Cell cityCell4 = fourthRow.createCell(1);
        cityCell4.setCellValue("tokyo");
        Cell populationCell4 = fourthRow.createCell(2);
        populationCell4.setCellValue("100000");

        FileOutputStream outputFile = new FileOutputStream("src/test/java/resources/ExcelFileTest.xls");
        workbook.write(outputFile);

        outputFile.close();
        workbook.close();

        System.out.println("Excel file written successfully.");

    }


}
