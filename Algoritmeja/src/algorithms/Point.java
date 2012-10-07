package algorithms;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Point {

	private int size = 8;
	
	
	
	private int x;
	private int y;
	
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

	public void draw(SpriteBatch batch, Texture texture) {
		
		texture.bind();
		batch.draw(texture, x-size/2, y-size/2);
	}
}
