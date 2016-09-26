package task05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Subsequence {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n;
		int[] arr;

		n = s.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		
		printArray(arr);
		
		int k = findMinK(arr);
		
		System.out.println("K = " + k);
	}
	
	public static int findMinK(int arr[]) {
		return arr.length - findLengthOfMaxSubsequence(arr); 
	}
	
	public static int findLengthOfMaxSubsequence(int[] arr) {
		int[] max = new int[arr.length];
		
		for (int i = 0; i < arr.length; i++) {
			max[i] = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] < arr[i]) {
					if (max[j] + 1 > max[i]) {
						max[i] = max[j] + 1;
					}
				}
			}
		}
		
		int n = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max[i] > n) {
				n = max[i];
			}
		}
		
		return n;
	}

//	public static int findLengthOfMaxSubsequence(int[] arr) {
//		List<ArrayList<Integer>> subseqs = new ArrayList<ArrayList<Integer>>();
//		
//		for (int i = 0; i < arr.length; i++) {
//			boolean flag = false;
//			
//			int n = subseqs.size();
//			for (int k = 0; k < n; k++) {
//				ArrayList<Integer> seq = subseqs.get(k);
//				if (seq.get(seq.size() - 1) < arr[i]) {
//					flag = true;
//					seq.add(arr[i]);
//				} else {
//					for (int j = seq.size() - 2; j >= 0; j--) {
//						if (seq.get(j) < arr[i]) {
//							flag = true;
//							ArrayList<Integer> newseq = new ArrayList<Integer>();
//							newseq.addAll(seq.subList(0, j + 1));
//							newseq.add(arr[i]);
//							subseqs.add(newseq);
//						}
//					}
//				}
//			}
//			
//			if (flag == false) {
//				ArrayList<Integer> seq = new ArrayList<Integer>();
//				seq.add(arr[i]);
//				subseqs.add(seq);
//			}
//		}
//		
//		int max = 0;
//		for (ArrayList<Integer> seq : subseqs) {
//			if (seq.size() > max) {
//				max = seq.size();
//			}
//		}
//		
//		return max;
//	}
	
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
