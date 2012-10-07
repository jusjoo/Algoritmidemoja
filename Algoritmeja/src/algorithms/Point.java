package algorithms;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Point {

	private int size = 8;

	private int x;
	private int y;
	
	/**
	 * Creates a new point to location (x, y)
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	/**
	 * Draws the given Texture to the location of this Point.
	 */
	public void draw(SpriteBatch batch, Texture texture) {
		
		batch.draw(texture, x-size/2, y-size/2);
	}
}
