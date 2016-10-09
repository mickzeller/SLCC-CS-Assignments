package icons;
//Mick Zeller
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;

import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.GridLayout;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

/*BalloonApp randomly generates two objects and checks if they are equal or not*/
public class BalloonApp extends JFrame {
	//text field to display the results
	private JTextField textField;
	//array to hold the different icons
	private Icon[] icons = new Icon[5];
	//this array will be used to make the balloon either "helium" or "air"
	//0 if false; 1 if true
	private boolean[] helium = {false, true};
	//declaring an instance of class Random
	private Random random = new Random();
	//this array will hold the emun sizes - constants
	private Size[] sizes = new Size[]{Size.XS, Size.S, Size.M, Size.L, Size.XL};

	public static void main(String[] args) {
		BalloonApp frame = new BalloonApp();
		frame.setTitle("Lab Object");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setSize(600,600);
		frame.setVisible(true);
		}
	public BalloonApp() {

		JLabel labelHeader = new JLabel("Lab Ballons");
		labelHeader.setBorder(new EmptyBorder(10,0,0,0));
		labelHeader.setFont(new Font("Tahoma", Font.PLAIN,18));
		labelHeader.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(labelHeader, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		getContentPane().add(panel, BorderLayout.SOUTH);

		textField = new JTextField();
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.GRAY);
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(10);

		JPanel panel1 = new JPanel();
		panel1.setBorder(new EmptyBorder(10, 10, 10, 10));
		getContentPane().add(panel1, BorderLayout.CENTER);
		panel1.setLayout(new GridLayout(0,2,5,0));

		JButton leftButton = new JButton("Click to Start!");
		leftButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		leftButton.setBackground(Color.WHITE);
		leftButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		leftButton.setHorizontalTextPosition(SwingConstants.CENTER);
		panel1.add(leftButton);

		JButton rightButton = new JButton("Click to Start!");
		rightButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		rightButton.setBackground(Color.WHITE);
		rightButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		rightButton.setHorizontalTextPosition(SwingConstants.CENTER);
		panel1.add(rightButton);

		/*-------------------main function!-----------------*/
		//instance array of icons
		for(int i = 0; i < 5; i++){
			icons[i] = new ImageIcon(getClass().getResource("balloon" + String.valueOf(i * 20 + 20) + ".jpg"));
		}
		/*Random button and action listener*/
		JButton randomButton = new JButton("Get Random Ballons");
			randomButton.addActionListener(new ActionListener() {
				//event handler for the getRandom button
				public void actionPerformed(ActionEvent e) {
					int iconValue = random.nextInt(5); //choose an icon randomly
					int ballonHelium = random.nextInt(2); //makes helium either 1 (true) or 0 (false)

					//left balloon
					Balloon leftBalloon = new Balloon(sizes[iconValue],helium[ballonHelium], icons[iconValue]);
					leftButton.setIcon(icons[iconValue]);
					leftButton.setText(leftBalloon.toString());

					iconValue = random.nextInt(5);
					ballonHelium = random.nextInt(2);

					//right ballon
					Balloon rightBallon = new Balloon(sizes[iconValue], helium[ballonHelium], icons[iconValue]);
					rightButton.setIcon(icons[iconValue]);
					rightButton.setText(rightBallon.toString());

					//compares the two balloons and sets the results to the text field
					if(leftBalloon.equals(rightBallon)) {
						textField.setText("equal");
						textField.setBackground(Color.GREEN);
					}
					else {
						textField.setText("not equal");
						textField.setBackground(Color.RED);
					}
				}
			});
			panel.add(randomButton);
			panel.add(textField);
	}
}
