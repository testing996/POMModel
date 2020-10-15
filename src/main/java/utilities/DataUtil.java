package utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import Base.BasePage;

public class DataUtil extends BasePage {
	
	public DataUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@DataProvider(name="dp")
	public  Object[][]getData(Method m) {
	String sheetName = m.getName();
	
	int rowCount= excel.getRowCount(sheetName);
	
	int colCount= excel.getColumnCount(sheetName);
	
	//System.out.println(excel.getCellData(sheetName, 0, 2));
	
	//System.out.println("Total rows are :"+rowCount+"---total cols are:"+colCount);
		
		Object[][] data = new Object[rowCount-1][colCount];
        
		for(int rows=2;rows<=rowCount;rows++) {
			
			for(int cols=0;cols<colCount;cols++) {
				
				
				data[rows-2][cols]=excel.getCellData(sheetName, cols, rows);	
				
			}
		}
		
		
		return data;



}
	
}
