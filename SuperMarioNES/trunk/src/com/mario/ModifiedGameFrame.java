package com.mario;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ModifiedGameFrame extends JPanel{

	static int frameRate = 60;

    private boolean isRunning = true;

	public ModifiedGameFrame(){
        Thread animationThread = new Thread () {
            @Override
            public void run() {
                if (isRunning) {
                    do {

                        update();   // update the position and image
                        repaint();  // Refresh the display
                        try {
                            Thread.sleep(2500 / frameRate); // delay and yield to other threads
                        } catch (InterruptedException ex) {
                        }
                    } while (isRunning);
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
		            final JFrame frame1 = new JFrame("Mario");
		      	  	frame1.addKeyListener(listener);
		            //frame1.setContentPane(new ModifiedGameFrame());
                    frame1.add(new MyPanel());
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
	      runGame();
	   }
}
