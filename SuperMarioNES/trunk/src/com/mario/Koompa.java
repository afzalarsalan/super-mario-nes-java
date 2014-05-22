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
 * @author lathasuraparaju
 */

public class Koompa {

    /**
     * @param args the command line arguments
     */
    int x,y;
    private int red;
    private int green;
    private int blue;
    
    public Koompa(){
    	
    }

    public Koompa(int x, int y){
        this.x=x;
        this.y=y;
        red = (int)(Math.random()*256);
        green = (int)(Math.random()*256);
        blue = (int)(Math.random()*256);

    }
    
    public void setPos(int x1, int y1){
    	x= x1;
    	y=y1;
    }

    @Deprecated
    public void MovingLeft1(Graphics g){
        Graphics2D g1=(Graphics2D)g;
        g1.scale(2, 2);
        /*int r=(int)(Math.random()*256);
        int g2=(int)(Math.random()*256);
        int b=(int)(Math.random()*256);*/
        // body color shade
        g.setColor(new Color(233,171,116));
        g.fillRect(x-10, y+35,5,25 );
        g.fillRect(x-5, y+44,5,11 );
        g.fillRect(x, y+39,5,5 );
        g.fillRect(x+5, y+34,5,5 );
        g.fillRect(x+5, y+103,5,10 );
        g.fillRect(x, y+108,5,10);
        g.fillRect(x+40, y+113,5,5);
        g.fillRect(x+20, y+25,5,5);//this
        g.fillRect(x+15, y+20,5,5);//this
        //body color
        g.setColor(new Color(171,86,0));
        g.fillRect(x-5, y+35,5,5 );
        g.fillRect(x+15, y+25,5,25 );
        g.fillRect(x+20, y+30,5,10 );
        g.fillRect(x+10, y+25,5,34 );
        g.fillRect(x+35, y+113,5,5);
        g.fillRect(x, y+44,3,11 );
        g.fillRect(x-5, y+44,9,6 );
        g.fillRect(x+5, y+39,5,5 );
        g.fillRect(x+7, y+48,5,11 );
        g.fillRect(x-5, y+55,18,16 );
        g.fillRect(x-5, y+55,5,10 );
        g.fillRect(x+15, y+20,5,5);
        g.fillRect(x+4, y+44,6,6);
        g.fillRect(x-1, y+69,11,9);
        g.fillRect(x+2, y+78,8,8);
        g.fillRect(x+10, y+108,10,10);
        g.fillRect(x+5, y+113,5,5);
        g.fillRect(x-5, y+115,5,3);
        //shell
        g.setColor(new Color(red,green,blue));
        g.fillRect(x+30, y+40,10 ,10);
        g.fillRect(x+15, y+50,35 ,55);
        g.fillRect(x+15, y+50,35 ,55);
        g.fillRect(x+10, y+70,10 ,30);
        g.fillRect(x+45, y+70,10 ,30);
        g.fillRect(x+20, y+100,30 ,10);

        //outline
        //eye
        g.setColor(Color.BLACK);
        g.fillRect(x, y,10,5 );
        g.fillRect(x-5, y+5,5,10 );
        g.fillRect(x-10, y+15,5,20 );
        g.fillRect(x-5, y+19,5,10 );
        g.fillRect(x+10, y+5,5,20 );
        //head
        g.fillRect(x+15, y+15, 5, 5);
        g.fillRect(x+20, y+20,5,5 );
        g.fillRect(x+25, y+25,5,15 );
        g.fillRect(x+20, y+40,5,10 );
        g.fillRect(x+15, y+50,5,8 );
        g.fillRect(x+10, y+58,5,15 );
        g.fillRect(x+5, y+73,5,30 );
        g.fillRect(x+10, y+98,5,5 );
        g.fillRect(x+10, y+103,10,5 );
        g.fillRect(x+20, y+108,30,5 );
        g.fillRect(x+50, y+98,5,10 );
        g.fillRect(x-15, y+35,5,25 );
        g.fillRect(x-10, y+60,5,5 );
        g.fillRect(x-5, y+65,4,10 );
        g.fillRect(x-1, y+55,4,10 );
        g.fillRect(x+3, y+50,4,7 );
        g.fillRect(x-5, y+39,5,5 );
        g.fillRect(x-1, y+75,4,10 );
        g.fillRect(x+2, y+85,5,5 );

        //legs
        g.fillRect(x, y+103,5,5 );
        g.fillRect(x-5, y+108,5,5 );
        g.fillRect(x-10, y+113,5,5 );
        g.fillRect(x-10, y+118,30,2 );
        g.fillRect(x+20, y+108,5,12 );
        g.fillRect(x+30, y+108,5,11 );
        g.fillRect(x+30, y+118,20,2 );
        g.fillRect(x+50, y+112,4,8 );
        //shell
        g.fillRect(x+30, y+40,10,5 );
        g.fillRect(x+40, y+45,5,5 );
        g.fillRect(x+25, y+45,5,5 );
        g.fillRect(x+45, y+50,5,10 );
        g.fillRect(x+50, y+60,5,20 );
        g.fillRect(x+55, y+80,5,18 );

        g.fillRect(x+45, y+65,5,5 );
        g.fillRect(x+25, y+85,5,5 );
        g.fillRect(x+30, y+80,5,5 );
        g.fillRect(x+35, y+75,5,5 );
        g.fillRect(x+40, y+70,5,5 );
        g.fillRect(x+20, y+90,5,5 );
        g.fillRect(x+15, y+95,5,5 );
        g.fillRect(x+45, y+93,5,5 );
        g.fillRect(x+40, y+88,5,5 );
        g.fillRect(x+35, y+83,5,5 );
        g.fillRect(x+30, y+78,5,5 );
        g.fillRect(x+25, y+73,5,5 );
        g.fillRect(x+20, y+68,5,5 );
        g.fillRect(x+15, y+63,5,5 );
        g.fillRect(x+10, y+58,5,5 );
        g.fillRect(x+15, y+43,5,5 );






    }

