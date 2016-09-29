package printer;
/*
 * Author: Mick Zeller
 * CSIS 1410 Printer Lab
 * Feb 20, 2015
 * 
 * */

public class PrinterApp
{

    public static void main(String[] args)
	{

	    /* Creating instances and then printing the results */

	    InkJetPrinter myInkjetPrinter = new InkJetPrinter(1234567);
	    LaserPrinter myLaserPrinter = new LaserPrinter(8912345);

	    System.out.println(myInkjetPrinter.toString());
	    System.out.printf("Remaining Cartridge: %d%%%n%n", myInkjetPrinter.getRemainingCartridge());
	    System.out.println(myLaserPrinter.toString());
	    System.out.printf("Remaining Toner: %d%%%n%n", myLaserPrinter.getRemaingingToner());

	    System.out.println("Array of Printers: \n");

	    /* Printing array of printers */

	    Printer[] array =
	    { myInkjetPrinter, myLaserPrinter };

	    for (Printer print : array)
	    {
		System.out.println(print.toString());
		print.print();
		print.print();
		System.out.println();
	    }

	}

}
