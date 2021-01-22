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

public class SPM_frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int FRAME_WIDTH = 1550;
	private static final int FRAME_HEIGHT = 800;

	private JSplitPane splitPane;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JComboBox<String> selectYear;

	private JLabel p1l1;
	private JLabel p2_buc;
	private JLabel p2_eur;
	private JLabel p2l1;
	private JLabel p2_an;
	private JLabel p2l2;
	private JLabel p2l3;
	private JLabel p2l4;
	private JLabel p2l5;
	private JLabel p2l6;
	private JLabel p2l7;
	private JLabel p2l8;
	private JLabel p2l9;
	private JLabel p2l10;
	private JLabel p2l11;
	private JLabel p2l12;
	private JLabel p2l13;
	private JLabel p2l14;
	private JLabel p2l15;
	private JLabel p2l16;
	private JLabel p2l17;
	private JLabel p2l18;
	private JLabel p2l19;
	private JLabel p2_2016buc;
	private JLabel p2_2017buc;
	private JLabel p2_2018buc;
	private JLabel p2_2019buc;
	private JLabel p2_2020buc;
	private JLabel p2_2021buc;
	private JLabel p2_2016eur;
	private JLabel p2_2017eur;
	private JLabel p2_2018eur;
	private JLabel p2_2019eur;
	private JLabel p2_2020eur;
	private JLabel p2_2021eur;
	private JLabel p2_anbuc;
	private JLabel p2_ianbuc;
	private JLabel p2_febbuc;
	private JLabel p2_marbuc;
	private JLabel p2_aprbuc;
	private JLabel p2_maibuc;
	private JLabel p2_iunbuc;
	private JLabel p2_iulbuc;
	private JLabel p2_augbuc;
	private JLabel p2_septbuc;
	private JLabel p2_octbuc;
	private JLabel p2_novbuc;
	private JLabel p2_decbuc;

	private JLabel p2_aneur;
	private JLabel p2_ianeur;
	private JLabel p2_febeur;
	private JLabel p2_mareur;
	private JLabel p2_apreur;
	private JLabel p2_maieur;
	private JLabel p2_iuneur;
	private JLabel p2_iuleur;
	private JLabel p2_augeur;
	private JLabel p2_septeur;
	private JLabel p2_octeur;
	private JLabel p2_noveur;
	private JLabel p2_deceur;

	static String first = new String("Raport pe ani");
	static String second = new String("Raport pe luni");

	private static DecimalFormat df2 = new DecimalFormat ("###,###.00");

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

		JLabel p1l1 = new JLabel("");										// Construct a label to catch the selected product
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

		// Construct an array containing the list of years to feed the comboBox

		String[] years_array = new String[7];
		years_array[0] = "Alege anul";
		years_array[1] = "2016";
		years_array[2] = "2017";
		years_array[3] = "2018";
		years_array[4] = "2019";
		years_array[5] = "2020";
		years_array[6] = "2021";

		// Construct an array list containing the list of months, to display the report by months

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

		selectYear = new JComboBox<>(years_array);
		selectYear.setBounds(1360, 65, 110, 30);
		selectYear.setBackground(Color.WHITE);
		selectYear.setVisible(false);

		//Add a Listener for the JComboBox "selectYear"

		selectYear.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e_year) {
				p2_an.setText((String) e_year.getItem());
				if (e_year.getStateChange() == ItemEvent.SELECTED) {

					ArrayList<Integer> buc_luni = null;
					Integer buc_an = 0;

					// Calculus for quantities (BUC) by months

					if (selectYear.getSelectedItem().toString().contentEquals("Alege anul")) {	
						p2_ianbuc.setText(null);
						p2_febbuc.setText(null);
						p2_marbuc.setText(null);
						p2_aprbuc.setText(null);
						p2_maibuc.setText(null);
						p2_iunbuc.setText(null);
						p2_iulbuc.setText(null);
						p2_augbuc.setText(null);
						p2_septbuc.setText(null);
						p2_octbuc.setText(null);
						p2_novbuc.setText(null);
						p2_decbuc.setText(null);
						p2_anbuc.setText(null);
						p2_ianeur.setText(null);
						p2_febeur.setText(null);
						p2_mareur.setText(null);
						p2_apreur.setText(null);
						p2_maieur.setText(null);
						p2_iuneur.setText(null);
						p2_iuleur.setText(null);
						p2_augeur.setText(null);
						p2_septeur.setText(null);
						p2_octeur.setText(null);
						p2_noveur.setText(null);
						p2_deceur.setText(null);
						p2_aneur.setText(null);
					}
					else {
						try {
							buc_luni = SumMonth.sumQuantityMonth(p1l1.getText(), p2_an.getText(), luni);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						if (buc_luni.get(0) == 0) {
							p2_ianbuc.setText("-");
						}
						else {
							buc_luni.get(0).toString();
							p2_ianbuc.setText(String.format("%,d", buc_luni.get(0)));
						}
						if (buc_luni.get(1) == 0) {
							p2_febbuc.setText("-");
						}
						else {
							buc_luni.get(1).toString();
							p2_febbuc.setText(String.format("%,d", buc_luni.get(1)));
						}
						if (buc_luni.get(2) == 0) {
							p2_marbuc.setText("-");
						}
						else {
							buc_luni.get(2).toString();
							p2_marbuc.setText(String.format("%,d", buc_luni.get(2)));
						}
						if (buc_luni.get(3) == 0) {
							p2_aprbuc.setText("-");
						}
						else {
							buc_luni.get(3).toString();
							p2_aprbuc.setText(String.format("%,d", buc_luni.get(3)));				
						}
						if (buc_luni.get(4) == 0) {
							p2_maibuc.setText("-");
						}
						else {
						buc_luni.get(4).toString();
						p2_maibuc.setText(String.format("%,d", buc_luni.get(4)));
						}
						if (buc_luni.get(5) == 0) {
							p2_iunbuc.setText("-");
						}
						else {
							buc_luni.get(5).toString();
							p2_iunbuc.setText(String.format("%,d", buc_luni.get(5)));
						}
						if (buc_luni.get(6) == 0) {
							p2_iulbuc.setText("-");
						}
						else {
							buc_luni.get(6).toString();
							p2_iulbuc.setText(String.format("%,d", buc_luni.get(6)));
						}
						if (buc_luni.get(7) == 0) {
							p2_augbuc.setText("-");
						}
						else {
							buc_luni.get(7).toString();
							p2_augbuc.setText(String.format("%,d", buc_luni.get(7)));
						}
						if (buc_luni.get(8) == 0) {
							p2_septbuc.setText("-");
						}
						else {
							buc_luni.get(8).toString();
							p2_septbuc.setText(String.format("%,d", buc_luni.get(8)));
						}
						if (buc_luni.get(9) == 0) {
							p2_octbuc.setText("-");
						}
						else {
							buc_luni.get(9).toString();
							p2_octbuc.setText(String.format("%,d", buc_luni.get(9)));
						}
						if (buc_luni.get(10) == 0) {
							p2_novbuc.setText("-");
						}
						else {
							buc_luni.get(10).toString();
							p2_novbuc.setText(String.format("%,d", buc_luni.get(10)));
						}
						if (buc_luni.get(11) == 0) {
							p2_decbuc.setText("-");
						}
						else {
							buc_luni.get(11).toString();
							p2_decbuc.setText(String.format("%,d", buc_luni.get(11)));
						}
						buc_an = buc_luni.get(0) + buc_luni.get(1) + buc_luni.get(2) + buc_luni.get(3) + buc_luni.get(4) + buc_luni.get(5) + buc_luni.get(6) + buc_luni.get(7)
						+ buc_luni.get(8) + buc_luni.get(9) + buc_luni.get(10) + buc_luni.get(11);
						if (buc_an == 0) {
							p2_anbuc.setText("-");
						}
						else {
							p2_anbuc.setText(String.format("%,d", buc_an));
						}
							
						ArrayList<Double> eur_luni = null;
						Double eur_an = 0.0;

						// Calculus for values (EUR) by months

						try {
							eur_luni = SumMonth.sumValueMonth(p1l1.getText(), p2_an.getText(), luni);
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}					
						if (eur_luni.get(0) == 0) {
							p2_ianeur.setText("-");
						}
						else {
							eur_luni.get(0).toString();
							p2_ianeur.setText(df2.format(eur_luni.get(0)));
						}
						if (eur_luni.get(1) == 0) {
							p2_febeur.setText("-");
						}
						else {
							eur_luni.get(1).toString();
							p2_febeur.setText(df2.format(eur_luni.get(1)));
						}
						if (eur_luni.get(2) == 0) {
							p2_mareur.setText("-");
						}
						else {
							eur_luni.get(2).toString();
							p2_mareur.setText(df2.format(eur_luni.get(2)));
						}
						if (eur_luni.get(3) == 0) {
							p2_apreur.setText("-");
						}
						else {
							eur_luni.get(3).toString();
							p2_apreur.setText(df2.format(eur_luni.get(3)));				
						}
						if (eur_luni.get(4) == 0) {
							p2_maieur.setText("-");
						}
						else {
							eur_luni.get(4).toString();
							p2_maieur.setText(df2.format(eur_luni.get(4)));
						}
						if (eur_luni.get(5) == 0) {
							p2_iuneur.setText("-");
						}
						else {
							eur_luni.get(5).toString();
							p2_iuneur.setText(df2.format(eur_luni.get(5)));
						}
						if (eur_luni.get(6) == 0) {
							p2_iuleur.setText("-");
						}
						else {
							eur_luni.get(6).toString();
							p2_iuleur.setText(df2.format(eur_luni.get(6)));
						}
						if (eur_luni.get(7) == 0) {
							p2_augeur.setText("-");
						}
						else {
							eur_luni.get(7).toString();
							p2_augeur.setText(df2.format(eur_luni.get(7)));
						}
						if (eur_luni.get(8) == 0) {
							p2_septeur.setText("-");
						}
						else {
							eur_luni.get(8).toString();
							p2_septeur.setText(df2.format(eur_luni.get(8)));
						}
						if (eur_luni.get(9) == 0) {
							p2_octeur.setText("-");
						}
						else {
							eur_luni.get(9).toString();
							p2_octeur.setText(df2.format(eur_luni.get(9)));
						}
						if (eur_luni.get(10) == 0) {
							p2_noveur.setText("-");
						}
						else {
							eur_luni.get(10).toString();
							p2_noveur.setText(df2.format(eur_luni.get(10)));
						}
						if (eur_luni.get(11) == 0) {
							p2_deceur.setText("-");
						}
						else {
							eur_luni.get(11).toString();
							p2_deceur.setText(df2.format(eur_luni.get(11)));
						}
							
						eur_an = eur_luni.get(0) + eur_luni.get(1) + eur_luni.get(2) + eur_luni.get(3) + eur_luni.get(4) + eur_luni.get(5) + eur_luni.get(6) + eur_luni.get(7)
						+ eur_luni.get(8) + eur_luni.get(9) + eur_luni.get(10) + eur_luni.get(11);
						if (eur_an == 0) {
							p2_aneur.setText("-");
						}
						else {
							p2_aneur.setText(df2.format(eur_an));
						}
					}
				}
			}
		});

		//Construct a JComboBox named "selectProduct", to select an item and view information about this item

		JComboBox<String> selectProduct = new JComboBox<>(Products.products());
		selectProduct.setBounds(20,10,400,25);
		selectProduct.setPreferredSize(new Dimension(400, 25));
		selectProduct.setBackground(Color.WHITE);

		//Add a Listener for the JComboBox "SelectProduct"

		selectProduct.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				p1l1.setText((String) e.getItem());

				ArrayList<String> ani = new ArrayList<String>();	//Construct an array list of string containing years
				ani.add("2016");
				ani.add("2017");
				ani.add("2018");
				ani.add("2019");
				ani.add("2020");
				ani.add("2021");

				// Calculus for quantities (BUC) by years

				ArrayList<Integer> buc_ani = null;

				try {
					buc_ani = SumYear.sumQuantityYear((String)e.getItem(), ani);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (buc_ani.get(0) == 0) {
					p2_2016buc.setText("-");
				}
				else {
					buc_ani.get(0).toString();
					p2_2016buc.setText(String.format("%,d", buc_ani.get(0)) + " BUC");
				}
				if (buc_ani.get(1) == 0) {
					p2_2017buc.setText("-");
				}
				else {
					buc_ani.get(1).toString();
					p2_2017buc.setText(String.format("%,d", buc_ani.get(1)) + " BUC");
				}
				if (buc_ani.get(2) == 0) {
					p2_2018buc.setText("-");
				}
				else {
					buc_ani.get(2).toString();
					p2_2018buc.setText(String.format("%,d", buc_ani.get(2)) + " BUC");
				}
				if (buc_ani.get(3) == 0) {
					p2_2019buc.setText("-");
				}
				else {
					buc_ani.get(3).toString();
					p2_2019buc.setText(String.format("%,d", buc_ani.get(3)) + " BUC");				
				}
				if (buc_ani.get(4) == 0) {
					p2_2020buc.setText("-");
				}
				else {
					buc_ani.get(4).toString();
					p2_2020buc.setText(String.format("%,d", buc_ani.get(4)) + " BUC");
				}
				if (buc_ani.get(5) == 0) {
					p2_2021buc.setText("-");
				}
				else {
					buc_ani.get(5).toString();
					p2_2021buc.setText(String.format("%,d", buc_ani.get(5)) + " BUC");
				}
					
				// Calculus for values (EUR) by years

				ArrayList<Double> eur_ani = null;

				try {
					eur_ani = SumYear.sumValueYear((String)e.getItem(), ani);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (eur_ani.get(0) == 0) {
					p2_2016eur.setText("-");
				}
				else {
					p2_2016eur.setText(df2.format(eur_ani.get(0)) + " EUR");
				}
				if (eur_ani.get(1) == 0) {
					p2_2017eur.setText("-");
				}
				else {
					p2_2017eur.setText(df2.format(eur_ani.get(1)) + " EUR");
				}
				if (eur_ani.get(2) == 0) {
					p2_2018eur.setText("-");
				}
				else {
					p2_2018eur.setText(df2.format(eur_ani.get(2)) + " EUR");
				}
				if (eur_ani.get(3) == 0) {
					p2_2019eur.setText("-");
				}
				else {
					p2_2019eur.setText(df2.format(eur_ani.get(3)) + " EUR");
				}
				if (eur_ani.get(4) == 0) {
					p2_2020eur.setText("-");
				}
				else {
					p2_2020eur.setText(df2.format(eur_ani.get(4)) + " EUR");
				}
				if (eur_ani.get(5) == 0) {
					p2_2021eur.setText("-");
				}
				else {
					p2_2021eur.setText(df2.format(eur_ani.get(5)) + " EUR");
				}
					
				// Calculus for quantities (BUC) by months

				ArrayList<Integer> buc_luni = null;
				Integer buc_an = 0;
				if (!selectYear.getSelectedItem().toString().contentEquals("Alege anul")) {
					try {
						buc_luni = SumMonth.sumQuantityMonth(p1l1.getText(), p2_an.getText(), luni);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if (buc_luni.get(0) == 0) {
						p2_ianbuc.setText("-");
					}
					else {
						buc_luni.get(0).toString();
						p2_ianbuc.setText(String.format("%,d", buc_luni.get(0)));
					}
					if (buc_luni.get(1) == 0) {
						p2_febbuc.setText("-");
					}
					else {
						buc_luni.get(1).toString();
						p2_febbuc.setText(String.format("%,d", buc_luni.get(1)));
					}
					if (buc_luni.get(2) == 0) {
						p2_marbuc.setText("-");
					}
					else {
						buc_luni.get(2).toString();
						p2_marbuc.setText(String.format("%,d", buc_luni.get(2)));
					}
					if (buc_luni.get(3) == 0) {
						p2_aprbuc.setText("-");
					}
					else {
						buc_luni.get(3).toString();
						p2_aprbuc.setText(String.format("%,d", buc_luni.get(3)));				
					}
					if (buc_luni.get(4) == 0) {
						p2_maibuc.setText("-");
					}
					else {
						buc_luni.get(4).toString();
						p2_maibuc.setText(String.format("%,d", buc_luni.get(4)));
					}
					if (buc_luni.get(5) == 0) {
						p2_iunbuc.setText("-");
					}
					else {
						buc_luni.get(5).toString();
						p2_iunbuc.setText(String.format("%,d", buc_luni.get(5)));
					}
					if (buc_luni.get(6) == 0) {
						p2_iulbuc.setText("-");
					}
					else {
						buc_luni.get(6).toString();
						p2_iulbuc.setText(String.format("%,d", buc_luni.get(6)));
					}
					if (buc_luni.get(7) == 0) {
						p2_augbuc.setText("-");
					}
					else {
						buc_luni.get(7).toString();
						p2_augbuc.setText(String.format("%,d", buc_luni.get(7)));
					}
					if (buc_luni.get(8) == 0) {
						p2_septbuc.setText("-");
					}
					else {
						buc_luni.get(8).toString();
						p2_septbuc.setText(String.format("%,d", buc_luni.get(8)));
					}
					if (buc_luni.get(9) == 0) {
						p2_octbuc.setText("-");
					}
					else {
						buc_luni.get(9).toString();
						p2_octbuc.setText(String.format("%,d", buc_luni.get(9)));
					}
					if (buc_luni.get(10) == 0) {
						p2_novbuc.setText("-");
					}
					else {
						buc_luni.get(10).toString();
						p2_novbuc.setText(String.format("%,d", buc_luni.get(10)));
					}
					if (buc_luni.get(11) == 0) {
						p2_decbuc.setText("-");
					}
					else {
						buc_luni.get(11).toString();
						p2_decbuc.setText(String.format("%,d", buc_luni.get(11)));
					}

					buc_an = buc_luni.get(0) + buc_luni.get(1) + buc_luni.get(2) + buc_luni.get(3) + buc_luni.get(4) + buc_luni.get(5) + buc_luni.get(6) + buc_luni.get(7)
					+ buc_luni.get(8) + buc_luni.get(9) + buc_luni.get(10) + buc_luni.get(11);
					if (buc_an == 0) {
						p2_anbuc.setText("-");
					}
					else {
						p2_anbuc.setText(String.format("%,d", buc_an));
					}
						
					// Calculus for values (EUR) by months

					ArrayList<Double> eur_luni = null;
					Double eur_an = 0.0;

					try {
						eur_luni = SumMonth.sumValueMonth(p1l1.getText(), p2_an.getText(), luni);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					
					if (eur_luni.get(0) == 0) {
						p2_ianeur.setText("-");
					}
					else {
						eur_luni.get(0).toString();
						p2_ianeur.setText(df2.format(eur_luni.get(0)));
					}
					if (eur_luni.get(1) == 0) {
						p2_febeur.setText("-");
					}
					else {
						eur_luni.get(1).toString();
						p2_febeur.setText(df2.format(eur_luni.get(1)));
					}
					if (eur_luni.get(2) == 0) {
						p2_mareur.setText("-");
					}
					else {
						eur_luni.get(2).toString();
						p2_mareur.setText(df2.format(eur_luni.get(2)));
					}
					if (eur_luni.get(3) == 0) {
						p2_apreur.setText("-");
					}
					else {
						eur_luni.get(3).toString();
						p2_apreur.setText(df2.format(eur_luni.get(3)));				
					}
					if (eur_luni.get(4) == 0) {
						p2_maieur.setText("-");
					}
					else {
						eur_luni.get(4).toString();
						p2_maieur.setText(df2.format(eur_luni.get(4)));
					}
					if (eur_luni.get(5) == 0) {
						p2_iuneur.setText("-");
					}
					else {
						eur_luni.get(5).toString();
						p2_iuneur.setText(df2.format(eur_luni.get(5)));
					}
					if (eur_luni.get(6) == 0) {
						p2_iuleur.setText("-");
					}
					else {
						eur_luni.get(6).toString();
						p2_iuleur.setText(df2.format(eur_luni.get(6)));
					}
					if (eur_luni.get(7) == 0) {
						p2_augeur.setText("-");
					}
					else {
						eur_luni.get(7).toString();
						p2_augeur.setText(df2.format(eur_luni.get(7)));
					}
					if (eur_luni.get(8) == 0) {
						p2_septeur.setText("-");
					}
					else {
						eur_luni.get(8).toString();
						p2_septeur.setText(df2.format(eur_luni.get(8)));
					}
					if (eur_luni.get(9) == 0) {
						p2_octeur.setText("-");
					}
					else {
						eur_luni.get(9).toString();
						p2_octeur.setText(df2.format(eur_luni.get(9)));
					}
					if (eur_luni.get(10) == 0) {
						p2_noveur.setText("-");
					}
					else {
						eur_luni.get(10).toString();
						p2_noveur.setText(df2.format(eur_luni.get(10)));
					}
					if (eur_luni.get(11) == 0) {
						p2_deceur.setText("-");
					}
					else {
						eur_luni.get(11).toString();
						p2_deceur.setText(df2.format(eur_luni.get(11)));
					}
					
					eur_an = eur_luni.get(0) + eur_luni.get(1) + eur_luni.get(2) + eur_luni.get(3) + eur_luni.get(4) + eur_luni.get(5) + eur_luni.get(6) + eur_luni.get(7)
					+ eur_luni.get(8) + eur_luni.get(9) + eur_luni.get(10) + eur_luni.get(11);
					if (eur_an == 0) {
						p2_aneur.setText("-");
					}
					else {
						p2_aneur.setText(df2.format(eur_an));				
					}
				}
			}
		});

		//Add the label and the comboBox to the topPanel

		topPanel.add(selectProduct);
		topPanel.add(p1l1);
		topPanel.add(byYears);
		topPanel.add(byMonths);
		topPanel.add(selectYear);

		//Add topPanel to the splitPane

		splitPane.add(topPanel);

		//Create a panel for the bottom of the frame. This panel will hold the informations by months and respectively by years of the products

		bottomPanel = new JPanel();
		bottomPanel.setLayout((LayoutManager) new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
		bottomPanel.setBackground(Color.BLUE);
		bottomPanel.setLayout(null);

		Font rowTitleFont = new Font("Verdana", Font.BOLD, 14);
		Dimension rowTitleDimension = new Dimension(80,30);

		p2_buc = new JLabel ("Vanzari (BUC)");
		p2_buc.setBounds(30, 60, 120, 30);
		p2_buc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_buc.setFont(rowTitleFont);
		p2_buc.setForeground(Color.BLACK);	

		p2_eur = new JLabel ("Venituri (EUR)");
		p2_eur.setBounds(30, 90, 120, 30);
		p2_eur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_eur.setFont(rowTitleFont);
		p2_eur.setForeground(Color.BLACK);			

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

		p2l2 = new JLabel("ian");												// Column title "ian" for the report by months
		p2l2.setPreferredSize(rowTitleDimension);
		p2l2.setBounds(320, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l2.setHorizontalAlignment(SwingConstants.CENTER);
		p2l2.setFont(rowTitleFont);
		p2l2.setForeground(Color.BLACK);
		p2l2.setVisible(false);

		p2l3 = new JLabel("feb");												// Column title "feb" for the report by months
		p2l3.setPreferredSize(rowTitleDimension);
		p2l3.setBounds(420, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l3.setHorizontalAlignment(SwingConstants.CENTER);
		p2l3.setFont(rowTitleFont);
		p2l3.setForeground(Color.BLACK);
		p2l3.setVisible(false);

		p2l4 = new JLabel("mar");												// Column title "mar" for the report by months
		p2l4.setPreferredSize(rowTitleDimension);
		p2l4.setBounds(520, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l4.setHorizontalAlignment(SwingConstants.CENTER);
		p2l4.setFont(rowTitleFont);
		p2l4.setForeground(Color.BLACK);	
		p2l4.setVisible(false);

		p2l5 = new JLabel("apr");												// Column title "apr" for the report by months
		p2l5.setPreferredSize(rowTitleDimension);
		p2l5.setBounds(620, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l5.setHorizontalAlignment(SwingConstants.CENTER);
		p2l5.setFont(rowTitleFont);
		p2l5.setForeground(Color.BLACK);			
		p2l5.setVisible(false);

		p2l6 = new JLabel("mai");												// Column title "mai" for the report by months
		p2l6.setPreferredSize(rowTitleDimension);
		p2l6.setBounds(720, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l6.setHorizontalAlignment(SwingConstants.CENTER);
		p2l6.setFont(rowTitleFont);
		p2l6.setForeground(Color.BLACK);		
		p2l6.setVisible(false);

		p2l7 = new JLabel("iun");												// Column title "iun" for the report by months
		p2l7.setPreferredSize(rowTitleDimension);
		p2l7.setBounds(820, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l7.setHorizontalAlignment(SwingConstants.CENTER);
		p2l7.setFont(rowTitleFont);
		p2l7.setForeground(Color.BLACK);
		p2l7.setVisible(false);

		p2l8 = new JLabel("iul");												// Column title "iul" for the report by months
		p2l8.setPreferredSize(rowTitleDimension);
		p2l8.setBounds(920, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l8.setHorizontalAlignment(SwingConstants.CENTER);
		p2l8.setFont(rowTitleFont);
		p2l8.setForeground(Color.BLACK);	
		p2l8.setVisible(false);

		p2l9 = new JLabel("aug");												// Column title "aug" for the report by months
		p2l9.setPreferredSize(rowTitleDimension);
		p2l9.setBounds(1020, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l9.setHorizontalAlignment(SwingConstants.CENTER);
		p2l9.setFont(rowTitleFont);
		p2l9.setForeground(Color.BLACK);	
		p2l9.setVisible(false);

		p2l10 = new JLabel("sept");												// Column title "sept" for the report by months
		p2l10.setPreferredSize(rowTitleDimension);
		p2l10.setBounds(1120, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l10.setHorizontalAlignment(SwingConstants.CENTER);
		p2l10.setFont(rowTitleFont);
		p2l10.setForeground(Color.BLACK);	
		p2l10.setVisible(false);

		p2l11 = new JLabel("oct");												// Column title "oct" for the report by months
		p2l11.setPreferredSize(rowTitleDimension);
		p2l11.setBounds(1220, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l11.setHorizontalAlignment(SwingConstants.CENTER);
		p2l11.setFont(rowTitleFont);
		p2l11.setForeground(Color.BLACK);	
		p2l11.setVisible(false);

		p2l12 = new JLabel("nov");												// Column title "nov" for the report by months
		p2l12.setPreferredSize(rowTitleDimension);
		p2l12.setBounds(1320, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l12.setHorizontalAlignment(SwingConstants.CENTER);
		p2l12.setFont(rowTitleFont);
		p2l12.setForeground(Color.BLACK);	
		p2l12.setVisible(false);

		p2l13 = new JLabel("dec");												// Column title "dec" for the report by months
		p2l13.setPreferredSize(rowTitleDimension);
		p2l13.setBounds(1420, 10, rowTitleDimension.width, rowTitleDimension.height);
		p2l13.setHorizontalAlignment(SwingConstants.CENTER);
		p2l13.setFont(rowTitleFont);
		p2l13.setForeground(Color.BLACK);	
		p2l13.setVisible(false);

		p2l14 = new JLabel("TOTAL an 2016");									// Column title "TOTAL an 2016" for the report by years
		p2l14.setPreferredSize(rowTitleDimension);
		p2l14.setBounds(200, 10, 150, 30);
		p2l14.setHorizontalAlignment(SwingConstants.CENTER);
		p2l14.setFont(rowTitleFont);
		p2l14.setForeground(Color.BLACK);	
		p2l14.setVisible(true);

		p2l15 = new JLabel("TOTAL an 2017");									// Column title "TOTAL an 2017" for the report by years
		p2l15.setPreferredSize(rowTitleDimension);
		p2l15.setBounds(400, 10, 150, 30);
		p2l15.setHorizontalAlignment(SwingConstants.CENTER);
		p2l15.setFont(rowTitleFont);
		p2l15.setForeground(Color.BLACK);	
		p2l15.setVisible(true);		

		p2l16 = new JLabel("TOTAL an 2018");									// Column title "TOTAL an 2018" for the report by years
		p2l16.setPreferredSize(rowTitleDimension);
		p2l16.setBounds(600, 10, 150, 30);
		p2l16.setHorizontalAlignment(SwingConstants.CENTER);
		p2l16.setFont(rowTitleFont);
		p2l16.setForeground(Color.BLACK);	
		p2l16.setVisible(true);		

		p2l17 = new JLabel("TOTAL an 2019");									// Column title "TOTAL an 2019" for the report by years
		p2l17.setPreferredSize(rowTitleDimension);
		p2l17.setBounds(800, 10, 150, 30);
		p2l17.setHorizontalAlignment(SwingConstants.CENTER);
		p2l17.setFont(rowTitleFont);
		p2l17.setForeground(Color.BLACK);	
		p2l17.setVisible(true);		

		p2l18 = new JLabel("TOTAL an 2020");									// Column title "TOTAL an 2020" for the report by years
		p2l18.setPreferredSize(rowTitleDimension);
		p2l18.setBounds(1000, 10, 150, 30);
		p2l18.setHorizontalAlignment(SwingConstants.CENTER);
		p2l18.setFont(rowTitleFont);
		p2l18.setForeground(Color.BLACK);	
		p2l18.setVisible(true);

		p2l19 = new JLabel("TOTAL an 2021");									// Column title "TOTAL an 2021" for the report by years
		p2l19.setPreferredSize(rowTitleDimension);
		p2l19.setBounds(1200, 10, 150, 30);
		p2l19.setHorizontalAlignment(SwingConstants.CENTER);
		p2l19.setFont(rowTitleFont);
		p2l19.setForeground(Color.BLACK);	
		p2l19.setVisible(true);

		p2_2016buc = new JLabel();												// Quantity of selected product sales for 2016
		p2_2016buc.setBounds(200, 60, 150, 30);
		p2_2016buc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2016buc.setFont(rowTitleFont);
		p2_2016buc.setForeground(Color.BLACK);	
		p2_2016buc.setVisible(true);

		p2_2017buc = new JLabel();												// Quantity of selected product sales for 2017
		p2_2017buc.setBounds(400, 60, 150, 30);
		p2_2017buc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2017buc.setFont(rowTitleFont);
		p2_2017buc.setForeground(Color.BLACK);	

		p2_2018buc = new JLabel();												// Quantity of selected product sales for 2018
		p2_2018buc.setBounds(600, 60, 150, 30);
		p2_2018buc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2018buc.setFont(rowTitleFont);
		p2_2018buc.setForeground(Color.BLACK);	

		p2_2019buc = new JLabel();												// Quantity of selected product sales for 2019
		p2_2019buc.setBounds(800, 60, 150, 30);
		p2_2019buc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2019buc.setFont(rowTitleFont);
		p2_2019buc.setForeground(Color.BLACK);	

		p2_2020buc = new JLabel();												// Quantity of selected product sales for 2020
		p2_2020buc.setBounds(1000, 60, 150, 30);
		p2_2020buc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2020buc.setFont(rowTitleFont);
		p2_2020buc.setForeground(Color.BLACK);	

		p2_2021buc = new JLabel();												// Quantity of selected product sales for 2021
		p2_2021buc.setBounds(1200, 60, 150, 30);
		p2_2021buc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2021buc.setFont(rowTitleFont);
		p2_2021buc.setForeground(Color.BLACK);	
		p2_2021buc.setVisible(true);

		p2_2016eur = new JLabel();												// Value of selected product sales for 2016
		p2_2016eur.setBounds(200, 90, 150, 30);
		p2_2016eur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2016eur.setFont(rowTitleFont);
		p2_2016eur.setForeground(Color.BLACK);	
		p2_2016eur.setVisible(true);

		p2_2017eur = new JLabel();												// Value of selected product sales for 2017
		p2_2017eur.setBounds(400, 90, 150, 30);
		p2_2017eur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2017eur.setFont(rowTitleFont);
		p2_2017eur.setForeground(Color.BLACK);	
		p2_2017eur.setVisible(true);

		p2_2018eur = new JLabel();												// Value of selected product sales for 2018
		p2_2018eur.setBounds(600, 90, 150, 30);
		p2_2018eur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2018eur.setFont(rowTitleFont);
		p2_2018eur.setForeground(Color.BLACK);	
		p2_2018eur.setVisible(true);

		p2_2019eur = new JLabel();												// Value of selected product sales for 2019
		p2_2019eur.setBounds(800, 90, 150, 30);
		p2_2019eur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2019eur.setFont(rowTitleFont);
		p2_2019eur.setForeground(Color.BLACK);	
		p2_2019eur.setVisible(true);

		p2_2020eur = new JLabel();												// Value of selected product sales for 2020
		p2_2020eur.setBounds(1000, 90, 150, 30);
		p2_2020eur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2020eur.setFont(rowTitleFont);
		p2_2020eur.setForeground(Color.BLACK);	
		p2_2020eur.setVisible(true);

		p2_2021eur = new JLabel();												// Value of selected product sales for 2021
		p2_2021eur.setBounds(1200, 90, 150, 30);
		p2_2021eur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_2021eur.setFont(rowTitleFont);
		p2_2021eur.setForeground(Color.BLACK);	
		p2_2021eur.setVisible(true);

		p2_anbuc = new JLabel();												// Quantity of selected product sales for selected year
		p2_anbuc.setPreferredSize(rowTitleDimension);
		p2_anbuc.setBounds(200, 60, 80, 30);
		p2_anbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_anbuc.setFont(rowTitleFont);
		p2_anbuc.setForeground(Color.BLACK);	
		p2_anbuc.setVisible(false);

		p2_ianbuc = new JLabel();												// Quantity of selected product sales for selected year in January
		p2_ianbuc.setPreferredSize(rowTitleDimension);
		p2_ianbuc.setBounds(320, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_ianbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_ianbuc.setFont(rowTitleFont);
		p2_ianbuc.setForeground(Color.BLACK);	
		p2_ianbuc.setVisible(false);

		p2_febbuc = new JLabel();												// Quantity of selected product sales for selected year in February
		p2_febbuc.setPreferredSize(rowTitleDimension);
		p2_febbuc.setBounds(420, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_febbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_febbuc.setFont(rowTitleFont);
		p2_febbuc.setForeground(Color.BLACK);	
		p2_febbuc.setVisible(false);

		p2_marbuc = new JLabel();												// Quantity of selected product sales for selected year in March
		p2_marbuc.setPreferredSize(rowTitleDimension);
		p2_marbuc.setBounds(520, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_marbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_marbuc.setFont(rowTitleFont);
		p2_marbuc.setForeground(Color.BLACK);	
		p2_marbuc.setVisible(false);

		p2_aprbuc = new JLabel();												// Quantity of selected product sales for selected year in April
		p2_aprbuc.setPreferredSize(rowTitleDimension);
		p2_aprbuc.setBounds(620, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_aprbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_aprbuc.setFont(rowTitleFont);
		p2_aprbuc.setForeground(Color.BLACK);	
		p2_aprbuc.setVisible(false);

		p2_maibuc = new JLabel();												// Quantity of selected product sales for selected year in May
		p2_maibuc.setPreferredSize(rowTitleDimension);
		p2_maibuc.setBounds(720, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_maibuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_maibuc.setFont(rowTitleFont);
		p2_maibuc.setForeground(Color.BLACK);	
		p2_maibuc.setVisible(false);

		p2_iunbuc = new JLabel();												// Quantity of selected product sales for selected year in June
		p2_iunbuc.setPreferredSize(rowTitleDimension);
		p2_iunbuc.setBounds(820, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_iunbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_iunbuc.setFont(rowTitleFont);
		p2_iunbuc.setForeground(Color.BLACK);	
		p2_iunbuc.setVisible(false);

		p2_iulbuc = new JLabel();												// Quantity of selected product sales for selected year in July
		p2_iulbuc.setPreferredSize(rowTitleDimension);
		p2_iulbuc.setBounds(920, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_iulbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_iulbuc.setFont(rowTitleFont);
		p2_iulbuc.setForeground(Color.BLACK);	
		p2_iulbuc.setVisible(false);

		p2_augbuc = new JLabel();												// Quantity of selected product sales for selected year in August
		p2_augbuc.setPreferredSize(rowTitleDimension);
		p2_augbuc.setBounds(1020, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_augbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_augbuc.setFont(rowTitleFont);
		p2_augbuc.setForeground(Color.BLACK);	
		p2_augbuc.setVisible(false);

		p2_septbuc = new JLabel();												// Quantity of selected product sales for selected year in September
		p2_septbuc.setPreferredSize(rowTitleDimension);
		p2_septbuc.setBounds(1120, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_septbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_septbuc.setFont(rowTitleFont);
		p2_septbuc.setForeground(Color.BLACK);	
		p2_septbuc.setVisible(false);

		p2_octbuc = new JLabel();												// Quantity of selected product sales for selected year in October
		p2_octbuc.setPreferredSize(rowTitleDimension);
		p2_octbuc.setBounds(1220, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_octbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_octbuc.setFont(rowTitleFont);
		p2_octbuc.setForeground(Color.BLACK);	
		p2_octbuc.setVisible(false);

		p2_novbuc = new JLabel();												// Quantity of selected product sales for selected year in November
		p2_novbuc.setPreferredSize(rowTitleDimension);
		p2_novbuc.setBounds(1320, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_novbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_novbuc.setFont(rowTitleFont);
		p2_novbuc.setForeground(Color.BLACK);	
		p2_novbuc.setVisible(false);

		p2_decbuc = new JLabel();												// Quantity of selected product sales for selected year in December
		p2_decbuc.setPreferredSize(rowTitleDimension);
		p2_decbuc.setBounds(1420, 60, rowTitleDimension.width, rowTitleDimension.height);
		p2_decbuc.setHorizontalAlignment(SwingConstants.CENTER);
		p2_decbuc.setFont(rowTitleFont);
		p2_decbuc.setForeground(Color.BLACK);	
		p2_decbuc.setVisible(false);

		p2_aneur = new JLabel();												// Value of selected product sales for selected year
		p2_aneur.setPreferredSize(rowTitleDimension);
		p2_aneur.setBounds(200, 90, 80, 30);
		p2_aneur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_aneur.setFont(rowTitleFont);
		p2_aneur.setForeground(Color.BLACK);	
		p2_aneur.setVisible(false);

		p2_ianeur = new JLabel();												// Value of selected product sales for selected year in January
		p2_ianeur.setPreferredSize(rowTitleDimension);
		p2_ianeur.setBounds(320, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_ianeur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_ianeur.setFont(rowTitleFont);
		p2_ianeur.setForeground(Color.BLACK);	
		p2_ianeur.setVisible(false);		

		p2_febeur = new JLabel();												// Value of selected product sales for selected year in February
		p2_febeur.setPreferredSize(rowTitleDimension);
		p2_febeur.setBounds(420, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_febeur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_febeur.setFont(rowTitleFont);
		p2_febeur.setForeground(Color.BLACK);	
		p2_febeur.setVisible(false);

		p2_mareur = new JLabel();												// Value of selected product sales for selected year in March
		p2_mareur.setPreferredSize(rowTitleDimension);
		p2_mareur.setBounds(520, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_mareur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_mareur.setFont(rowTitleFont);
		p2_mareur.setForeground(Color.BLACK);	
		p2_mareur.setVisible(false);		

		p2_apreur = new JLabel();												// Value of selected product sales for selected year in April
		p2_apreur.setPreferredSize(rowTitleDimension);
		p2_apreur.setBounds(620, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_apreur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_apreur.setFont(rowTitleFont);
		p2_apreur.setForeground(Color.BLACK);	
		p2_apreur.setVisible(false);

		p2_maieur = new JLabel();												// Value of selected product sales for selected year in May
		p2_maieur.setPreferredSize(rowTitleDimension);
		p2_maieur.setBounds(720, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_maieur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_maieur.setFont(rowTitleFont);
		p2_maieur.setForeground(Color.BLACK);	
		p2_maieur.setVisible(false);	

		p2_iuneur = new JLabel();												// Value of selected product sales for selected year in June
		p2_iuneur.setPreferredSize(rowTitleDimension);
		p2_iuneur.setBounds(820, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_iuneur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_iuneur.setFont(rowTitleFont);
		p2_iunbuc.setForeground(Color.BLACK);	
		p2_iunbuc.setVisible(false);

		p2_iuleur = new JLabel();												// Value of selected product sales for selected year in July
		p2_iuleur.setPreferredSize(rowTitleDimension);
		p2_iuleur.setBounds(920, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_iuleur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_iuleur.setFont(rowTitleFont);
		p2_iuleur.setForeground(Color.BLACK);	
		p2_iuleur.setVisible(false);

		p2_augeur = new JLabel();												// Value of selected product sales for selected year in August
		p2_augeur.setPreferredSize(rowTitleDimension);
		p2_augeur.setBounds(1020, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_augeur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_augeur.setFont(rowTitleFont);
		p2_augeur.setForeground(Color.BLACK);	
		p2_augeur.setVisible(false);

		p2_septeur = new JLabel();												// Value of selected product sales for selected year in September
		p2_septeur.setPreferredSize(rowTitleDimension);
		p2_septeur.setBounds(1120, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_septeur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_septeur.setFont(rowTitleFont);
		p2_septeur.setForeground(Color.BLACK);	
		p2_septeur.setVisible(false);

		p2_octeur = new JLabel();												// Value of selected product sales for selected year in October
		p2_octeur.setPreferredSize(rowTitleDimension);
		p2_octeur.setBounds(1220, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_octeur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_octeur.setFont(rowTitleFont);
		p2_octeur.setForeground(Color.BLACK);	
		p2_octeur.setVisible(false);

		p2_noveur = new JLabel();												// Value of selected product sales for selected year in November
		p2_noveur.setPreferredSize(rowTitleDimension);
		p2_noveur.setBounds(1320, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_noveur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_noveur.setFont(rowTitleFont);
		p2_noveur.setForeground(Color.BLACK);	
		p2_noveur.setVisible(false);

		p2_deceur = new JLabel();												// Value of selected product sales for selected year in December
		p2_deceur.setPreferredSize(rowTitleDimension);
		p2_deceur.setBounds(1420, 90, rowTitleDimension.width, rowTitleDimension.height);
		p2_deceur.setHorizontalAlignment(SwingConstants.CENTER);
		p2_deceur.setFont(rowTitleFont);
		p2_deceur.setForeground(Color.BLACK);	
		p2_deceur.setVisible(false);

		//Add labels to bottomPanel

		bottomPanel.add(p2_buc);
		bottomPanel.add(p2_eur);
		bottomPanel.add(p2l1);
		bottomPanel.add(p2_an);
		bottomPanel.add(p2l2);
		bottomPanel.add(p2l3);
		bottomPanel.add(p2l4);
		bottomPanel.add(p2l5);
		bottomPanel.add(p2l6);
		bottomPanel.add(p2l7);
		bottomPanel.add(p2l8);
		bottomPanel.add(p2l9);
		bottomPanel.add(p2l10);
		bottomPanel.add(p2l11);
		bottomPanel.add(p2l12);
		bottomPanel.add(p2l13);
		bottomPanel.add(p2l14);
		bottomPanel.add(p2l15);
		bottomPanel.add(p2l16);
		bottomPanel.add(p2l17);
		bottomPanel.add(p2l18);
		bottomPanel.add(p2l19);
		bottomPanel.add(p2_2016buc);
		bottomPanel.add(p2_2017buc);
		bottomPanel.add(p2_2018buc);
		bottomPanel.add(p2_2019buc);
		bottomPanel.add(p2_2020buc);
		bottomPanel.add(p2_2021buc);
		bottomPanel.add(p2_2016eur);
		bottomPanel.add(p2_2017eur);
		bottomPanel.add(p2_2018eur);
		bottomPanel.add(p2_2019eur);
		bottomPanel.add(p2_2020eur);
		bottomPanel.add(p2_2021eur);
		bottomPanel.add(p2_anbuc);
		bottomPanel.add(p2_ianbuc);
		bottomPanel.add(p2_febbuc);
		bottomPanel.add(p2_marbuc);
		bottomPanel.add(p2_aprbuc);
		bottomPanel.add(p2_maibuc);
		bottomPanel.add(p2_iunbuc);
		bottomPanel.add(p2_iulbuc);
		bottomPanel.add(p2_augbuc);
		bottomPanel.add(p2_septbuc);
		bottomPanel.add(p2_octbuc);
		bottomPanel.add(p2_novbuc);
		bottomPanel.add(p2_decbuc);
		bottomPanel.add(p2_aneur);
		bottomPanel.add(p2_ianeur);
		bottomPanel.add(p2_febeur);
		bottomPanel.add(p2_mareur);
		bottomPanel.add(p2_apreur);
		bottomPanel.add(p2_maieur);
		bottomPanel.add(p2_iuneur);
		bottomPanel.add(p2_iuleur);
		bottomPanel.add(p2_augeur);
		bottomPanel.add(p2_septeur);
		bottomPanel.add(p2_octeur);
		bottomPanel.add(p2_noveur);
		bottomPanel.add(p2_deceur);

		// Add the bottomPanel to the splitPane

		splitPane.add(bottomPanel);

		pack();
	}
	class RadioListener implements ActionListener { 

		public void actionPerformed (ActionEvent e) {
			if (e.getActionCommand() == first) {
				selectYear.setVisible(false);
				p2l1.setVisible(false);
				p2_an.setVisible(false);
				p2l2.setVisible(false);
				p2l3.setVisible(false);
				p2l4.setVisible(false);
				p2l5.setVisible(false);
				p2l6.setVisible(false);
				p2l7.setVisible(false);
				p2l8.setVisible(false);
				p2l9.setVisible(false);
				p2l10.setVisible(false);
				p2l11.setVisible(false);
				p2l12.setVisible(false);
				p2l13.setVisible(false);
				p2l14.setVisible(true);
				p2l15.setVisible(true);
				p2l16.setVisible(true);
				p2l17.setVisible(true);
				p2l18.setVisible(true);
				p2l19.setVisible(true);
				p2_2016buc.setVisible(true);
				p2_2017buc.setVisible(true);
				p2_2018buc.setVisible(true);
				p2_2019buc.setVisible(true);
				p2_2020buc.setVisible(true);
				p2_2021buc.setVisible(true);
				p2_2016eur.setVisible(true);
				p2_2017eur.setVisible(true);
				p2_2018eur.setVisible(true);
				p2_2019eur.setVisible(true);
				p2_2020eur.setVisible(true);
				p2_2021eur.setVisible(true);
				p2_anbuc.setVisible(false);
				p2_ianbuc.setVisible(false);
				p2_febbuc.setVisible(false);
				p2_marbuc.setVisible(false);
				p2_aprbuc.setVisible(false);
				p2_maibuc.setVisible(false);
				p2_iunbuc.setVisible(false);
				p2_iulbuc.setVisible(false);
				p2_augbuc.setVisible(false);
				p2_septbuc.setVisible(false);
				p2_octbuc.setVisible(false);
				p2_novbuc.setVisible(false);
				p2_decbuc.setVisible(false);
				p2_aneur.setVisible(false);
				p2_ianeur.setVisible(false);
				p2_febeur.setVisible(false);
				p2_mareur.setVisible(false);
				p2_apreur.setVisible(false);
				p2_maieur.setVisible(false);
				p2_iuneur.setVisible(false);
				p2_iuleur.setVisible(false);
				p2_augeur.setVisible(false);
				p2_septeur.setVisible(false);
				p2_octeur.setVisible(false);
				p2_noveur.setVisible(false);
				p2_deceur.setVisible(false);

				ArrayList<String> ani = new ArrayList<String>();	//Construct an array list of string containing years
				ani.add("2016");
				ani.add("2017");
				ani.add("2018");
				ani.add("2019");
				ani.add("2020");
				ani.add("2021");

				// Calculus for quantities (BUC) by years

				ArrayList<Integer> buc_ani = null;

				try {
					buc_ani = SumYear.sumQuantityYear(p1l1.getText(), ani);
				} 
				catch (FileNotFoundException e2) {
					e2.printStackTrace();
				}
				
				if (buc_ani.get(0) == 0) {
					p2_2016buc.setText("-");
				}
				else {
					buc_ani.get(0).toString();
					p2_2016buc.setText(String.format("%,d", buc_ani.get(0)) + " BUC");
				}
				if (buc_ani.get(1) == 0) {
					p2_2017buc.setText("-");
				}
				else {
					buc_ani.get(1).toString();
					p2_2017buc.setText(String.format("%,d", buc_ani.get(1)) + " BUC");
				}
				if (buc_ani.get(2) == 0) {
					p2_2018buc.setText("-");
				}
				else {
					buc_ani.get(2).toString();
					p2_2018buc.setText(String.format("%,d", buc_ani.get(2)) + " BUC");
				}
				if (buc_ani.get(3) == 0) {
					p2_2019buc.setText("-");
				}
				else {
					buc_ani.get(3).toString();
					p2_2019buc.setText(String.format("%,d", buc_ani.get(3)) + " BUC");				
				}
				if (buc_ani.get(4) == 0) {
					p2_2020buc.setText("-");
				}
				else {
					buc_ani.get(4).toString();
					p2_2020buc.setText(String.format("%,d", buc_ani.get(4)) + " BUC");
				}
				if (buc_ani.get(5) == 0) {
					p2_2021buc.setText("-");
				}
				else {
					buc_ani.get(5).toString();
					p2_2021buc.setText(String.format("%,d", buc_ani.get(5)) + " BUC");
				}

				// Calculus for values (EUR) by years

				ArrayList<Double> eur_ani = null;

				try {
					eur_ani = SumYear.sumValueYear(p1l1.getText(), ani);
				} 
				catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (eur_ani.get(0) == 0) {
					p2_2016eur.setText("-");
				}
				else {
					p2_2016eur.setText(df2.format(eur_ani.get(0)) + " EUR");
				}
				if (eur_ani.get(1) == 0) {
					p2_2017eur.setText("-");
				}
				else {
					p2_2017eur.setText(df2.format(eur_ani.get(1)) + " EUR");
				}
				if (eur_ani.get(2) == 0) {
					p2_2018eur.setText("-");
				}
				else {
					p2_2018eur.setText(df2.format(eur_ani.get(2)) + " EUR");
				}
				if (eur_ani.get(3) == 0) {
					p2_2019eur.setText("-");
				}
				else {
					p2_2019eur.setText(df2.format(eur_ani.get(3)) + " EUR");
				}
				if (eur_ani.get(4) == 0) {
					p2_2020eur.setText("-");
				}
				else {
					p2_2020eur.setText(df2.format(eur_ani.get(4)) + " EUR");
				}
				if (eur_ani.get(5) == 0) {
					p2_2021eur.setText("-");
				}
				else {
					p2_2021eur.setText(df2.format(eur_ani.get(5)) + " EUR");
				}
			}

			else if (e.getActionCommand() == second){
				selectYear.setVisible(true);
				p2l1.setVisible(true);
				p2_an.setVisible(true);
				p2l2.setVisible(true);
				p2l3.setVisible(true);
				p2l4.setVisible(true);
				p2l5.setVisible(true);
				p2l6.setVisible(true);
				p2l7.setVisible(true);
				p2l8.setVisible(true);
				p2l9.setVisible(true);
				p2l10.setVisible(true);
				p2l11.setVisible(true);
				p2l12.setVisible(true);
				p2l13.setVisible(true);
				p2l14.setVisible(false);
				p2l15.setVisible(false);
				p2l16.setVisible(false);
				p2l17.setVisible(false);
				p2l18.setVisible(false);
				p2l19.setVisible(false);
				p2_2016buc.setVisible(false);
				p2_2017buc.setVisible(false);
				p2_2018buc.setVisible(false);
				p2_2019buc.setVisible(false);
				p2_2020buc.setVisible(false);
				p2_2021buc.setVisible(false);
				p2_2016eur.setVisible(false);
				p2_2017eur.setVisible(false);
				p2_2018eur.setVisible(false);
				p2_2019eur.setVisible(false);
				p2_2020eur.setVisible(false);
				p2_2021eur.setVisible(false);
				p2_anbuc.setVisible(true);
				p2_ianbuc.setVisible(true);
				p2_febbuc.setVisible(true);
				p2_marbuc.setVisible(true);
				p2_aprbuc.setVisible(true);
				p2_maibuc.setVisible(true);
				p2_iunbuc.setVisible(true);
				p2_iulbuc.setVisible(true);
				p2_augbuc.setVisible(true);
				p2_septbuc.setVisible(true);
				p2_octbuc.setVisible(true);
				p2_novbuc.setVisible(true);
				p2_decbuc.setVisible(true);
				p2_aneur.setVisible(true);
				p2_ianeur.setVisible(true);
				p2_febeur.setVisible(true);
				p2_mareur.setVisible(true);
				p2_apreur.setVisible(true);
				p2_maieur.setVisible(true);
				p2_iuneur.setVisible(true);
				p2_iuleur.setVisible(true);
				p2_augeur.setVisible(true);
				p2_septeur.setVisible(true);
				p2_octeur.setVisible(true);
				p2_noveur.setVisible(true);
				p2_deceur.setVisible(true);

				// Calculus for quantities (BUC) by months

				ArrayList<Integer> buc_luni = null;
				Integer buc_an = 0;

				ArrayList<String> luni = new ArrayList<>();
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

				try {
					buc_luni = SumMonth.sumQuantityMonth(p1l1.getText(), p2_an.getText(), luni);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (buc_luni.get(0) == 0) {
					p2_ianbuc.setText("-");
				}
				else {
					buc_luni.get(0).toString();
					p2_ianbuc.setText(String.format("%,d", buc_luni.get(0)));
				}
				if (buc_luni.get(1) == 0) {
					p2_febbuc.setText("-");
				}
				else {
					buc_luni.get(1).toString();
					p2_febbuc.setText(String.format("%,d", buc_luni.get(1)));
				}
				if (buc_luni.get(2) == 0) {
					p2_marbuc.setText("-");
				}
				else {
					buc_luni.get(2).toString();
					p2_marbuc.setText(String.format("%,d", buc_luni.get(2)));
				}
				if (buc_luni.get(3) == 0) {
					p2_aprbuc.setText("-");
				}
				else {
					buc_luni.get(3).toString();
					p2_aprbuc.setText(String.format("%,d", buc_luni.get(3)));				
				}
				if (buc_luni.get(4) == 0) {
					p2_maibuc.setText("-");
				}
				else {
					buc_luni.get(4).toString();
					p2_maibuc.setText(String.format("%,d", buc_luni.get(4)));
				}
				if (buc_luni.get(5) == 0) {
					p2_iunbuc.setText("-");
				}
				else {
					buc_luni.get(5).toString();
					p2_iunbuc.setText(String.format("%,d", buc_luni.get(5)));
				}
				if (buc_luni.get(6) == 0) {
					p2_iulbuc.setText("-");
				}
				else {
					buc_luni.get(6).toString();
					p2_iulbuc.setText(String.format("%,d", buc_luni.get(6)));
				}
				if (buc_luni.get(7) == 0) {
					p2_augbuc.setText("-");
				}
				else {
					buc_luni.get(7).toString();
					p2_augbuc.setText(String.format("%,d", buc_luni.get(7)));
				}
				if (buc_luni.get(8) == 0) {
					p2_septbuc.setText("-");
				}
				else {
					buc_luni.get(8).toString();
					p2_septbuc.setText(String.format("%,d", buc_luni.get(8)));
				}
				if (buc_luni.get(9) == 0) {
					p2_octbuc.setText("-");
				}
				else {
					buc_luni.get(9).toString();
					p2_octbuc.setText(String.format("%,d", buc_luni.get(9)));
				}
				if (buc_luni.get(10) == 0) {
					p2_novbuc.setText("-");
				}
				else {
					buc_luni.get(10).toString();
					p2_novbuc.setText(String.format("%,d", buc_luni.get(10)));
				}
				if (buc_luni.get(11) == 0) {
					p2_decbuc.setText("-");
				}
				else {
					buc_luni.get(11).toString();
					p2_decbuc.setText(String.format("%,d", buc_luni.get(11)));
				}

				buc_an = buc_luni.get(0) + buc_luni.get(1) + buc_luni.get(2) + buc_luni.get(3) + buc_luni.get(4) + buc_luni.get(5) + buc_luni.get(6) + buc_luni.get(7)
				+ buc_luni.get(8) + buc_luni.get(9) + buc_luni.get(10) + buc_luni.get(11);
				if (buc_an == 0) {
					p2_anbuc.setText("-");
				}
				else {
					p2_anbuc.setText(String.format("%,d", buc_an));
				}

				// Calculus for values (EUR) by months

				ArrayList<Double> eur_luni = null;
				Double eur_an = 0.0;

				try {
					eur_luni = SumMonth.sumValueMonth(p1l1.getText(), p2_an.getText(), luni);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					
				if (eur_luni.get(0) == 0) {
					p2_ianeur.setText("-");
				}
				else {
					eur_luni.get(0).toString();
					p2_ianeur.setText(df2.format(eur_luni.get(0)));
				}
				if (eur_luni.get(1) == 0) {
					p2_febeur.setText("-");
				}
				else {
					eur_luni.get(1).toString();
					p2_febeur.setText(df2.format(eur_luni.get(1)));
				}
				if (eur_luni.get(2) == 0) {
					p2_mareur.setText("-");
				}
				else {
					eur_luni.get(2).toString();
					p2_mareur.setText(df2.format(eur_luni.get(2)));
				}
				if (eur_luni.get(3) == 0) {
					p2_apreur.setText("-");
				}
				else {
					eur_luni.get(3).toString();
					p2_apreur.setText(df2.format(eur_luni.get(3)));				
				}
				if (eur_luni.get(4) == 0) {
					p2_maieur.setText("-");
				}
				else {
					eur_luni.get(4).toString();
					p2_maieur.setText(df2.format(eur_luni.get(4)));
				}
				if (eur_luni.get(5) == 0) {
					p2_iuneur.setText("-");
				}
				else {
					eur_luni.get(5).toString();
					p2_iuneur.setText(df2.format(eur_luni.get(5)));
				}
				if (eur_luni.get(6) == 0) {
					p2_iuleur.setText("-");
				}
				else {
					eur_luni.get(6).toString();
					p2_iuleur.setText(df2.format(eur_luni.get(6)));
				}
				if (eur_luni.get(7) == 0) {
					p2_augeur.setText("-");
				}
				else {
					eur_luni.get(7).toString();
					p2_augeur.setText(df2.format(eur_luni.get(7)));
				}
				if (eur_luni.get(8) == 0) {
					p2_septeur.setText("-");
				}
				else {
					eur_luni.get(8).toString();
					p2_septeur.setText(df2.format(eur_luni.get(8)));
				}
				if (eur_luni.get(9) == 0) {
					p2_octeur.setText("-");
				}
				else {
					eur_luni.get(9).toString();
					p2_octeur.setText(df2.format(eur_luni.get(9)));
				}
				if (eur_luni.get(10) == 0) {
					p2_noveur.setText("-");
				}
				else {
					eur_luni.get(10).toString();
					p2_noveur.setText(df2.format(eur_luni.get(10)));
				}
				if (eur_luni.get(11) == 0) {
					p2_deceur.setText("-");
				}
				else {
					eur_luni.get(11).toString();
					p2_deceur.setText(df2.format(eur_luni.get(11)));
				}
				
				eur_an = eur_luni.get(0) + eur_luni.get(1) + eur_luni.get(2) + eur_luni.get(3) + eur_luni.get(4) + eur_luni.get(5) + eur_luni.get(6) + eur_luni.get(7)
				+ eur_luni.get(8) + eur_luni.get(9) + eur_luni.get(10) + eur_luni.get(11);
				if (eur_an == 0) {
					p2_aneur.setText("-");
				}
				else {
					p2_aneur.setText(df2.format(eur_an));				
				}				
			}
		}
	}
}

