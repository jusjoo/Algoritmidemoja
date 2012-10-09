package algorithms;

import java.util.ArrayList;

public class ClosestPairAlgorithm {

	private ArrayList<Point> points;
	private SortedDimensionList sortedX;
	private SortedDimensionList sortedY;
	
	public ClosestPairAlgorithm() {
		points = new ArrayList<Point>();
		sortedX = new SortedDimensionList();
		sortedY = new SortedDimensionList();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Point> getPoints() {
		return (ArrayList<Point>) points.clone();
	}
	
	/**
	 * Adds a new point in the algorithm 
	 * and updates the sorted x and y lists.	 
	 */
	public void add(Point p){
		points.add(p);
		sortedX.put(p.getX(), p);
		sortedY.put(p.getY(), p);
	}
	
	/**
	 * Removes the point from the algorithm
	 * and updates the sorted x and y lists.
	 */
	public void remove(Point p){
		points.remove(p);
		sortedX.delete(p.getX());
		sortedY.delete(p.getY());
	}
	
}
