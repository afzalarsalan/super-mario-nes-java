package com.mario;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GameFrame extends JPanel{

	static int frameRate = 30;
	
	public GameFrame(){
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
		if(StaticStuff.mario.walking)
			StaticStuff.mario.frame++;
		if(StaticStuff.mario.frame > 2)
			StaticStuff.mario.frame = 0;
	}
	
	  static KeyListener listener = new KeyListener(){
		   @Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					StaticStuff.mario.walking = true;
					StaticStuff.mario.dir = 1;
					StaticStuff.mario.frame++;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					StaticStuff.mario.walking = true;
					StaticStuff.mario.dir = 0;
					StaticStuff.mario.frame++;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				//if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				//	StaticStuff.mario.walking = false;
				//}
				//if(e.getKeyCode() == KeyEvent.VK_LEFT){
				//	StaticStuff.mario.walking = false;
				//}
			}  
	   };
	   
	   @Override
	   public void paintComponent(Graphics g){
		   g.clearRect(0, 0, 800, 600);
		   if(StaticStuff.mario.dir == 1)
			   StaticStuff.mario.framesRight[StaticStuff.mario.frame].paint(g, StaticStuff.mario.framesRight[StaticStuff.mario.frame].ca, 50, 50);
		   else
			   StaticStuff.mario.framesLeft[StaticStuff.mario.frame].paint(g, StaticStuff.mario.framesLeft[StaticStuff.mario.frame].ca, 50, 50);
	   }
	   
	   public static void runGame(){
		   SwingUtilities.invokeLater(new Runnable() {
		         @Override
		         public void run() {
		            final JFrame frame1 = new JFrame("Mario");
		      	  	frame1.addKeyListener(listener);
		            frame1.setContentPane(new GameFrame());
		            frame1.pack();
		            frame1.setLocationRelativeTo(null); // center the application window
		            frame1.setResizable(false);
		            frame1.setSize(StaticStuff.CANVAS_WIDTH, StaticStuff.CANVAS_HEIGHT);
		            frame1.setVisible(true);
                    frame1.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosing(WindowEvent windowEvent) {
                            MainMenu.setVisible(true);
                            super.windowClosed(windowEvent);
                        }
                    });
		         }
		      }); 
	   }
	
	   /** The Entry main method */
	   public static void main(String[] args) {
	      // Run the GUI codes on the Event-Dispatching thread for thread safety
		   StaticStuff.mario.loadImages();
	      runGame();
	   }
}
