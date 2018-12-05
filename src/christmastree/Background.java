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
        updateBgProperty();
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
    public void update(long time) {
        this.curTime = time;
        System.out.println("curtime: "+time);
        updateBgProperty();
        refresh();
    }
    
    //*******Note: Read properties suppose in DateTimeReader(Subject) class)?
    private void updateBgProperty(){
        Properties p = new Properties();
        try {
            p.load(ClassLoader.getSystemResourceAsStream("christmas.properties"));
            bgProperty = p.getProperty("Background");
            System.out.println(bgProperty);
        } catch (IOException e) {
            System.out.println("Error in properties file");
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