    public void MovingLeft2(Graphics g){
        Graphics2D g1=(Graphics2D)g;
        g1.scale(0.5,0.5);
        /*int r=(int)(Math.random()*256);
        int g2=(int)(Math.random()*256);
        int b=(int)(Math.random()*256);*/
        // body color shade
        g.setColor(new Color(233,171,116));
        g.fillRect(x-10, y+35,5,25 );
        g.fillRect(x-5, y+44,5,11 );
        g.fillRect(x, y+39,5,5 );
        g.fillRect(x+5, y+34,5,5 );
        g.fillRect(x+5, y+103,5,10 );
        g.fillRect(x, y+108,5,10);
        g.fillRect(x+40, y+113,5,5);
        g.fillRect(x+20, y+25,5,5);//this
        g.fillRect(x+15, y+20,5,5);//this
        //body color
        g.setColor(new Color(171,86,0));
        g.fillRect(x-5, y+35,5,5 );
        g.fillRect(x+15, y+25,5,25 );
        g.fillRect(x+20, y+30,5,10 );
        g.fillRect(x+10, y+25,5,34 );
        g.fillRect(x+35, y+113,5,5);
        g.fillRect(x, y+44,3,11 );
        g.fillRect(x-5, y+44,9,6 );
        g.fillRect(x+5, y+39,5,5 );
        g.fillRect(x+7, y+48,5,11 );
        g.fillRect(x-5, y+55,18,16 );
        g.fillRect(x-5, y+55,5,10 );
        g.fillRect(x+15, y+20,5,5);
        g.fillRect(x+4, y+44,6,6);
        g.fillRect(x-1, y+69,11,9);
        g.fillRect(x+2, y+78,8,8);
        g.fillRect(x+10, y+108,10,10);
        g.fillRect(x+5, y+113,5,5);
        g.fillRect(x-5, y+115,5,3);
        //shell
        g.setColor(new Color(red,green,blue));
        g.fillRect(x+30, y+40,10 ,10);
        g.fillRect(x+15, y+50,35 ,55);
        g.fillRect(x+15, y+50,35 ,55);
        g.fillRect(x+10, y+70,10 ,30);
        g.fillRect(x+45, y+70,10 ,30);
        g.fillRect(x+20, y+100,30 ,10);

        //outline
        //eye
        g.setColor(Color.BLACK);
        g.fillRect(x, y,10,5 );
        g.fillRect(x-5, y+5,5,10 );
        g.fillRect(x-10, y+15,5,20 );
        g.fillRect(x-5, y+19,5,10 );
        g.fillRect(x+10, y+5,5,20 );
        //head
        g.fillRect(x+15, y+15, 5, 5);
        g.fillRect(x+20, y+20,5,5 );
        g.fillRect(x+25, y+25,5,15 );
        g.fillRect(x+20, y+40,5,10 );
        g.fillRect(x+15, y+50,5,8 );
        g.fillRect(x+10, y+58,5,15 );
        g.fillRect(x+5, y+73,5,30 );
        g.fillRect(x+10, y+98,5,5 );
        g.fillRect(x+10, y+103,10,5 );
        g.fillRect(x+20, y+108,30,5 );
        g.fillRect(x+50, y+98,5,10 );
        g.fillRect(x-15, y+35,5,25 );
        g.fillRect(x-10, y+60,5,5 );
        g.fillRect(x-5, y+65,4,10 );
        g.fillRect(x-1, y+55,4,10 );
        g.fillRect(x+3, y+50,4,7 );
        g.fillRect(x-5, y+39,5,5 );
        g.fillRect(x-1, y+75,4,10 );
        g.fillRect(x+2, y+85,5,5 );

        //legs

        g.fillRect(x, y+103,5,5 );
        g.fillRect(x-5, y+108,5,5 );
        g.fillRect(x-10, y+113,5,5 );
        g.fillRect(x+15, y+98,5,5 );


        g.fillRect(x+20, y+108,5,8 );
        g.fillRect(x+30, y+108,5,11 );
        g.fillRect(x+30, y+118,20,2 );
        g.fillRect(x+50, y+112,4,8 );
        //shell
        g.fillRect(x+30, y+40,10,5 );
        g.fillRect(x+40, y+45,5,5 );
        g.fillRect(x+25, y+45,5,5 );
        g.fillRect(x+45, y+50,5,10 );
        g.fillRect(x+50, y+60,5,20 );
        g.fillRect(x+55, y+80,5,18 );

        g.fillRect(x+45, y+65,5,5 );
        g.fillRect(x+25, y+85,5,5 );
        g.fillRect(x+30, y+80,5,5 );
        g.fillRect(x+35, y+75,5,5 );
        g.fillRect(x+40, y+70,5,5 );
        g.fillRect(x+20, y+90,5,5 );
        g.fillRect(x+15, y+95,5,5 );
        g.fillRect(x+45, y+93,5,5 );
        g.fillRect(x+40, y+88,5,5 );
        g.fillRect(x+35, y+83,5,5 );
        g.fillRect(x+30, y+78,5,5 );
        g.fillRect(x+25, y+73,5,5 );
        g.fillRect(x+20, y+68,5,5 );
        g.fillRect(x+15, y+63,5,5 );
        g.fillRect(x+10, y+58,5,5 );
        g.fillRect(x+15, y+43,5,5 );
        //continue foot
        Graphics2D g3 = (Graphics2D) g;
        g3.setStroke(new BasicStroke(3));
        g3.drawLine(x-8,y+118,x+20,y+113);   //thick
    }
    
}
