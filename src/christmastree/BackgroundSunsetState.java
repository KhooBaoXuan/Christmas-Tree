package christmastree;

import javax.swing.ImageIcon;

/**
 *
 * @author Kee Aun
 */

public class BackgroundSunsetState extends BackgroundState {
    Background background;
    
    public BackgroundSunsetState(Background background){
        this.background = background;
        image = new ImageIcon(getClass().getResource("Xmastree sunset.jpg"));
    }
    
    @Override
    public void refresh() {
        String bgProperty = background.getBgProperty();
        
        if(bgProperty.equals("SUNSET")){
            // do nothing
        }else if(bgProperty.equals("NIGHT")){
            background.setBgState(background.getBgNightState());
        }else{
            System.err.println("Follow the sequence DAY->SUNRISE->SUNSET->NIGHT");
            throw new UnsupportedOperationException("Not support yet");        
        }
    }

}