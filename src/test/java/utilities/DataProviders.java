package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="logindata")
	public String [][] getData() throws IOException
	{
		//1. taking excel file from test data
		String path=".\\testdata\\LoginTestDataTutorialsNinja.xlsx";  
		
		//2. now need to invoke Excel utility methods
		ExcelUtility utilities=new ExcelUtility(path); 
		
		//3. Find number of rows
		int totalrows=utilities.getRowCount("sheet1"); //here we passed the sheet tab name
		
		//4. Find number of columns
		int totalcells=utilities.getCellCount("sheet1", 1); //here we passed the sheet tab name and row number
		
		//5. String excel data in 2d array
		String logindata[][]=new String[totalrows][totalcells];
		
		
		//6. For loop to read the data
		for(int i=1; i<=totalrows; i++)
		{
			for(int j=0; j<totalcells; j++)
			{
				logindata[i-1][j]=utilities.getCellData("sheet1", i, j);
			}
		}
		return logindata;
		
	}
	
	
}
