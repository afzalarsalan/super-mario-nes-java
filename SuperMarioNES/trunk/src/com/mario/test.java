package com.mario;
import java.awt.*;
import java.awt.geom.AffineTransform;

import javax.swing.*;

public class test
{
	public static void main(String...args)
	{
		JFrame j = new JFrame();  //JFrame is the window; window is a depricated class
		MyPanel m = new MyPanel();
		j.setSize(m.getSize());
		j.add(m); //adds the panel to the frame so that the picture will be drawn
			      //use setContentPane() sometimes works better then just add b/c of greater efficiency.

		j.setVisible(true); //allows the frame to be shown.

		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the dialog box exit when you click the "x" button.
	}

}

class MyPanel extends JPanel 
{
	static int frameRate = 60;
	
	MyPanel()
	{
		setSize(800, 600);
		setVisible(true); //it's like calling the repaint method.
		Thread animationThread = new Thread () {
	         @Override
	         public void run() {
	            while (true) {
	            	
	               update();   // update the position and image
	               repaint();  // Refresh the display
	               try {
	                  Thread.sleep(2500 / frameRate); // delay and yield to other threads
	               } catch (InterruptedException ex) { }
	            }
	         }
	      };
	      animationThread.start();  // start the thread to run animation
	}
	
	public void update(){
		
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		//g2.scale(0.3, 0.3);
		//Still Mario
		stillMario(g);
		g2.translate(0, 200);
		rightMario1(g);
		g2.translate(500, 200);
		rightMario2(g);
	}
	
	public void rightMario1(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(100, 100, 30, 10);
		g.fillRect(80, 110, 90, 10);
		g.fillRect(90, 110, 90, 10);
		g.fillRect(110, 170, 10, 10);
		g.fillRect(150, 170, 10, 10);
		g.fillRect(120, 180, 10, 10);
		g.fillRect(160, 180, 10, 10);
		g.fillRect(120, 190, 50, 10);
		g.fillRect(90, 200, 10, 10);
		for(int i = 90; i <= 170; i+=10)
		g.fillRect(i, 210, 10, 10);
		for(int i = 90; i <= 170; i+=10)
			g.fillRect(i, 220, 10, 10);
		for(int i = 110; i <= 130; i+=10)
		g.fillRect(i, 200, 10, 10);
		g.fillRect(150, 200, 10, 10);
		g.fillRect(170, 200, 10, 10);
		for(int i = 80; i <= 140; i+=10)
			g.fillRect(i, 230, 10, 10);
		for(int i = 80; i <= 110; i+=10)
			g.fillRect(i, 240, 10, 10);
		g.setColor(Color.ORANGE);
		g.fillRect(120, 120, 20, 10);
		g.fillRect(150, 120, 10, 10);
		g.fillRect(90, 130, 10, 10);
		g.fillRect(110, 130, 30, 10);
		g.fillRect(150, 130, 30, 10);
		g.fillRect(90, 140, 10, 10);
		g.fillRect(120, 140, 30, 10);
		g.fillRect(160, 140, 30, 10);
		g.fillRect(100, 150, 40, 10);
		g.fillRect(100, 160, 70, 10);
		g.fillRect(40, 190, 20, 10);
		g.fillRect(40, 200, 30, 10);
		g.fillRect(50, 210, 10, 10);
		g.fillRect(190, 110, 10, 10);
		g.fillRect(180, 110, 10, 10);
		g.fillRect(190, 100, 10, 10);
		g.fillRect(180, 100, 10, 10);
		g.fillRect(170, 90, 10, 10);
		g.fillRect(170, 100, 10, 10);
		g.fillRect(180, 90, 10, 10);
		g.fillRect(190, 90, 10, 10);
		g.fillRect(140, 200, 10, 10);
		g.fillRect(160, 200, 10, 10);
		g.setColor(Color.BLACK);
		g.fillRect(70, 220, 10, 10);
		g.fillRect(70, 210, 10, 10);
		g.fillRect(80, 220, 10, 10);
		g.fillRect(70, 230, 10, 10);
		g.fillRect(60, 220, 10, 10);
		g.fillRect(50, 230, 20, 10);
		g.fillRect(90, 120, 30, 10);
		g.fillRect(80, 130, 10, 10);
		g.fillRect(50, 240, 10, 10);
		g.fillRect(140, 120, 10, 10);
		g.fillRect(100, 130, 10, 10);
		g.fillRect(140, 130, 10, 10);
		g.fillRect(80, 140, 10, 10);
		g.fillRect(90, 140, 30, 10);
		g.fillRect(150, 140, 10, 10);
		g.fillRect(80, 150, 20, 10);
		g.fillRect(140, 150, 40, 10);
		g.fillRect(60, 170, 50, 10);
		g.fillRect(50, 180, 70, 10);
		g.fillRect(60, 190, 60, 10);
		g.fillRect(120, 170, 30, 10);
		g.fillRect(130, 180, 30, 10);
		g.fillRect(160, 170, 10, 10);
		g.fillRect(100, 200, 10, 10);
		g.fillRect(170, 160, 10, 10);
		g.fillRect(180, 150, 10, 10);
		g.fillRect(190, 140, 10, 10);
		g.fillRect(190, 130, 10, 10);
		g.fillRect(190, 120, 10, 10);
		g.fillRect(180, 120, 10, 10);
		g.fillRect(170, 120, 10, 10);
		g.fillRect(180, 130, 10, 10);
		for(int i = 200; i <= 220; i+=10)
		g.fillRect(180, i, 20, 10);
		g.fillRect(190, 190, 10, 10);
		g.fillRect(190, 180, 10, 10);
	}
	
