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
    ArrayList<Brick> level = new ArrayList();
    ArrayList<Mushroom> mushrooms = new ArrayList();
    static ArrayList<Bullet> bullets = new ArrayList();
    
    public double GRAVITY = .6;
    public double TERMINAL = 20;
    public static double fallrate = 0;
    public static int DELAY = 1000/60;
    
    public static boolean scrollmode = false;
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
                            //System.out.println(updates + "ups, " + frames + " fps");
                            frame1.setTitle("SuperMarioNES" + " | " + updates + "ups, " + frames + " fps");
                            updates = 0;
                            frames = 0;
                        }  // Refresh the display
                    } while (!animationThread.isInterrupted());
                }
            }
        };
       // loadLevel();
        animationThread.start();  // start the thread to run animation
    }
    
    public void loadLevel(){
    	level.add(new Brick(100, 510));
    	level.add(new Brick(120, 510));
    	level.add(new Brick(140, 510));
    	level.add(new Brick(160, 510));
    	level.add(new Brick(160, 490));
    	level.add(new Brick(160, 470));
    	level.add(new Brick(140, 490));
    	
    	level.add(new Brick(260, 490));
    	//level.add(new PowerBrick(125, 420));
    	//level.add(new PowerBrick(150, 420));
    }
    
    int cnt = 0;
    int nextSpawn = 0;
    int spawnRate = 0;
    
    public void addMushroom(){
    	int ran = (int)(Math.random()*2);
    	if(ran == 0)
    		mushrooms.add(new Mushroom(33, 513));
    	else
    		mushrooms.add(new Mushroom(740, 513));
    }
    
    //Mushroom m = new Mushroom(500,513);
	
	public void update(){
		nextSpawn++;
		
		if(nextSpawn > 500){
			nextSpawn = spawnRate;
			if(spawnRate < 450)
				spawnRate++;
		}
	
		//mario code
		if(StaticStuff.startSpin){
			Powerup p = StaticStuff.powerups.get((int)(Math.random() * 3));
			StaticStuff.mario.powerups.add(p);
			System.out.println(p);
			StaticStuff.startSpin = false;
		}
		
		//System.out.println(StaticStuff.mario.collisionbox.x + " " + StaticStuff.mario.x);
		//if(cnt == 1000){
			//cnt = 0;
		//}
		
		if(nextSpawn == 500){
			addMushroom();
		}
		
		//cnt++;
		//cnt2++;
		
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
		  }
			  if(StaticStuff.mario.hitFloor){
				  jumped = false;
				  //StaticStuff.jump.stop();
			  }
		
		if(StaticStuff.mario.walking && StaticStuff.mario.frameDelay == 9){
			if(StaticStuff.mario.frame < 2)
				StaticStuff.mario.frame++;
			else
				StaticStuff.mario.frame = 0;
		}
		
		if(StaticStuff.mario.walking){
			if(scrollmode){
			if(StaticStuff.mario.dir == 1  && StaticStuff.mario.x < 400)
				StaticStuff.mario.x+=2;
			else if(tempx < 0 && StaticStuff.mario.dir == 0  && StaticStuff.mario.x > 398)
				StaticStuff.mario.x-=2;
			else if(tempx == 8 && StaticStuff.mario.dir == 0 && StaticStuff.mario.x > 30)
				StaticStuff.mario.x-=4;
			}else{
				if(StaticStuff.mario.dir == 1  && StaticStuff.mario.x < 742)
					StaticStuff.mario.x+=2;
				else if(StaticStuff.mario.dir == 0  && StaticStuff.mario.x > 30)
					StaticStuff.mario.x-=2;
			}
			//else
			//if(tempx >= 0 && StaticStuff.mario.dir == 0  && StaticStuff.mario.x > 30)
			//	StaticStuff.mario.x-=2;
			
		}
		StaticStuff.mario.frameDelay++;
		
		StaticStuff.mario.update();
		for(Brick pb : level)
			pb.update();
		for(Mushroom m : mushrooms)
			m.update();
		for(Bullet b : bullets)
		  if(b.x > -20 || b.x < 820)
			  b.update();
	}

    public void stop(){
        isRunning = false;
    }
    
    static SoundEffect jump = new SoundEffect("Jump.wav");
	
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
					jump =new SoundEffect("Jump.wav");
					jump.play();
					StaticStuff.mario.hitFloor = false;
					jumped = true;
		 			fallrate = -12;
				}
				if(e.getKeyCode() == KeyEvent.VK_S){
					//StaticStuff.mario.ammo--;
					if(StaticStuff.mario.ammo > 0)
						bullets.add(new Bullet(StaticStuff.mario.dir));
					if(StaticStuff.mario.ammo < 0)
						StaticStuff.mario.ammo = 0;
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
	   
	   GreenPipe g1 = new GreenPipe(30,1060);
	   GreenPipe g3 = new GreenPipe(1560,1060);
	   
	   static int tempx = 0;
	   
	   public void drawLevel(Graphics g){
		   //floor
		   g2 = (Graphics2D)g;
		  // g2.scale(0.2,0.2);
		   Brick b = new Brick();
		   b.y = 530;
		   if(scrollmode){
		   if(StaticStuff.mario.x >= 400 && StaticStuff.mario.walking)
			   tempx-=8;
		   if(tempx <= 0 && StaticStuff.mario.x <= 398 && StaticStuff.mario.walking)
			   tempx+=8;
		   }
		   //System.out.println(tempx);
		   if(scrollmode){
		   for(int i = tempx; i < 10000; i+=100){
			   b.x = i;
			   b.draw(g);
		   }
		   b.y = 518;
		   for(int i = tempx; i < 10000; i+=100){
			   b.x = i;
			   b.draw(g);
		   }
		   }else{
			   for(int i = 0; i < 790; i+=20){
				   b.x = i;
				   b.draw(g);
			   }
			   b.y = 550;
			   for(int i = 0; i < 790; i+=20){
				   b.x = i;
				   b.draw(g);
			   }
		   }
		 //  g2.scale(5, 5);
		   g2.scale(.5, .5);
		   g1.GreenPipe(g);
		   g3.GreenPipe(g);
		   g2.scale(2,2);
	   }
	   Cloud c1 = new Cloud(100,50);
	   Cloud c2 = new Cloud(400, 50);
	   Cloud c3 = new Cloud(600, 120);
	   Cloud c4 = new Cloud(250, 120);
	   
	   @Override
	   public void paintComponent(Graphics g){
		   g.clearRect(0, 0, 800, 600);
		   g.setColor(new Color(150,164,227));
		   g.fillRect(0, 0, 800, 600);
		   c1.draw(g);
		   c2.draw(g);
		   c3.draw(g);
		   c4.draw(g);
		   if(StaticStuff.mario.dir == 1)
			   StaticStuff.mario.framesRight[StaticStuff.mario.frame].paint(g, StaticStuff.mario.framesRight[StaticStuff.mario.frame].ca, StaticStuff.mario.collisionbox.x, StaticStuff.mario.collisionbox.y);
		   else
			   StaticStuff.mario.framesLeft[StaticStuff.mario.frame].paint(g, StaticStuff.mario.framesLeft[StaticStuff.mario.frame].ca2, StaticStuff.mario.collisionbox.x, StaticStuff.mario.collisionbox.y);
		  
		   // StaticStuff.mario.framesRight[2].paint(g, StaticStuff.mario.framesRight[0].ca, StaticStuff.mario.x, StaticStuff.mario.y);
		  // StaticStuff.mario.framesRight[2].paint(g, StaticStuff.mario.framesRight[1].ca, StaticStuff.mario.x + 100, StaticStuff.mario.y);
		  // StaticStuff.mario.framesRight[2].paint(g, StaticStuff.mario.framesRight[2].ca, StaticStuff.mario.x + 200, StaticStuff.mario.y);
		   
		   //drawGrid(g);
		   drawLevel(g);
		   for(Brick pb : level){
				pb.draw(g);
				//g.fillRect(pb.collisionbox.x,pb.collisionbox.y,20, 20);
		   }
		   for(Mushroom m : mushrooms){
			   m.draw(g);
			   //g.fillRect(m.collisionbox.x+6,m.collisionbox.y,14,30);
		   }
		   
		   MushroomPower p = new MushroomPower();
		   p.draw(g, 50, 50);
		   
		   for(Bullet b : bullets)
				b.draw(g);
		   
		//   if(StaticStuff.startSpin){
			  // g.setColor(Color.BLACK);
			   //g.fillRect(400,400,100,100);
		 //  }
		  // x,y, 20, 30
		   //g.fillRect(StaticStuff.mario.collisionbox.x+3, StaticStuff.mario.collisionbox.y, 20, 32);
	   }
	   
	   public void loadImgs(){
		   	 StaticStuff.brickim.setDim(11, 11, 2);
		   	 StaticStuff.brickim.parse("(0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (105:61:26), (105:61:26), (105:61:26), (105:61:26), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0)");
		   	 StaticStuff.bulletim.setDim(10, 10, 1);
		   	 StaticStuff.bulletim.parse("null, null, (255:255:0), (222:149:22), (255:0:0), (255:0:0), (222:149:22), (255:255:0), null, null, null, (255:255:0), (222:149:22), (255:0:0), (255:255:0), (255:255:0), (255:0:0), (222:149:22), (255:255:0), null, (255:255:0), (222:149:22), (255:0:0), (255:255:0), (222:149:22), (222:149:22), (255:255:0), (255:0:0), (222:149:22), (255:255:0), (222:149:22), (255:0:0), (255:255:0), (222:149:22), (222:149:22), (222:149:22), (222:149:22), (255:255:0), (255:0:0), (222:149:22), (255:0:0), (255:255:0), (222:149:22), (255:255:0), (255:0:0), (255:0:0), (255:255:0), (222:149:22), (255:255:0), (255:0:0), (255:0:0), (255:255:0), (222:149:22), (255:255:0), (255:0:0), (255:0:0), (255:255:0), (222:149:22), (255:255:0), (255:0:0), (222:149:22), (255:0:0), (255:255:0), (222:149:22), (222:149:22), (222:149:22), (222:149:22), (255:255:0), (255:0:0), (222:149:22), (255:255:0), (222:149:22), (255:0:0), (255:255:0), (222:149:22), (222:149:22), (255:255:0), (255:0:0), (222:149:22), (255:255:0), null, (255:255:0), (222:149:22), (255:0:0), (255:255:0), (255:255:0), (255:0:0), (222:149:22), (255:255:0), null, null, null, (255:255:0), (222:149:22), (255:0:0), (255:0:0), (222:149:22), (255:255:0), null, null");
		   	 
		   	 ImageHelper frame1 = new ImageHelper();
		   	 ImageHelper frame2 = new ImageHelper();
		   	 
		   	 frame1.setDim(25,25,1);
		   	 frame1.parse("null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (255:138:0), (255:138:0), (255:138:0), (255:138:0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, (255:138:0), (0:0:0), (0:0:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (0:0:0), (0:0:0), (255:138:0), null, null, null, null, null, null, null, null, null, null, null, null, (255:138:0), (255:138:0), (255:138:0), (255:255:255), (0:0:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (0:0:0), (255:255:255), (255:138:0), (255:138:0), (255:138:0), null, null, null, null, null, null, null, null, null, null, null, (255:138:0), (255:138:0), (255:138:0), (255:255:255), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:255:255), (255:138:0), (255:138:0), (255:138:0), null, null, null, null, null, null, null, null, null, null, (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:255:255), (0:0:0), (255:255:255), (255:138:0), (255:138:0), (255:255:255), (0:0:0), (255:255:255), (255:138:0), (255:138:0), (255:138:0), (255:138:0), null, null, null, null, null, null, null, null, null, (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:255:255), (255:255:255), (255:255:255), (255:138:0), (255:138:0), (255:255:255), (255:255:255), (255:255:255), (255:138:0), (255:138:0), (255:138:0), (255:138:0), null, null, null, null, null, null, null, null, null, (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:138:0), null, null, null, null, null, null, null, null, null, null, (255:138:0), (255:138:0), (255:138:0), (255:138:0), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:138:0), (255:138:0), (255:138:0), (255:138:0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (255:187:128), (255:187:128), (255:187:128), (255:187:128), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (255:187:128), null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null");
		   	 frame2.setDim(20, 20, 1);
		   	 frame2.parse("null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (247:139:4), (247:139:4), (247:139:4), (247:139:4), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), null, null, null, null, null, null, null, null, null, null, null, null, null, (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), null, null, null, null, null, null, null, null, null, null, null, (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), null, null, null, null, null, null, null, null, null, (247:139:4), (0:0:0), (0:0:0), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (0:0:0), (0:0:0), (247:139:4), null, null, null, null, null, null, null, (247:139:4), (247:139:4), (247:139:4), null, (0:0:0), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (0:0:0), null, (247:139:4), (247:139:4), (247:139:4), null, null, null, null, null, null, (247:139:4), (247:139:4), (247:139:4), null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null, (247:139:4), (247:139:4), (247:139:4), null, null, null, null, null, null, (247:139:4), (247:139:4), (247:139:4), null, (0:0:0), null, (247:139:4), (247:139:4), null, (0:0:0), null, (247:139:4), (247:139:4), (247:139:4), null, null, null, null, null, null, (247:139:4), (247:139:4), (247:139:4), null, null, null, (247:139:4), (247:139:4), null, null, null, (247:139:4), (247:139:4), (247:139:4), null, null, null, null, null, null, (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), (247:139:4), null, null, null, null, null, null, (247:139:4), (247:139:4), (247:139:4), (247:139:4), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (247:139:4), (247:139:4), (247:139:4), (247:139:4), null, null, null, null, null, null, null, null, null, (238:195:143), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (238:195:143), null, null, null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (238:195:143), null, null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (238:195:143), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (238:195:143), (238:195:143), (238:195:143), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (238:195:143), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null");
		   	 StaticStuff.mushim[0] = frame1;
		   	 StaticStuff.mushim[1] = frame2;
	   }
	   
	   public void runGame(){
		   SwingUtilities.invokeLater(new Runnable() {
		         @Override
		         public void run() {
		        	//LevelBuilder.importLvl("src/level1.lvl",lb);
		        	//loadKey();
		        	//();
		        	// int x = (int)(Math.random()*720 + 30);
		        	 loadImgs();
		        	 StaticStuff.powerups.add(new Star());
		        	 StaticStuff.powerups.add(new MushroomPower());
		        	 StaticStuff.powerups.add(new Coin());
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
		   Music m = new Music("Sounds/back1.wav");
		   m.music();
	        new GameFrame().runGame();
	   }

}
