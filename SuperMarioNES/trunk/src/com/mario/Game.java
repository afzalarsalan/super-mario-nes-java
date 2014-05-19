package com.mario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;

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
    private Screen screen;
    private BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
    private BufferStrategy bufferStrategy;

    public Game(){
        Dimension size = new Dimension(width * scale, height * scale);
        setPreferredSize(size);
        setMaximumSize(size);
        setMinimumSize(size);
        //screen = new Screen(width,height);
        frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("Mario");
        frame.setLayout(new BorderLayout());
        frame.add(this,BorderLayout.CENTER);
        frame.pack();
        //frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                MainMenu.setVisible(true);
                frame.dispose();
            }
        });

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
        bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            bufferStrategy = getBufferStrategy();
            return;
        }
        createBufferStrategy(3);
        bufferStrategy = getBufferStrategy();
        Graphics g = bufferStrategy.getDrawGraphics();
        g.setColor(Color.BLACK);
        koompaTrooper.MovingLeft2(g);
        g.dispose();
        bufferStrategy.show();
    }

    /*public static void main(String[] args){
        Game game = new Game();
        game.start();
    }*/
}
