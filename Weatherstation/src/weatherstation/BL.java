/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oskar
 */
public class BL extends AbstractTableModel implements Serializable{

    private ArrayList<WeatherStation> w = new ArrayList<>();
    private String[] colNames = {"Place","Sea Level","Tempretur","rel. Humidity"};
    @Override
    public int getRowCount() {
        return w.size();
    }
    
    public void add(WeatherStation w){
        this.w.add(w);
        Collections.sort(this.w);
        fireTableDataChanged();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return w.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    
   public void remove(int[] rows){
       for (int i=rows.length-1;i>-1;i--) {
           w.remove(i);
       }
       fireTableDataChanged();
   }
   
   public void setTemp(int row,double temp) throws Exception{
       if(temp<-80||temp>50)
           throw new Exception("no possible Temp");
       w.get(row).setTemp(temp);
       fireTableDataChanged();
   }
   
   public void setHumidity(int row, int hum) throws Exception{
       if(hum<0||hum>100)
           throw new Exception("no possible Humidity");
       w.get(row).setRelHumidity(hum);
       fireTableDataChanged();
   }
   
   public void read(File f) throws FileNotFoundException, IOException, ClassNotFoundException{
       ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
       Object o;
       while((o=ois.readObject())!=null){
           if(o instanceof WeatherStation)
               w.add((WeatherStation) o);
       }
       ois.close();
       fireTableDataChanged();
   }
   
   public void write(File f) throws FileNotFoundException, IOException{
   ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
       for (WeatherStation weatherStation : w) {
           oos.writeObject(oos);
       }
       
       oos.flush();
       oos.close();
   }
    
    
    
}
