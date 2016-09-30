package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/*****************************************************************************
*
*  Name    :  Mick, Dante, Clifford
*  Date    :  4/18/15
****************************************************************************/

public class GUI extends JFrame
{


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    JPanel panel = new JPanel();
    PlayerScoreRecord scoreRecord = new PlayerScoreRecord();
    private int playerBet = 0;
    private int funds = PlayerScoreRecord.getWinnings();
    final JLabel chipTotal = new JLabel();
    final JLabel playerTotal = new JLabel();
    final JLabel dealerTotal = new JLabel();
    final JLabel playersCurrentMoney = new JLabel();
    final JTextPane helpMenuPrintout = new JTextPane();
    final JLabel playerCard1 = new JLabel();
    final JLabel playerCard2 = new JLabel();
    final JLabel playerCard3 = new JLabel();
    final JLabel playerCard4 = new JLabel();
    final JLabel playerCard5 = new JLabel();
    final JLabel playerCard6 = new JLabel();
    final JLabel dealerCard1 = new JLabel();
    final JLabel dealerCard2 = new JLabel();
    final JLabel dealerCard3 = new JLabel();
    final JLabel dealerCard4 = new JLabel();
    final JLabel dealerCard5 = new JLabel();
    final JLabel dealerCard6 = new JLabel();
    final ImageIcon backOfCard = new ImageIcon(getClass().getResource("Images/Back.png"));
    final ImageIcon chip1Disabled = new ImageIcon(getClass().getResource("Images/1_chip_sm_disabled.png"));
    final ImageIcon chip5Disabled = new ImageIcon(getClass().getResource("Images/5_chip_sm_disabled.png"));
    final ImageIcon chip25Disabled = new ImageIcon(getClass().getResource("Images/25_chip_sm_disabled.png"));
    final ImageIcon chip100Disabled = new ImageIcon(getClass().getResource("Images/100_chip_sm_disabled.png"));
    //Buttons
    JButton chip1Button = new JButton("");
    JButton chip5Button = new JButton("");
    JButton chip25Button = new JButton("");
    JButton chip100Button = new JButton("");
    JButton btnStay = new JButton("STAY");
    JButton btnHit = new JButton("HIT");
    JButton newGameButton = new JButton("NEW GAME");
    JButton donePlacingBet = new JButton("DONE");
    JButton placeNewBet = new JButton("NEW BET");
    JLabel message = new JLabel();
    JLabel tieMessage = new JLabel();
    static GUI frame;
    Game game = new Game();
    int hitCount = 0;

    public static void main(String[] args)
	{
	    EventQueue.invokeLater(new Runnable()
	    {
		public void run()
		    {
			try
			{
			    frame = new GUI();
			    frame.setVisible(true);
			} catch (Exception e)
			{
			    e.printStackTrace();
			}
		    }
	    });
	}

    public GUI()
    {
	game.newGame();

	setTitle("BLACKJACK");
	setForeground(Color.DARK_GRAY);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 1157, 868);

