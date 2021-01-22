import java.util.ArrayList;

public class ProductCodes {

	public static ArrayList<String> coduriProdus (String produs) {

		ArrayList<String> coduriProdus = new ArrayList<String>();

		int rows_number = SPM_main.array_denumiri.length;

		for (int i =0; i < rows_number; i++) {
			if(SPM_main.array_denumiri[i][2] != null) {
				String cell = SPM_main.array_denumiri[i][2];
				if (cell != null) {
					if (cell.equals(produs)) {
						String cod_produs = SPM_main.array_denumiri[i][0];
						coduriProdus.add(cod_produs);
					}
				}
			}
		}
		return coduriProdus;
	}
}
