import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Utilities {

	public static void AddToPanel (JPanel panel, JLabel[] labels) {
		
		for (int i = 0; i < labels.length; i++) {
			panel.add(labels[i]);
		}
	}
	
	public static void SetVisible (JLabel[] labels, boolean b) {
		for (int i = 0; i < labels.length; i++) {
			labels[i].setVisible(b);
		}
	}
	
	public static JLabel[] CreateCategoryLabels(ArrayList<String> labels, Dimension d, ArrayList<String> text) {
		
		Font labelFont = new Font("Verdana", Font.BOLD, 14);

		JLabel[] name = new JLabel[labels.size()]; 
		
		for (int i = 0; i < labels.size(); i++) {
			name[i] = new JLabel (text.get(i));
			name[i].setBounds(30, 60 + i * 30, d.width, d.height);
			name[i].setHorizontalAlignment(SwingConstants.CENTER);
			name[i].setFont(labelFont);
			name[i].setForeground(Color.BLACK);	
		}
		return name;
	}
	
	public static JLabel[] CreateMonthsTitleLabels(ArrayList<String> labels, Dimension d, ArrayList<String> text) {
		
		Font labelFont = new Font("Verdana", Font.BOLD, 14);

		JLabel[] name = new JLabel[labels.size()]; 
		
		for (int i = 0; i < labels.size(); i++) {
			name[i] = new JLabel (text.get(i));
			name[i].setBounds(320 + i * 100, 10, d.width, d.height);
			name[i].setHorizontalAlignment(SwingConstants.CENTER);
			name[i].setFont(labelFont);
			name[i].setForeground(Color.BLACK);	
		}
		return name;
	}
	
	public static JLabel[] CreateYearsTitleLabels(ArrayList<String> labels, Dimension d, ArrayList<String> text) {
		
		Font labelFont = new Font("Verdana", Font.BOLD, 14);

		JLabel[] name = new JLabel[labels.size()]; 
		
		for (int i = 0; i < labels.size(); i++) {
			name[i] = new JLabel (text.get(i));
			name[i].setBounds(200 + i * 200, 10, d.width, d.height);
			name[i].setHorizontalAlignment(SwingConstants.CENTER);
			name[i].setFont(labelFont);
			name[i].setForeground(Color.BLACK);	
		}
		return name;
	}

	public static JLabel[] CreateYearsQuantityLabels(ArrayList<String> labels, Dimension d) {

		Font labelFont = new Font("Verdana", Font.BOLD, 14);

		JLabel[] name = new JLabel[labels.size()]; 
		
		for (int i = 0; i < labels.size(); i++) {
			name[i] = new JLabel();
//			name[i] = new JLabel (text.get(i));
			name[i].setBounds(200 + i * 200, 60, d.width, d.height);
			name[i].setHorizontalAlignment(SwingConstants.CENTER);
			name[i].setFont(labelFont);
			name[i].setForeground(Color.BLACK);	
		}
		return name;
	}
	
	public static JLabel[] CreateYearsValueLabels(ArrayList<String> labels, Dimension d) {
		
		Font labelFont = new Font("Verdana", Font.BOLD, 14);

		JLabel[] name = new JLabel[labels.size()]; 
		
		for (int i = 0; i < labels.size(); i++) {
			name[i] = new JLabel();
			name[i].setBounds(200 + i * 200, 90, d.width, d.height);
			name[i].setHorizontalAlignment(SwingConstants.CENTER);
			name[i].setFont(labelFont);
			name[i].setForeground(Color.BLACK);	
		}
		return name;
	}
	
	public static JLabel[] CreateMonthsQuantityLabels(ArrayList<String> labels, Dimension d) {
		
		Font labelFont = new Font("Verdana", Font.BOLD, 14);

		JLabel[] name = new JLabel[labels.size()]; 
		
		for (int i = 0; i < labels.size(); i++) {
			name[i] = new JLabel();
			name[i].setBounds(320 + i * 100, 60, d.width, d.height);
			name[i].setHorizontalAlignment(SwingConstants.CENTER);
			name[i].setFont(labelFont);
			name[i].setForeground(Color.BLACK);	
		}
		return name;
	}

	public static JLabel[] CreateMonthsValueLabels(ArrayList<String> labels, Dimension d) {
		
		Font labelFont = new Font("Verdana", Font.BOLD, 14);

		JLabel[] name = new JLabel[labels.size()]; 
		
		for (int i = 0; i < labels.size(); i++) {
			name[i] = new JLabel();
			name[i].setBounds(320 + i * 100, 90, d.width, d.height);
			name[i].setHorizontalAlignment(SwingConstants.CENTER);
			name[i].setFont(labelFont);
			name[i].setForeground(Color.BLACK);	
		}
		return name;
	}

	public static JLabel[] CalculateQuantityYear (String text_product, JLabel[] bottomLabelsYearsQuantity) {

		ArrayList<String> ani = new ArrayList<String>();	//Construct an array list of string containing years
		ani.add("2016");
		ani.add("2017");
		ani.add("2018");
		ani.add("2019");
		ani.add("2020");
		ani.add("2021");
		ArrayList<Integer> buc_ani = null;
			try {
				buc_ani = SumYear.sumQuantityYear(text_product, ani);
			}
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		for (int i = 0; i < bottomLabelsYearsQuantity.length; i++) {
			if (buc_ani.get(i) == 0) {
				bottomLabelsYearsQuantity[i].setText("-");
			}
			else {
				buc_ani.get(i).toString();
				bottomLabelsYearsQuantity[i].setText((String.format("%,d", buc_ani.get(i))));
			}
		}
		return bottomLabelsYearsQuantity;
	}
	
	public static JLabel[] CalculateValueYear(String text_product, JLabel[] bottomLabelsYearsValue) {

		final DecimalFormat df2 = new DecimalFormat ("###,###.00");
		
		ArrayList<String> ani = new ArrayList<String>();	//Construct an array list of string containing years
			ani.add("2016");
			ani.add("2017");
			ani.add("2018");
			ani.add("2019");
			ani.add("2020");
			ani.add("2021");

		ArrayList<Double> eur_ani = null;
		
		try {
			eur_ani = SumYear.sumValueYear(text_product, ani);
		}
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		for (int i = 0; i < bottomLabelsYearsValue.length; i++) {
			if (eur_ani.get(i) == 0) {
				bottomLabelsYearsValue[i].setText("-");
			}
			else {
//				eur_ani.get(i).toString();
				bottomLabelsYearsValue[i].setText(df2.format(eur_ani.get(i)));
			}
		}
		return bottomLabelsYearsValue;
	}
	
	public static JLabel[] CalculateQuantityMonth(String text_product, String text_year,JLabel[] bottomLabelsMonthsQuantity) {

		ArrayList<String> luni = new ArrayList<String>();	//Construct an array list of string containing months
			luni.add("ian");
			luni.add("feb");
			luni.add("mar");
			luni.add("apr");
			luni.add("mai");
			luni.add("iun");
			luni.add("iul");
			luni.add("aug");
			luni.add("sept");
			luni.add("oct");
			luni.add("nov");
			luni.add("dec");
		
		ArrayList<Integer> buc_luni = null;
		
		try {
			buc_luni = SumMonth.sumQuantityMonth(text_product, text_year, luni);
		}
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		
		for (int i = 0; i < bottomLabelsMonthsQuantity.length; i++) {
			if (buc_luni.get(i) == 0) {
				bottomLabelsMonthsQuantity[i].setText("-");
			}
			else {
				buc_luni.get(i).toString();
				bottomLabelsMonthsQuantity[i].setText((String.format("%,d", buc_luni.get(i))));
			}
		}
		return bottomLabelsMonthsQuantity;
	}

	public static JLabel[] CalculateValueMonth(String text_product, String text_year,JLabel[] bottomLabelsMonthsValue) {

		final DecimalFormat df2 = new DecimalFormat ("###,###.00");
		
		ArrayList<String> luni = new ArrayList<String>();	//Construct an array list of string containing months
			luni.add("ian");
			luni.add("feb");
			luni.add("mar");
			luni.add("apr");
			luni.add("mai");
			luni.add("iun");
			luni.add("iul");
			luni.add("aug");
			luni.add("sept");
			luni.add("oct");
			luni.add("nov");
			luni.add("dec");
		
		ArrayList<Double> eur_luni = null;
		
		try {
			eur_luni = SumMonth.sumValueMonth(text_product, text_year, luni);
		}
		catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
		e1.printStackTrace();
		}
		
		for (int i = 0; i < bottomLabelsMonthsValue.length; i++) {
			if (eur_luni.get(i) == 0) {
				bottomLabelsMonthsValue[i].setText("-");
			}
			else {
//				eur_luni.get(i).toString();
				bottomLabelsMonthsValue[i].setText(df2.format(eur_luni.get(i)));
			}
		}
		return bottomLabelsMonthsValue;
	}

	
}
