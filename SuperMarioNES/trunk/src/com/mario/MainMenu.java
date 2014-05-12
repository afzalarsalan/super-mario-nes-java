package com.mario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * Created by arsalan on 5/10/14.
 */
public class MainMenu {
    private JPanel MenuPage;
    private BackgroundPanel backgroundPanel1;
    private TransparentButton buttonTransparentButton;
    private TransparentButton buttonTransparentButton1;
    private TransparentButton buttonTransparentButton2;
    private Font marioFont;

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainMenu");
        frame.setContentPane(new MainMenu().MenuPage);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setSize(800,600);
        frame.setVisible(true);
    }

    public MainMenu(){
        initializeFonts();
        buttonTransparentButton.setFont(marioFont);
        buttonTransparentButton1.setFont(marioFont);
        buttonTransparentButton2.setFont(marioFont);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        try {
            backgroundPanel1 = new BackgroundPanel(ImageIO.read(getClass().getResource("mainmenubackground-adjust.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
            backgroundPanel1 = new BackgroundPanel(Color.BLUE);
        }
        buttonTransparentButton = new TransparentButton("");
        buttonTransparentButton1 = new TransparentButton("");
        buttonTransparentButton2 = new TransparentButton("");
    }

    private void initializeFonts(){
        try {
            Font customfont = Font.createFont(Font.TRUETYPE_FONT,MainMenu.class.getResourceAsStream("fonts/prstart.ttf")).deriveFont(24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,MainMenu.class.getResourceAsStream("fonts/prstart.ttf")));
            marioFont = customfont;

        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}