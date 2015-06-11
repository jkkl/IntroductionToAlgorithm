package chapter6;

import util.Util;

public class PriorityQueue {
	public int heapSize;
	
	public PriorityQueue(int _heapSize){
		heapSize = _heapSize;
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
		index /= 2;
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
