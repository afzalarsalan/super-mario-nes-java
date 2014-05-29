package com.mario;

import java.awt.Rectangle;
import java.util.ArrayList;

public class Mario {
	Rectangle collisionbox = new Rectangle();
	ImageHelper[] framesRight = new ImageHelper[3];
	ImageHelper[] framesLeft = new ImageHelper[3];
	ImageHelper marioSwitch = new ImageHelper();
	ImageHelper marioStand = new ImageHelper();
	ImageHelper marioJump = new ImageHelper();
	
	int hearts = 3;
	int ammo = 30;
	
	int x,y;
	int dir = 0; //0 is left 1 is right
	int frame;
	boolean dead;
	boolean hitFloor = false;
	int velocity = 2;
	int speed;
	int maxVel = 10;
	boolean walking;
	int frameDelay = 1;
	ArrayList<Powerup> powerups = new ArrayList();
	
	public Mario(int x1, int y1){
		x = x1; y = y1;
		collisionbox.setRect(x,y, 20, 30);
	}
	
	public void update(){
		if(hearts < 0)
			StaticStuff.gameOver = true;
		collisionbox.setRect(x,y, 20, 30);
	}
	
	public void loadImages(){
		ImageHelper m1 = new ImageHelper();
		ImageHelper m2 = new ImageHelper();
		ImageHelper m3 = new ImageHelper();
		
		
		marioSwitch.setDim(16, 13, 2);
		marioSwitch.parse("null, null, null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, null, null, null, (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:200:0), (0:0:0), (255:200:0), null, null, null, (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), null, (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), null, (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), null, null, null, (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:200:0), (255:200:0), null, null, null, (255:0:0), (255:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, (255:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, (255:0:0), (255:0:0), (255:0:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, (255:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, (0:0:0), null, (0:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null");
		m1.setDim(16, 15, 2);
		m1.parse("null, null, null, null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, null, null, null, null, null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), null, null, null, null, null, null, null, (0:0:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), null, null, null, null, null, (0:0:0), (255:200:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), null, null, null, null, (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), null, null, null, null, null, (255:200:0), (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), null, (0:0:0), (0:0:0), (255:0:0), (255:200:0), (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, (0:0:0), null, null, null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), null, null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), null, null, (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), null, null, (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, null, null");
		m2.setDim(16, 11, 2);
		m2.parse("null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, (0:0:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), null, null, null, (0:0:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), null, (0:0:0), (255:200:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), null, null, (0:0:0), (0:0:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), null, null, null, (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:200:0), (255:0:0), (255:0:0), (255:200:0), null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, (255:0:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, (255:0:0), (0:0:0), (255:200:0), (255:200:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, null, null, (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null");
		m3.setDim(15,13,2);
		m3.parse("null, null, null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, null, null, null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), null, null, null, null, null, (0:0:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), null, null, null, (0:0:0), (255:200:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), null, null, (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (0:0:0), null, (255:200:0), null, null, null, null, (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), null, null, (255:200:0), (255:200:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), null, null, null, (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, null, (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), null, (255:0:0), (255:0:0), (255:0:0), null, null, null, null, (0:0:0), null, null, null, null, (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null");
		m1.flip();
		m2.flip();
		m3.flip();
		framesRight[0]=m1;
		framesRight[1]=m2;
		framesRight[2]=m3;
		framesLeft[0]=m1;
		framesLeft[1]=m2;
		framesLeft[2]=m3;
		marioJump.setDim(16,16,2);
		marioJump.parse("null, null, null, null, null, null, null, null, null, null, null, null, null, (255:200:0), (255:200:0), (255:200:0), null, null, null, null, null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, (255:200:0), (255:200:0), (255:200:0), null, null, null, null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:200:0), (255:200:0), null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), null, (0:0:0), (0:0:0), (0:0:0), null, null, null, null, (0:0:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, (0:0:0), (255:200:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), null, null, null, null, (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (0:0:0), null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), null, null, (0:0:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, (0:0:0), (255:200:0), (255:200:0), (255:200:0), null, (255:0:0), (255:0:0), (0:0:0), (255:0:0), (255:0:0), (255:200:0), (255:0:0), (255:0:0), (255:200:0), (255:0:0), (0:0:0), (0:0:0), null, (255:200:0), null, (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), null, null, (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), null, (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, null, null, null, (0:0:0), null, null, (255:0:0), (255:0:0), (255:0:0), (255:0:0), null, null, null, null, null, null, null, null");
		marioJump.flip();
	}
}
