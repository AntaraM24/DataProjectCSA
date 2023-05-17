import java.net.*;
import java.io.*;
import java.util.*;

public class ImportData {
  
  ArrayList<Record> data = new ArrayList<Record>();
  
  public ImportData(String url)  {
    try{
        //1. GET THE DATA from 
        URL http_url = new URL(url);
        HttpURLConnection con = (HttpURLConnection) http_url.openConnection();
  
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine = in.readLine();
        String[] columnNames = inputLine.split(",");
        inputLine = in.readLine();
        while (inputLine != null) {
            String[] items = inputLine.split("\",\"");
            data.add(new Record(columnNames, items));
            inputLine = in.readLine();
        }
        in.close();
    } catch(Exception e){
      e.printStackTrace();
    }
  }

  public ArrayList<Record> getData(){
    return data;
  }
}