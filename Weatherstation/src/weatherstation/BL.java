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

   
    
    
    
}
