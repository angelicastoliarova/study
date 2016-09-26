package task08;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App08 {

	public static void main(String[] args) {

		int[] a = null;
		int[] b = null;
		List<Integer> listA = new LinkedList<>();
		List<Integer> listOfIndex = new LinkedList<>();
		List<Integer> listofIndexWithShift = new LinkedList<>();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter the number of elements in the Array'a': ");
		int sizeListA = scanner.nextInt();
		System.out.println("Enter the max element in the Array  ");
		int maxElementInList = scanner.nextInt();
		try {
			a = fillArray(sizeListA, maxElementInList);
			Arrays.sort(a);
		} catch (IllegalArgumentException e) {
			System.out.println("negative values");
		}

		System.out.print("Enter the number of elements in the Array'b': ");
		int sizeListB = scanner.nextInt();
		System.out.println("Enter the max element in the Array  ");
		int maxElementInList2 = scanner.nextInt();
		try {
			b = fillArray(sizeListB, maxElementInList2);
			Arrays.sort(b);
		} catch (IllegalArgumentException e) {
			
			System.out.println("negative values");
		}
		try {
		listOfIndex = findIndexes(a, b);
		listofIndexWithShift = findIndexesShift(a, b);
		}
		 catch (NullPointerException e) {
			 System.out.println("values are zero");
		 }
	
		System.out.println("Array 'à' is: " + Arrays.toString(a));
		System.out.println("Array 'b' is: " + Arrays.toString(b));
		for (int element : a) {
			listA.add(element);
		}

		int i = 0;
		for (Integer integer : listofIndexWithShift) {
			listA.add(integer, b[i++]);
		}
		System.out.println("Result array is: " + Arrays.toString(listA.toArray()));

	}

	public static int[] fillArray(int lenght, int maxElementInList) {
		if ((lenght <= 0) || (maxElementInList <= 0)) {
			throw new IllegalArgumentException("negative values");
		}
		int[] array = new int[lenght];
		Random randomNum = new Random();

		for (int i = 0; i < array.length; i++) {
			array[i] = randomNum.nextInt(maxElementInList);
		}
		return array;

	}

	public static List<Integer> findIndexes(int[] a, int[] b) {
		if ((a.length == 0) || (b.length == 0)) {
			throw new NullPointerException("values are zero");
		}
		List<Integer> list = new LinkedList<>();
		for (int i = 0, j = 0; i < a.length && j < b.length;) {
			if ((i == a.length - 1) && (b[j] > a[i])) {
				list.add(i + 1);
				j++;

			} else if (b[j] <= a[i]) {
				list.add(i);
				j++;
			} else {
				i++;
			}
		}
		return list;
	}

	public static List<Integer> findIndexesShift(int[] a, int[] b) {
		List<Integer> listA = new ArrayList<Integer>();
		for (int element : a) {
			listA.add(element);
		}
		List<Integer> list = new ArrayList<>();

		for (int i = 0, j = 0; i < listA.size() && j < b.length;) {
			if ((i == listA.size() - 1) && (b[j] > listA.get(i))) {
				listA.add(i + 1, b[j]);
				list.add(i + 1);
				j++;

			} else if (b[j] <= listA.get(i)) {
				listA.add(i, b[j]);
				list.add(i);
				j++;
				i++;
			} else {
				i++;
			}
		}
		return list;
	}
}
