/*
* Name: Mick Zeller
* Date:
*/
package main;


import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class GuiFace extends JFrame {

  //Array to hold the various changing face images.

  private ArrayList<Image> backGroundList = new ArrayList<Image>();
  private ArrayList<Image> eyeList = new ArrayList<Image>();
  private ArrayList<Image> mouthList = new ArrayList<Image>();
  private ArrayList<Image> noseList = new ArrayList<Image>();

  //these primitive type vars will be used to loop through the
  //different images.

  private int numEyes = 0;
  private int numNose = 0;
  private int numMouth = 0;
  private int numBackGround = 0;
  //main class calling constructor and creating the attributes of
  //the GUI
  private static void main(String[] args){
    System.out.println("Is it working yet?");
    GuiFace frame = new GuiFace();
    frame.setTitle("GUI Changing Face");
    frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
  public GuiFace() {
    //adding the images into the respective ArrayList
    for(int i = 0; i < 4; i++){
      eyeList.add(new ImageIcon(getClass().getResource("images/eyes" + String.valueOf(i) + ".png")).getImage());
      noseList.add(new ImageIcon(getClass().getResource("images/nose" + String.valueOf(i) + ".png")).getImage());
      mouthList.add(new ImageIcon(getClass().getResource("images/mouth" + String.valueOf(i) + ".png")).getImage());
      backGroundList.add(new ImageIcon(getClass().getResource("images/background" + String.valueOf(i) + ".png")).getImage());
    }
    /*Setting the dementions of the inner workings of the GUI*/
    JPanel panel = new JPanel();
    panel.setBackground(Color.GRAY);
    getContentPane().add(panel, BorderLayout.WEST);
    panel.setLayout(new GridLayout(5,1,0,-20));

    JLabel labelYouChoose = new JLabel("Your Choice:");
    labelYouChoose.setHorizontalAlignment(SwingConstants.CENTER);
    panel.add(labelYouChoose);
    JCheckBox checkBoxEye = new JCheckBox("Eyes");
    checkBoxEye.setOpaque(false);
    panel.add(checkBoxEye);

    JCheckBox checkBoxNose = new JCheckBox("Nose");
    checkBoxNose.setOpaque(false);
    panel.add(checkBoxNose);

    JCheckBox checkBoxMouth = new JCheckBox("Mouth");
    checkBoxMouth.setOpaque(false);
    panel.add(checkBoxMouth);

    JButton buttonUpdate = new JButton("Update");
    buttonUpdate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int checked = 0; //checks the number of boxes that are marked, if no boxes are check then it will remain zero.

        if(checkBoxEye.isSelected()) {
          checked += 1;
        if(numEyes != 3) //max index because there are 4 elements
        numEyes++;
        else numEyes = 0;
      }
        if(checkBoxMouth.isSelected()) {
          checked++;
        if(numMouth != 3)
          numMouth++;
        else numMouth = 0;
      }
        if(checkBoxNose.isSelected()) {
          checked++;
          if(numNose != 3)
            numNose++;
          else numNose = 0;
      }
        if(checked == 0) { // checked remains 0 as long as no box is checked.
          if(numBackGround != 3)
            numBackGround++; //then the background changes
            else numBackGround = 0;
        }
      }
    });
    buttonUpdate.setOpaque(false);
    panel.add(buttonUpdate);

    getContentPane().add(new Face(), BorderLayout.CENTER);
  }

  /*Panel for the users to paint on.*/
  protected class Face extends JPanel {
    @Override
    public void paint(Graphics g) {
      //using the super keyword allows this subclass to overload the methods inherited by the superclass
      super.paint(g);
      g.drawImage(backGroundList.get(numBackGround), 50, 50, 400, 400, null);
      g.drawImage(eyeList.get(numEyes), 0, 0, 500, 500, null);
      g.drawImage(noseList.get(numNose), 0, 10, 500, 500, null);
      g.drawImage(mouthList.get(numMouth), 0, 35, 500, 500, null);
      repaint();  //updates continuously
    }

  }
}
