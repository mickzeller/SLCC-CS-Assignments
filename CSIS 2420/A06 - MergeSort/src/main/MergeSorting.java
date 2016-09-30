/********************************************************
 * Name : Mick Zeller 
 * Date : February 17, 2015
 *
 *
 * Merge Sort(M.S.) is a algorithm used to organize data in computer Science. It
 * uses a type of sorting method referred to as Divide-and-Conquer. If your
 * wondering if this stable consistent algorithm is worthy of being classified
 * as such a brutally awesome Medieval title as Divide-and-Conquer the answer is
 * ABSOLUTALLY. Lets break down how M.S. uses the Divide-and-Conquer sort to
 * solve a problem. Now being that we're trying to sort an entire ARRAY[N].
 * (Think of N as the lazy mans way of writing size) We could say that a smaller
 * piece of the problem is to sort a SubARRAY == ( 1/2 * ARRAY ). Now think of
 * the SubARRAY having a starting point and an ending point. These point are
 * know as index stating at 'p' and index ending at 'r'. So [p, N elements , r]
 * Now how does M.S. know where to split the SubArray in half? All it needs to
 * do is get the N (size) of the SubArray and divide it by 2. Now finding that
 * middle ground is referred to as q.
 *
 * Think of it like this.... LENGTH DIVISION OF N
 * -----------------------------------------------------------------------------
 * ------------------------- ^ ARRAY[] (N) | | | / \ | / \ | DIVIDE-AND-CONQURE
 * | / \ O (N lgN) / \ | / \ | SubARRAY[p to r] SubARRAY[p to r] (N/2) | | | | |
 * | | / \ / \ | DIVIDE-AND-CONQURE DIVIDE-AND-CONQURE | / \ / \ | / \ / \ ^
 * SubARRAY[p,q-1] SubARRAY[q,r] SubARRAY[p,q-1] SubARRAY[q,r] (N/4) ^
 *
 * This keeps happening until the M.S. go so Medieval on the unsorted array that
 * there is nothing left to divide, all that's left is one element. To be more
 * specific because the M.S. ARRAY has N elements it will stop (unless told
 * otherwise) at N SubARRAY. <<In fact, this code is designed to show if it is
 * better stopping this Divide-and-Conquer sooner and use a non-Recursive
 * sort.>>
 *
 * Now it starts to rebuild all of the SubARRAY's it's divided. The M.S. has a
 * certain condition ( MUST have at least 1 ) and piece-by-piece it goes through
 * each SubARRAY arranges it. This is known as Recursion and because our M.S.
 * used Divide-and-Conquer making tons of SubARRAYs Recursion is going to happen
 * multiple times. Recursion also performs the merging of the sorted SubARRAYs
 * once it has sorted them.
 *
 * Sort and Merge. Sort and Merge. Sort and Merge. Sort and Merge.
 *
 * Recursion steadily cleans up the mess Divide-and-Conquer left until all of
 * the SubARRAYs are merged back to it's original state. Only now it's way more
 * awesome, not only is it a full ARRAY but it's ordered and organized in such a
 * way that all the little baby SubARRAYs wish they we're as cool.
 *
 * Now, I'm going to to start throwing some numbers at you but DON'T glaze over
 * this part cause it's why Merge Sort(M.S.) can be so useful. Take note of some
 * key terms.
 *
 * Big-O notation is a relative representation of the complexity of an algorithm
 *
 * Big-O: Often referred to as the upper bounds of the graph Big-Theta: O : is
 * referred to as tight bound, will represent the most accurate part of our
 * graph Big-Omega: referred to as the lower bounds of the graph or WORSE CASE
 *
 * Merge Sort isn't the fastest sorting algorithm, but it does come with
 * something the faster sorts can't always promise. CONSISTANSY. When you need
 * an ARRAY sorted in the time it claims it can in it's Best-Case Scenario M.S.
 * is the one to choose. Take a look at it's speeds I think you'll agree this is
 * one reliable Sort.
 *
 * Scenario Speed
 *
 * 1) Worst-Case__________________ O (n lgn)
 *
 * 2) Best-Case___________________ O (n lgn)
 *
 * 3) Average-Case________________ O (n lgn)
 *
 * *each merge takes O(n) time
 *
 *
 *
 *
 * It also needs a lot of memory in order to run.(M.S. needs to make copies the
 * ARRAY in order to sort)
 *
 * M.S. does however have a bit of overhead in order to run it's
 * Divide-and-Conquer so it could make sense to bring in a light weight sorting
 * algorithm to help lighten the load esp when the SubARRAYs reach a certain
 * size. If the InsertionTest is run you can see that the best number for
 * insertion sort to be run falls between a SubARRAY of 5 and 10 integers.
 * Because of this I've decided to use 7 int in the SubARRAY.
 *
 * .....to be continued!
 *
 *
 * 
 ********************************************************/
package main;

import java.util.LinkedList;
import java.util.Random;

public class MergeSorting
{

