package util;

public class Util {
	public static void swap(int A[], int indexB, int indexC) {
		int tmp = A[indexB];
		A[indexB] = A[indexC];
		A[indexC] = tmp;
	}
	
	public static void print(int A[]){
		System.out.print("\n");
		for (int i = 1; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
	
	public static void printArray(int A[]){
		System.out.print("\n");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
