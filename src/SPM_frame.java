import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

public class SPM_frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int FRAME_WIDTH = 1550;
	private static final int FRAME_HEIGHT = 800;

	private JSplitPane splitPane;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JComboBox<String> selectYear;

	private JLabel p1l1;
	private JLabel p2l1;
	private JLabel p2_an;
	private JLabel p2_anbuc;
	private JLabel p2_aneur;

	private JComboBox<String> selectProduct;

	static String first = new String("Raport pe ani");
	static String second = new String("Raport pe luni");
	boolean year = true;

	private static DecimalFormat df2 = new DecimalFormat ("###,###.00");

	private static ArrayList<String> bottomMonthsTitleNames;
	private static ArrayList<String> bottomYearsTitleNames;
	private static ArrayList<String> bottomYearsQuantityNames;
	private static ArrayList<String> bottomYearsValueNames;
	private static ArrayList<String> bottomMonthsQuantityNames;
	private static ArrayList<String> bottomMonthsValueNames;

	private static Dimension bottomMonthsTitleDimension;
	private static Dimension bottomYearsTitleDimension;
	private static Dimension bottomYearsQuantityDimension;
	private static Dimension bottomYearsValueDimension;
	private static Dimension bottomMonthsQuantityDimension;
	private static Dimension bottomMonthsValueDimension;

	private static ArrayList<String> bottomMonthsTitleText;
	private static ArrayList<String> bottomYearsTitleText;

	private static JLabel[] bottomCategoryLabels;
	private static JLabel[] bottomLabelsMonthsTitle;
	private static JLabel[] bottomLabelsYearsTitle;
	private static JLabel[] bottomLabelsYearsQuantity;
	private static JLabel[] bottomLabelsYearsValue;
	private static JLabel[] bottomLabelsMonthsQuantity;
	private static JLabel[] bottomLabelsMonthsValue;

	public static ArrayList<Integer> buc_ani;
	public static ArrayList<Integer> buc_luni;
	public static ArrayList<Double> eur_ani;
	public static ArrayList<Double> eur_luni;

	public DefaultCategoryDataset dataset_years;
	public DefaultCategoryDataset dataset_months;

	private ChartPanel chartPanel_years;
	private ChartPanel chartPanel_months;

	public SPM_frame() throws InvalidFormatException, FileNotFoundException {

		setTitle("Sales of Printed Materials");
		createComponents();			
		setSize(FRAME_WIDTH, FRAME_HEIGHT);	
	}
	public void createComponents() throws InvalidFormatException, FileNotFoundException {

		splitPane = new JSplitPane();										// Construct a splitPane that will hold the top and he bottom panels
		setPreferredSize(new Dimension(1550, 800));
		getContentPane().setLayout(new GridLayout());
		getContentPane().add(splitPane);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setDividerLocation(120);
		splitPane.setTopComponent(topPanel);
		splitPane.setBottomComponent(bottomPanel);

		topPanel = new JPanel();											// Construct the topPanel that will hold the selection area
		topPanel.setLayout(null);

		bottomPanel = new JPanel();											// Construct the bottomPanel that will hold the reports and charts by years or by months
		bottomPanel.setLayout((LayoutManager) new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		bottomPanel.setBackground(new Color(224, 224, 224));
		bottomPanel.setLayout(null);

		p1l1 = new JLabel("");												// Construct a label to catch the selected product
		p1l1.setPreferredSize(new Dimension(1120, 40));
		Dimension size1 = p1l1.getPreferredSize();
		p1l1.setBounds(20, 55, size1.width, size1.height);
		p1l1.setHorizontalAlignment(SwingConstants.CENTER);
		p1l1.setFont(new Font("Verdana", Font.BOLD, 22));
		p1l1.setOpaque(true);
		p1l1.setBackground(new Color(224, 224, 224));
		p1l1.setForeground(Color.RED);

		JRadioButton byYears = new JRadioButton(first, true);				// Construct a radioButton to select the report by years
		byYears.setBounds(1210, 25, 150, 30);
		byYears.setActionCommand(first);

		JRadioButton byMonths = new JRadioButton(second);					// Construct a radioButton to select the report by months
		byMonths.setBounds(1210, 65, 150, 30);
		byMonths.setActionCommand(second);

		ButtonGroup group = new ButtonGroup();								// Group the above radioButtons
		group.add(byYears);
		group.add(byMonths);

		RadioListener myListener = new RadioListener();						// Register a listener for the radio buttons
		byYears.addActionListener(myListener);
		byMonths.addActionListener(myListener);

		String[] years_array = new String[7];								// Construct an array containing the list of years to feed the comboBox
		years_array[0] = "Alege anul";
		years_array[1] = "2016";
		years_array[2] = "2017";
		years_array[3] = "2018";
		years_array[4] = "2019";
		years_array[5] = "2020";
		years_array[6] = "2021";

		ArrayList<String> luni = new ArrayList<String>();					//Construct an ArrayList of strings containing the list of months, to display the report by months
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

		selectYear = new JComboBox<>(years_array);							//Construct a JComboBox named "selectYear", to select the year for which the report on months will be constructed
		selectYear.setBounds(1360, 65, 110, 30);
		selectYear.setBackground(Color.WHITE);
		selectYear.setVisible(false);

		selectYear.addItemListener(new ItemListener() {						//Add a Listener for the JComboBox "selectYear"
			public void itemStateChanged(ItemEvent e_selectYear) {
				p2_an.setText((String) e_selectYear.getItem());
				if (e_selectYear.getStateChange() == ItemEvent.SELECTED) {

					Integer buc_an = 0;

					// Calculus for quantities (BUC) by months

					if (selectYear.getSelectedItem().toString().contentEquals("Alege anul")) {
						for (int i = 0; i < bottomLabelsMonthsQuantity.length; i++) {
							bottomLabelsMonthsQuantity[i].setText(null);
						}
						for (int i = 0; i < bottomLabelsMonthsValue.length; i++) {
							bottomLabelsMonthsValue[i].setText(null);
						}
						p2_aneur.setText(null);
					}
					else {
						Utilities.CalculateQuantityMonth(p1l1.getText(), p2_an.getText(), bottomLabelsMonthsQuantity);
						try {
							buc_luni = SumMonth.sumQuantityMonth(p1l1.getText(), p2_an.getText(), luni);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}						
						for (int i = 0; i < buc_luni.size(); i++) {
							buc_an = buc_an + buc_luni.get(i);
						}
						if (buc_an == 0) {
							p2_anbuc.setText("-");
						}
						else {
							p2_anbuc.setText(String.format("%,d", buc_an));
						}

						// Calculus for values (EUR) by months	

						Double eur_an = 0.0;

						Utilities.CalculateValueMonth(p1l1.getText(), p2_an.getText(), bottomLabelsMonthsValue);
						try {
							eur_luni = SumMonth.sumValueMonth(p1l1.getText(), p2_an.getText(), luni);
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}						
						for (int i = 0; i < eur_luni.size(); i++) {
							eur_an = eur_an + eur_luni.get(i);
						}
						if (eur_an == 0) {
							p2_aneur.setText("-");
						}
						else {
							p2_aneur.setText(df2.format(eur_an));
						}
					}

					//Create Months chart

					if(e_selectYear.getStateChange() == ItemEvent.SELECTED && buc_luni != null && eur_luni != null) {
						try {
							dataset_months = Graph_months.CreateDatasetMonths(buc_luni, eur_luni, "Vanzari (BUC)", "Venituri (EUR)", p1l1.getText(), p2_an.getText());
						} catch (FileNotFoundException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						JFreeChart barChart_months = Graph_months.runGraph("", "Luni", "Valoare", dataset_months);
						chartPanel_months.setBounds(200, 150, 1320, 450);
						chartPanel_months.setChart(barChart_months);
					}				
				}
			}
		});

		selectProduct = new JComboBox<>(Products.products());						//Construct a JComboBox named "selectProduct", to select an item and view information about this item
		selectProduct.setBounds(20,10,400,25);
		selectProduct.setPreferredSize(new Dimension(400, 25));
		selectProduct.setBackground(Color.WHITE);

		selectProduct.addItemListener(new ItemListener() {							//Add a Listener for the JComboBox "SelectProduct"
			public void itemStateChanged(ItemEvent e_selectProduct) {
				p1l1.setText((String) e_selectProduct.getItem());

				ArrayList<String> ani = new ArrayList<String>();					//Construct an array list of string containing years
				ani.add("2016");
				ani.add("2017");
				ani.add("2018");
				ani.add("2019");
				ani.add("2020");
				ani.add("2021");

				if (p1l1.getText().equals("Alegeti un produs")) {
					for (int i = 0; i < bottomLabelsYearsQuantity.length; i++) {
						bottomLabelsYearsQuantity[i].setText(null);
					}
					for (int i = 0; i < bottomLabelsYearsValue.length; i++) {
						bottomLabelsYearsValue[i].setText(null);
					}
				}
				else {
					Utilities.CalculateQuantityYear(p1l1.getText(), bottomLabelsYearsQuantity);
					Utilities.CalculateValueYear(p1l1.getText(), bottomLabelsYearsValue);
					try {
						buc_ani = SumYear.sumQuantityYear(p1l1.getText(), ani);
						eur_ani = SumYear.sumValueYear(p1l1.getText(), ani);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}						
				}

				//Create Years chart

				if (e_selectProduct.getStateChange() == ItemEvent.SELECTED && Utilities.CalculateQuantityYear(p1l1.getText(), bottomLabelsYearsQuantity) != null 
						&& Utilities.CalculateValueYear(p1l1.getText(), bottomLabelsYearsValue) != null) {	

					try {
						dataset_years = Graph_years.CreateDatasetYears(buc_ani, eur_ani, "Vanzari (BUC)", "Venituri (EUR)", p1l1.getText(), p2_an.getText());
					} 
					catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					JFreeChart barChart = Graph_years.runGraph("", "Ani", "Valoare", dataset_years);
					chartPanel_years.setBounds(100, 150, 1250, 450);
					chartPanel_years.setChart(barChart);
				}

				// Calculus for quantities (BUC) by months

				Integer buc_an = 0;

				if (!selectYear.getSelectedItem().toString().contentEquals("Alege anul")) {
					Utilities.CalculateQuantityMonth(p1l1.getText(), p2_an.getText(), bottomLabelsMonthsQuantity);
					try {
						buc_luni = SumMonth.sumQuantityMonth(p1l1.getText(), p2_an.getText(), luni);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}						
					for (int i = 0; i < buc_luni.size(); i++) {
						buc_an = buc_an + buc_luni.get(i);
					}
					if (buc_an == 0) {
						p2_anbuc.setText("-");
					}
					else {
						p2_anbuc.setText(String.format("%,d", buc_an));
					}

					// Calculus for values (EUR) by months

					Double eur_an = 0.0;

					Utilities.CalculateValueMonth(p1l1.getText(), p2_an.getText(), bottomLabelsMonthsValue);
					try {
						eur_luni = SumMonth.sumValueMonth(p1l1.getText(), p2_an.getText(), luni);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}						
					for (int i = 0; i < eur_luni.size(); i++) {
						eur_an = eur_an + eur_luni.get(i);
					}
					if (eur_an == 0) {
						p2_aneur.setText("-");
					}
					else {
						p2_aneur.setText(df2.format(eur_an));
					}
				}

				//Create Months chart

				if (buc_luni != null && eur_luni != null) {
					try {
						dataset_months = Graph_months.CreateDatasetMonths(buc_luni, eur_luni, "Vanzari (BUC)", "Venituri (EUR)", p1l1.getText(), p2_an.getText());
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					JFreeChart barChart_months = Graph_months.runGraph("", "Luni", "Valoare", dataset_months);
					chartPanel_months.setBounds(200, 150, 1320, 450);
					chartPanel_months.setChart(barChart_months);
				}		
			}
		});

		//Add labels and the comboBox to the topPanel

		topPanel.add(selectProduct);
		topPanel.add(p1l1);
		topPanel.add(byYears);
		topPanel.add(byMonths);
		topPanel.add(selectYear);

		splitPane.add(topPanel);

		// Create Category labels for bottom panel

		ArrayList<String> bottomCategoryNames = new ArrayList<>();				// ArrayList with names for category labels (Vanzari (BUC), Venituri (EUR))
		Collections.addAll(bottomCategoryNames, "p2_buc", "p2_eur");
		Dimension categoryLabelsDimension = new Dimension(120, 30);
		ArrayList<String> text_CategoryLabel = new ArrayList<>();
		text_CategoryLabel.add("Vanzari (BUC)");
		text_CategoryLabel.add("Venituri (EUR)");
		bottomCategoryLabels = Utilities.CreateCategoryLabels(bottomCategoryNames, categoryLabelsDimension, text_CategoryLabel);

		// Create Months Title labels for bottom panel

		bottomMonthsTitleNames = new ArrayList<>();								// ArrayList with names for Months Title labels )
		Collections.addAll(bottomMonthsTitleNames, "p2l2", "p2l3", "p2l4", "p2l5", "p2l6", "p2l7", "p2l8", "p2l9", "p2l10", "p2l11", "p2l12", "p2l13");
		bottomMonthsTitleDimension = new Dimension(80, 30);
		bottomMonthsTitleText = new ArrayList<>();
		Collections.addAll(bottomMonthsTitleText, "ian", "feb", "mar", "apr", "mai", "iun", "iul", "aug", "sept", "oct", "nov", "dec");
		bottomLabelsMonthsTitle = Utilities.CreateMonthsTitleLabels(bottomMonthsTitleNames, bottomMonthsTitleDimension, bottomMonthsTitleText);

		//Create Years Title labels for bottom panel

		bottomYearsTitleNames = new ArrayList<>();								// ArrayList with names for Years Title labels )
		Collections.addAll(bottomYearsTitleNames, "p2l14", "p2l15", "p2l16", "p2l17", "p2l18", "p2l19");
		bottomYearsTitleDimension = new Dimension(150, 30);
		bottomYearsTitleText = new ArrayList<>();
		Collections.addAll(bottomYearsTitleText, "TOTAL an 2016", "TOTAL an 2017", "TOTAL an 2018", "TOTAL an 2019", "TOTAL an 2020", "TOTAL an 2021");
		bottomLabelsYearsTitle = Utilities.CreateYearsTitleLabels(bottomYearsTitleNames, bottomYearsTitleDimension, bottomYearsTitleText);

		// Create Years Quantity labels for bottom panel

		bottomYearsQuantityNames = new ArrayList<>();							// ArrayList with names for Years Quantity labels )
		Collections.addAll(bottomYearsQuantityNames, "p2_2016buc", "p2_2017buc", "p2_2018buc", "p2_2019buc", "p2_2020buc", "p2_2021buc");
		bottomYearsQuantityDimension = new Dimension(150, 30);
		bottomLabelsYearsQuantity = Utilities.CreateYearsQuantityLabels(bottomYearsQuantityNames, bottomYearsQuantityDimension);

		// Create Years Values labels for bottom panel

		bottomYearsValueNames = new ArrayList<>();								// ArrayList with names for Years Value labels )
		Collections.addAll(bottomYearsValueNames, "p2_2016eur", "p2_2017eur", "p2_2018eur", "p2_2019eur", "p2_2020eur", "p2_2021eur");
		bottomYearsValueDimension = new Dimension(150, 30);
		bottomLabelsYearsValue = Utilities.CreateYearsValueLabels(bottomYearsValueNames, bottomYearsValueDimension);

		// Create Months Quantity labels for bottom panel		

		bottomMonthsQuantityNames = new ArrayList<>();							// ArrayList with names for Years Quantity labels )
		Collections.addAll(bottomMonthsQuantityNames, "p2_ianbuc", "p2_febbuc", "p2_marbuc", "p2_aprbuc", "p2_maibuc", "p2_iunbuc", "p2_iulbuc", "p2_augbuc",
				"p2_septbuc", "p2_octbuc", "p2_novbuc", "p2_decbuc");
		bottomMonthsQuantityDimension = new Dimension(80, 30);
		bottomLabelsMonthsQuantity = Utilities.CreateMonthsQuantityLabels(bottomMonthsQuantityNames, bottomMonthsQuantityDimension);

		// Create Months Values labels for bottom panel

		bottomMonthsValueNames = new ArrayList<>();								// ArrayList with names for Years Quantity labels )
		Collections.addAll(bottomMonthsValueNames, "p2_ianeur", "p2_febeur", "p2_mareur", "p2_apreur", "p2_maieur", "p2_iuneur", "p2_iuleur", "p2_augeur",
				"p2_septeur", "p2_octeur", "p2_noveur", "p2_deceur");
		bottomMonthsValueDimension = new Dimension(80, 30);
		bottomLabelsMonthsValue = Utilities.CreateMonthsValueLabels(bottomMonthsValueNames, bottomMonthsValueDimension);

		Font rowTitleFont = new Font("Verdana", Font.BOLD, 14);
		Dimension rowTitleDimension = new Dimension(80,30);

		// Create Labels for years Title report in bottom panel

		p2l1 = new JLabel("TOTAL an");											// Column title "TOTAL an" for the report by months
		p2l1.setPreferredSize(rowTitleDimension);
		p2l1.setBounds(200, 10, 80, 30);
		p2l1.setHorizontalAlignment(SwingConstants.CENTER);
		p2l1.setFont(rowTitleFont);
		p2l1.setForeground(Color.BLACK);
		p2l1.setVisible(false);

		p2_an = new JLabel();													// Column title selected year for the report by months
		p2_an.setPreferredSize(rowTitleDimension);
		p2_an.setBounds(200, 30, 80, 30);
		p2_an.setHorizontalAlignment(SwingConstants.CENTER);
		p2_an.setFont(rowTitleFont);
		p2_an.setForeground(Color.BLACK);
		p2_an.setVisible(false);

		p2_anbuc = new JLabel();												// Quantity of selected product sales for selected year
		p2_anbuc.setPreferredSize(rowTitleDimension);
		p2_anbuc.setBounds(200, 60, 80, 30);
		p2_anbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_anbuc.setFont(rowTitleFont);
		p2_anbuc.setForeground(Color.BLACK);	
		p2_anbuc.setVisible(false);

		p2_aneur = new JLabel();												// Value of selected product sales for selected year
		p2_aneur.setPreferredSize(rowTitleDimension);
		p2_aneur.setBounds(200, 90, 80, 30);
		p2_aneur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_aneur.setFont(rowTitleFont);
		p2_aneur.setForeground(Color.BLACK);	
		p2_aneur.setVisible(false);

		chartPanel_years = new ChartPanel(null);
		chartPanel_months = new ChartPanel(null);

		//Add labels to bottomPanel

		Utilities.AddToPanel(bottomPanel, bottomCategoryLabels);
		Utilities.AddToPanel(bottomPanel, bottomLabelsMonthsTitle);
		Utilities.SetVisible(bottomLabelsMonthsTitle, false);
		Utilities.AddToPanel(bottomPanel, bottomLabelsYearsTitle);
		Utilities.SetVisible(bottomLabelsYearsTitle, true);
		Utilities.AddToPanel(bottomPanel, bottomLabelsYearsQuantity);
		Utilities.SetVisible(bottomLabelsYearsQuantity, true);
		Utilities.AddToPanel(bottomPanel, bottomLabelsYearsValue);
		Utilities.SetVisible(bottomLabelsYearsValue, true);
		Utilities.AddToPanel(bottomPanel, bottomLabelsMonthsQuantity);
		Utilities.SetVisible(bottomLabelsMonthsQuantity, false);
		Utilities.AddToPanel(bottomPanel, bottomLabelsMonthsValue);
		Utilities.SetVisible(bottomLabelsMonthsValue, false);
		bottomPanel.add(p2l1);
		bottomPanel.add(p2_an);
		bottomPanel.add(p2_anbuc);
		bottomPanel.add(p2_aneur);
		bottomPanel.add(chartPanel_years);
		bottomPanel.add(chartPanel_months);

		splitPane.add(bottomPanel);
		pack();
	}

	class RadioListener implements ActionListener { 

		public void actionPerformed (ActionEvent e) {
			if (e.getActionCommand() == first) {
				selectYear.setVisible(false);
				Utilities.SetVisible(bottomLabelsMonthsTitle, false);
				Utilities.SetVisible(bottomLabelsYearsTitle, true);
				Utilities.SetVisible(bottomLabelsYearsQuantity, true);
				Utilities.SetVisible(bottomLabelsYearsValue, true);
				Utilities.SetVisible(bottomLabelsMonthsQuantity, false);
				Utilities.SetVisible(bottomLabelsMonthsValue, false);
				p2l1.setVisible(false);
				p2_an.setVisible(false);
				p2_anbuc.setVisible(false);
				p2_aneur.setVisible(false);
				chartPanel_years.setVisible(true);
				chartPanel_months.setVisible(false);
				year = true;
			}
			else if (e.getActionCommand() == second){
				selectYear.setVisible(true);
				Utilities.SetVisible(bottomLabelsMonthsTitle, true);
				Utilities.SetVisible(bottomLabelsYearsTitle, false);
				Utilities.SetVisible(bottomLabelsYearsQuantity, false);
				Utilities.SetVisible(bottomLabelsYearsValue, false);
				Utilities.SetVisible(bottomLabelsMonthsQuantity, true);
				Utilities.SetVisible(bottomLabelsMonthsValue, true);
				p2l1.setVisible(true);
				p2_an.setVisible(true);
				p2_anbuc.setVisible(true);
				p2_aneur.setVisible(true);
				chartPanel_years.setVisible(false);
				chartPanel_months.setVisible(true);
				year = false;
			}
		}
	}
}

