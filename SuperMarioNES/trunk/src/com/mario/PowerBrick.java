package com.mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PowerBrick extends Brick{
	
	public PowerBrick(int x, int y){
		super(x,y);
	}
	
	public void StarBrick(Graphics g){
	    Graphics2D rect=(Graphics2D)g;
	        rect.scale(1, 1);
	    g.setColor(Color.BLACK);
	    g.fillRect(x,y,8,8);
	    g.setColor(new Color(245,152,37));
	    g.fillRect(x,y+8,8,90);
	  g.setColor(Color.BLACK);
	    g.fillRect(x,y+98,100,8);
	   g.setColor(Color.BLACK);
	    g.fillRect(x+92,y,8,98);
	    g.setColor(new Color(245,152,37));
	    g.fillRect(x+8,y,84,8);
	    g.setColor(new Color(250,188,129));
	    g.fillRect(x+8,y+8,84,90);
	    //buttons
	    g.setColor(Color.BLACK);
	    g.fillRect(x+12, y+12, 6, 6);
	     g.fillRect(x+80, y+12, 6, 6);
	      g.fillRect(x+12, y+80, 6, 6);
	       g.fillRect(x+80, y+80, 6, 6);
	       //Question Mark shadow
	         g.setColor(Color.BLACK);
	       g.fillRect(x+49,y+75,10,10);
	       g.fillRect(x+49,y+54,10,16);
	       g.fillRect(x+54,y+50,20,5);
	       g.fillRect(x+64,y+30,10,20);
	       g.fillRect(x+44,y+25,25,5);
	        g.fillRect(x+38,y+30,10,20);
	       //Question Mark
	       g.setColor(new Color(245,85,6));
	       g.fillRect(x+45,y+70,10,10);
	       g.fillRect(x+45,y+50,10,10);
	       g.fillRect(x+50,y+45,20,5);
	       g.fillRect(x+60,y+25,10,20);
	       g.fillRect(x+40,y+20,25,5);
	        g.fillRect(x+34,y+25,10,20);
	     
	   
	    
	}
}
