/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author oskar
 */
public class BL extends AbstractTableModel{

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
    
    
    
}
