package com.mario;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;

public class GameFrame extends JPanel{

	static int frameRate = 40;
    private volatile boolean isRunning = true;
    public static JFrame frame1;
    public Thread animationThread;
    public LevelBuilder lb;
    HashMap<String, Object> key = new HashMap();
    Object[][] lvlmap;
    ArrayList<Brick> fallingBricks = new ArrayList();
    ArrayList<PowerBrick> fallingPowerups = new ArrayList();
    
    public double GRAVITY = .6;
    public double TERMINAL = 20;
    public static double fallrate = 0;
    public static int DELAY = 1000/60;
    
    public static boolean jumped = false;

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
                            repaint();
                            frames++;
                        }
                        //repaint();
                        //frames++;
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
    
    int cnt = 0;
	
	public void update(){
		//mario code
		
		System.out.println(StaticStuff.mario.collisionbox.x + " " + StaticStuff.mario.x);
		if(cnt == 1000){
			int x = (int)(Math.random()*720 + 30);
			fallingPowerups.add(new PowerBrick(x, 50));
			cnt = 0;
		}
		cnt++;
		
		if(!StaticStuff.mario.walking)
			StaticStuff.mario.frame = 1;
		if(StaticStuff.mario.frameDelay > 9)
			StaticStuff.mario.frameDelay = 0;
		//if(StaticStuff.mario.frame > 2)
		//	StaticStuff.mario.frame = 0;
		//if(!StaticStuff.mario.hitFloor)
		//StaticStuff.mario.y += GRAVITY;
		
		  if(fallrate > TERMINAL) {
			  fallrate = TERMINAL;
		  }
		  //birdy += fallrate* 0.688;
		  if(!StaticStuff.mario.hitFloor){
			  StaticStuff.mario.y += fallrate;
              //StaticStuff.mario.x += 5;
			  fallrate += GRAVITY;
		  }
		  
		  if(StaticStuff.mario.y > 498){
			  StaticStuff.mario.y = 498;
			  StaticStuff.mario.hitFloor = true;
			  jumped = false;
		  }
		  
		  
		
		if(StaticStuff.mario.walking && StaticStuff.mario.frameDelay == 9){
			if(StaticStuff.mario.frame < 2)
				StaticStuff.mario.frame++;
			else
				StaticStuff.mario.frame = 0;
		}
		
		if(StaticStuff.mario.walking){
			if(StaticStuff.mario.dir == 1  && StaticStuff.mario.x < 742)
				StaticStuff.mario.x+=2;
			else if(StaticStuff.mario.dir == 0  && StaticStuff.mario.x > 31)
				StaticStuff.mario.x-=2;
		}
		StaticStuff.mario.frameDelay++;
		
		StaticStuff.mario.update();
		for(PowerBrick pb : fallingPowerups)
			pb.update();
		
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
				if(e.getKeyCode() == KeyEvent.VK_SPACE && !jumped){
					StaticStuff.mario.hitFloor = false;
					jumped = true;
					fallrate = -12;
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
	   
	   public void drawGrid(Graphics g){
		   for(int r = 0; r < 800; r+=20)
			   for(int c = 0; c < 600; c+=20)
				   g.drawRect(r, c, 20, 20);
	   }
	   
	   Graphics2D g2;
	   
	   GreenPipe g1 = new GreenPipe(40,1325);
	   GreenPipe g3 = new GreenPipe(1940,1325);
	   
	   public void drawLevel(Graphics g){
		   //floor
		   g2 = (Graphics2D)g;
		   g2.scale(0.2,0.2);
		   Brick b = new Brick();
		   b.y = 2740;
		   for(int i = 0; i < 10000; i+=100){
			   b.x = i;
			   b.NormalBrick(g);
		   }
		   b.y = 2640;
		   for(int i = 0; i < 10000; i+=100){
			   b.x = i;
			   b.NormalBrick(g);
		   }
		   g2.scale(2, 2);
		   g1.GreenPipe(g);
		   g3.GreenPipe(g);
	   }
	   
	   @Override
	   public void paintComponent(Graphics g){
		   g.clearRect(0, 0, 800, 600);
		   if(StaticStuff.mario.dir == 1)
			   StaticStuff.mario.framesRight[StaticStuff.mario.frame].paint(g, StaticStuff.mario.framesRight[StaticStuff.mario.frame].ca, StaticStuff.mario.collisionbox.x, StaticStuff.mario.collisionbox.y);
		   else
			   StaticStuff.mario.framesLeft[StaticStuff.mario.frame].paint(g, StaticStuff.mario.framesLeft[StaticStuff.mario.frame].ca2, StaticStuff.mario.collisionbox.x, StaticStuff.mario.collisionbox.y);
		  
		   // StaticStuff.mario.framesRight[2].paint(g, StaticStuff.mario.framesRight[0].ca, StaticStuff.mario.x, StaticStuff.mario.y);
		  // StaticStuff.mario.framesRight[2].paint(g, StaticStuff.mario.framesRight[1].ca, StaticStuff.mario.x + 100, StaticStuff.mario.y);
		  // StaticStuff.mario.framesRight[2].paint(g, StaticStuff.mario.framesRight[2].ca, StaticStuff.mario.x + 200, StaticStuff.mario.y);
		   
		   //drawGrid(g);
		   drawLevel(g);
		   for(PowerBrick pb : fallingPowerups){
				pb.StarBrick(g);
		   }
		   if(StaticStuff.startSpin){
			   System.out.println("shit");
			   g.setColor(Color.BLACK);
			   g.fillRect(400,400,100,100);
		   }
		   
		   g.fillRect(StaticStuff.mario.collisionbox.x, StaticStuff.mario.collisionbox.y, 60, 60);
	   }
	   
	   public void runGame(){
		   SwingUtilities.invokeLater(new Runnable() {
		         @Override
		         public void run() {
		        	//LevelBuilder.importLvl("src/level1.lvl",lb);
		        	//loadKey();
		        	//();
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
//=======

	
	   /** The Entry main method */
	   public static void main(String[] args) {
	      // Run the GUI codes on the Event-Dispatching thread for thread safety
		   StaticStuff.mario.loadImages();
	        new GameFrame().runGame();
	   }

}
