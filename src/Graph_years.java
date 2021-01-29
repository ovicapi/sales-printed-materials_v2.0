import java.awt.Color;
import java.awt.GradientPaint;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
	
public class Graph_years {

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
		renderer.setItemMargin(0.1);
		
		final GradientPaint gp0 = new GradientPaint(0.0f, 0.0f, Color.blue, 0.0f, 0.0f, Color.lightGray);
		final GradientPaint gp1 = new GradientPaint(0.0f, 0.0f, Color.red, 0.0f, 0.0f, Color.lightGray);
		renderer.setSeriesPaint(0, gp0);
		renderer.setSeriesPaint(1, gp1);
		renderer.setMaximumBarWidth(0.3);

		final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setLowerMargin(0.03);
        domainAxis.setCategoryMargin(0.4);
        domainAxis.setUpperMargin(0.01);
		
        return barChart;
    }
		
}
