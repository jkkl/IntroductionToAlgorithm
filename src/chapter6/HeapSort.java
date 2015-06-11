package chapter6;

import util.MyException;
import util.Util;

public class HeapSort {
	
	public static int heapSize = 0;
	
	public static int[] heap;
	
	public HeapSort(int[] A) {
		// TODO Auto-generated constructor stub
		heap = A;
		heapSize = A.length-1;
		//Integer.MAX_VALUE 
	}
	
	public HeapSort(int[] A, int _heapSize) {
		// TODO Auto-generated constructor stub
		heap = A;
		heapSize = _heapSize;
	}
	/**
	 * swap the val of indexB and indexC
	 * @param A
	 * @param indexB
	 * @param indexC
	 */
	public void swap(int[] A, int indexB, int indexC) {
		int tmp = A[indexB];
		A[indexB] = A[indexC];
		A[indexC] = tmp;
	}
	
	void print(int A[]){
		for (int i = 1; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
	
	/**
	 * Create heap from array
	 * @param A : the array to create heap
	 */
	void createHeap(int A[]){
		for (int i = heapSize; i > 0; i--) {
			maxHeapify(A, i);
		}
	}
	
	/**
	 * 
	 * @param A	: the array to store the heap
	 * @param index	: to maintian the property of heap from index to all his children
	 */
	void maxHeapify(int A[], int index){
		if ( 2 * index > heapSize) {
			return;
		}
		int lChild = 2 * index;
		int rChild = lChild + 1;
		int largest = index;
		
		if (lChild <= heapSize) {
			if (A[index] < A[lChild]) {
				largest = lChild; 
			}
		}
		
		if (rChild <= heapSize) {
			if (A[largest] < A[rChild]) {
				largest = rChild;
			}
		}
		
		if (index != largest) {
			swap(A, index, largest);
			maxHeapify(A, largest);
		}
		return;
	}
	
	/**
	 * sort array by heap
	 * @param A
	 */
	public void heapSort(int A[]) {
		// TODO Auto-generated method stub
		createHeap(A);
		
		for (int i = A.length-1; i > 0; i--) {
			swap(A, 1, i);
			heapSize -= 1;
			maxHeapify(A, 1);
		}
	}
	
	/**
	 * insert element to priority queue
	 * @param A : the priority queue
	 * @param val : the val of the element
	 * @return if insert success
	 */
	boolean insert(int A[], int val){
		if (heapSize == A.length -1 ) {
			return false;
		}
		heapSize++;
		A[heapSize] = Integer.MIN_VALUE;
		heapIncreaseKey(A, heapSize, val);
		return false;
	}
	

	/**
	 * increase the value of A[index] and maintain the property of priority queue
	 * @param A	: the array to store the heap
	 * @param index : the index of the element will be increased
	 * @param val : the new value 
	 */
	void heapIncreaseKey(int A[], int index, int val){
		//the new value should bigger then original
		if (A[index] > val) {
			return;
		}
		A[index] = val;
		//index /= 2;
		int parent = index / 2; 
		while ( parent > 0) {
			if (A[parent] < A[index]) {
				Util.swap(A, parent, index);
				index = parent;
				parent = index/2;
			}else {
				break;
			}
		}
	}
	
	int extractMax(int A[]){
		try {
			if (heapSize <= 0) {
				throw new MyException("heap is empty!"); 
			}
		} catch (MyException e) {
			// TODO Auto-generated catch block
			System.out.print(e);
		}
		int max = A[1];
		Util.swap(A, heapSize, 1);
		heapSize--;
		maxHeapify(A, 1);
		return max;
	}
	
	static void testHeapSort(int A[]){
		HeapSort hSort = new HeapSort(A);
		hSort.heapSort(A);
		System.out.println("\n");
		hSort.print(A);
	}
	
	static void testPriorityQueue(int A[]){
		HeapSort hpq = new HeapSort(A,3);
		hpq.createHeap(A);
		Util.print(A);
		hpq.insert(A, 300);
		System.out.println("\n");
		System.out.println(heapSize);
		Util.print(A);
		hpq.insert(A, 500);
		System.out.println(heapSize);
		System.out.println("\n");
		Util.print(A);
		hpq.insert(A, 900);
		System.out.println(heapSize);
		System.out.println("\n");
		Util.print(A);
		System.out.println("max: "+ hpq.extractMax(A));
		System.out.println(heapSize);
		Util.print(A);
		
	}
	
	public static void main(String args[]) {
		int A[] = {0,4,9,1,100, 60, 40, 90 };
		testHeapSort(A);
		testPriorityQueue(A);
		
	}
	
	
	
}










