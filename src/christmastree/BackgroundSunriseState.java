package christmastree;

import javax.swing.ImageIcon;

/**
 *
 * @author Kee Aun
 */

public class BackgroundSunriseState extends BackgroundState {
    Background background;
    
    public BackgroundSunriseState(Background background){
        this.background = background;
        image = new ImageIcon(getClass().getResource("Xmastree sunrise.jpg"));
    }
    
    @Override
    public void refresh() {
        String bgProperty = background.getBgProperty();
        
        if(bgProperty.equals("SUNRISE")){
            // do nothing
        }else if(bgProperty.equals("SUNSET")){
            background.setBgState(background.getBgSunsetState());
        }else{
            System.err.println("Follow the sequence DAY->SUNRISE->SUNSET->NIGHT");
            throw new UnsupportedOperationException("Not support yet");        
        }
    }

}
