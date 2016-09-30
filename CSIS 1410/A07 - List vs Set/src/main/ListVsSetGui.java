/********************************************************
 *Name : Mick Zeller 
 *Date : March 30, 2015
 ********************************************************/
package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class ListVsSetGui extends JFrame
{

    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenuItem mntnListVsSet;
    private JMenuItem mntmDemo;
    private JMenuItem mntnExit;
    private JTextArea listVsSetTextArea;
    private JPanel demoControlPanel;
    private JLabel lblYourChoice;
    private JRadioButton rdbtnListElements;
    private JRadioButton rdbtnSetElements;
    private JRadioButton rdbtnAddElements;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JTextArea demoTextArea;

    private ListVsSetDemo demo = new ListVsSetDemo(new ColoredSquare(14, Color.BLUE), new ColoredSquare(18, Color.RED),
	    new ColoredSquare(12, Color.YELLOW), new ColoredSquare(18, Color.RED), new ColoredSquare(16, Color.GREEN));

    public static void main(String[] args)
	{
	    EventQueue.invokeLater(new Runnable()
	    {
		@Override
		public void run()
		    {
			try
			{
			    ListVsSetGui frame = new ListVsSetGui();
			    frame.setVisible(true);
			} catch (Exception e)
			{
			    e.printStackTrace();
			}
		    }
	    });
	}

    public ListVsSetGui()
    {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(50, 50, 700, 450);
	createMenu();
	createListVsSetTextArea();
	createDemoControlPanel();
	createDemoTextArea();
	createContentPane();
    }

    private void createContentPane()
	{
	    contentPane = new JPanel();
	    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(new BorderLayout(0, 0));
	    contentPane.setFont(new Font("Verdana", Font.PLAIN, 26));
	    setContentPane(contentPane);
	    contentPane.add(listVsSetTextArea, BorderLayout.CENTER);
	}

    private void createDemoTextArea()
	{
	    demoTextArea = new JTextArea();
	    demoTextArea.setBackground(UIManager.getColor("TextField.light"));
	    demoTextArea.setFont(new Font("Consolas", Font.PLAIN, 16));
	    demoTextArea.setMargin(new Insets(25, 25, 25, 25));
	}

    private void createDemoControlPanel()
	{
	    demoControlPanel = new JPanel();
	    demoControlPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
	    demoControlPanel.setLayout(new GridLayout(12, 1, 0, 0));

	    lblYourChoice = new JLabel("Your Choice:");
	    lblYourChoice.setFont(new Font("Consolas", Font.BOLD, 14));
	    demoControlPanel.add(lblYourChoice);

	    rdbtnListElements = new JRadioButton("List Elements");
	    rdbtnListElements.setFont(new Font("Consolas", Font.PLAIN, 14));
	    rdbtnListElements.addActionListener(new ActionListener()
	    {

		@Override
		public void actionPerformed(ActionEvent arg0)
		    {
			demoTextArea.setText(demo.getListElements());
		    }
	    });
	    buttonGroup.add(rdbtnListElements);
	    demoControlPanel.add(rdbtnListElements);

	    rdbtnSetElements = new JRadioButton("Set Elements");
	    rdbtnSetElements.setFont(new Font("Consolas", Font.PLAIN, 14));
	    rdbtnSetElements.addActionListener(new ActionListener()
	    {

		@Override
		public void actionPerformed(ActionEvent arg0)
		    {
			demoTextArea.setText(demo.getSetElements());
		    }
	    });
	    buttonGroup.add(rdbtnSetElements);
	    demoControlPanel.add(rdbtnSetElements);

	    rdbtnAddElements = new JRadioButton("Add Element");
	    rdbtnAddElements.setFont(new Font("Consolas", Font.PLAIN, 14));
	    rdbtnAddElements.addActionListener(new ActionListener()
	    {

		@Override
		public void actionPerformed(ActionEvent arg0)
		    {
			demo.addElement(new ColoredSquare(10, Color.ORANGE));
			demoTextArea.setText("New element has been added.");
		    }
	    });
	    buttonGroup.add(rdbtnAddElements);
	    demoControlPanel.add(rdbtnAddElements);
	}

    private void createListVsSetTextArea()
	{
	    listVsSetTextArea = new JTextArea("The 2 main differences between interface List and Set are:\n"
		    + "1. List allows duplicates while Set doesn't \n"
		    + "2. - List maintains insertion order of elements.\n"
		    + "    - Set is an unordered grouping of elements.");
	    listVsSetTextArea.setMargin(new Insets(25, 25, 25, 25));
	    listVsSetTextArea.setForeground(new Color(255, 255, 255));
	    listVsSetTextArea.setOpaque(true);
	    listVsSetTextArea.setBackground(SystemColor.inactiveCaptionText);
	    listVsSetTextArea.setFont(new Font("Verdana", Font.PLAIN, 18));
	}

    private void createMenu()
	{
	    menuBar = new JMenuBar();
	    setJMenuBar(menuBar);

	    mntmDemo = new JMenuItem("Demo");
	    mntmDemo.setHorizontalAlignment(SwingConstants.CENTER);
	    mntmDemo.addActionListener(new ActionListener()
	    {
		@Override
		public void actionPerformed(ActionEvent arg0)
		    {
			contentPane.removeAll();
			contentPane.add(demoControlPanel, BorderLayout.WEST);
			contentPane.add(demoTextArea, BorderLayout.CENTER);
			revalidate();
			repaint();
		    }
	    });
	    menuBar.add(mntmDemo);

	    mntnListVsSet = new JMenuItem("List vs Set");
	    mntnListVsSet.setHorizontalAlignment(SwingConstants.CENTER);
	    mntnListVsSet.addActionListener(new ActionListener()
	    {
		@Override
		public void actionPerformed(ActionEvent arg0)
		    {
			contentPane.removeAll();
			contentPane.add(listVsSetTextArea, BorderLayout.CENTER);
			revalidate();
			repaint();
		    }
	    });
	    menuBar.add(mntnListVsSet);

	    mntnExit = new JMenuItem("Exit");
	    mntnExit.setHorizontalAlignment(SwingConstants.CENTER);
	    mntnExit.addActionListener(new ActionListener()
	    {
		@Override
		public void actionPerformed(ActionEvent arg0)
		    {
			System.exit(0);
		    }
	    });
	    menuBar.add(mntnExit);
	}
}
