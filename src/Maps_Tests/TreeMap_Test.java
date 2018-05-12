package Maps_Tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

public class TreeMap_Test {
	private TreeMap<Float, ArrayList<Integer>> map = null;
	
	public TreeMap_Test() {
		map = new TreeMap<Float, ArrayList<Integer>>();
	}
	
	public TreeMap<Float, ArrayList<Integer>> getTreeMap() {
		return map;
	}
	
	public void AddKeyVal(float val, int var) {
		if (!map.containsKey(val)) {
			ArrayList<Integer> array = new ArrayList<Integer>();
			array.add(var);
			map.put(val, array);
		}
		else {
			ArrayList<Integer> array = map.get(val);
			array.add(var);
		}
		System.out.println("L'ajout a bien été fait");
	}
	
	public void CrossMap() {
		for (Float key : map.keySet()) {
			ArrayList<Integer> VArray = map.get(key);
			for (Integer val : VArray) {
				System.out.println("La clé est " + key + " dont sa valeur est " + val);
			}
		}
	}
}
