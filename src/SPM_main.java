import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class SPM_main {
	protected static final int EXIT_ON_CLOSE = 0;
	
	public static ArrayList<String> sD = null;
	public static String[][] sheet_date = null;
	public static ArrayList<String> aD = null;
	public static String[][] array_denumiri = null;
	public static ArrayList<String> pN = null;
	public static String[][] productNames = null;
	
	final static int sD_colNum = 10;
	final static int aD_colNum = 4;
	final static int pN_colNum = 1;

	public static void main(String[] args) throws IOException, InvalidFormatException, InterruptedException {

		JFrame frameLogo = new Logo();
		frameLogo.setLocationRelativeTo(null);
		frameLogo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameLogo.setAlwaysOnTop (true);
		frameLogo.setUndecorated(true);
		frameLogo.setVisible(true);
		
		int delay = 2000; // Delay in milliseconds

		sD = ImportExcel.getExcel("resources/Date_SPM.xlsm", "Date");
		sheet_date = ImportExcel.ArrayListTo2Darray(sD, sD_colNum);
		aD = ImportExcel.getExcel("resources/Date_SPM.xlsm", "Denumiri");
		array_denumiri = ImportExcel.ArrayListTo2Darray(aD, aD_colNum);
		pN = ImportExcel.getExcel("resources/Date_SPM.xlsm", "ListaProduse");
		productNames = ImportExcel.ArrayListTo2Darray(pN, pN_colNum);
		
		Thread.sleep(delay);
		frameLogo.dispose();
		try {
			MainFrame.mainFrame();
		} catch (InvalidFormatException e1) {
			e1.printStackTrace();
		}
	}
}
