package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataprovider {

	public XSSFWorkbook wb;

	public ExcelDataprovider() {

		File src = new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {
			System.out.println("Unable to read Excel File " + e.getMessage());
		}
	}

	// Get cell values with sheet index and row, coloumn
	public String getDataSheetIndex(int sheetIndex, int row, int column) {
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}

	// Get cell values with sheet name and row, coloumn
	public String getDataSheetName(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).toString();
	}

	// get numeric data
	public double getNumericData(String sheetName, int row, int column) {
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}

}
