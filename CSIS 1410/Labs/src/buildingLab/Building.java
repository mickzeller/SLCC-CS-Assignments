package buildingLab;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Building extends JPanel
{

    @Override
    protected void paintComponent(Graphics g)
	{
	    super.paintComponent(g);

	    buildingColor(g);

	    //this will make the blocks light up like christmas lights
	    //repaint();

	    for (int x = 1; x <= 5 * x * x; x++)
	    {
		//repaint();
		for (int y = 1; y <= 50; y++)
		{
		    g.fillRect(80 * y, 80 * x, 20, 20);

		    g.setColor(new Color((int) (Math.random() * 0x1000000)));
		}

	    }

	}

    private void buildingColor(Graphics g)
	{
	    g.fillRect(70, 10, this.getWidth() - 100, this.getHeight());
	    g.setColor(new Color((int) (Math.random() * 0x1000000)));
	}

}
