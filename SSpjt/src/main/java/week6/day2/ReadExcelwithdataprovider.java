package week6.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ReadExcelwithdataprovider {
	 
	static Object data[][];
	
	
	@DataProvider(name="getData")
	public static Object[][] readdata(String filename)  {
		 XSSFWorkbook wb;
		
		try {
			wb = new XSSFWorkbook("./TestData/"+filename+".xlsx");
			XSSFSheet sheet = wb.getSheet("Sheet1");

			int totalrow = sheet.getLastRowNum();
			System.out.println("The total rows is " + totalrow);

			int totalcolumn = sheet.getRow(0).getLastCellNum();
			System.out.println("The total column is " + totalcolumn);
			
			data=new Object[totalrow][totalcolumn];
			
			for (int i = 1; i <= totalrow; i++) {
				XSSFRow row = sheet.getRow(i);
				for (int j = 0; j < totalcolumn; j++) {
					XSSFCell cell = row.getCell(j);
					data[i-1][j]=cell.getStringCellValue();
					
					String cellvalue = cell.getStringCellValue();
					System.out.println(cellvalue);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}