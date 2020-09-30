package testData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static FileInputStream fis= null;
	public FileInputStream getFileInputStream()
	{
		String filePath=System.getProperty("user.dir")+"\\src\\test\\java\\testData\\TestData.xlsx";
		File srcFile=new File(filePath);
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test data file doesn't found : check file path of the data!");
			System.exit(0);
		}
		return fis;
	}
	public Object [] [] getExcelData() throws IOException
	{
		fis = getFileInputStream();
		// to read from sheet as cell and columns and rows
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(1);
		int totalNumberOfRows= (sheet.getLastRowNum()+1);
		int totalNumberOfColumns=4;
		
		String[] [] arrayExcelData= new String[totalNumberOfRows] [totalNumberOfColumns];
		for (int i = 0; i < totalNumberOfRows; i++) {
			for (int j = 0; j < totalNumberOfColumns; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j]=row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;
	}
}
