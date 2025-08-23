package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name="dp")
	public String[][] getdata() throws IOException{
		String path= "./testdata//Opencart_LoginData.xlsx";
		
		ExcelUtility xlfile=new ExcelUtility(path);
		
		int rowcount=xlfile.getRowCount("Sheet1");
		int cellcount=xlfile.getCellCount("Sheet1", 1);
		
		String[][] finaldata= new String[rowcount][cellcount];
		
		for(int r=1;r<=rowcount;r++) {
			for(int c=0;c<cellcount;c++) {
				finaldata[r-1][c] =xlfile.getCellData("Sheet1", r, c);
			}
		}
		return finaldata;
	}
}
