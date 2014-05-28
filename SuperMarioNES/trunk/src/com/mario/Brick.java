/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Brick{
	Rectangle collisionBox = new Rectangle();
	//ImageHelper im = new ImageHelper();
    int width,height;
     int x,y;
     boolean hit = false;
     Rectangle collisionbox = new Rectangle();
     boolean lastcollision = false;
     boolean wasColliding = false;
     
     public Brick(){
    	// im.setDim(11, 11, 2);
    	// im.parse("(0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0)");
     }
     
     
    public Brick(int x,int y){
         this.x=x;
         this.y=y;
         collisionbox.setRect(x,y,20, 20);
    }
    
    public boolean top(){
    	return StaticStuff.mario.collisionbox.y+30 > collisionbox.y;
    }
    
    public boolean left(){
    	return StaticStuff.mario.collisionbox.x+14 >= collisionbox.x && !top();
    }
    
    public boolean right(){
    	return StaticStuff.mario.collisionbox.x >= collisionbox.x+20 && !top();
    }
    
    public boolean steppedOff(){
    	return StaticStuff.mario.collisionbox.x > collisionbox.x+25 || StaticStuff.mario.collisionbox.x+14 < collisionbox.x;
    }
    
    public void update(){
    	collisionbox.setRect(x,y,20, 20);
    	if(collides()){
    		if(top()){
    			StaticStuff.mario.y = y-30;
    			StaticStuff.mario.hitFloor = true;
    		}
    	}
  
    }
    
    //0 = top, 1 = right, 2 = bottom, 3 = left
    public boolean bottom(){
    	if(!StaticStuff.mario.hitFloor && StaticStuff.mario.y > y && StaticStuff.mario.collisionbox.x - x > 0 && x+20 - StaticStuff.mario.collisionbox.x > 0)
    		return true;
    	if(!StaticStuff.mario.hitFloor && StaticStuff.mario.y > y && StaticStuff.mario.collisionbox.x+14 - x > 0 && x+20 - StaticStuff.mario.collisionbox.x+14 > 0)
    		return true;
    	return false;
    }
    
    public void draw(Graphics g){
    	if(hit)
    		StaticStuff.brickim.paint(g, StaticStuff.brickim.ca, x, y);
    	else
    		StaticStuff.brickim.paint(g, StaticStuff.brickim.ca, x, y);
    }
    
    public boolean collides(){
    	if(collisionbox.intersects(StaticStuff.mario.collisionbox))
			return true;
    	return false;
    }
    
    Graphics2D g2;
    
    public void NormalBrick(Graphics g){
       //g2 = (Graphics2D)g;
       //g2.scale(0.2,0.2);
//brown color
g.setColor(new Color(246,96,29));
g.fillRect(x+10/6,y+10/6, 100/6, 100/6);
//outside
g.setColor(Color.BLACK);
g.fillRect(x+10/6,y,100/6,10/6);
g.fillRect(x,y,10/6,100/6);
g.fillRect(x,y+100/6,100/6,10/6);
g.fillRect(x+100/6,y,10/6,110/6);
g.fillRect(x+10/6,y+10/6,100/6,10/6);
g.fillRect(x,y+10/6,10/6,100/6);
g.fillRect(x,y+110/6,100/6,10/6);
g.fillRect(x+100/6,y+10/6,10/6,110/6);
//inside
g.fillRect(x+50/6,y,10/6,40/6);
g.fillRect(x,y+40/6,100/6,10/6);
g.fillRect(x,y+70/6,100/6,10/6);
g.fillRect(x+30/6,y+40/6,10/6,30/6);
g.fillRect(x+70/6,y+40/6,10/6,30/6);
g.fillRect(x+50/6,y+80/6,10/6,30/6);
g.fillRect(x+50/6,y+10/6,10/6,40/6);
g.fillRect(x,y+50/6,100/6,10/6);
g.fillRect(x,y+80/6,100/6,10/6);
g.fillRect(x+30/6,y+50/6,10/6,30/6);
g.fillRect(x+70/6,y+50/6,10/6,30/6);
g.fillRect(x+50/6,y+90/6,10/6,30/6);
//g2.scale(5, 5);

            }
    public void BrickWhenFinishedCollision(Graphics g){
       Graphics2D rect=(Graphics2D)g;
       rect.scale(0.2, 0.2);
        
    g.setColor(new Color(193,76,0));
    g.fillRoundRect(x,y , 100, 100, 9, 9);
    g.setColor(Color.BLACK);
    g.fillOval(x+8,y+10, 10, 10);
    g.fillOval(x+80, y+10, 10, 10);
    g.fillOval(x+8, y+80, 10, 10);
    g.fillOval(x+80, y+80, 10, 10);
   g2.scale(5, 5);
}

   
}
    
