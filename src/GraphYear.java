	import org.jfree.chart.JFreeChart;
	import org.jfree.chart.axis.CategoryAxis;
	import org.jfree.chart.axis.NumberAxis;
	import org.jfree.chart.plot.CategoryPlot;
	import org.jfree.chart.renderer.category.BarRenderer;
	import org.jfree.chart.renderer.category.CategoryItemRenderer;
	import org.jfree.chart.renderer.category.LineAndShapeRenderer;
	import org.jfree.data.category.DefaultCategoryDataset;
	
public class GraphYear {

	   public static JFreeChart chart(DefaultCategoryDataset dataset) {

	      // Create Category plot
	      CategoryPlot plot = new CategoryPlot();

	      // Add the first dataset and render as bar
	      CategoryItemRenderer barRenderer = new BarRenderer();
	      plot.setDataset(0, dataset);
	      plot.setRenderer(0, barRenderer);

	      // Add the second dataset and render as lines
//	      CategoryItemRenderer lineRenderer = new  LineAndShapeRenderer();
//	      plot.setDataset(1, dataset);
//	      plot.setRenderer(1, lineRenderer);

	      // Set Axis
	      plot.setDomainAxis(new CategoryAxis("Time"));
	      plot.setRangeAxis(new NumberAxis("Value"));

	      JFreeChart chart = new JFreeChart(plot);
	      chart.setTitle("Sales of Printed Materials");
	      
	      
	      return chart;
	   }
	}
