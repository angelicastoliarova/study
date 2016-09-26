package task04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App04 {

	public static void main(String[] args) {
		int[] a = null;
		List<Integer> listOfIndex = new LinkedList<>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of elements in the Array  ");
		int sizeList = scanner.nextInt();
		System.out.println("Enter the max element in the Array  ");
		int maxElementInList = scanner.nextInt();
		try {
			a = fillArray(sizeList, maxElementInList);
			Arrays.sort(a);
			System.out.println("Your array is:" + Arrays.toString(a));
			listOfIndex = (findIndexes(a));
			System.out.println("Prime numbers are  " + Arrays.toString(listOfIndex.toArray()));
		} catch (Exception e) {
			System.out.println("invalid data");
		}

	}

	public static int[] fillArray(int lenght, int maxElementInList) throws Exception {
		if ((lenght < 0) || (maxElementInList <= 0)) {
			throw new Exception("invalid data");
		}
		int[] array = new int[lenght];
		Random randomNum = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = randomNum.nextInt(maxElementInList);
		}
		return array;
	}

	public static List<Integer> findIndexes(int[] a) {
		List<Integer> list = new ArrayList<Integer>();
		for (int element : a) {
			if (element % 2 == 0) {
				list.add(element);
			}
		}

		return list;
	}

}
