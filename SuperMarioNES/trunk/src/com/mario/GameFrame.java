package com.mario;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class GameFrame extends JPanel{

	static int frameRate = 40;
    private volatile boolean isRunning = true;
    public static JFrame frame1;
    public Thread animationThread;
    
    public double GRAVITY = 9.8;
    public double TERMINAL = 20;

    public GameFrame(){
        animationThread = new Thread () {
            @Override
            public void run() {
                long lastTime = System.nanoTime();
                long timer = System.currentTimeMillis();
                double ns = 1000000000.0/60.0;
                double delta = 0;
                int frames =0;
                int updates = 0;
                if (!animationThread.isInterrupted()) {
                    do {
                        long now = System.nanoTime();
                        delta += (now - lastTime) / ns;
                        lastTime = now;
                        while (delta >=1){
                            update();
                            updates++;
                            delta--;
                        }
                        repaint();
                        frames++;
                        if(System.currentTimeMillis() - timer > 1000) {
                            timer += 1000;
                            System.out.println(updates + "ups, " + frames + " fps");
                            frame1.setTitle("SuperMarioNES" + " | " + updates + "ups, " + frames + " fps");
                            updates = 0;
                            frames = 0;
                        }  // Refresh the display
                    } while (!animationThread.isInterrupted());
                }
            }
        };
        animationThread.start();  // start the thread to run animation
    }
	
	public void update(){
		//mario code
		if(!StaticStuff.mario.walking)
			StaticStuff.mario.frame = 1;
		if(StaticStuff.mario.frameDelay > 9)
			StaticStuff.mario.frameDelay = 0;
		//if(StaticStuff.mario.frame > 2)
		//	StaticStuff.mario.frame = 0;
		
		
		if(StaticStuff.mario.walking && StaticStuff.mario.frameDelay == 9){
			if(StaticStuff.mario.frame < 2)
				StaticStuff.mario.frame++;
			else
				StaticStuff.mario.frame = 0;
		}
		
		if(StaticStuff.mario.walking){
			if(StaticStuff.mario.dir == 1)
				StaticStuff.mario.x+=2;
			else
				StaticStuff.mario.x-=2;
		}
		StaticStuff.mario.frameDelay++;
		
		
	}

    public void stop(){
        isRunning = false;
    }
	
	  static KeyListener listener = new KeyListener(){
		   @Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_RIGHT && !StaticStuff.mario.walking){
					StaticStuff.mario.walking = true;
					StaticStuff.mario.dir = 1;
					StaticStuff.mario.frame++;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT && !StaticStuff.mario.walking){
					StaticStuff.mario.walking = true;
					StaticStuff.mario.dir = 0;
					StaticStuff.mario.frame++;
				}
				if(e.getKeyCode() == KeyEvent.VK_SPACE){
					
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_RIGHT){
					StaticStuff.mario.walking = false;
				}
				if(e.getKeyCode() == KeyEvent.VK_LEFT){
					StaticStuff.mario.walking = false;
				}
			}  
	   };
	   
	   @Override
	   public void paintComponent(Graphics g){
		   g.clearRect(0, 0, 800, 600);
		   if(StaticStuff.mario.dir == 1)
			   StaticStuff.mario.framesRight[StaticStuff.mario.frame].paint(g, StaticStuff.mario.framesRight[StaticStuff.mario.frame].ca, StaticStuff.mario.x, StaticStuff.mario.y);
		   else
			   StaticStuff.mario.framesLeft[StaticStuff.mario.frame].paint(g, StaticStuff.mario.framesLeft[StaticStuff.mario.frame].ca2, StaticStuff.mario.x, StaticStuff.mario.y);
		  // StaticStuff.mario.framesRight[2].paint(g, StaticStuff.mario.framesRight[0].ca, StaticStuff.mario.x, StaticStuff.mario.y);
		  // StaticStuff.mario.framesRight[2].paint(g, StaticStuff.mario.framesRight[1].ca, StaticStuff.mario.x + 100, StaticStuff.mario.y);
		  // StaticStuff.mario.framesRight[2].paint(g, StaticStuff.mario.framesRight[2].ca, StaticStuff.mario.x + 200, StaticStuff.mario.y);
	   }
	   
	   public void runGame(){
		   SwingUtilities.invokeLater(new Runnable() {
		         @Override
		         public void run() {
		        	StaticStuff.mario.loadImages();
		            frame1 = new JFrame("Mario");
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
                            animationThread.interrupt();
                            MainMenu.setVisible(true);
                            isRunning = false;
                            try {
                                animationThread.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            frame1.dispose();
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
	        new GameFrame().runGame();
	   }

}
