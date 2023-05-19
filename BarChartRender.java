import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*; 
import org.jfree.ui.*; 
import java.util.*;

public class BarChartRender extends ApplicationFrame {
 
  private ImportData id = new ImportData("https://think.cs.vt.edu/corgis/datasets/csv/broadway/broadway.csv");
  

  public BarChartRender() {
      super( "amt of poeple who went to a musical/play/special in Feb 2015" );   //title of file     
      JFreeChart barChart = ChartFactory.createBarChart(
         "attendance of people who attended a musical, play, or special in months in 2015.",      // title     
         "month",    // X axis  
         "number of people",    // Y axis        
         createDataset(id.getData()),    
         PlotOrientation.VERTICAL,           
         true, true, false);
      
   
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