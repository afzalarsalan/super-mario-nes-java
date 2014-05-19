package com.mario;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by Arsalan Afzal on 5/18/14. Made for Comp Sci II project
 */
public class Game extends Canvas implements Runnable{

    public static int width = 200;
    public static int height = width / 4 * 3;
    public static int scale = 4;

    private Thread thread;
    private JFrame frame;
    private boolean isRunning;
    public KoompaTrooper koompaTrooper;

    public Game(){
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Mario");
        frame.setLayout(new BorderLayout());
        frame.add(this,BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public synchronized void start(){
        isRunning = true;
        thread = new Thread(this, "Screen");
        thread.start();
    }

    public synchronized void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        koompaTrooper = new KoompaTrooper(20,10);
        while(isRunning){
            update();
            render();
        }

    }

    public void update() {

    }

    public void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bufferStrategy.getDrawGraphics();
        g.setColor(Color.BLACK);
        koompaTrooper.MovingLeft2(g);
        g.dispose();
        bufferStrategy.show();
    }

    public static void main(String[] args){
        Game game = new Game();
        game.start();
    }
}
