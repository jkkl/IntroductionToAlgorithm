package chapter7;

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
		
		int part_index = 
	}

	private int partition(int A[], int low_index, int high_index) {
		if (low_index >= high_index) {
			return -1;
		}
		
		int key = A[high_index];
		int low = low_index -1;
		int high = low_index;
		
		for (; high < high_index; high++) {
			if (A[high] < key) {
				low++;
				Util.swap(A, low, indexC)
			}
		}
		
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