    public static void main(String[] args)
	{

	    LinkedList<Integer> list = randomNumList();
	    System.out.print("\t\t   Random 10x10 Grid\n");
	    final long s = System.nanoTime();
	    listGrid(list);
	    final long e = System.nanoTime();

	    System.out.printf("\t\t   Time: %.3f seconds%n ", (e - s) / 1000000.0);
	    System.out.println("\t-------------------------------------\n");

	    Integer[] arrayayList = new Integer[list.size()];
	    list.toArray(arrayayList);

	    /*
	     * Perform a recursive merge sort on the array without having
	     * insertion sort included. Will create a timer to see how long in
	     * nano seconds it took to run the program then this will be
	     * converted to seconds
	     */

	    final long start = System.nanoTime();
	    MergeSorting.recursiveMergeSortInsertion(arrayayList);
	    final long end = System.nanoTime();
	    System.out.println("\t\tMick's Merge Sorted List\n");
	    System.out.println("\t\t\t10x10 Grid\n");
	    System.out.printf("\t\t   Time: %.3f seconds%n ", (end - start) / 1000000.0);
	    System.out.println("\t------------------------------------------\n");

	    /* Display the sorted linked list in a 10 x 10 table. */
	    MergeSorting.arrayayGrid(arrayayList);
	    Integer[] arrayInsertion = new Integer[list.size()];

	    System.out.println("--------------------------------------------------------------\n");
	    list.toArray(arrayInsertion);

	    final long startTime = System.nanoTime();
	    MergeSorting.insertionMergeSort(arrayInsertion, 7);
	    final long endTime = System.nanoTime();
	    System.out.println("\t\tMerge Sort with Theshold of 7");
	    System.out.printf("\t\t   Time: %.3f seconds%n ", (endTime - startTime) / 1000000.0);
	    arrayayGrid(arrayInsertion);

	}

    private static void listGrid(LinkedList<Integer> list)
	{
	    int grid10x10 = 10;
	    int increasingIndex = 0;

	    for (int i = 0; i < grid10x10; i++)
	    {
		for (int j = 0; j < grid10x10; j++)
		{
		    System.out.printf("%-5d ", list.get(increasingIndex++));
		}
		System.out.println();
	    }
	    System.out.println();
	}

    private static LinkedList<Integer> randomNumList()
	{
	    LinkedList<Integer> list = new LinkedList<Integer>();
	    //setting the range for random numbers
	    int min = 0;
	    int max = 1000;
	    Random random = new Random();

	    int randomNumber;
	    for (int i = 0; i < 100; i++)
	    {
		randomNumber = random.nextInt(max - min) + 1;
		list.add(randomNumber);
	    }
	    return list;
	}

    public static void merge(Integer[] array, Integer[] arrayCopy, int first, int mid, int last)
	{
	    int insertIndex = first, firstPartitionIndex = 0, secondPartitionIndex = mid;
	    System.arraycopy(array, first, arrayCopy, 0, mid - first);

	    while ((firstPartitionIndex < (mid - first)) && (secondPartitionIndex <= last))
	    {
		if (arrayCopy[firstPartitionIndex] < array[secondPartitionIndex])
		{
		    array[insertIndex] = arrayCopy[firstPartitionIndex];
		    firstPartitionIndex++;
		} else
		{
		    array[insertIndex] = array[secondPartitionIndex];
		    secondPartitionIndex++;
		}
		insertIndex++;
	    }
	    while (firstPartitionIndex < (mid - first))
	    {
		array[insertIndex] = arrayCopy[firstPartitionIndex];
		firstPartitionIndex++;
		insertIndex++;
	    }
	}

    public static void arrayayGrid(Integer[] array)
	{
	    {
		int size = (int) (Math.sqrt(array.length));
		for (int i = 0; i < array.length; i += size)
		{
		    for (int j = 0; (j < size) && ((i + j) < array.length); j++)
		    {
			System.out.printf("%-5d ", array[i + j]);
		    }
		    System.out.println();
		}
		System.out.println();
	    }
	}

    public static void recursiveMergeSortInsertion(Integer[] array)
	{
	    if (array == null)
	    {
		throw new NullPointerException();
	    }

	    Integer arrayCopy[] = new Integer[array.length / 2];
	    MergeSorting.recursiveMergeSortInsertion(array, arrayCopy, 0, array.length - 1);
	}

    public static void recursiveMergeSortInsertion(Integer[] array, Integer[] arrayCopy, int first, int last)
	{
	    if (((last - first) + 1) <= 1)
	    {
		return;
	    }
	    int mid = ((first + last + 1) / 2);
	    MergeSorting.recursiveMergeSortInsertion(array, arrayCopy, first, mid - 1);
	    MergeSorting.recursiveMergeSortInsertion(array, arrayCopy, mid, last);
	    MergeSorting.merge(array, arrayCopy, first, mid, last);
	}

    private static void insertionSort(Integer[] array, int first, int last)
	{

	    int key;
	    int currentPosition;
	    int finalPosition;

	    if (array == null)
	    {
		throw new NullPointerException("Array is empty");
	    }
	    if (last > array.length)
	    {
		throw new IndexOutOfBoundsException("Array is out of Bounds");
	    }

	    for (currentPosition = first + 1; currentPosition < (last + 1); currentPosition++)
	    {

		key = array[currentPosition];
		for (finalPosition = currentPosition - 1; (finalPosition >= first)
			&& (array[finalPosition] > key); finalPosition--)
		{
		    array[finalPosition + 1] = array[finalPosition];
		}
		array[finalPosition + 1] = key;
	    }
	}

    public static void insertionMergeSort(Integer[] arr, int threshold)
	{
	    if (arr == null)
	    {
		throw new NullPointerException();
	    }
	    Integer temp[] = new Integer[arr.length / 2];
	    MergeSorting.insertionMergeSort(arr, temp, 0, arr.length - 1, threshold);
	}

    public static void insertionMergeSort(Integer[] arr, Integer[] temp, int first, int last, int threshold)
	{
	    int mid = ((first + last + 1) / 2);

	    if ((last - first) <= threshold)
	    {
		MergeSorting.insertionSort(arr, first, last);
		return;
	    }
	    if (((last - first) + 1) <= 1)
	    {
		return;
	    }
	    MergeSorting.insertionMergeSort(arr, temp, first, mid - 1, threshold);
	    MergeSorting.insertionMergeSort(arr, temp, mid, last, threshold);
	    MergeSorting.merge(arr, temp, first, mid, last);
	}
}