	public void rightMario2(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(100, 100, 30, 10);
		g.fillRect(80, 110, 90, 10);
		g.fillRect(90, 110, 90, 10);
		g.fillRect(110, 170, 10, 10);
		g.fillRect(150, 170, 10, 10);
		g.fillRect(120, 180, 10, 10);
		g.fillRect(160, 180, 10, 10);
		g.fillRect(120, 190, 50, 10);
		g.fillRect(90, 200, 10, 10);
		for(int i = 90; i <= 170; i+=10)
		g.fillRect(i, 210, 10, 10);
		for(int i = 90; i <= 170; i+=10)
			g.fillRect(i, 220, 10, 10);
		for(int i = 110; i <= 130; i+=10)
		g.fillRect(i, 200, 10, 10);
		g.fillRect(150, 200, 10, 10);
		g.fillRect(170, 200, 10, 10);
		for(int i = 80; i <= 140; i+=10)
			g.fillRect(i, 230, 10, 10);
		for(int i = 80; i <= 110; i+=10)
			g.fillRect(i, 240, 10, 10);
		g.fillRect(140, 200, 10, 10);
		g.fillRect(160, 200, 10, 10);
		g.setColor(Color.ORANGE);
		g.fillRect(120, 120, 20, 10);
		g.fillRect(150, 120, 10, 10);
		g.fillRect(90, 130, 10, 10);
		g.fillRect(110, 130, 30, 10);
		g.fillRect(150, 130, 30, 10);
		g.fillRect(90, 140, 10, 10);
		g.fillRect(120, 140, 30, 10);
		g.fillRect(160, 140, 30, 10);
		g.fillRect(100, 150, 40, 10);
		g.fillRect(100, 160, 70, 10);
		g.fillRect(40, 190, 20, 10);
		g.fillRect(40, 200, 30, 10);
		g.fillRect(50, 210, 10, 10);
		g.fillRect(190, 110, 10, 10);
		g.fillRect(180, 110, 10, 10);
		g.fillRect(190, 100, 10, 10);
		g.fillRect(180, 100, 10, 10);
		g.fillRect(170, 90, 10, 10);
		g.fillRect(170, 100, 10, 10);
		g.fillRect(180, 90, 10, 10);
		g.fillRect(190, 90, 10, 10);
		g.setColor(Color.BLACK);
		g.fillRect(70, 220, 10, 10);
		g.fillRect(70, 210, 10, 10);
		g.fillRect(80, 220, 10, 10);
		g.fillRect(70, 230, 10, 10);
		g.fillRect(60, 220, 10, 10);
		g.fillRect(50, 230, 20, 10);
		g.fillRect(90, 120, 30, 10);
		g.fillRect(80, 130, 10, 10);
		g.fillRect(50, 240, 10, 10);
		g.fillRect(140, 120, 10, 10);
		g.fillRect(100, 130, 10, 10);
		g.fillRect(140, 130, 10, 10);
		g.fillRect(80, 140, 10, 10);
		g.fillRect(90, 140, 30, 10);
		g.fillRect(150, 140, 10, 10);
		g.fillRect(80, 150, 20, 10);
		g.fillRect(140, 150, 40, 10);
		g.fillRect(60, 170, 50, 10);
		g.fillRect(50, 180, 70, 10);
		g.fillRect(60, 190, 60, 10);
		g.fillRect(120, 170, 30, 10);
		g.fillRect(130, 180, 30, 10);
		g.fillRect(160, 170, 10, 10);
		g.fillRect(100, 200, 10, 10);
		g.fillRect(170, 160, 10, 10);
		g.fillRect(180, 150, 10, 10);
		g.fillRect(190, 140, 10, 10);
		g.fillRect(190, 130, 10, 10);
		g.fillRect(190, 120, 10, 10);
		g.fillRect(180, 120, 10, 10);
		g.fillRect(170, 120, 10, 10);
		g.fillRect(180, 130, 10, 10);
		for(int i = 200; i <= 220; i+=10)
		g.fillRect(180, i, 20, 10);
		g.fillRect(190, 190, 10, 10);
		g.fillRect(190, 180, 10, 10);
	}
	
