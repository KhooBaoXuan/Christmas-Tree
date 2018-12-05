package christmastree;

import javax.swing.ImageIcon;

/**
 *
 * @author Kee Aun
 */

public class BackgroundDayState extends BackgroundState {
    Background background;
    
    public BackgroundDayState(Background background){
        this.background = background;
        image = new ImageIcon(getClass().getResource("Xmastree day.jpg"));
    }
    
    @Override
    public void refresh() {
        String bgProperty = background.getBgProperty();
        
        if(bgProperty.equals("DAY")){
            // do nothing
        }else if(bgProperty.equals("SUNRISE")){
            background.setBgState(background.getBgSunriseState());
        }else{
            System.err.println("Follow the sequence DAY->SUNRISE->SUNSET->NIGHT");
            throw new UnsupportedOperationException("Not support yet");        
        }
    }

}
