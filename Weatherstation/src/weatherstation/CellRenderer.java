/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author oskar
 */
public class CellRenderer implements TableCellRenderer{

    private int col=4;

    public void setCol() {
        if(col==3)
            this.col = 4;
        else 
            this.col=3;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel l  = new JLabel();
        WeatherStation w = (WeatherStation) value;
        l.setOpaque(true);
        if(col==4){
            switch(column){
            case 0:
                l.setText(w.getPlace());
                break;
            case 1:
                l.setText(""+w.getSeaLevel()+"m");
                break;
            case 2:
                l.setText(String.format("%.2f",w.getTemp())+"°");
                break;
            case 3:
                l.setText(w.getRelHumidity()+"%");
                break;
        }}
        else{
                switch(column){
            case 0:
                l.setText(w.getPlace());
                break;
            case 1:
                l.setText(String.format("%.2f",w.getTemp())+"°");
                break;
            case 2:
               l.setText(w.getRelHumidity()+"%");
                break;
        }
        }
        if(w.getTemp()>25&&w.getRelHumidity()>20){
            l.setBackground(Color.yellow);
        }
        else if(w.getSeaLevel()<0&&w.getRelHumidity()<30)
            l.setBackground(Color.blue);
        else if(w.getTemp()>0&&w.getTemp()<25&&w.getRelHumidity()>50){
            l.setBackground(Color.GREEN);
        }
        return l;
    }
    
}
