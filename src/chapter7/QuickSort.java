package chapter7;

import java.util.Random;

import util.MyException;
import util.Util;

public class QuickSort {
	/**
	 * implement the quick sort
	 * @param A : the array to sort
	 * @param low_index : the low index of the sort section
	 * @param high_index : the high index of the sort section
	 */
	
	public void quickSort(int A[], int low_index, int high_index) {
		if (low_index >= high_index) {
			return;
		}
		
		int part_index = partition(A, low_index, high_index);
		quickSort(A, low_index, part_index - 1);
		quickSort(A, part_index + 1, high_index);
	}

	private int partition(int A[], int low_index, int high_index) {
		try {
			if (low_index >= high_index) {
				throw new MyException("low_index >= high_index");
			}
		} catch (MyException e) {
			System.out.print(e);
		}
		
		
		int part_index = new Random().nextInt(high_index - low_index) + low_index;
		
		Util.swap(A, part_index, high_index);
			
		int key = A[high_index];
		int low = low_index -1;
		int high = low_index;
		
		for (; high < high_index; high++) {
			if (A[high] < key) {
				low++;
				Util.swap(A, low, high);
			}
		}
		
		Util.swap(A, ++low, high_index);
		return low;
	}
	
	public static void testQuickSort(int A[]) {
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(A, 0, A.length-1);
		Util.printArray(A);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//int A[] = {0,4,9,1,100, 60, 40, 90 };
		int A[] = {4,0};
		testQuickSort(A);

	}

}
