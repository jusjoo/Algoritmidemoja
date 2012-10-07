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

	
	private ArrayList<Point> points;
	private SpriteBatch batch;
	
	private FPSLogger fpsLogger;
	
	private Texture pointTexture;
	private Texture pointSelectedTexture;
	
	@Override
	public void create() {
		// TODO Auto-generated method stub
		fpsLogger = new FPSLogger();
		batch = new SpriteBatch();
		
		points = new ArrayList<Point>();
		points.add(new Point(100,100));
		
		
		createTextures();
		
	}

	private void createTextures() {
		int size = 8;
		Pixmap pixmap = new Pixmap(size,size,Pixmap.Format.RGB565);
		pointTexture = new Texture(pixmap);
		pixmap.setColor(new Color(0f,0f,1f,1f));
		pixmap.fill();
		pointTexture.draw(pixmap, 0, 0);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
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
		if (Gdx.input.justTouched()) {
			
			points.add(new Point(Gdx.input.getX(), Gdx.graphics.getHeight()-Gdx.input.getY()));
			
			
		}
	}

	private void renderPoints() {
		
		for (Point p : points) {
			p.draw(batch, pointTexture);			
			
		}
		
		
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

}
