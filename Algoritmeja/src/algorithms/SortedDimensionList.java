package algorithms;

import java.util.TreeMap;

public class SortedDimensionList {

	private TreeMap<Integer, Point> coordinatePairings;
	
	public SortedDimensionList(){
		coordinatePairings = new TreeMap<Integer, Point>();
	}
	
	public void put(Integer i, Point p) {
		coordinatePairings.put(i, p);
	}
	
	public void delete(Integer i) {
		coordinatePairings.remove(i);
	}
}
