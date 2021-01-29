import java.util.ArrayList;

import javax.swing.JPanel;

public class Utilities {

	public static void AddToPanel (JPanel panel, ArrayList<String> labels) {
		
		for (int i = 0; i < labels.size(); i++) {
			panel.add(panel, labels.get(i));
		}
	}
}
