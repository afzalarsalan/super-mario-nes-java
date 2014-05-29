package com.mario;

import java.util.ArrayList;

public class StaticStuff {

	public static int CANVAS_WIDTH = 800;
	public static int CANVAS_HEIGHT = 600;
	public static Mario mario = new Mario(40,478);
	public static boolean startSpin = false;
	public static ArrayList<Powerup> powerups = new ArrayList();
	public static boolean gameOver = false;
	
	public static ImageHelper brickim = new ImageHelper();
	public static ImageHelper[] mushim = new ImageHelper[2];
	public static ImageHelper powerupim = new ImageHelper();
	public static ImageHelper bulletim = new ImageHelper();
	
	public static SoundEffect sf = new SoundEffect("Fireball.wav");
	
	public static SoundEffect jump = new SoundEffect("Jump.wav");
}
