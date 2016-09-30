package main;
/*********************************
 * Name: Mick Zeller
 * Date: March 17, 2015
 ********************************/
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;

public class App extends JFrame
{

    private static final long serialVersionUID = 1L;
    private PanelToDraw mainPanel;
    private JMenuBar menuBar;
    private JPanel scorePanel;
    private JPanel choicePanel;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private Image compImage;
    private Image playerImage;

    private JLabel playerScoreField;
    private JLabel compScoreField;
    private JLabel result;
    private int playerScore = 0;
    private int compScore = 0;
    private JPanel resultPanel;

    public static void main(String[] args)
	{
	    EventQueue.invokeLater(new Runnable()
	    {
		@Override
		public void run()
		    {
			try
			{
			    App frame = new App();
			    frame.setVisible(true);
			} catch (Exception e)
			{
			    e.printStackTrace();
			}
		    }
	    });
	}

    public App()
    {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(50, 50, 700, 600);
	setTitle("Rock Paper Scissors");
	setResizable(false);
	createMenu();
	createChoicePanel();

	mainPanel = new PanelToDraw();
	mainPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, false));
	mainPanel.setLayout(new GridLayout(2, 1));
	mainPanel.setBackground(Color.WHITE);
	getContentPane().add(mainPanel, BorderLayout.CENTER);
	createResultPanel();
    }

    protected class PanelToDraw extends JPanel
    {

	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g)
	    {
		super.paint(g);
		g.drawImage(compImage, 190, 60, 200, 200, null);
		g.drawImage(playerImage, 190, 310, 200, 200, null);
		repaint(); //update continuously
	    }

    }

    private class EventHandler implements ActionListener
    {

	@Override
	public void actionPerformed(ActionEvent e)
	    {
		RockPaperScissors computer = RockPaperScissors.getRandom();
		RockPaperScissors player = RockPaperScissors.valueOf(e.getActionCommand());
		App.this.compImage = computer.getImageReversed().getImage();
		App.this.playerImage = player.getImage().getImage();

		switch (player.evaluate(computer))
		{
		    case 1:
			playerScore++;
			playerScoreField.setText(String.valueOf(playerScore));
			result.setText("You Win!");
			result.setForeground(Color.GREEN);
			break;
		    case -1:
			compScore++;
			compScoreField.setText(String.valueOf(compScore));
			result.setText("You Lose!");
			result.setForeground(Color.RED);
			break;
		    case 0:
			result.setText("Tie");
			result.setForeground(Color.BLUE);
			break;
		}
	    }
    }

    private void createChoicePanel()
	{
	    EventHandler event = new EventHandler();
	    choicePanel = new JPanel();
	    choicePanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, false));
	    choicePanel.setBackground(Color.WHITE);
	    getContentPane().add(choicePanel, BorderLayout.WEST);
	    choicePanel.setLayout(new GridLayout(3, 1, 0, 0));

	    JRadioButton rdbtnRock = new JRadioButton("");
	    rdbtnRock.setBackground(Color.WHITE);
	    rdbtnRock.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnRock.setIcon(new ImageIcon(App.class.getResource("/images/rockIcon.jpg")));
	    rdbtnRock.setActionCommand("ROCK");
	    rdbtnRock.addActionListener(event);
	    buttonGroup.add(rdbtnRock);
	    choicePanel.add(rdbtnRock);

	    JRadioButton rdbtnPaper = new JRadioButton("");
	    rdbtnPaper.setBackground(Color.WHITE);
	    rdbtnPaper.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnPaper.setIcon(new ImageIcon(App.class.getResource("/images/paperIcon.jpg")));
	    rdbtnPaper.setActionCommand("PAPER");
	    rdbtnPaper.addActionListener(event);
	    buttonGroup.add(rdbtnPaper);
	    choicePanel.add(rdbtnPaper);

	    JRadioButton rdbtnScissors = new JRadioButton("");
	    rdbtnScissors.setBackground(Color.WHITE);
	    rdbtnScissors.setHorizontalAlignment(SwingConstants.CENTER);
	    rdbtnScissors.setIcon(new ImageIcon(App.class.getResource("/images/scissorsIcon.jpg")));
	    rdbtnScissors.setActionCommand("SCISSORS");
	    rdbtnScissors.addActionListener(event);
	    buttonGroup.add(rdbtnScissors);
	    choicePanel.add(rdbtnScissors);
	}

    private void createResultPanel()
	{
	    scorePanel = new JPanel();
	    scorePanel.setBackground(Color.WHITE);
	    mainPanel.add(scorePanel);

	    JLabel lblPlayer = new JLabel("Player");
	    scorePanel.add(lblPlayer);

	    playerScoreField = new JLabel();
	    playerScoreField.setText("0");
	    playerScoreField.setForeground(Color.BLACK);
	    scorePanel.add(playerScoreField);

	    JLabel lblColon = new JLabel(":");
	    scorePanel.add(lblColon);

	    compScoreField = new JLabel();
	    compScoreField.setText("0");
	    compScoreField.setForeground(Color.BLACK);
	    scorePanel.add(compScoreField);

	    JLabel lblComp = new JLabel("Computer");
	    scorePanel.add(lblComp);

	    resultPanel = new JPanel();
	    resultPanel.setBackground(Color.WHITE);

	    result = new JLabel();
	    result.setBackground(Color.WHITE);
	    result.setFont(new Font("Tahoma", 1, 25));
	    mainPanel.add(resultPanel);
	    resultPanel.add(result);
	}

    private void createMenu()
	{
	    menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    JMenuItem mntmNewGame = new JMenuItem("New Game");
	    mntmNewGame.addActionListener(new ActionListener()
	    {

		@Override
		public void actionPerformed(ActionEvent arg0)
		    {
			reset();
		    }
	    });
	    menuBar.add(mntmNewGame);

	    JMenuItem mntmExit = new JMenuItem("Exit");
	    mntmExit.setHorizontalAlignment(SwingConstants.RIGHT);
	    mntmExit.addActionListener(new ActionListener()
	    {

		@Override
		public void actionPerformed(ActionEvent arg0)
		    {
			System.exit(0);

		    }
	    });
	    menuBar.add(mntmExit);
	}

    private void reset()
	{
	    result.setText("");
	    playerScoreField.setText("0");
	    compScoreField.setText("0");
	    compImage = null;
	    playerImage = null;
	    compScore = 0;
	    playerScore = 0;
	}

}
