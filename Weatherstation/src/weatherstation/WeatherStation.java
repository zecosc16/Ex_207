/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

/**
 *
 * @author oskar
 */
public class WeatherStation implements Comparable<WeatherStation>{
    private String place;
    private int seaLevel,relHumidity;
    private double temp;

    public WeatherStation(String place, int seaLevel, int relHumidity, double temp) {
        this.place = place;
        this.seaLevel = seaLevel;
        this.relHumidity = relHumidity;
        this.temp = temp;
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

    public void setRelHumidity(int relHumidity) {
        this.relHumidity = relHumidity;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    

    @Override
    public int compareTo(WeatherStation o) {
        return this.place.compareTo(o.place);
    }
    
    
}
