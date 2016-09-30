/********************************************************
 *  Name    :  Mick Zeller
 *  Date    :  March 21, 2015
 ********************************************************/
package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MemoryApp extends JFrame
{

    private final int pairs[] = new int[12];
    private final JButton[] btn = new JButton[12];
    private final ImageIcon[] icons = new ImageIcon[7];

    public static void main(String[] args)
	{
	    MemoryApp frame = new MemoryApp();
	    frame.setTitle("Memory Game");
	    frame.setBounds(50, 50, 700, 750);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	}

    public MemoryApp()
    {
	final JPanel content = new JPanel();
	content.setBackground(Color.BLACK);
	content.setBorder(new EmptyBorder(20, 20, 20, 30));
	content.setLayout(new BorderLayout(0, 30));
	final JLabel lb = new JLabel("Memory Game");
	lb.setForeground(Color.WHITE);
	lb.setFont(new Font("", Font.BOLD, 35));
	lb.setHorizontalAlignment((int) CENTER_ALIGNMENT);
	content.add(lb, BorderLayout.NORTH);
	//contains the images to be displayed
	final JPanel contentPane = new JPanel();
	contentPane.setBackground(Color.GRAY);
	contentPane.setLayout(new GridLayout(3, 4, 20, 20));

	//reading all images into array icons. Icon id will be from 0 - 6
	for (int i = 0; i <= 6; i++)
	{
	    icons[i] = new ImageIcon(getClass()

		    .getResource(String.valueOf(i) + ".png"));
	}
	//assigning pairs to other pictures
	for (int i = 0; i < 6; i++)
	{
	    pairs[2 * i] = i;
	    pairs[2 * i + 1] = i;
	}

	Random rand = new Random();
	//Randomly distributes the images
	for (int i = 0; i < 12; i++)
	{
	    int r = rand.nextInt(12);
	    int temp = pairs[r];
	    pairs[r] = pairs[i];
	    pairs[i] = temp;
	}

	btnClickHandler event = new btnClickHandler();
	//adding the pictures to the pane
	for (int i = 0; i < 12; i++)
	{
	    btn[i] = new JButton();
	    btn[i].setIcon(icons[6]);
	    contentPane.add(btn[i]);
	    btn[i].setActionCommand(String.valueOf(i));
	    btn[i].addActionListener(event);
	}

	content.add(contentPane);
	setContentPane(content);

    }

    private class btnClickHandler implements ActionListener
    {

	//action listener that will see which item is clicked on the frame
	@Override
	public void actionPerformed(ActionEvent e)
	    {
		int btnId = Integer.parseInt(e.getActionCommand());

		JButton bttn = btn[btnId];

		if (bttn.getIcon().equals(icons[6]))
		{
		    bttn.setIcon(icons[pairs[btnId]]);
		} else
		{
		    bttn.setIcon(icons[6]);
		}
	    }

    }

}
