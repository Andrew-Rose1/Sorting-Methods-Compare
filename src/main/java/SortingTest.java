import java.util.*;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class SortingTest{
	public static void main(String[] args) {
		// When running this file a series of tests on each sorting algorithm with different array sizes is performed
		// These results are then all transfered to a csv file
		try (PrintWriter writer = new PrintWriter(new File("../../../time.csv"))){
			StringBuilder sb = new StringBuilder();
			// Create the headings for each column
			sb.append("Array Length");
			sb.append(",");
			sb.append("InsertionSort");
			sb.append(",");
			sb.append("QuickSort");
			sb.append(",");
			sb.append("MergeSort");
			sb.append(",");
			sb.append("HeapSort");
			sb.append("\r\n");
			writer.write(sb.toString());
			// Iterate through the various array sizes and time their sorting time in milliseconds.
			// Perfrom each sorting algorithm test 3 times and take the average as the result to decrease randomness
			System.out.println("Starting...");
			for (int j = 100; j <= 100000; j+=1000) {
				// create randomArray with size of j
				int [] testArr = randomArray(j);
				// call sortingTime 3 seperate times for each sorting algorigthm, with this new random array
				double time_insertionSort_1 = sortingTime("insertionSort", testArr);
				double time_quickSort_1 = sortingTime("quickSort", testArr);
				double time_mergeSort_1 = sortingTime("mergeSort", testArr);
				double time_heapSort_1 = sortingTime("heapSort", testArr);

				double time_insertionSort_2 = sortingTime("insertionSort", testArr);
				double time_quickSort_2 = sortingTime("quickSort", testArr);
				double time_mergeSort_2 = sortingTime("mergeSort", testArr);
				double time_heapSort_2 = sortingTime("heapSort", testArr);

				double time_insertionSort_3 = sortingTime("insertionSort", testArr);
				double time_quickSort_3 = sortingTime("quickSort", testArr);
				double time_mergeSort_3 = sortingTime("mergeSort", testArr);
				double time_heapSort_3 = sortingTime("heapSort", testArr);

				// calculate averages of each sorting algorithm
				double time_insertionSort = (time_insertionSort_1 + time_insertionSort_2 + time_insertionSort_3)/3;
				double time_quickSort = (time_quickSort_1 + time_quickSort_2 + time_quickSort_3)/3;
				double time_mergeSort = (time_mergeSort_1 + time_mergeSort_2 + time_mergeSort_3)/3;
				double time_heapSort = (time_heapSort_1 +time_heapSort_2 + time_heapSort_3)/3;

				// Test Print to terminal
				//System.out.print("Array size: " + j + ".   Insertion: " + time_insertionSort + ".   QuickSort: " + time_quickSort + ".   MergeSort: " + time_mergeSort + ".   HeapSort: " + time_heapSort + ".");
				//System.out.println(" ");

				// Append the array size that was tested, and each of the sorting algorithm's times in milliseconds respectively, to the csv file
				StringBuilder sb2 = new StringBuilder();
				sb2.append(j);
				sb2.append(",");
				sb2.append(time_insertionSort);
				sb2.append(",");
				sb2.append(time_quickSort);
				sb2.append(",");
				sb2.append(time_mergeSort);
				sb2.append(",");
				sb2.append(time_heapSort);
				sb2.append("\r\n");
				writer.write(sb2.toString());
			}
			} catch (FileNotFoundException e) {
				System.out.println("File not found... Sorry!");
			}
			System.out.println("Done!");
		}



	// this method generate a random int array with the length as size
	// each random int should be in [0, 10000]
	// parameters: size
	// return data: int[]
	public static int[] randomArray(int size) {
		// Initialize new empty array, with a size declared in the method's paramaters
		int[] randomArr = new int[size];
		// Generate the new empty array with random integers
		for (int i = 0; i < size; i++) {
			randomArr[i] = (int)(Math.random()*1000);
		}
		return randomArr;
	}



	// this method counts the time it takes to sort arr using sortingAlgorithm
	// parameters: sortingAlgorithm and int array
	// return data: double
	public static double sortingTime(String sortingAlgorithm, int[] arr) {
		// Create new object from SortingPack class in SortingPack.java
		SortingPack obj = new SortingPack();
		double startTime = System.currentTimeMillis();
		// Check the method's passed parameter and call the correct sorting algorithm from SortingPack class
		if (sortingAlgorithm == "insertionSort") {
			int[] sortedArr = obj.insertionSort(arr);
		} else if (sortingAlgorithm == "quickSort") {
			int[] sortedArr = obj.quickSort(arr);
		} else if (sortingAlgorithm == "mergeSort") {
			int[] sortedArr = obj.mergeSort(arr);
		} else if (sortingAlgorithm == "heapSort") {
			int[] sortedArr = obj.heapSort(arr);
		} else {
			System.out.println("Not a valid sorting algorithm.");
		}
		double endTime = System.currentTimeMillis();
		// Calculate the the total time, in milliseconds, the sorting algorithm took to finish
		double totalTime = endTime - startTime;
		return totalTime;
	}
}
