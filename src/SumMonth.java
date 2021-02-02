import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SumMonth {

	public static ArrayList<Integer> sumQuantityMonth (String produs, String an, ArrayList<String> luni) throws FileNotFoundException {

		ArrayList<Integer> sumQuantityMonth = new ArrayList<>();
		for (int i = 0; i < luni.size(); i++) {
			sumQuantityMonth.add(0);
		}
		for (int i = 0; i < SPM_main.sheet_date.length; i++) {
			if (SPM_main.sheet_date[i][6] != null) {
				String cell_prod = SPM_main.sheet_date[i][6];
				for (int j = 0; j < ProductCodes.coduriProdus(produs).size(); j++) {
					if (cell_prod.equals(ProductCodes.coduriProdus(produs).get(j))) {
						if(SPM_main.sheet_date[i][8].equals(an)) {
							String cell_luna = SPM_main.sheet_date[i][3];
							for (int k = 0; k < luni.size(); k++) {
								if (cell_luna.equals(luni.get(k))) {
									sumQuantityMonth.set(k, sumQuantityMonth.get(k) + Integer.parseInt(SPM_main.sheet_date[i][5]));
								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < sumQuantityMonth.size(); i++) {
			sumQuantityMonth.set(i, sumQuantityMonth.get(i) * (-1));
		}
		return sumQuantityMonth;
	}

	public static ArrayList<Double> sumValueMonth (String produs, String an, ArrayList<String> luni) throws FileNotFoundException {

		ArrayList<Double> sumValueMonth = new ArrayList<>();
		for (int i = 0; i < luni.size(); i++) {
			sumValueMonth.add(0.0);
		}
		for (int i = 0; i < SPM_main.sheet_date.length; i++) {
			if (SPM_main.sheet_date[i][6] != null) {
				String cell_prod = SPM_main.sheet_date[i][6];
				for (int j = 0; j < ProductCodes.coduriProdus(produs).size(); j++) {
					if (cell_prod.equals(ProductCodes.coduriProdus(produs).get(j))) {
						if (SPM_main.sheet_date[i][8] != null && !SPM_main.sheet_date[i][8].equals("")) {
							if (SPM_main.sheet_date[i][8].equals(an)) {
								String cell_luna = SPM_main.sheet_date[i][3];
								if (cell_luna != null) {
									for (int k = 0; k < luni.size(); k++) {
										if (cell_luna.equals(luni.get(k))) {
											if (SPM_main.sheet_date[i][4] != null && !SPM_main.sheet_date[i][4].equals("")) {
												sumValueMonth.set(k, sumValueMonth.get(k) + Double.parseDouble(SPM_main.sheet_date[i][4]));
											}
										}
									}
								}
							}		
						}
					}
				}
			}
		}
		for (int i = 0; i < sumValueMonth.size(); i++) {
			sumValueMonth.set(i, sumValueMonth.get(i) * (-1));
		}
		return sumValueMonth;
	}
}