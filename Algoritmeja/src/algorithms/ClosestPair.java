package algorithms;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class ClosestPair implements ApplicationListener {

	
	private ClosestPairAlgorithm algorithm;
	private SpriteBatch batch;
		
	private Texture pointTexture;
	private Texture pointSelectedTexture;
	
	@Override
	public void create() {
		
		batch = new SpriteBatch();
		points = new ArrayList<Point>();
	
		
		createTextures();
		
	}

	private void createTextures() {
		int size = AppConfig.pointSize;
		
		// pointTexture creation
		Pixmap pixmap = new Pixmap(size,size,Pixmap.Format.RGB565);
		pointTexture = new Texture(pixmap);
		pixmap.setColor(AppConfig.pointColor);
		pixmap.fill();
		pointTexture.draw(pixmap, 0, 0);
		
		// pointSelectedTexture creation
		Pixmap pixmap2 = new Pixmap(size,size,Pixmap.Format.RGB565);
		pointSelectedTexture = new Texture(pixmap);
		pixmap2.setColor(AppConfig.pointSelectedColor);
		pixmap2.fill();
		pointSelectedTexture.draw(pixmap2, 0, 0);
	}

	@Override
	public void dispose() {		
	}

	@Override
	public void pause() {		
	}

	@Override
	public void render() {
		
		update();
		
        Gdx.gl.glClearColor( 0f,0.1f, 0.1f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT );	
        
        batch.begin();
        renderPoints();
        batch.end();
	}

	private void update() {
		handleInput();
	}

	private void handleInput() {
		
		if (Gdx.input.justTouched()) {
			handleClick(Gdx.input.getX(), Gdx.graphics.getHeight()-Gdx.input.getY());
			
		}
	}

	private void handleClick(int x, int y) {
		Point deleted = null;
		int checkRange = AppConfig.pointSize;
		
		// check if the click is within an existing points range
		for (Point p : points) {
	
			if (	p.getX() < x + checkRange && p.getX() > x - checkRange	&& 
					p.getY() < y + checkRange && p.getY() > y - checkRange) {
				deleted = p;
				break;
			}
		}
		
		// no near point found, add new
		if (deleted == null) {
			points.add(new Point(x, y));
		}
		// else remove the found point
		else {
			points.remove(deleted);
		}
	}

	private void renderPoints() {
		
		for (Point p : points) {
			p.draw(batch, pointTexture);						
		}	
	}

	@Override
	public void resize(int arg0, int arg1) {
		
	}

	@Override
	public void resume() {
		
	}

}
