package com.mario;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameFrame extends JPanel{

	static int frameRate = 60;
	
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
		
	}
	
	  static KeyListener listener = new KeyListener(){
		   @Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}  
	   };
	   
	   public static void runGame(){
		   SwingUtilities.invokeLater(new Runnable() {
		         @Override
		         public void run() {
		            JFrame frame = new JFrame("Mario");
		      	  	frame.addKeyListener(listener);
		            frame.setContentPane(new GameFrame());
		            frame.pack();
		            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		            frame.setLocationRelativeTo(null); // center the application window
		            frame.setResizable(false);
		            frame.setSize(StaticStuff.CANVAS_WIDTH, StaticStuff.CANVAS_HEIGHT);
		            frame.setVisible(true);
		         }
		      }); 
	   }
	
	   /** The Entry main method */
	   public static void main(String[] args) {
	      // Run the GUI codes on the Event-Dispatching thread for thread safety
	      runGame();
	   }
}
