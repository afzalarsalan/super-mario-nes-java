package com.mario;

import java.awt.Graphics;
import java.awt.Rectangle;

public class MushroomPower extends Powerup{

	Rectangle collisionbox = new Rectangle();
		int x, y;
		boolean dead = false;
	    ImageHelper m1 = new ImageHelper();

	    MushroomPower() {
	    	loadImages();
	    }

	    public MushroomPower(int x2, int y2) {
	    	x=x2;y=y2;
	    	loadImages();
		}

		public void loadImages() {

	        m1.setDim(16, 16, 1);
	        m1.parse("null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:200:0), (255:200:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:200:0), (255:200:0), (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), null, null, null, (0:0:0), (0:0:0), (255:200:0), (255:0:0), (255:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:0:0), (255:0:0), (255:200:0), (0:0:0), (0:0:0), null, null, (0:0:0), (255:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:0:0), (0:0:0), null, (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:200:0), (255:200:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:200:0), (255:200:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:200:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:200:0), (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:0:0), (255:200:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:200:0), (255:0:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), (255:0:0), (255:0:0), (255:200:0), (255:200:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:200:0), (255:200:0), (255:0:0), (255:0:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:0:0), (255:0:0), (255:0:0), (255:0:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:200:0), (255:200:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:255:255), (255:255:255), (0:0:0), (255:255:255), (255:255:255), (0:0:0), (255:255:255), (255:255:255), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, (0:0:0), (0:0:0), (255:255:255), (255:255:255), (255:255:255), (0:0:0), (255:255:255), (255:255:255), (0:0:0), (255:255:255), (255:255:255), (255:255:255), (0:0:0), (0:0:0), null, null, null, (0:0:0), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (0:0:0), null, null, null, null, (0:0:0), (0:0:0), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (255:255:255), (0:0:0), (0:0:0), null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null");
	    }
		
		public boolean collides(){
			return collisionbox.intersects(StaticStuff.mario.collisionbox);
		}
		
		public void update(){
			if(!dead){
			collisionbox.setRect(x,y,20,20);
			if(collides()){
				dead=true;GameFrame.score+=400;}
			}else{
				collisionbox.setRect(0,0,0,0);
			}
				
		}

	    public void draw(Graphics g) {
	    	if(!dead)
	        m1.paint(g, m1.ca, x, y);
	    }
	    
		public String toString(){
			return "MushroomPower";
		}

	}
