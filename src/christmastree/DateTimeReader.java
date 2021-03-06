/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package christmastree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Kee Aun
 */

public class DateTimeReader implements Subject {
    private ArrayList<Observer> observers;
    public long time;
    public String period;
    
    public DateTimeReader(){
        observers = new ArrayList<Observer>();
    }
    
    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
        timeChanged();
    }

    @Override
    public void removeObserver(Observer obs) {
        int i = observers.indexOf(obs);
        if(i>=0){
            observers.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        for(Observer obs:observers){
            obs.update(time, period);
        }
    }
    
    public String getPeriod() {
        Properties p = new Properties();
        String bgProperty = "";
        try {
            p.load(ClassLoader.getSystemResourceAsStream("christmas.properties"));
            bgProperty = p.getProperty("Background");
            System.out.println(bgProperty);
        } catch (IOException e) {
            System.out.println("Error in properties file");
        }    
        return bgProperty;
    }

    public void setTime(long time){
        this.time = time;
        timeChanged();
    }
    
    public void setPeriod () {
        this.period = this.getPeriod();
    }
    
    public void timeChanged(){
        setPeriod();
        notifyObserver();
    }
}
