package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	
	public static void main(String[] args) throws IOException {

		XSSFWorkbook wb = new XSSFWorkbook("./TestData/Mytestdata.xlsx");
		XSSFSheet sheet = wb.getSheet("Sheet1");

		int totalrow = sheet.getLastRowNum();
		System.out.println("The total rows is " + totalrow);

		int totalcolumn = sheet.getRow(0).getLastCellNum();
		System.out.println("The total column is " + totalcolumn);
		
		for (int i = 1; i <= totalrow; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < totalcolumn; j++) {
				XSSFCell cell = row.getCell(j);	
				String cellvalue = cell.getStringCellValue();
				System.out.println(cellvalue);
			}
		}
	}

}
