/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package christmastree;

import java.util.ArrayList;

/**
 *
 * @author Kee Aun
 */

public class DateTimeReader implements Subject {
    private ArrayList<Observer> observers;
    public long time;
    
    public DateTimeReader(){
        observers = new ArrayList<Observer>();
    }
    
    @Override
    public void registerObserver(Observer obs) {
        observers.add(obs);
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
            obs.update(time);
        }
    }

    public void setTime(long time){
        this.time = time;
        timeChanged();
    }
    
    public void timeChanged(){
        notifyObserver();
    }
}
