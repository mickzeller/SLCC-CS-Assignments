package printer;
/*
 * Author: Mick Zeller
 * CSIS 1410 Printer Lab
 * Feb 20, 2015
 * 
 * */

public abstract class Printer {

	private int serialNumber;
	
	public Printer(int number) {
		number = this.serialNumber;
	}
	abstract void print();

	@Override
	public String toString() {
		return " " + serialNumber;
	}

}
