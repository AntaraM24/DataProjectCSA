import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*; 
import org.jfree.ui.*; 
import java.util.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class pieChart extends ApplicationFrame {
  //LOOK HERE
  private ImportData id = new ImportData("https://think.cs.vt.edu/corgis/datasets/csv/broadway/broadway.csv");
  
  // createPieChart(String, PieDataset, boolean, boolean, boolean)

  //STUDY THIS
  public pieChart() {
      super( "amt of poeple who went to a musical/play/special in Feb 2015" );   //title of file     
      JFreeChart pieChart = ChartFactory.createPieChart(
         "attendance of people who attended a musical, play, or special in months in 2015.",      // title            
         createDataset(id.getData()),    //NOTICE THIS !      
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


      ChartPanel chartPanel = new ChartPanel( pieChart );        
      chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      setContentPane( chartPanel ); 
      this.pack( );          
      this.setVisible( true ); 
   }
   
   private PieDataset createDataset(ArrayList<Record> records) {      
    DefaultPieDataset dataset = new DefaultPieDataset( );  

      //Create a dataset --
      for(Record r : records){
         
         String year = r.getValueByIndex(3);
         String month = r.getValueByIndex(2);
        // int year = Integer.parseInt(r.getValueByIndex(3));
         //int month = Integer.parseInt(r.getValueByIndex(2));



         if(year.equals("2015")  && month.equals("2")){
            //dataset.addValue(attendance, type, month);
            dataset.setValue("Musical", getMusical(records));  
            dataset.setValue("Play", getPlay(records)); 
            dataset.setValue("Special", getSpecial(records)); 
     

         }
      }
      return dataset; 
   }

   int musical = 0;
    int play = 0;
    int special = 0;

   public void countData(ArrayList<Record> records){
  
        for(Record r : records){
            if(r.getValueByIndex(6).equals("Musical")){

                musical++;
            }
            else if(r.getValueByIndex(6).equals("Play")){
                play++;
            }
            else{
                special++;
            }
        }
   }

   public int getMusical(ArrayList<Record> records){
    countData(records);
    return musical;
   }
   public int getPlay(ArrayList<Record> records){
    countData(records);
    return play;
   }
   public int getSpecial(ArrayList<Record> records){
    countData(records);
    return special;
   }



   public static void main(String[] args) {
      new pieChart();
   }
}