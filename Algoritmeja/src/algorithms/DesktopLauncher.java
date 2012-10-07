package algorithms;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopLauncher {

	public static void main(String[] args) {
		
		// create the listener that will receive the application events
		ApplicationListener listener = new ClosestPair();
		// define the window's title
		String title = "Closest Pair";
		
		// define the window's size
		int width = 800, height = 480;
		
		// whether to use OpenGL ES 2.0
		boolean useOpenGLES2 = false;
		
		// create the game
		new LwjglApplication( listener, title, width, height, useOpenGLES2);
		
	}
}
