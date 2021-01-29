import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.monitorjbl.xlsx.StreamingReader;

public class ImportExcel {

	private static String[][] arrayDataTable;
	private static int rowNumber;

	public static ArrayList<String> getExcel(String filename, String sheetname) {

		ArrayList<String> dataTable = new ArrayList<>();
		File file = new File(filename);

		try {
			InputStream myExcel = new FileInputStream(file);
			Workbook myWorkBook = StreamingReader.builder()
					.rowCacheSize(100)    					// number of rows to keep in memory (defaults to 10)
					.bufferSize(4096)     					// buffer size to use when reading InputStream to file (defaults to 1024)
					.open(myExcel);            				// InputStream or File for XLSX file (required)
			Sheet xlSheet = myWorkBook.getSheet(sheetname);	
			
			rowNumber = xlSheet.getLastRowNum() + 1;

			for (Row r : xlSheet) {
				for (Cell c : r) {
					dataTable.add(c.getStringCellValue());
				}
			}
			myWorkBook.close();
		} 
		catch (IOException e) {
			System.out.println("ERROR FILE HANDLING " + e.toString());
		}
		return dataTable;
	}
	
	public static int getRowNumber() {
		return rowNumber;
	}
	
	public static String[][] ArrayListTo2Darray (ArrayList<String> dataTable, int colNum) {

		int rowNum = getRowNumber();
		
		arrayDataTable = new String[rowNum][colNum];
		
		ArrayList<String> dataTable1 = new ArrayList<String>(dataTable);
			for (int i = 0;  i < rowNum; i++) {
				for (int j = 0; j < colNum; j++) {
					arrayDataTable[i][j] = dataTable1.get(i * colNum + j); 
				}
			}
		return arrayDataTable;
	}
}