package classwork;

import java.util.ArrayList;

public class MinimumDouble {
	public static void main(String[] args) {
		ArrayList<Double> newList = new ArrayList<>();
		ArrayList<Double> newList1 = new ArrayList<>();
		ArrayList<Double> nullList;
		newList.add(2.0);
		newList.add(1.0);
		System.out.println(min(newList));
		System.out.println(min(newList1));
	}
	public static Double min(ArrayList<Double> list) {
		try {
			Double min = list.get(0);
			if (list.size() > 0) {
				for(int i = 0; i < list.size(); i++) {
					if (list.get(i) < min) {
						min = list.get(i);
					}
				}
				return min;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			return null;
		}
	}
}
