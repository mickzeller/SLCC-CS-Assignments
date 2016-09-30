package buildingLab;

import javax.swing.JFrame;


public class BuildingApp extends JFrame
{

    public static void main(String[] args)
	{
	    new BuildingApp().run();
	}

    public void run()
	{
	    setBounds(100, 10, 400, 500);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    add(new Building());
	    setVisible(true);
	}

}
