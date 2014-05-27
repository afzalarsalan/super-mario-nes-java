package com.mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PowerBrick extends Brick{
	
	public PowerBrick(int x, int y){
		super(x,y);
	}
	
	boolean checked = false;
	
	public void update(){
		
		y+=1;
		collisionBox.setRect(x,y, 25, 25);
		
		if(hit && !checked){
			collisionBox.setRect(0,0, 0, 0);
			StaticStuff.startSpin = true;
			checked = true;
		}
		if(collisionBox.intersects(StaticStuff.mario.collisionbox))
			hit = true;
	}
	Graphics2D rect;
	public void StarBrick(Graphics g){
		if(!hit){
	    //rect =(Graphics2D)g;
	    //rect.scale(.5, .5);
	    g.setColor(Color.BLACK);
	    g.fillRect(x,y,8/4,8/4);
	    g.setColor(new Color(245,152,37));
	    g.fillRect(x,y+8/4,8/4,90/4);
	  g.setColor(Color.BLACK);
	    g.fillRect(x,y+98/4,100/4,8/4);
	   g.setColor(Color.BLACK);
	    g.fillRect(x+92/4,y,8/4,98/4);
	    g.setColor(new Color(245,152,37));
	    g.fillRect(x+8/4,y,84/4,8/4);
	    g.setColor(new Color(250,188,129));
	    g.fillRect(x+8/4,y+8/4,84/4,90/4);
	    //buttons
	    g.setColor(Color.BLACK);
	    g.fillRect(x+12/4, y+12/4, 6/4, 6/4);
	     g.fillRect(x+80/4, y+12/4, 6/4, 6/4);
	      g.fillRect(x+12/4, y+80/4, 6/4, 6/4);
	       g.fillRect(x+80/4, y+80/4, 6/4, 6/4);
	       //Question Mark shadow
	         g.setColor(Color.BLACK);
	       g.fillRect(x+49/4,y+75/4,10/4,10/4);
	       g.fillRect(x+49/4,y+54/4,10/4,16/4);
	       g.fillRect(x+54/4,y+50/4,20/4,5/4);
	       g.fillRect(x+64/4,y+30/4,10/4,20/4);
	       g.fillRect(x+44/4,y+25/4,25/4,5/4);
	        g.fillRect(x+38/4,y+30/4,10/4,20/4);
	       //Question Mark
	       g.setColor(new Color(245,85,6));
	       g.fillRect(x+45/4,y+70/4,10/4,10/4);
	       g.fillRect(x+45/4,y+50/4,10/4,10/4);
	       g.fillRect(x+50/4,y+45/4,20/4,5/4);
	       g.fillRect(x+60/4,y+25/4,10/4,20/4);
	       g.fillRect(x+40/4,y+20/4,25/4,5/4);
	        g.fillRect(x+34/4,y+25/4,10/4,20/4);
	     //rect.scale(2, 2);
		   //g.fillRect(collisionBox.x / 2,collisionBox.y / 2, 100, 100);
		}
	}
}
