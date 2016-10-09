/*
 * Name: Mick Zeller
 * Midterm 2 CSIS 1410
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GuiExcercise extends JFrame {

	private JPanel contentPane;
	private Icon pictures;
	private int i=1;
   //index 0 = white index 1 = light gray
	private Color[] colors ={Color.WHITE,Color.LIGHT_GRAY};


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiExcercise frame = new GuiExcercise();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiExcercise() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);


		final JLabel ladyLiberty = new JLabel();
		ladyLiberty.setOpaque(true);

		pictures = new ImageIcon(getClass().getResource("NewYork.png"));

		ladyLiberty.setIcon(pictures);

		ladyLiberty.setBackground(Color.WHITE);

		contentPane.add(ladyLiberty, BorderLayout.CENTER);
        //create action listener
		JButton btnNewButton = new JButton("Show New York at Night");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			//each time the button is clicked it will fall into the if or else statement changing the value of i.
            if(i == 2)
				{
             //set i equal to 0 then white (index 0) will be displayed
					i = 0;
			   ladyLiberty.setBackground(colors[i]);
               btnNewButton.setText("Show New York at Night");
				}
				else {
               //set i equal to 2 then light gray (index 1) will be displayed.  use color[i-1] to prevent array out of bounds exception
					i =2;
              ladyLiberty.setBackground( colors[ i-1]);
			  btnNewButton.setText("Show New York at Day");
				}
			}
		});
		contentPane.add(btnNewButton, BorderLayout.SOUTH);

		JLabel lblNewYork = new JLabel("New York");
		lblNewYork.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblNewYork.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewYork, BorderLayout.NORTH);
	}
}
