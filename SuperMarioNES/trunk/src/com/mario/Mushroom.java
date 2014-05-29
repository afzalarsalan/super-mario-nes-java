package com.mario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.Timer;

public class Mushroom{

	int frameDelay = 0;
	Rectangle collisionbox = new Rectangle();
	int width, height;
    int i=0,j=1;
    int r=0;
    Timer t;
    int x,y;
    int walk=0;
    int curFrame = 0; //0-1
    boolean dead = false;
    
    public Mushroom(){
    	//super(0,0);
    }
     boolean yesorno=true;
     Mushroom(int x,int y)
     	{
    	 	// to visible the frame
    	 	//super(x,y);

    	 	//to set the size
    	 	this.x=x;
    	 	this.y=y;
    	 	collisionbox.setRect(x,y,20,20);

    	 	//setSize(800,800);
    //width=getWidth();
 //height=getHeight();
 //t=new Timer(1,this);
   // t.start();
//setVisible(true);
    
    
}
     
public void setPos(int x1, int y1){
	x= x1;
	y= y1;
}
     Graphics2D g2;
public void MushroomStand(Graphics g){
	//g2 = (Graphics2D)g;
	//g2.scale(1, 1);
     
//head
g.setColor(new Color(104, 56, 38));
g.fillRect(x,y,30,8);
	g.fillRect(x-10,y+7,50,8);
	g.fillRect(x-20,y+15,70,8);
	g.fillRect(x-30,y+23,90,8);
	g.fillRect(x-40,y+31,110,8);
	g.fillRect(x-50,y+39,130,20);
		g.fillRect(x-60,y+55,150,20);
		g.fillRect(x-50,y+70,130,15);
			g.fillRect(x-40,y+85,30,10);
			g.fillRect(x+40,y+85,30,10);
			//body
			g.setColor(new Color(255,187,128));
			g.fillRect(x-10,y+85,50,10);
			g.fillRect(x-15,y+95,60,10);
			g.fillRect(x-15,y+105,60,10);
			g.fillRect(x-10,y+115,50,10);
				g.fillRect(x-5,y+125,40,10);
				//legs
				g.setColor(Color.BLACK);
				//left
					g.fillRect(x-30,y+105,15,20);
						g.fillRect(x-23,y+115,15,20);
						g.fillRect(x-17,y+125,20,15);
						//left
						g.fillRect(x+45,y+105,15,20);
						g.fillRect(x+39,y+115,15,20);
						g.fillRect(x+24,y+125,20,15);
						//Eyebrows
					g.fillRect(x-30,y+30,20,10);
					g.fillRect(x-10,y+40,10,25);
                                            g.fillRect(x,y+48,40,10);
                                            g.fillRect(x+30,y+40,10,25);
                                            g.fillRect(x+40,y+30,20,10);
                                            //Eyes
                                            //left eye
                                            g.setColor(Color.white);
                                            g.fillRect(x-20,y+40,10,30);
                                            g.fillRect(x-20,y+65,30,10);
                                            g.fillRect(x,y+58,10,16);
                                            //right eye
					    g.fillRect(x+40,y+40,10,30);
                                            g.fillRect(x+20,y+65,30,10);
                                            g.fillRect(x+20,y+58,10,16);
}
public void MushroomRight(Graphics g){
	//g2 = (Graphics2D)g;
	//g2.scale(0.25, 0.25);

//head
  
         
//head
g.setColor(new Color(104, 56, 38));
g.fillRect(x,y,30,8);
	g.fillRect(x-10,y+7,50,8);
	g.fillRect(x-20,y+15,70,8);
	g.fillRect(x-30,y+23,90,8);
	g.fillRect(x-40,y+31,110,8);
	g.fillRect(x-50,y+39,130,20);
		g.fillRect(x-60,y+55,150,20);
		g.fillRect(x-50,y+70,130,15);
			g.fillRect(x-40,y+85,30,10);
			g.fillRect(x+40,y+85,30,10);
			//body
			g.setColor(new Color(255,187,128));
			g.fillRect(x-10,y+85,50,10);
			g.fillRect(x-15,y+95,60,10);
			g.fillRect(x-15,y+105,60,10);
			g.fillRect(x-10,y+115,50,10);
				g.fillRect(x-5,y+125,40,10);
				//legs
				g.setColor(Color.BLACK);
				//left
					g.fillRect(x-30,y+105,15,20);
						g.fillRect(x-23,y+115,15,20);
						g.fillRect(x-17,y+125,20,15);
						//right
						g.fillRect(x+45,y+105,30,40);
						g.fillRect(x+39,y+115,30,40);
						g.fillRect(x+24,y+125,40,30);
						//Eyebrows
					g.fillRect(x-30,y+30,20,10);
					g.fillRect(x-10,y+40,10,25);
                                            g.fillRect(x,y+48,40,10);
                                            g.fillRect(x+30,y+40,10,25);
                                            g.fillRect(x+40,y+30,20,10);
                                            //Eyes
                                            //left eye
                                            g.setColor(Color.white);
                                            g.fillRect(x-20,y+40,10,30);
                                            g.fillRect(x-20,y+65,30,10);
                                            g.fillRect(x,y+58,10,16);
                                            //right eye
					    g.fillRect(x+40,y+40,10,30);
                                            g.fillRect(x+20,y+65,30,10);
                                            g.fillRect(x+20,y+58,10,16);
                                            
                                          //  g2.scale(4, 4);
}
public void MushroomLeft(Graphics g){
// g2 = (Graphics2D)g;
// g2.scale(0.25, 0.25);

         
//head
g.setColor(new Color(104, 56, 38));
g.fillRect(x,y,30,8);
	g.fillRect(x-10,y+7,50,8);
	g.fillRect(x-20,y+15,70,8);
	g.fillRect(x-30,y+23,90,8);
	g.fillRect(x-40,y+31,110,8);
	g.fillRect(x-50,y+39,130,20);
		g.fillRect(x-60,y+55,150,20);
		g.fillRect(x-50,y+70,130,15);
			g.fillRect(x-40,y+85,30,10);
			g.fillRect(x+40,y+85,30,10);
			//body
			g.setColor(new Color(255,187,128));
			g.fillRect(x-10,y+85,50,10);
			g.fillRect(x-15,y+95,60,10);
			g.fillRect(x-15,y+105,60,10);
			g.fillRect(x-10,y+115,50,10);
				g.fillRect(x-5,y+125,40,10);
				//legs
				g.setColor(Color.BLACK);
				//left
					g.fillRect(x-30,y+105,30,40);
						g.fillRect(x-23,y+115,30,40);
						g.fillRect(x-17,y+125,40,30);
						//right
						g.fillRect(x+45,y+105,15,20);
						g.fillRect(x+39,y+115,15,20);
						g.fillRect(x+24,y+125,20,15);
						//Eyebrows
					g.fillRect(x-30,y+30,20,10);
					g.fillRect(x-10,y+40,10,25);
                                            g.fillRect(x,y+48,40,10);
                                            g.fillRect(x+30,y+40,10,25);
                                            g.fillRect(x+40,y+30,20,10);
                                            //Eyes
                                            //left eye
                                            g.setColor(Color.white);
                                            g.fillRect(x-20,y+40,10,30);
                                            g.fillRect(x-20,y+65,30,10);
                                            g.fillRect(x,y+58,10,16);
                                            //right eye
					    g.fillRect(x+40,y+40,10,30);
                                            g.fillRect(x+20,y+65,30,10);
                                            g.fillRect(x+20,y+58,10,16);                                         g.fillRect((width/2)+20,(height/2)+58,10,16);
                                           // g2.scale(4, 4);
}

int dir = 1;

public boolean collides(Mario m){
	return m.collisionbox.intersects(collisionbox);
}

public boolean collides(Bullet b){
	return b.collisionbox.intersects(collisionbox);
}

public void update() {
	if(!dead){
		if(frameDelay > 9)
			frameDelay = 0;
		x+=dir;
		if(x > 752 || x < 31)
			dir = -dir;
		if(collides(StaticStuff.mario)){
			StaticStuff.gameOver = true;
			//StaticStuff.mario.dead = true;
		}
		for(Bullet b : GameFrame.bullets)
			if(collides(b)){
				dead = true;
				dead = true;
				b.dead = true;
				GameFrame.score+=100;
			}
		collisionbox.setRect(x,y,20,20);
		if(frameDelay == 1)
		curFrame++;
		frameDelay++;
	}else
		collisionbox.setRect(-50,-50,0,0);
}

public void draw(Graphics g){
	if(!dead){
			StaticStuff.mushim[curFrame%2].paint(g, StaticStuff.mushim[curFrame%2].ca, x, y);
	}
}

}
