package Progressbar;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelRead {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f=new File("C:\\Users\\biswa\\Desktop\\kanha.xlsx");
		FileInputStream fio=new FileInputStream(f);
		XSSFWorkbook workbook=new XSSFWorkbook(fio);
		XSSFSheet sheet=workbook.getSheet("sheet1");
	int rowCount=sheet.getPhysicalNumberOfRows();
	int colCount=sheet.getRow(0).getPhysicalNumberOfCells();
	System.out.println(rowCount);
	System.out.println(colCount);
	for(int i=1;i<rowCount;i++)
	{
		for(int j=0;j<colCount;j++)
		{
//			DataFormatter df=new DataFormatter();
//			System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j))); all type of value print
			
			System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());  //String value only print
			
		}
		System.out.println();
	}
	fio.close();
	workbook.close();
		
		
	}

}
