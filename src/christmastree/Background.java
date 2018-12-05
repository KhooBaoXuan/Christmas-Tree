/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package christmastree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Kee Aun
 */

public class Background extends JLabel implements Observer {
    private DateTimeReader dateTimeReader;
    
    private ImageIcon day = new ImageIcon(getClass().getResource("Xmastree day.jpg"));
    private ImageIcon sunrise = new ImageIcon(getClass().getResource("Xmastree sunrise.jpg"));
    private ImageIcon sunset = new ImageIcon(getClass().getResource("Xmastree sunset.jpg"));
    private ImageIcon night = new ImageIcon(getClass().getResource("Xmastree night.jpg"));

    long curTime = 0;
    
    public Background(DateTimeReader dateTimeReader){
        this.dateTimeReader = dateTimeReader;
        dateTimeReader.registerObserver(this);
        long time = System.currentTimeMillis();
        this.dateTimeReader.setTime(time);
    }
    
    @Override
    public void update(long time) {
        this.curTime = time;
        System.out.println("curtime: "+time);
        updateBackground();
    }
    
    public void updateBackground(){
        Properties p = new Properties();
        try {
            p.load(ClassLoader.getSystemResourceAsStream("christmas.properties"));
            String bgDesign = p.getProperty("Background");
            System.out.println(bgDesign);
            
            if(bgDesign.equals("DAY")){
                this.setIcon(day);
            }else if(bgDesign.equals("SUNRISE")){
                this.setIcon(sunrise);
            }else if(bgDesign.equals("SUNSET")){
                this.setIcon(sunset);
            }else{
                this.setIcon(night);
            }
        } catch (IOException e) {
            System.out.println("Error in properties file");
        }
    }

}