	final JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);

	JMenu jMenuBar_File = new JMenu("File");
	menuBar.add(jMenuBar_File);

	JMenuItem mntmNewMenuItem = new JMenuItem("New Game");
	mntmNewMenuItem.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
		{
		    startNewGame();
		}
	});
	jMenuBar_File.add(mntmNewMenuItem);

	JMenuItem chckbxmntmNewCheckItem = new JMenuItem("Save");
	jMenuBar_File.add(chckbxmntmNewCheckItem);

	JMenuItem chckbxmntmNewCheckItem_1 = new JMenuItem("Load");
	jMenuBar_File.add(chckbxmntmNewCheckItem_1);
	/* Closes program when user selects File>Exit */
	JMenuItem chckbxmntmNewCheckItem_2 = new JMenuItem("Exit");
	chckbxmntmNewCheckItem_2.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
		{
		    System.exit(0);
		}
	});
	jMenuBar_File.add(chckbxmntmNewCheckItem_2);

	JMenu jMenuBar_Game = new JMenu("Cheats");
	menuBar.add(jMenuBar_Game);

	JCheckBoxMenuItem chckbxmntmUnlimitedChips = new JCheckBoxMenuItem("More Money");
	jMenuBar_Game.add(chckbxmntmUnlimitedChips);

	JCheckBoxMenuItem chckbxmntmPoints = new JCheckBoxMenuItem("Blackjack!");
	jMenuBar_Game.add(chckbxmntmPoints);

	JMenu mnNewMenu = new JMenu("Help");
	menuBar.add(mnNewMenu);
	/*
	 * Can't figure out how to get the Help Menu Printout to disappear I
	 * tried a setVisablity to false and repaint
	 */
	JMenuItem menuItemRules = new JMenuItem("Rules");
	menuItemRules.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
		{
		    helpMenuPrintout.setVisible(true);
		    helpMenuPrintout.setText("A card game where you basically try "
			    + "to beat the dealer by getting as close to a total of "
			    + "21 as possible without going over. A picture card and "
			    + "an Ace counts as 21, or Blackjack. This is one of the "
			    + "best games to play when you are in a casino given the "
			    + "low winning advantage of the house." + "-UrbanDictionary.com");

		}

	});
	mnNewMenu.add(menuItemRules);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);

	panel.setBackground(Color.LIGHT_GRAY);
	panel.setBounds(15, 16, 1120, 796);
	contentPane.add(panel);
	panel.setLayout(null);

	message.setText("Place a bet!");
	message.setVisible(true);


	addCards();
	addTotals();
	oneChip(panel);
	fiveChip(panel);
	twentyFiveChip(panel);
	oneHundredChip(panel);
	playersTotalChips(panel);
	playersTotalMoney(panel);

	//Win/Lose Message
	message.setFont(new Font("Sitka Text", Font.BOLD, 30));
	message.setForeground(Color.BLACK);
	message.setBounds(860, 120, 220, 60);
	message.setHorizontalAlignment(SwingConstants.RIGHT);
	panel.add(message);

	//Tie Message
	tieMessage.setFont(new Font("Sitka Text", Font.BOLD, 30));
	tieMessage.setForeground(Color.BLACK);
	tieMessage.setBounds(880, 90, 200, 60);
	tieMessage.setHorizontalAlignment(SwingConstants.RIGHT);
	panel.add(tieMessage);

	//Done button. Player must place this before a new game can be started
	donePlacingBet.setBounds(960, 180, 115, 29);
	donePlacingBet.setFocusable(false);
	donePlacingBet.setCursor(new Cursor(Cursor.HAND_CURSOR));
	donePlacingBet.setBackground(Color.BLACK);
	donePlacingBet.setForeground(Color.WHITE);
	donePlacingBet.setBorder(UIManager.getBorder("DesktopIcon.border"));
	donePlacingBet.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
		{
		    if (funds == 0)
		    {
			message.setText("You're Broke!");
		    } else
		    {
			btnStay.setEnabled(true);
			btnHit.setEnabled(true);
			donePlacingBet.setVisible(false);
			placeNewBet.setVisible(false);
			chip1Button.setEnabled(false);
			chip5Button.setEnabled(false);
			chip25Button.setEnabled(false);
			chip100Button.setEnabled(false);
			game.playerHand.hand.clear();
			game.dealerHand.hand.clear();
			game.newGame();
			resetCards();
		    }
		}
	});
	panel.add(donePlacingBet);

	//New Game button. Player must place this before a new game can be started
	newGameButton.setBounds(960, 180, 115, 29);
	newGameButton.setVisible(false);
	newGameButton.setFocusable(false);
	newGameButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	newGameButton.setBackground(Color.BLACK);
	newGameButton.setForeground(Color.WHITE);
	newGameButton.setBorder(UIManager.getBorder("DesktopIcon.border"));
	newGameButton.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
		{
		    startNewGame();
		    newGameButton.setVisible(false);
		}
	});
	panel.add(newGameButton);
	placeNewBet.setBounds(960, 180, 115, 29);
	placeNewBet.setFocusable(false);
	placeNewBet.setCursor(new Cursor(Cursor.HAND_CURSOR));
	placeNewBet.setBackground(Color.BLACK);
	placeNewBet.setForeground(Color.WHITE);
	placeNewBet.setBorder(UIManager.getBorder("DesktopIcon.border"));
	placeNewBet.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
		{
		    placeNewBetLogic();
		}
	});
	panel.add(placeNewBet);
	btnHit.setEnabled(false);
	btnHit.setToolTipText("Draw another card");
	btnHit.setBackground(Color.BLACK);
	btnHit.setBorder(UIManager.getBorder("DesktopIcon.border"));
	btnHit.setForeground(Color.WHITE);
	btnHit.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	btnHit.setAlignmentX(Component.CENTER_ALIGNMENT);
	btnHit.setBounds(420, 705, 115, 29);
	btnHit.setCursor(new Cursor(Cursor.HAND_CURSOR));
	btnHit.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
		{
		    game.hit();
		    switch (hitCount)
		    {
			case 0:
			    playerCard3.setIcon(game.playerHand.hand.get(2).getIcon());
			    playerCard3.setVisible(true);
			    break;
			case 1:
			    playerCard4.setIcon(game.playerHand.hand.get(3).getIcon());
			    playerCard4.setVisible(true);
			    break;
			case 2:
			    playerCard5.setIcon(game.playerHand.hand.get(4).getIcon());
			    playerCard5.setVisible(true);
			    break;
			case 3:
			    playerCard6.setIcon(game.playerHand.hand.get(5).getIcon());
			    playerCard6.setVisible(true);
			    break;
		    }
		    playerTotal.setText(String.valueOf(game.playerHand.value()));
		    ++hitCount;
		    if (game.playerBusts)
		    {
			endGame();
		    }
		}
	});
	panel.add(btnHit);
	btnStay.setEnabled(false);
	btnStay.setToolTipText("Don't draw another card");
	btnStay.setForeground(Color.WHITE);
	btnStay.setBorder(UIManager.getBorder("DesktopIcon.border"));
	btnStay.setBackground(Color.BLACK);
	btnStay.setAlignmentX(Component.CENTER_ALIGNMENT);
	btnStay.setAlignmentY(Component.BOTTOM_ALIGNMENT);
	btnStay.setBounds(621, 705, 115, 29);
	btnStay.setCursor(new Cursor(Cursor.HAND_CURSOR));
	btnStay.addActionListener(new ActionListener()
	{
	    @Override
	    public void actionPerformed(ActionEvent e)
		{
		    dealerCard1.setIcon(game.dealerHand.hand.get(0).getIcon());
		    game.stay();
		    switch (game.dealerHand.hand.size())
		    {
			case 3:
			    dealerCard3.setIcon(game.dealerHand.hand.get(2).getIcon());
			    dealerCard3.setVisible(true);
			    break;
			case 4:
			    dealerCard3.setIcon(game.dealerHand.hand.get(2).getIcon());
			    dealerCard3.setVisible(true);
			    dealerCard4.setIcon(game.dealerHand.hand.get(3).getIcon());
			    dealerCard4.setVisible(true);
			    break;
			case 5:
			    dealerCard3.setIcon(game.dealerHand.hand.get(2).getIcon());
			    dealerCard3.setVisible(true);
			    dealerCard4.setIcon(game.dealerHand.hand.get(3).getIcon());
			    dealerCard4.setVisible(true);
			    dealerCard5.setIcon(game.dealerHand.hand.get(4).getIcon());
			    dealerCard5.setVisible(true);
			    break;
			case 6:
			    dealerCard3.setIcon(game.dealerHand.hand.get(2).getIcon());
			    dealerCard3.setVisible(true);
			    dealerCard4.setIcon(game.dealerHand.hand.get(3).getIcon());
			    dealerCard4.setVisible(true);
			    dealerCard5.setIcon(game.dealerHand.hand.get(4).getIcon());
			    dealerCard5.setVisible(true);
			    dealerCard6.setIcon(game.dealerHand.hand.get(5).getIcon());
			    dealerCard6.setVisible(true);
			    break;
		    }
		    dealerTotal.setText(String.valueOf(game.dealerHand.value()));
		    endGame();
		}
	});
	panel.add(btnStay);

	JLabel panel_1 = new JLabel();
	panel_1.setIcon(new ImageIcon(GUI.class.getResource("/project/Images/table_trans.png")));
	panel_1.setLayout(null);
	panel_1.setBackground(new Color(0, 51, 0));
	panel_1.setBounds(0, 0, 1120, 796);
	panel.add(panel_1);

	JPopupMenu popupMenu = new JPopupMenu();
	addPopup(panel_1, popupMenu);

	JMenuItem mntmDealNewCard = new JMenuItem("Deal new card");
	mntmDealNewCard.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
		{
		    game.playerHand.hand.clear();
		    game.dealerHand.hand.clear();
		    game.newGame();
		    resetCards();
		}
	});
	popupMenu.add(mntmDealNewCard);

	JMenuItem mntmSave = new JMenuItem("Save");
	popupMenu.add(mntmSave);

	JMenuItem mntmExit = new JMenuItem("Exit");
	mntmExit.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
		{
		    System.exit(0);
		}
	});
	popupMenu.add(mntmExit);

	JLabel label = new JLabel("");
	label.setBounds(449, 17, 151, 217);
	panel_1.add(label);

	JLabel label_2 = new JLabel("");
	label_2.setBounds(449, 461, 151, 217);
	panel_1.add(label_2);

	JLabel label_4 = new JLabel("");
	label_4.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
	label_4.setBackground(Color.BLUE);
	label_4.setBounds(492, 17, 150, 217);
	panel_1.add(label_4);

	JLabel label_5 = new JLabel("");
	label_5.setBounds(477, 461, 151, 217);
	panel_1.add(label_5);

	JLabel label_6 = new JLabel("");
	label_6.setBorder(new LineBorder(new Color(0, 0, 0), 7, true));
	label_6.setBounds(502, 461, 151, 217);
	panel_1.add(label_6);
	helpMenuPrintout.setInheritsPopupMenu(true);

	helpMenuPrintout.setForeground(Color.LIGHT_GRAY);
	helpMenuPrintout.setVisible(false);
	helpMenuPrintout.setFont(new Font("Tahoma", Font.BOLD, 17));
	helpMenuPrintout.setEditable(false);
	helpMenuPrintout.setBounds(332, 120, 479, 246);
	panel.add(helpMenuPrintout);
    }

    private void clearCardsAndTotals()
	{
	    //**CARDS**
	    //Player Card 1
	    playerCard1.setVisible(false);
	    //Card 2
	    playerCard2.setVisible(false);
	    //Card 3
	    playerCard3.setVisible(false);
	    //Card 4
	    playerCard4.setVisible(false);
	    //Card 5
	    playerCard5.setVisible(false);
	    //Card 6
	    playerCard6.setVisible(false);

	    //Dealer Card 1
	    dealerCard1.setVisible(false);
	    //Card 2
	    dealerCard2.setVisible(false);
	    //Card 3
	    dealerCard3.setVisible(false);
	    //Card 4
	    dealerCard4.setVisible(false);
	    //Card 5
	    dealerCard5.setVisible(false);
	    //Card 6
	    dealerCard6.setVisible(false);

	    dealerTotal.setText("0");
	    playerTotal.setText("0");
	}

    private void addCards()
	{
	    //**CARDS**
	    //Player Card 1
	    playerCard1.setBounds(449, 461, 151, 217);
	    playerCard1.setVisible(false);
	    //Card 2
	    playerCard2.setBounds(477, 461, 151, 217);
	    playerCard2.setVisible(false);
	    //Card 3
	    playerCard3.setBounds(502, 461, 151, 217);
	    playerCard3.setVisible(false);
	    //Card 4
	    playerCard4.setBounds(530, 461, 151, 217);
	    playerCard4.setVisible(false);
	    //Card 5
	    playerCard5.setBounds(558, 461, 151, 217);
	    playerCard5.setVisible(false);
	    //Card 6
	    playerCard6.setBounds(586, 461, 151, 217);
	    playerCard6.setVisible(false);

	    //Dealer Card 1
	    dealerCard1.setVisible(false);
	    dealerCard1.setBounds(449, 17, 151, 217);
	    //Card 2
	    dealerCard2.setVisible(false);
	    dealerCard2.setBounds(477, 17, 151, 217);
	    //Card 3
	    dealerCard3.setVisible(false);
	    dealerCard3.setBounds(502, 17, 151, 217);
	    //Card 4
	    dealerCard4.setVisible(false);
	    dealerCard4.setBounds(530, 17, 151, 217);
	    //Card 5
	    dealerCard5.setVisible(false);
	    dealerCard5.setBounds(558, 17, 151, 217);
	    //Card 6
	    dealerCard6.setVisible(false);
	    dealerCard6.setBounds(586, 17, 151, 217);

	    //Adding the Cards to the Panel. This order will determine which cards on are top/bottom
	    panel.add(playerCard6);
	    panel.add(playerCard5);
	    panel.add(playerCard4);
	    panel.add(playerCard3);
	    panel.add(playerCard2);
	    panel.add(playerCard1);

	    panel.add(dealerCard6);
	    panel.add(dealerCard5);
	    panel.add(dealerCard4);
	    panel.add(dealerCard3);
	    panel.add(dealerCard2);
	    panel.add(dealerCard1);
	}

    private void addTotals()
	{
	    dealerTotal.setOpaque(true);
	    dealerTotal.setBackground(Color.BLACK);
	    dealerTotal.setForeground(Color.WHITE);
	    dealerTotal.setBorder(UIManager.getBorder("DesktopIcon.border"));
	    dealerTotal.setBounds(512, 250, 130, 33);
	    dealerTotal.setText("0");
	    dealerTotal.setHorizontalAlignment(SwingConstants.CENTER);
	    panel.add(dealerTotal);
	    playerTotal.setBorder(UIManager.getBorder("DesktopIcon.border"));
	    playerTotal.setBackground(Color.BLACK);
	    playerTotal.setForeground(Color.WHITE);
	    playerTotal.setOpaque(true);
	    playerTotal.setBounds(512, 419, 130, 33);
	    playerTotal.setText("0");
	    playerTotal.setHorizontalAlignment(SwingConstants.CENTER);
	    panel.add(playerTotal);
	}
    private void oneChip(JPanel panel)
	{
	    chip1Button.setFocusable(false);
	    chip1Button.setToolTipText("Increase bet by $1");
	    chip1Button.setContentAreaFilled(false);
	    chip1Button.setBorderPainted(false);
	    chip1Button.setAlignmentX(Component.CENTER_ALIGNMENT);
	    chip1Button.setBorder(null);
	    chip1Button.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		    {
			donePlacingBet.setVisible(true);
			playerBet += 1;
			chipTotal.setText("Bet $" + playerBet);
		    }
	    });
	    chip1Button.setIcon(new ImageIcon(GUI.class.getResource("/project/Images/1_chip_sm.png")));
	    chip1Button.setBounds(15, 63, 151, 142);
	    chip1Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    chip1Button.setDisabledIcon(chip1Disabled);
	    panel.add(chip1Button);
	}
    
    private void fiveChip(JPanel panel)
	{
	    chip5Button.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent e)
		    {
			donePlacingBet.setVisible(true);
			playerBet += 5;
			chipTotal.setText("Bet $" + playerBet);
		    }
	    });
	    chip5Button.setFocusable(false);
	    chip5Button.setToolTipText("Increase bet by $5");
	    chip5Button.setBorderPainted(false);
	    chip5Button.setIcon(new ImageIcon(GUI.class.getResource("/project/Images/5_chip_sm.png")));
	    chip5Button.setContentAreaFilled(false);
	    chip5Button.setBounds(15, 195, 151, 142);
	    chip5Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    chip5Button.setDisabledIcon(chip5Disabled);
	    panel.add(chip5Button);
	}

    private void twentyFiveChip(JPanel panel)
	{
	    chip25Button.setFocusable(false);
	    chip25Button.setToolTipText("Increase bet by $25");
	    chip25Button.setBorderPainted(false);
	    chip25Button.setContentAreaFilled(false);
	    chip25Button.setInheritsPopupMenu(true);
	    chip25Button.setIconTextGap(0);
	    chip25Button.setIcon(new ImageIcon(GUI.class.getResource("/project/Images/25_chip_sm.png")));
	    chip25Button.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent arg0)
		    {
			donePlacingBet.setVisible(true);
			playerBet += 25;
			chipTotal.setText("Bet $" + playerBet);
		    }
	    });
	    chip25Button.setBounds(15, 329, 151, 142);
	    chip25Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    chip25Button.setDisabledIcon(chip25Disabled);
	    panel.add(chip25Button);
	}
    
    private void oneHundredChip(JPanel panel)
	{
	    chip100Button.setFocusable(false);
	    chip100Button.setToolTipText("Increase bet by $100");
	    chip100Button.addActionListener(new ActionListener()
	    {
		public void actionPerformed(ActionEvent arg0)
		    {
			donePlacingBet.setVisible(true);
			playerBet += 100;
			chipTotal.setText("Bet $" + playerBet);

		    }
	    });
	    chip100Button.setIcon(new ImageIcon(GUI.class.getResource("/project/Images/100_chip_sm.png")));
	    chip100Button.setContentAreaFilled(false);
	    chip100Button.setBorderPainted(false);
	    chip100Button.setBounds(15, 461, 151, 142);
	    chip100Button.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    chip100Button.setDisabledIcon(chip100Disabled);
	    panel.add(chip100Button);
	}

    private void playersTotalMoney(JPanel panel)
	{
	    playersCurrentMoney.setText("$ " + funds);
	    playersCurrentMoney.setToolTipText("Total winnings/losses");
	    playersCurrentMoney.setForeground(Color.YELLOW);
	    playersCurrentMoney.setFont(new Font("Sitka Text", Font.BOLD, 20));
	    playersCurrentMoney.setBorder(UIManager.getBorder("DesktopIcon.border"));
	    playersCurrentMoney.setOpaque(true);
	    playersCurrentMoney.setBackground(Color.BLACK);
	    playersCurrentMoney.setBounds(911, 32, 156, 33);
	    panel.add(playersCurrentMoney);
	}

    private void playersTotalChips(JPanel panel)
	{
	    chipTotal.setText("Bet " + playerBet);
	    chipTotal.setToolTipText("Players current bet");
	    chipTotal.setOpaque(true);
	    chipTotal.setForeground(Color.YELLOW);
	    chipTotal.setFont(new Font("Sitka Text", Font.BOLD, 20));
	    chipTotal.setBorder(UIManager.getBorder("DesktopIcon.border"));
	    chipTotal.setBackground(Color.BLACK);
	    chipTotal.setBounds(15, 32, 156, 33);
	    panel.add(chipTotal);
	}

    public void resetCards()
	{

	    playerCard1.setIcon(game.playerHand.hand.get(0).getIcon());
	    playerCard1.setVisible(true);
	    playerCard2.setIcon(game.playerHand.hand.get(1).getIcon());
	    playerCard2.setVisible(true);
	    playerCard3.setVisible(false);
	    playerCard4.setVisible(false);
	    playerCard5.setVisible(false);
	    playerCard6.setVisible(false);
	    dealerCard1.setIcon(backOfCard);
	    dealerCard1.setVisible(true);
	    dealerCard2.setIcon(game.dealerHand.hand.get(1).getIcon());
	    dealerCard2.setVisible(true);
	    dealerCard3.setVisible(false);
	    dealerCard4.setVisible(false);
	    dealerCard5.setVisible(false);
	    dealerCard6.setVisible(false);
	    playerTotal.setText(String.valueOf(game.playerHand.value()));
	    dealerTotal.setText(String.valueOf(game.dealerHand.hand.get(1).getValue()));
	    hitCount = 0;

	    btnHit.setEnabled(true);
	    btnStay.setEnabled(true);
	    message.setVisible(false);
	    tieMessage.setVisible(false);

	    if (game.tieGame || game.dealerWins || game.playerWins)
	    {
		dealerCard2.setIcon(game.dealerHand.hand.get(1).getIcon());

		endGame();
	    }
	}

    public void endGame()
	{
	    if (game.tieGame)
	    {
		tieMessage.setText("Tie Game!");
		tieMessage.setVisible(true);
		message.setText("Dealer Wins!");
		message.setVisible(true);
		dealerTotal.setText(String.valueOf(game.dealerHand.value()));
		funds -= playerBet;
		playersCurrentMoney.setText("$ " + funds);
		playerBet = 0;
		chipTotal.setText("Bet " + playerBet);
		disableButtons();
		return;
	    }

	    if (game.playerBusts)
	    {
		message.setText("You Bust!");
		message.setVisible(true);
		funds -= playerBet;
		playersCurrentMoney.setText("$ " + funds);
		playerBet = 0;
		chipTotal.setText("Bet " + playerBet);
		PlayerScoreRecord.setWinnings(funds);
		disableButtons();
		return;
	    }
	    if (game.playerWins && !game.playerBusts)
	    {
		message.setText("You Win!");
		message.setVisible(true);
		funds += playerBet;
		dealerTotal.setText(String.valueOf(game.dealerHand.value()));
		playersCurrentMoney.setText("$ " + funds);
		playerBet = 0;
		chipTotal.setText("Bet " + playerBet);
		PlayerScoreRecord.setWinnings(funds);
		disableButtons();
		return;
	    }
	    if (game.dealerBusts)
	    {
		message.setText("Dealer Busts!");
		message.setVisible(true);
		dealerTotal.setText(String.valueOf(game.dealerHand.value()));
		funds += playerBet;
		playersCurrentMoney.setText("$ " + funds);
		playerBet = 0;
		chipTotal.setText("Bet " + playerBet);
		PlayerScoreRecord.setWinnings(funds);
		disableButtons();
		return;
	    }
	    if (game.dealerWins && !game.dealerBusts)
	    {
		message.setText("Dealer Wins!");
		message.setVisible(true);
		dealerTotal.setText(String.valueOf(game.dealerHand.value()));
		funds -= playerBet;
		playersCurrentMoney.setText("$ " + funds);
		playerBet = 0;
		chipTotal.setText("Bet " + playerBet);
		PlayerScoreRecord.setWinnings(funds);
		disableButtons();
		return;
	    }
	}
    private void placeNewBetLogic()
	{
	    if (funds == 0)
	    {
		message.setText("You're Broke!");
		placeNewBet.setVisible(false);
		newGameButton.setVisible(true);
		return;
	    }

	    if (funds >= 1)
	    {
		placeNewBet.setVisible(false);
		message.setText("Place a bet!");
		message.setVisible(true);
		chip1Button.setEnabled(true);
		clearCardsAndTotals();
	    }
	    if (funds >= 5)
	    {
		placeNewBet.setVisible(false);
		message.setText("Place a bet!");
		message.setVisible(true);
		chip1Button.setEnabled(true);
		chip5Button.setEnabled(true);
		clearCardsAndTotals();
	    }
	    if (funds >= 25)
	    {
		placeNewBet.setVisible(false);
		message.setText("Place a bet!");
		message.setVisible(true);
		chip1Button.setEnabled(true);
		chip5Button.setEnabled(true);
		chip25Button.setEnabled(true);
		clearCardsAndTotals();
	    }
	    if (funds >= 100)
	    {
		placeNewBet.setVisible(false);
		message.setText("Place a bet!");
		message.setVisible(true);
		chip1Button.setEnabled(true);
		chip5Button.setEnabled(true);
		chip25Button.setEnabled(true);
		chip100Button.setEnabled(true);
		clearCardsAndTotals();
	    }
	}

    private void startNewGame()
	{
	    btnStay.setEnabled(true);
	    btnHit.setEnabled(true);
	    donePlacingBet.setVisible(false);
	    placeNewBet.setVisible(false);
	    chip1Button.setEnabled(false);
	    chip5Button.setEnabled(false);
	    chip25Button.setEnabled(false);
	    chip100Button.setEnabled(false);
	    game.playerHand.hand.clear();
	    game.dealerHand.hand.clear();
	    game.newGame();
	    resetCards();
	    placeNewBet.setVisible(false);
	    message.setText("Place a bet!");
	    message.setVisible(true);
	    chip1Button.setEnabled(true);
	    chip5Button.setEnabled(true);
	    chip25Button.setEnabled(true);
	    chip100Button.setEnabled(true);
	    clearCardsAndTotals();
	    funds = 250;
	    playersCurrentMoney.setText(String.valueOf(funds));
	}

    public void disableButtons()
	{
	    btnHit.setEnabled(false);
	    btnStay.setEnabled(false);
	    placeNewBet.setVisible(true);
	}

    public int updateBet(int bet)
	{
	    bet += playerBet;
	    return playerBet;
	}

    private static void addPopup(Component component, final JPopupMenu popup)
	{
	    component.addMouseListener(new MouseAdapter()
	    {
		public void mousePressed(MouseEvent e)
		    {
			if (e.isPopupTrigger())
			{
			    showMenu(e);
			}
		    }

		public void mouseReleased(MouseEvent e)
		    {
			if (e.isPopupTrigger())
			{
			    showMenu(e);
			}
		    }

		private void showMenu(MouseEvent e)
		    {
			popup.show(e.getComponent(), e.getX(), e.getY());
		    }
	    });
	}

}
