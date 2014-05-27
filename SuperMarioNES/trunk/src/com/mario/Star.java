/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author nithinkuchibotla
 */
public class Star extends Powerup{
   
    Star(){
    }
    Graphics2D g2;
    public void draw(Graphics g, int x, int y){
        int r=(int)(Math.random()*226);
        int f=(int)(Math.random()*226);
        int b=(int)(Math.random()*226);
    	//g2 = (Graphics2D)g;
    	//g2.scale(2, 2);
   
        g.setColor(Color.BLACK);
    // Outline
        g.fillRect(x,y,15,10);//1
        g.fillRect(x-8,y+10, 8,19);//2
        g.fillRect(x+15,y+10,8,19);//3
        g.fillRect(x-14,y+29, 7,22);//4
        g.fillRect(x+22,y+29, 7,22);//5
        g.fillRect(x+28,y+44, 40,7);//6
        g.fillRect(x-53,y+44, 40,7);//7
        g.fillRect(x-53,y+50, 7,15);//8
       g.fillRect(x+61,y+50, 7,15);//9
       g.fillRect(x-47,y+65, 8,8);//10
        g.fillRect(x-39,y+73, 8,8);//11
         g.fillRect(x-31,y+81, 8,8);//12
        g.fillRect(x+54,y+65, 8,8);//13
        g.fillRect(x+46,y+73, 8,8);//14
        g.fillRect(x+38,y+81, 8,8);//15
        g.fillRect(x+46,y+89, 8,15);//16
        g.fillRect(x+54,y+103, 8,15);//17
           g.fillRect(x+62,y+117,8,15);//18
           g.fillRect(x-39,y+89, 8,15);//19
           g.fillRect(x-47,y+103, 8,15);//20
          g.fillRect(x-55,y+118, 8,15);//21
           g.fillRect(x-55,y+133, 20,8);//22
          g.fillRect(x-35,y+125, 16,8);//23
           g.fillRect(x-19,y+117, 16,8);//23
           g.fillRect(x-4,y+109, 20,8);//23
           g.fillRect(x+16,y+117, 16,8);//24
           g.fillRect(x+32,y+125, 16,8);//25
           g.fillRect(x+48,y+132, 22,9);//26
     // body shade
           g.setColor(new Color(r,f,b));
             g.fillRect(x,y+10, 8,19);//1
             g.fillRect(x-7,y+29, 7,22);//2
           g.fillRect(x-46,y+51, 40,8);//3 
            g.fillRect(x-46,y+59, 10,6);//4
            g.fillRect(x-39,y+65, 8,8);//5
             g.fillRect(x-31,y+73, 8,8);//6
            g.fillRect(x-23,y+81, 8,8);//7
             g.fillRect(x-31,y+89, 12,36);//8
           g.fillRect(x-39,y+104, 10,14);//9
             g.fillRect(x-47,y+118, 12,15);//10
             g.fillRect(x-47,y+118, 11,15);//11
             g.fillRect(x-25,y+105, 21,13);//12
             g.fillRect(x-43,y+118, 16,7);//12
             // body 
             g.setColor(new Color(r,f,b));
            g.fillRect(x+8,y+10, 8,19);//1
            g.fillRect(x,y+29, 7,22);//2
            g.fillRect(x+7,y+29, 7,22);//3
            g.fillRect(x+14,y+29, 8,22);//4
            //g.fillRect(x+14,y-71, 8,22);//5
            g.fillRect(x-6,y+50, 67,9);//6
           g.fillRect(x-42,y+59,103 ,6);//7
             g.fillRect(x-32,y+63,86 ,10);//8
              g.fillRect(x-32,y+73,78 ,8);//9
             g.fillRect(x-15,y+81,53 ,8);//10
              g.fillRect(x-23,y+89,61,20);//11
             g.fillRect(x+38,y+89,8,36);//12
              //g.fillRect(x-23,y-26,61,25);//13
              g.fillRect(x+32,y+109,19,16);//14
              g.fillRect(x+16,y+108,27,9);//15
              g.fillRect(x+42,y+103,12,15);//16
              g.fillRect(x+48,y+118,15,14);//17
         
               // eyes
                g.setColor(Color.BLACK);
                g.fillRect(x+20,y+60,8,13);//1
                 g.fillRect(x-10,y+60,8,13);//2
    }
    
	public String toString(){
		return "Star";
	}
    
}