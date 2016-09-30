package main;

import java.util.Random;

public class InsertionTest
{

    public static void main(String[] args)
	{

	    Random random = new Random();
	    int[] ar1 = new int[1];
	    int[] ar2 = new int[5];
	    int[] ar3 = new int[10];
	    int[] ar4 = new int[15];
	    int[] ar5 = new int[20];
	    int[] ar6 = new int[25];
	    int[] ar7 = new int[30];
	    for (int i = 0; i < ar1.length; i++)
	    {
		ar1[i] = random.nextInt(1000);
		ar2[i] = random.nextInt(1000);
		ar3[i] = random.nextInt(1000);
		ar4[i] = random.nextInt(1000);
		ar5[i] = random.nextInt(1000);
		ar6[i] = random.nextInt(1000);
		ar7[i] = random.nextInt(1000);

	    }

	    long startTime = System.nanoTime();

	    InsertionSort(ar1);
	    long endTime = System.nanoTime();
	    System.out.printf("Insertion time 1 integer: %.9f seconds%n ", (endTime - startTime) / 1000000.0);
	    long startTime1 = System.nanoTime();

	    InsertionSort(ar2);
	    long endTime1 = System.nanoTime();
	    System.out.printf("Insertion time 5 integer: %.9f seconds%n ", (endTime1 - startTime1) / 1000000.0);
	    long startTime2 = System.nanoTime();

	    InsertionSort(ar3);
	    long endTime2 = System.nanoTime();
	    System.out.printf("Insertion time 10 integer: %.9f seconds%n ", (endTime2 - startTime2) / 1000000.0);
	    long startTime3 = System.nanoTime();

	    InsertionSort(ar4);
	    long endTime3 = System.nanoTime();
	    System.out.printf("Insertion time 15 integer: %.9f seconds%n ", (endTime3 - startTime3) / 1000000.0);
	    long startTime4 = System.nanoTime();

	    InsertionSort(ar5);
	    long endTime4 = System.nanoTime();
	    System.out.printf("Insertion time 20 integer: %.9f seconds%n ", (endTime4 - startTime4) / 1000000.0);
	    long startTime5 = System.nanoTime();

	    InsertionSort(ar6);
	    long endTime5 = System.nanoTime();
	    System.out.printf("Insertion time 25 integer: %.9f seconds%n ", (endTime5 - startTime5) / 1000000.0);
	    long startTime6 = System.nanoTime();
	    InsertionSort(ar7);
	    long endTime6 = System.nanoTime();
	    System.out.printf("Insertion time 25 integer: %.9f seconds%n ", (endTime6 - startTime6) / 1000000.0);

	}

    public static void InsertionSort(int[] num)
	{
	    int j; // the number of items sorted so far
	    int key; // the item to be inserted
	    int i;

	    for (j = 1; j < num.length; j++) // Start with 1 (not 0)
	    {
		key = num[j];
		for (i = j - 1; (i >= 0) && (num[i] < key); i--) // Smaller values are moving up
		{
		    num[i + 1] = num[i];
		}
		num[i + 1] = key; // Put the key in its proper location
	    }
	}

}
