package com.mario;

import java.awt.Rectangle;

public abstract class Enemy {

	boolean topHit = false;
	boolean dead = false;
	Rectangle coll = null;
	
	public Enemy(int x, int y){
		
	}
	
	public void setDead(){
		dead = false;
	}
	
	public abstract void move();
	
	public boolean hitTop(){
		//if()
		return false;
	}
}
