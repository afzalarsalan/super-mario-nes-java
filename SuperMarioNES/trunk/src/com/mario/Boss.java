package com.mario;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Boss {
	
	Rectangle collisionbox = new Rectangle();
	ImageHelper im = new ImageHelper();
	int x,y;
	int health = 100;
	boolean dead = false;
	
	public Boss(int x1, int y1){
		x=x1;y=y1;
		im.setDim(31,31,2);
		im.parse("null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (240:198:81), null, null, null, (33:189:2), (33:189:2), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (240:198:81), (240:198:81), null, null, (33:189:2), (33:189:2), (33:189:2), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (240:198:81), (240:198:81), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, (33:189:2), null, null, (240:198:81), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, (33:189:2), (33:189:2), (240:198:81), null, (240:198:81), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (240:198:81), (33:189:2), (33:189:2), (33:189:2), null, null, null, (240:198:81), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (240:198:81), (240:198:81), (240:198:81), (33:189:2), (33:189:2), (33:189:2), null, (240:198:81), (240:198:81), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (240:198:81), (33:189:2), null, (240:198:81), (240:198:81), (33:189:2), (33:189:2), (240:198:81), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, (33:189:2), (240:198:81), null, null, (33:189:2), (33:189:2), null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (240:198:81), (33:189:2), (33:189:2), (33:189:2), (240:198:81), (240:198:81), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, (33:189:2), (240:198:81), (240:198:81), null, null, null, (33:189:2), null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (240:198:81), null, (33:189:2), (33:189:2), null, (33:189:2), null, null, null, null, null, null, null, null, null, (240:198:81), null, null, (33:189:2), (33:189:2), (240:198:81), (240:198:81), null, (33:189:2), (33:189:2), null, null, null, (33:189:2), (33:189:2), (33:189:2), (240:198:81), (240:198:81), (33:189:2), null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (240:198:81), (240:198:81), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, null, (33:189:2), (33:189:2), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, null, (33:189:2), (33:189:2), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, null, (33:189:2), (33:189:2), (240:198:81), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (240:198:81), null, null, (33:189:2), (33:189:2), null, null, null, null, null, null, (33:189:2), (33:189:2), null, null, (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, (240:198:81), null, null, (33:189:2), (33:189:2), (33:189:2), (240:198:81), (240:198:81), (33:189:2), (33:189:2), null, null, (240:198:81), (240:198:81), (240:198:81), (33:189:2), (33:189:2), null, null, null, null, null, null, null, null, null, null, null, null, null, null, (240:198:81), (240:198:81), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, (240:198:81), (240:198:81), (240:198:81), null, null, null, null, (240:198:81), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, (33:189:2), (240:198:81), (240:198:81), null, null, (240:198:81), (240:198:81), (240:198:81), null, null, (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, (240:198:81), (33:189:2), (33:189:2), (33:189:2), null, null, null, (33:189:2), (33:189:2), null, null, (33:189:2), (33:189:2), null, null, (240:198:81), (240:198:81), (240:198:81), (240:198:81), null, null, (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (240:198:81), null, null, (33:189:2), (33:189:2), null, null, (33:189:2), (33:189:2), null, (240:198:81), (240:198:81), (240:198:81), (240:198:81), (240:198:81), (240:198:81), null, null, (240:198:81), null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (240:198:81), (240:198:81), (33:189:2), (33:189:2), null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (240:198:81), (240:198:81), (240:198:81), (240:198:81), (240:198:81), null, null, (240:198:81), null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (240:198:81), (240:198:81), (240:198:81), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, null, (240:198:81), (240:198:81), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, (240:198:81), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (240:198:81), (33:189:2), null, null, (33:189:2), (33:189:2), (33:189:2), null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (240:198:81), (33:189:2), (33:189:2), null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (33:189:2), (33:189:2), (33:189:2), null, null, null, (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (33:189:2), (240:198:81), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (240:198:81), (240:198:81), (240:198:81), (240:198:81), (33:189:2), (33:189:2), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (240:198:81), (240:198:81), (240:198:81), (240:198:81), (240:198:81), (240:198:81), (240:198:81), (240:198:81), (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (240:198:81), (240:198:81), (240:198:81), (240:198:81), null, null, (240:198:81), (240:198:81), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (240:198:81), (240:198:81), (240:198:81), (240:198:81), (240:198:81), null, null, null, (240:198:81), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null");
	}
	
	int rate = 4;
	
	public boolean collides(Bullet b){
		return collisionbox.intersects(b.collisionbox);
	}
	
	public boolean collides(Mario m){
		return collisionbox.intersects(m.collisionbox);
	}
	
	public void update(){
		if(!dead){
		for(Bullet b : GameFrame.bullets)
			if(collides(b)){
				b.dead = true;
				health--;
			}
		if(collides(StaticStuff.mario)){
			StaticStuff.gameOver = true;
			//StaticStuff.mario.dead = true;
		}
		if(health <= 0)
			dead = true;
		y+=rate;
		if(y > 600 || y < 400)
			rate = -rate;
		collisionbox.setRect(x,y,50,50);
		}else{
			y= 700;
			collisionbox.setRect(0,0,0,0);
		}
	}
	
	public void draw(Graphics g){
		if(!dead)
		im.paint(g, im.ca, x, y);
	}

}
