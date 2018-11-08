/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.io.Serializable;

/**
 *
 * @author oskar
 */
public class WeatherStation implements Serializable, Comparable<WeatherStation> {
    private String place;
    private int seaLevel,relHumidity;
    private double temp;

    public WeatherStation(String place, int seaLevel, int relHumidity, double temp) throws Exception {
        this.place = place;
        this.seaLevel = seaLevel;
        this.setRelHumidity(relHumidity);
        this.setTemp(temp);
    }

    public String getPlace() {
        return place;
    }

    public int getSeaLevel() {
        return seaLevel;
    }

    public int getRelHumidity() {
        return relHumidity;
    }

    public double getTemp() {
        return temp;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setSeaLevel(int seaLevel) {
        this.seaLevel = seaLevel;
    }

    public void setRelHumidity(int hum) throws Exception {
        if(hum<0||hum>100)
           throw new Exception("no possible Humidity");
        this.relHumidity = relHumidity;
    }

    public void setTemp(double temp) throws Exception {
               if(temp<-80||temp>50)
           throw new Exception("no possible Temp");
        this.temp = temp;
    }

    

    @Override
    public int compareTo(WeatherStation o) {
        return this.place.compareTo(o.place);
    }
    
    
}
