/*
Author: Ethan Bates
Date: 8/22/2023
Description: 
 */
import java.util.ArrayList;
import java.util.HashSet;
public class Exercise193 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(14);
		list.add(24);
		list.add(14);
		list.add(42);
		list.add(25);
		ArrayList<Integer> newList = removeDuplicates(list);
		System.out.print(newList);
	}
	public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list){
		ArrayList<E> newList = new ArrayList<>();
		HashSet<E> set = new HashSet<>();
		for (E element : list) {
			if (set.add(element)) {
				newList.add(element);
			}
		}
		return newList;
	}
}
