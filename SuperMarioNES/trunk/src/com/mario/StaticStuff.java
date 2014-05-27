package com.mario;

import java.util.ArrayList;

public class StaticStuff {

	public static int CANVAS_WIDTH = 800;
	public static int CANVAS_HEIGHT = 600;
	public static Mario mario = new Mario(50,478);
	public static boolean startSpin = false;
	ArrayList<Powerup> powerups = new ArrayList(){{
		new Star(500, 500);
	}};
}
