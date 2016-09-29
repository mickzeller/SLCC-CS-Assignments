package printer;
/*
 * Author: Mick Zeller
 * CSIS 1410 Printer Lab
 * Feb 20, 2015
 * 
 * */
public class InkJetPrinter extends Printer 
{
	private int remainingCartridge;
	
	public InkJetPrinter(int sNumber) 
	{
		super(sNumber);
		 
		remainingCartridge = 100;
		this.remainingCartridge = getRemainingCartridge();
		System.out.print("InkJetPrinter #"  + sNumber + "\n");
		
	}

	public void print()
	{
		
		if(remainingCartridge > 0)
		{
			remainingCartridge -= 10;
			System.out.println("InkJetPrinter is printing " + getRemainingCartridge() + "%");
			
		}
	}


	public final int getRemainingCartridge() {
		return remainingCartridge;
	}
	@Override
	public String toString() {
		return  "Remaining Cartridge: " + remainingCartridge + "%";
	}
}
