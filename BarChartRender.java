import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*; 
import org.jfree.ui.*; 
import java.util.*;

public class BarChartRender extends ApplicationFrame {
  //LOOK HERE
  private ImportData id = new ImportData("https://think.cs.vt.edu/corgis/datasets/csv/broadway/broadway.csv");
  
  //STUDY THIS
  public BarChartRender() {
      super( "amt of poeple who went to a musical/play/special in Feb 2015" );   //title of file     
      JFreeChart barChart = ChartFactory.createBarChart(
         "attendance of people who attended a musical, play, or special in months in 2015.",      // title     
         "month",    // X axis  
         "number of people",    // Y axis        
         createDataset(id.getData()),    //NOTICE THIS !      
         PlotOrientation.VERTICAL,           
         true, true, false);
      
      //HOW TO COLOR BARS
      // CategoryPlot plot = barChart.getCategoryPlot();
      // BarRenderer renderer = (BarRenderer) plot.getRenderer();

      // // // set the color (r,g,b) or (r,g,b,a)
      //  Color color = new Color(255, 129, 189);
      //  Color color1 = new Color(150, 129, 189);
      //  Color color2 = new Color(0, 129, 189);
      //  renderer.setSeriesPaint(0, color);
      //  renderer.setSeriesPaint(1, color1);
      //  renderer.setSeriesPaint(2, color2);


      ChartPanel chartPanel = new ChartPanel( barChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
      this.pack( );          
      this.setVisible( true ); 
   }
   
   private CategoryDataset createDataset(ArrayList<Record> records) {      
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );  

      //Create a dataset --
      for(Record r : records){
         String type = r.getValueByIndex(6);
         String year = r.getValueByIndex(3);
         String month = r.getValueByIndex(2);
         int attendance = Integer.parseInt(r.getValueByIndex(7));
        // int year = Integer.parseInt(r.getValueByIndex(3));
         //int month = Integer.parseInt(r.getValueByIndex(2));

         if(year.equals("2015")){
            dataset.addValue(attendance, type, month);
         }
      }
      return dataset; 
   }

   public static void main(String[] args) {
      new BarChartRender();
   }
}