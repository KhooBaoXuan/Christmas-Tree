package christmastree;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.imageio.ImageIO;

public class XmasTreeSwing extends JFrame implements ActionListener {
   //Buttons
   private JButton lightButton;
   private JButton presentButton;
   private JButton ornamentButton;
   private JButton addAllButton;
   private JButton exitButton;
 
   //Panels
   private JPanel titlePanel, imagePanel, buttonPanel, infoPanel;
 
   //Labels
   private JLabel title, imageLabel, buttonLabel;
 
   //Image
   private ImageIcon image;
 
   //Boolean
//   private boolean presents = true;
//   private boolean ornaments = true;
//   private boolean lights = true;
   
    private static RemoteControl rc;
    private static CommandHistory ch;
      
    private static Light light;
    private static Ornament ornament;
    private static Present present;
   
   private boolean presents = false;
   private boolean ornaments = false;
   private boolean lights = false;
   
   public void setupChristmasTree() {
       setupTitle();
       setupImage();
       setupButtonLabel();
       setupInfoPanel();
       setupButton();
       setupPanel();
       setupFrame();
   }
   
   public void setupTitle() {
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
   }
   
   public void setupImage() {
       //Creating a new JPanel for the image to go
       imagePanel = new JPanel();

       //Retrieving image from the file
       image = new ImageIcon(getClass().getResource("tree1.jpg"));


       //Adding the image to a label
       imageLabel = new JLabel(image);

       //Adding image label to the image panel
       imagePanel.add(imageLabel);

       //Setting colour of image panel
       imagePanel.setBackground(Color.white);
   }
   
   public void setupInfoPanel() {
       //Info panel
       infoPanel = new JPanel();
       infoPanel.add(buttonLabel);
       infoPanel.setBackground(Color.white);
   }
   
   public void setupButtonLabel() {
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
   }
   
   public void setupButton() {
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
   }
   
   public void setupPanel() {
       //Positioning Panels
       add(titlePanel, BorderLayout.NORTH);
       add(imagePanel, BorderLayout.CENTER);
       imagePanel.add(infoPanel, BorderLayout.NORTH);
       add(buttonPanel, BorderLayout.SOUTH);
   }
   
   public void setupFrame() {
       //Configure the frame
       getContentPane().setBackground(Color.white);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(500, 650);
       setLocation(300,40);
       setVisible(true);
   }
 
   public XmasTreeSwing() {
       
       //Set title
       setTitle("Decorate the Christmas tree!");
       setLayout(new BorderLayout());

       setupChristmasTree();
    
   }//Constructor
 
   public void drawLights(Graphics g) {
    //draw lights
     g.setColor(Color.white);

     //middle lights
     g.fillOval(250,190,10,10);
     g.fillOval(250,260,10,10);
     g.fillOval(250,350,10,10);
     g.fillOval(250,430,10,10);

     //left lights
     g.fillOval(200,260,10,10);
     g.fillOval(180,350,10,10);
     g.fillOval(160,430,10,10);

     //right lights
     g.fillOval(300,260,10,10);
     g.fillOval(330,350,10,10);
     g.fillOval(340,430,10,10);
   }
   
   public void drawOrnaments (Graphics g) {
        //draw ornaments
      g.setColor(Color.red);
      g.fillOval(220,220,15,15);
      g.fillOval(280,220,15,15);
      g.setColor(Color.blue);
      g.fillOval(320,380,15,15);
      g.fillOval(180,380,15,15);
      g.setColor(Color.cyan);
      g.fillOval(200,300,15,15);
      g.fillOval(300,300,15,15);
   }
   
   public void drawPresents (Graphics g) {
       //draw presents
        g.setColor(Color.red);
     //   g.fillRect(320,500,60,60);
    //    g.fillRect(140,480,30,30);
        g.fillRect(320,400,60,60);
        g.fillRect(140,380,30,30);

        g.setColor(Color.orange);
     //   g.fillRect(180,530,40,40);
           g.fillRect(180,430,40,40);

        g.setColor(Color.blue);
    //     g.fillRect(120,500,60,60);
     //   g.fillRect(360,540,30,30);

           g.fillRect(120,400,60,60);
        g.fillRect(360,440,30,30);
   }
   
   public void paint(Graphics g) {
      //Call the paint method of the superclass
      super.paint(g);
 
      if(lights)
      {
         drawLights(g);
      }//if lights
 
      if(ornaments)
      {
         drawOrnaments(g);
      }//if ornaments
 
      if(presents)
      {
         drawPresents(g);
 
      }//if presents
 
   } //paint
 
   //Coding the event-handling routine
   public void actionPerformed(ActionEvent event)
   {
 
      if(event.getSource()==lightButton)
      {
          toggleLight();
         lights = light.isLight();
         repaint();
 
      }//if light
 
      else if(event.getSource()==ornamentButton)
      {
          toggleOrnament();
         ornaments = ornament.isOrnament();
         repaint();
 
      }//if ornament
 
      else if(event.getSource()==presentButton)
      {
          togglePresent();
         presents = present.isPresent();
         repaint();
 
      }//if present
 
      else if(event.getSource()==addAllButton)
      {
        toggleAllTrue();
          
         lights = light.isLight();
         ornaments = ornament.isOrnament();
         presents = present.isPresent();
         repaint();
      }//if add all
 
      else
      {
         System.exit(0);
 
      }//else exit
 
   } //actionPerformed
   
   public void toggleLight () {
       String log = "";
       if (!light.isLight()) {
           log = rc.showButtonPushed(0);
       } else {
           log = rc.hideButtonPushed(0);
       }
       ch.log(log);
   }
   
   public void toggleOrnament () {
       String log = "";
       if (!ornament.isOrnament()) {
           log = rc.showButtonPushed(1);
       } else {
           log = rc.hideButtonPushed(1);
       }
       ch.log(log);
   }
   
   public void togglePresent () {
       String log = "";
       if (!present.isPresent()) {
           log = rc.showButtonPushed(2);
       } else {
           log = rc.hideButtonPushed(2);
       }
       ch.log(log);
   }
   
   public void toggleAllTrue () {
       String log = "";
       if (light.isLight() &&
         ornament.isOrnament() &&
         present.isPresent()) {
        log = rc.hideAll();
       } else {
        log = rc.showAll();
       }
       ch.log(log);
   }
 
   public static void main(String[] args)
   {
      XmasTreeSwing gui = new XmasTreeSwing();
      
      rc = new RemoteControl();
      ch = CommandHistory.getInstance();
      
      light = new Light();
      ornament = new Ornament();
      present = new Present();
      
      LightShowCommand lsc = new LightShowCommand(light);
      LightHideCommand lhc = new LightHideCommand(light);
      OrnamentShowCommand osc = new OrnamentShowCommand(ornament);
      OrnamentHideCommand ohc = new OrnamentHideCommand(ornament);
      PresentShowCommand psc = new PresentShowCommand(present);
      PresentHideCommand phc = new PresentHideCommand(present);
      
      rc.setCommand(lsc, lhc);
      rc.setCommand(osc, ohc);
      rc.setCommand(psc, phc);
   }//main
 
}//class
