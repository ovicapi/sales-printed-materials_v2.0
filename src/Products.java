
public class Products {

	public static String[] denumiri = new String[66];

	public static String[] products () {

		int rows_number = SPM_main.productNames.length;
		
		for (int i = 0; i < rows_number; i++) {
			denumiri[i] = SPM_main.productNames[i][0];
		}
		return denumiri;
	}
}
