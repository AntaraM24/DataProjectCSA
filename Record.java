import java.util.*;

public class Record {
  private ArrayList<String> column_names = new ArrayList<String>();
  private ArrayList<String> values = new ArrayList<String>();

  public Record(String[] columns, String[] arr_values){
      for(String c: columns)
        column_names.add(c.replace("\"",""));
      for(String v : arr_values)
        values.add(v.replace("\"",""));
  }

  public String getValueByIndex(int index){
      return values.get(index); 
  }

  public String toString(){
      String s = "===== Record: \n";
      for(String v: values){
          s += v + "\n";
      }
      
      return s;
  }
}