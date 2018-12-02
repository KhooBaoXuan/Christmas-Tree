/** Just ignore this file unless you wanna try the observer class **/

package christmastree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class ObserverDriver extends JFrame implements ActionListener {
   private static DateTimeReader dateTimeReader;
   //Buttons
   private JButton lightButton;
   private JButton presentButton;
   private JButton ornamentButton;
   private JButton addAllButton;
   private JButton exitButton;
 
   //Panels
   private JPanel titlePanel, imagePanel, buttonPanel, infoPanel;
 
   //Labels
   private JLabel background;
   private JLabel title, imageLabel, buttonLabel;
 
   //Image
   private ImageIcon image;
   
   private boolean presents = false;
   private boolean ornaments = false;
   private boolean lights = false;
 
   public ObserverDriver() {
       
       //Set title
       setTitle("Decorate the Christmas tree!");
       setLayout(new BorderLayout());

       //Setting the title of the JLabel
       title = new JLabel("Click on the button to add the adornment to the tree.");

       //Setting the font
       title.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 15));

       //Setting the text colour to red and positioning it to the centre
       title.setForeground(Color.red);
       title.setHorizontalAlignment(SwingConstants.CENTER);

       //Creating a new JPanel and adding the title label to it
       titlePanel = new JPanel();
       titlePanel.add(title);

       //Setting colour of title panel
       titlePanel.setBackground(Color.white);

       //Creating a new JPanel for the image to go
       imagePanel = new JPanel();

       background = new Background(dateTimeReader);
       
//       imagePanel.add(background);
       
       //Retrieving image from the file
       image = new ImageIcon(getClass().getResource("Xmastree day.jpg"));

       

       //Adding the image to a label
       imageLabel = new JLabel(image);

       //Adding image label to the image panel
       imagePanel.add(imageLabel);
       imagePanel.add(background);

       //Setting colour of image panel
       imagePanel.setBackground(Color.white);

       //Creating a new JPanel for the buttons to go
       buttonPanel = new JPanel();

       //Setting colour of button panel
       buttonPanel.setBackground(Color.white);

       //Button Label
       // buttonLabel = new JLabel("Click on the button to add the item to the tree.");
       buttonLabel = new JLabel("");
       buttonLabel.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
       buttonLabel.setForeground(Color.red);
       buttonLabel.setHorizontalAlignment(SwingConstants.CENTER);
       buttonLabel.setBackground(Color.white);

       //Info panel
       infoPanel = new JPanel();
       infoPanel.add(buttonLabel);
       infoPanel.setBackground(Color.white);

       //Naming buttons
       lightButton = new JButton("Lights");
       presentButton = new JButton("Presents");
       ornamentButton = new JButton("Ornaments");
       addAllButton = new JButton("Add All");
       exitButton = new JButton("Exit");

       //Setting colour of buttons
       lightButton.setBackground(Color.red);
       ornamentButton.setBackground(Color.red);
       presentButton.setBackground(Color.red);
       addAllButton.setBackground(Color.red);
       exitButton.setBackground(Color.red);

       //Setting font on buttons
       lightButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
       ornamentButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC,16));
       presentButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC, 16));
       addAllButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC,16));
       exitButton.setFont(new Font("CENTURY GOTHIC", Font.ITALIC,16));

       //Setting font colour on buttons
       lightButton.setForeground(Color.white);
       ornamentButton.setForeground(Color.white);
       presentButton.setForeground(Color.white);
       addAllButton.setForeground(Color.white);
       exitButton.setForeground(Color.white);

       //Add the buttons to the buttonPanel
       buttonPanel.add(lightButton);
       buttonPanel.add(ornamentButton);
       buttonPanel.add(presentButton);
       buttonPanel.add(addAllButton);
       buttonPanel.add(exitButton);

       //Enable buttons to listen for a mouse-click
       lightButton.addActionListener(this);
       ornamentButton.addActionListener(this);
       presentButton.addActionListener(this);
       addAllButton.addActionListener(this);
       exitButton.addActionListener(this);

       //Positioning Panels
       add(titlePanel, BorderLayout.NORTH);
       add(imagePanel, BorderLayout.CENTER);
       imagePanel.add(infoPanel, BorderLayout.NORTH);
       add(buttonPanel, BorderLayout.SOUTH);

       //Configure the frame
       getContentPane().setBackground(Color.white);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(600, 720);
       setLocation(300,40);
       setVisible(true);
   }//Constructor
 
   public void paint(Graphics g) {
      //Call the paint method of the superclass
      super.paint(g);
 
      if(lights)
      {
         //draw lights
         g.setColor(Color.white);
 
         //middle lights
         g.fillOval(290,190,10,10);
         g.fillOval(290,300,10,10);
         g.fillOval(290,400,10,10);
         g.fillOval(290,500,10,10);
 
         //left lights
         g.fillOval(250,300,10,10);
         g.fillOval(230,400,10,10);
         g.fillOval(210,500,10,10);
 
         //right lights
         g.fillOval(330,300,10,10);
         g.fillOval(350,400,10,10);
         g.fillOval(370,500,10,10);
 
      }//if lights
 
      if(ornaments)
      {
         //draw ornaments
         g.setColor(Color.red);
         g.fillOval(310,260,15,15);
         g.fillOval(270,260,15,15);
         g.setColor(Color.blue);
         g.fillOval(320,350,15,15);
         g.fillOval(260,350,15,15);
         g.setColor(Color.cyan);
         g.fillOval(330,450,15,15);
         g.fillOval(250,450,15,15);
 
      }//if ornaments
 
      if(presents)
      {
         //draw presents
         g.setColor(Color.red);
      //   g.fillRect(320,500,60,60);
     //    g.fillRect(140,480,30,30);
         g.fillRect(350,600,60,60);
         g.fillRect(170,580,30,30);
 
         g.setColor(Color.orange);
      //   g.fillRect(180,530,40,40);
            g.fillRect(210,630,40,40);
 
         g.setColor(Color.blue);
    //     g.fillRect(120,500,60,60);
      //   g.fillRect(360,540,30,30);
         
            g.fillRect(150,600,60,60);
         g.fillRect(390,640,30,30);
 
      }//if presents
 
   } //paint
 
   //Coding the event-handling routine
   public void actionPerformed(ActionEvent event)
   {
       long time = System.currentTimeMillis();
       dateTimeReader.setTime(time);
       
      if(event.getSource()==lightButton)
      {
         ornaments = false;
         presents = false;
         lights = true;
         repaint();
 
      }//if light
 
      else if(event.getSource()==ornamentButton)
      {
         lights = false;
         presents = false;
         ornaments = true;
         repaint();
 
      }//if ornament
 
      else if(event.getSource()==presentButton)
      {
         lights = false;
         ornaments = false;
         presents = true;
         repaint();
 
      }//if present
 
      else if(event.getSource()==addAllButton)
      {
         lights = true;
         ornaments = true;
         presents = true;
         repaint();
      }//if add all
 
      else
      {
         System.exit(0);
 
      }//else exit
 
   } //actionPerformed
 
   public static void main(String[] args)
   {
       // Subject
       dateTimeReader = new DateTimeReader();
//       Background bg = new Background(dateTimeReader);
       ObserverDriver gui = new ObserverDriver();
 
   }//main
 
}//class