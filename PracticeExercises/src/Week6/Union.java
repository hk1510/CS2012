package Week6;

import java.util.ArrayList;

public class Union {
	
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i = 0; i < 10; i++) {
			list1.add(i+1);
		}
		for(int i = 10; i < 20; i++) {
			list2.add(i+1);
		}
		ArrayList<Integer> union = union(list1, list2);
		System.out.println(union.toString());
		
		ArrayList<Character> characterArray = toCharacterArray("bruh");
		System.out.println(characterArray.toString());
	}
	
	public static ArrayList<Integer> union(
			ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> union = new ArrayList<>();
		for(int i = 0; i < list1.size(); i++) {
			union.add(list1.get(i));
		}
		for(int i = 0; i < list2.size(); i++) {
			union.add(list2.get(i));
		}
		return union;
	}
	
	public static ArrayList<Character> toCharacterArray(String s) {
		ArrayList<Character> characterArray = new ArrayList<>();
		for(int i = 0; i < s.length(); i++) {
			characterArray.add(s.charAt(i));
		}
		return characterArray;
	}
	
}