	public void stillMario(Graphics g){
		g.setColor(Color.RED);			//CLOTHES
		g.fillRect(100, 100, 30, 10);
		g.fillRect(90, 110, 90, 10);
		g.fillRect(110, 170, 10, 10);
		g.fillRect(110, 180, 10, 10);
		g.fillRect(140, 180, 10, 10);
		g.fillRect(110, 190, 40, 10);
		g.fillRect(100, 200, 10, 10);
		g.fillRect(120, 200, 20, 10);
		g.fillRect(150, 200, 10, 10);
		g.fillRect(100, 210, 60, 10);
		g.fillRect(90, 220, 80, 10);
		g.fillRect(90, 230, 30, 10);
		g.fillRect(140, 230, 30, 10);
		g.setColor(Color.BLACK);		//HAIR / EYES
		g.fillRect(90, 120, 30, 10);
		g.fillRect(80, 130, 10, 10);
		g.fillRect(140, 120, 10, 10);
		g.fillRect(100, 130, 10, 10);
		g.fillRect(140, 130, 10, 10);
		g.fillRect(80, 140, 10, 10);
		g.fillRect(90, 140, 30, 10);
		g.fillRect(150, 140, 10, 10);
		g.fillRect(80, 150, 20, 10);
		g.fillRect(140, 150, 40, 10);
		g.fillRect(90, 170, 20, 10);
		g.fillRect(120, 170, 30, 10);
		g.fillRect(80, 180, 30, 10);
		g.fillRect(120, 180, 20, 10);
		g.fillRect(150, 180, 30, 10);
		g.fillRect(70, 190, 40, 10);
		g.fillRect(150, 190, 40, 10);
		g.fillRect(90, 200, 10, 10);
		g.fillRect(160, 200, 10, 10);
		g.fillRect(80, 240, 30, 10);
		g.fillRect(70, 250, 40, 10);
		g.fillRect(150, 240, 30, 10);
		g.fillRect(150, 250, 40, 10);
		g.setColor(Color.ORANGE);		//SKIN
		g.fillRect(120, 120, 20, 10);
		g.fillRect(150, 120, 10, 10);
		g.fillRect(90, 130, 10, 10);
		g.fillRect(110, 130, 30, 10);
		g.fillRect(150, 130, 30, 10);
		g.fillRect(90, 140, 10, 10);
		g.fillRect(120, 140, 30, 10);
		g.fillRect(160, 140, 30, 10);
		g.fillRect(100, 150, 40, 10);
		g.fillRect(100, 160, 70, 10);
		g.fillRect(70, 200, 20, 10);
		g.fillRect(110, 200, 10, 10);
		g.fillRect(140, 200, 10, 10);
		g.fillRect(170, 200, 20, 10);
		g.fillRect(70, 210, 30, 10);
		g.fillRect(160, 210, 30, 10);
		g.fillRect(70, 220, 20, 10);
		g.fillRect(170, 220, 20, 10);
	}
}
