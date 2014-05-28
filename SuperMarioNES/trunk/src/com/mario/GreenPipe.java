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

/**
 *
 * @author lathasuraparaju
 */
public class GreenPipe{

    /**
     * @param args the command line arguments
     */
    int width,height;
    int x,y;
    GreenPipe(int x,int y){
        this.x=x;
        this.y=y;
    }
    
    public void update(){
    	
    }
    
public void GreenPipe(Graphics g){
    Graphics2D g1=(Graphics2D)g;
    //g1.scale(2, 2);
    g.setColor(new Color(86,254,4));
    g.fillRect(x,y-300,10,300);
    g.setColor(new Color(85,210,2));
     g.fillRect(x+10,y-300,8,300);
     g.setColor(new Color(80,161,2));
     g.fillRect(x+18,y-300,10,300);
     g.setColor(Color.BLACK);
     g.fillRect(x+28,y-300,4,300);
     g.setColor(new Color(85,171,0));
     g.fillRect(x+32,y-300,4,300);
 g.setColor(Color.BLACK);
     g.fillRect(x+36,y-300,4,300);
      g.setColor(new Color(255,255,255));
     g.fillRect(x-10,y-300,9,300);
     g.setColor(new Color(85,210,2));
    g.fillRect(x-15,y-300,5,300);
    g.setColor(new Color(85,171,0));
    g.fillRect(x-25,y-300,10,300);
     g.setColor(Color.BLACK);
     g.fillRect(x-28,y-300,4,300);
   g.setColor(Color.BLACK);
     g.fillRect(x-34, y-300,80,10 );
      g.fillRect(x-34, y-360,80,10 );
     //lid
     g.setColor(Color.WHITE);
        g.fillRect(x-34, y-350,80,50 );
        g.setColor(new Color(85,210,2));
    g.fillRect(x-10,y-300,12,3);
     g.setColor(new Color(86,254,4));
    g.fillRect(x,y-345,10,48);
    g.setColor(new Color(85,210,2));
     g.fillRect(x+10,y-345,10,48);
     g.setColor(new Color(80,161,2));
     g.fillRect(x+18,y-350,10,50);
     g.setColor(Color.BLACK);
     g.fillRect(x+28,y-350,5,50);
     g.setColor(new Color(85,171,0));
     g.fillRect(x+32,y-350,4,50);
     g.setColor(Color.BLACK);
     g.fillRect(x+36,y-350,4,50);
     
     //neck
     
     
     
     g.fillRect(x+41,y-350,5,50);
//left
    g.setColor(new Color(85,171,0));
    g.fillRect(x-25,y-350,8,50);
     g.setColor(Color.BLACK);
     g.fillRect(x-28,y-350,3,50);
     g.setColor(new Color(80,210,2));
     g.fillRect(x-18,y-345,8,50);
     g.setColor(new Color(85,210,2));
     g.fillRect(x-34,y-350,5,50);

     
    
}
    
}
