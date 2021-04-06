import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SumYear {

	public static ArrayList<Integer> sumQuantityYear (String produs, ArrayList<String> ani) throws FileNotFoundException {

		// Construiesc un ArrayList de dimensiune egala cu numarul de ani, si stochez in fiecare element cantitatea vanzarilor produsului pentru fiecare an

		ArrayList<Integer> sumQuantityYear = new ArrayList<>();
		for (int i = 0; i < ani.size(); i++) {
			sumQuantityYear.add(0);
		}
		for (int i = 0; i < SPM_main.sheet_date.length; i++) {
			if (SPM_main.sheet_date[i][6] != null) {
				String cell_prod = SPM_main.sheet_date[i][6];
				if (cell_prod != null) {
					for (int j = 0; j < ProductCodes.coduriProdus(produs).size(); j++) {
						if (cell_prod.equals(ProductCodes.coduriProdus(produs).get(j))) {
							String cell_an = SPM_main.sheet_date[i][8];
							if (cell_an != null) {
								for (int k = 0; k < ani.size(); k++) {
									if (cell_an.equals(ani.get(k))) {
										if (SPM_main.sheet_date[i][5] != null && !SPM_main.sheet_date[i][5].equals("")) {
											sumQuantityYear.set(k, sumQuantityYear.get(k) + Integer.parseInt(SPM_main.sheet_date[i][5]));
										}
									}
								}
							}
						}		
					}
				}
			}
		}		
		for (int i = 0; i < sumQuantityYear.size(); i++) {
			sumQuantityYear.set(i, sumQuantityYear.get(i) * (-1));
		}
		return sumQuantityYear;
	}

	public static ArrayList<Double> sumValueYear (String produs, ArrayList<String> ani) throws FileNotFoundException {

		// Construiesc un ArrayList de dimensiune egala cu numarul de ani, si stochez in fiecare element valoarea vanzarilor produsului pentru fiecare an

		ArrayList<Double> sumValueYear = new ArrayList<>();
		for (int i = 0; i < ani.size(); i++) {
			sumValueYear.add(0.0);
		}
		for (int i = 0; i < SPM_main.sheet_date.length; i++) {
			if (SPM_main.sheet_date[i][6] != null) {
				String cell_prod = SPM_main.sheet_date[i][6];
				for (int j = 0; j < ProductCodes.coduriProdus(produs).size(); j++) {
					if (cell_prod.equals(ProductCodes.coduriProdus(produs).get(j))) {
						String cell_an = SPM_main.sheet_date[i][8];
						if (cell_an != null) {
							for (int k = 0; k < ani.size(); k++) {
								if (cell_an.equals(ani.get(k))) {
									if (SPM_main.sheet_date[i][4] != null && !SPM_main.sheet_date[i][4].equals("")) {
										if (SPM_main.sheet_date[i][1].contentEquals("70401100")) {
											sumValueYear.set(k, sumValueYear.get(k) + Double.parseDouble(SPM_main.sheet_date[i][4]));
										}
									}
								}
							}
						}
					}		
				}
			}
		}
		for (int i = 0; i < sumValueYear.size(); i++) {
			sumValueYear.set(i, sumValueYear.get(i) * (-1));
		}
		return sumValueYear;
	}
}