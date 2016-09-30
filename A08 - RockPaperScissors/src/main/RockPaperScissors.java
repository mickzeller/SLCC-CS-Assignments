package main;
/*********************************
 * Name: Mick Zeller
 * Date: March 17, 2015
 ********************************/
import javax.swing.ImageIcon;

public enum RockPaperScissors
{

    ROCK(new ImageIcon(RockPaperScissors.class.getResource("/images/rock.jpg")),
	    new ImageIcon(RockPaperScissors.class.getResource("/images/rockReversed.jpg"))),

    PAPER(new ImageIcon(RockPaperScissors.class.getResource("/images/paper.jpg")),
	    new ImageIcon(RockPaperScissors.class.getResource("/images/paperReversed.jpg"))),

    SCISSORS(new ImageIcon(RockPaperScissors.class.getResource("/images/scissors.jpg")),
	    new ImageIcon(RockPaperScissors.class.getResource("/images/scissorsReversed.jpg")));

    private ImageIcon image;
    private ImageIcon imageReversed;

    private RockPaperScissors(ImageIcon image, ImageIcon reversed)
    {
	setImage(image);
	setImageReversed(reversed);
    }

    public void setImage(ImageIcon icon)
	{
	    this.image = icon;
	}

    public ImageIcon getImage()
	{
	    return image;
	}

    public ImageIcon getImageReversed()
	{
	    return imageReversed;
	}

    public void setImageReversed(ImageIcon imageReversed)
	{
	    this.imageReversed = imageReversed;
	}

    public static RockPaperScissors getRandom()
	{
	    return RockPaperScissors.class.getEnumConstants()[(new java.util.Random()).nextInt(3)];

	}

    public int evaluate(RockPaperScissors arg0)
	{
	    if (this.equals(arg0))
		return 0;
	    else
	    {
		if (this.equals(ROCK))
		{
		    if (arg0.equals(PAPER))
			return -1;
		    else if (arg0.equals(SCISSORS))
			return 1;
		}
		if (this.equals(SCISSORS))
		{
		    if (arg0.equals(ROCK))
			return -1;
		    if (arg0.equals(PAPER))
			return 1;
		}
		if (this.equals(PAPER))
		{
		    if (arg0.equals(SCISSORS))
			return -1;
		    if (arg0.equals(ROCK))
			return 1;
		}
	    }
	    return 0;
	}
}
