/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Brick{
    int width,height;
     int x,y;
     boolean hit = false;
     
     Brick(){
    	 
     }
     
    Brick(int x,int y){
         this.x=x;
         this.y=y;
    }
    
    public void draw(Graphics g){
    	if(hit)
    		BrickWhenFinishedCollision(g);
    	else
    		NormalBrick(g);
    }
    
    public void NormalBrick(Graphics g){
       
        Graphics2D g1=(Graphics2D)g;
g1.scale(2,2);
//brown color
g.setColor(new Color(246,96,29));
g.fillRect(x+110,y+10, 100, 100);
//outside
g.setColor(Color.BLACK);
g.fillRect(x+110,y+10,100,10);
g.fillRect(x+100,y+10,10,100);
g.fillRect(x+100,y+110,100,10);
g.fillRect(x+200,y+10,10,110);
//inside
g.fillRect(x+150,y+10,10,40);
g.fillRect(x+100,y+50,100,10);
g.fillRect(x+100,y+80,100,10);
g.fillRect(x+130,x+50,10,30);
g.fillRect(x+170,y+50,10,30);
g.fillRect(x+150,y+90,10,30);

            }
    public void BrickWhenFinishedCollision(Graphics g){
        Graphics2D rect=(Graphics2D)g;
        rect.scale(0.5, 0.5);
        
    g.setColor(new Color(193,76,0));
    g.fillRoundRect(x,y , 100, 100, 9, 9);
    g.setColor(Color.BLACK);
    g.fillOval(x+8,y+10, 10, 10);
    g.fillOval(x+80, y+10, 10, 10);
    g.fillOval(x+8, y+80, 10, 10);
    g.fillOval(x+80, y+80, 10, 10);
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
    
