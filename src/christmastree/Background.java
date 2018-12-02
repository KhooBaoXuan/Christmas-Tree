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
    private Subject dateTimeReader;
    private ImageIcon day = new ImageIcon(getClass().getResource("Xmastree day.jpg"));
    private ImageIcon night = new ImageIcon(getClass().getResource("Xmastree night.jpg"));
    
    int dayTime = 0;
    int nightTime = 1;    
    int sunset = 2;
    int sunrise = 3;
    
    long curTime = 0;
    
    public Background(Subject dateTimeReader){
        this.dateTimeReader = dateTimeReader;
        dateTimeReader.registerObserver(this);
        if(curTime%2==0){
            this.setIcon(day);
        }else{
            this.setIcon(night);
        }
    }
    
    @Override
    public void update(long time) {
        this.curTime = time;
//        if(curTime%2==0){
//            this.setIcon(day);
//        }else{
//            this.setIcon(night);
//        }
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
                
            }else if(bgDesign.equals("SUNSET")){
                
            }else{
                this.setIcon(night);
            }
        } catch (Exception e) {
            System.out.println("Error in properties file");
        }
    }

}
