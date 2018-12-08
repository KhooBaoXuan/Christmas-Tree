package christmastree;

import java.io.IOException;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Kee Aun
 */

public class Background extends JLabel implements Observer {
    private DateTimeReader dateTimeReader;
      
    private BackgroundState bgDayState = new BackgroundDayState(this);
    private BackgroundState bgSunriseState;
    private BackgroundState bgSunsetState;
    private BackgroundState bgNightState;

    private BackgroundState bgState;
    private String bgProperty;

    long curTime = 0;
    
    public Background(DateTimeReader dateTimeReader){
        bgDayState = new BackgroundDayState(this);
        bgSunriseState = new BackgroundSunriseState(this);
        bgSunsetState = new BackgroundSunsetState(this);
        bgNightState = new BackgroundNightState(this);
                
        this.dateTimeReader = dateTimeReader;
        dateTimeReader.registerObserver(this);
        bgState = BackgroundState.InitialState(this);
        long time = System.currentTimeMillis();        
        this.dateTimeReader.setTime(time);
    }

    public BackgroundState getBgDayState() {
        return bgDayState;
    }

    public BackgroundState getBgSunriseState() {
        return bgSunriseState;
    }

    public BackgroundState getBgSunsetState() {
        return bgSunsetState;
    }

    public BackgroundState getBgNightState() {
        return bgNightState;
    }

    public BackgroundState getBgState() {
        return bgState;
    }

    public void setBgState(BackgroundState bgState) {
        this.bgState = bgState;
    }

    public void setBgProperty(String bgProperty) {
        this.bgProperty = bgProperty;
    }

    public String getBgProperty() {
        return bgProperty;
    }
    
    @Override
    public void update(long time, String period) {
        this.curTime = time;
        this.bgProperty = period;
        System.out.println("curtime: "+time);
        System.out.println("period: " + bgProperty);
        if (bgState != null) {
            refresh();
        }
    }

    public void refresh(){
        bgState.refresh();
        refreshUI();
    }
    
    private void refreshUI(){
        this.setIcon(bgState.getImage());
    }

}
