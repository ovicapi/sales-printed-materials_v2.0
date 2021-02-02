import java.awt.Color;
import java.awt.GradientPaint;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graph_months {
	public static DefaultCategoryDataset dataset_months;

	public static JFreeChart runGraph(String chartTitle, String xLabel, String yLabel, DefaultCategoryDataset dataset) {
		JFreeChart barChart = ChartFactory.createBarChart(
				chartTitle,           
				xLabel,            
				yLabel,            
				dataset,          
				PlotOrientation.VERTICAL,           
				true, true, false);
		final CategoryPlot plot = barChart.getCategoryPlot();
		plot.setBackgroundPaint(new Color(224, 224, 224));
		plot.setDomainGridlinePaint(new Color(224, 224, 224));
		plot.setRangeGridlinePaint(new Color(224, 224, 224));

		final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

		final BarRenderer renderer = (BarRenderer) plot.getRenderer();
		renderer.setDrawBarOutline(false);
		renderer.setItemMargin(0.0);

		final GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.lightGray);
		final GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.lightGray);
		renderer.setSeriesPaint(0, gp0);
		renderer.setSeriesPaint(1, gp1);
		renderer.setMaximumBarWidth(0.32);
		renderer.setMinimumBarLength(0.8);

		final CategoryAxis domainAxis = plot.getDomainAxis();
		domainAxis.setLowerMargin(0.01);
		domainAxis.setCategoryMargin(0.1);
		domainAxis.setUpperMargin(0.01);

		return barChart;
	}

	public static DefaultCategoryDataset CreateDatasetMonths (ArrayList<Integer> buc_luni, ArrayList<Double> eur_luni, String series1, String series2, String text_product, String text_year) throws FileNotFoundException {
		dataset_months = new DefaultCategoryDataset();
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
		for (int i = 0; i < luni.size(); i++) {
			dataset_months.addValue(buc_luni.get(i), series1, luni.get(i));
		}
		for (int i = luni.size(); i < luni.size() * 2; i++) {
			dataset_months.addValue(eur_luni.get(i-luni.size()), series2, luni.get(i - luni.size()));
		}
		return dataset_months;
	}
}
