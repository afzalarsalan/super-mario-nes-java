package com.mario;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {

	Rectangle collisionbox = new Rectangle();
	int dir = 0;
	int x; int y;
	boolean dead = false;
	SoundEffect sf = new SoundEffect("Fireball.wav");
	
	public Bullet(int dir){
		this.dir = dir;
		if(dir == 0)
			x = StaticStuff.mario.x-5;
		else
			x = StaticStuff.mario.x+25;
		y = StaticStuff.mario.y+15;
		sf.play();
		collisionbox.setRect(x,y,10,10);
		//Sound.play("Fireball.wav");
	}
	
	public void update(){
		if(!dead){
		if(dir == 0)
			x-=4;
		else
			x+=4;
		collisionbox.setRect(x,y,10,10);
		}else
			collisionbox.setRect(0,0,0,0);
	}
	
	public void draw(Graphics g){
		if(!dead)
			StaticStuff.bulletim.paint(g, StaticStuff.bulletim.ca, x, y);
	}
}
