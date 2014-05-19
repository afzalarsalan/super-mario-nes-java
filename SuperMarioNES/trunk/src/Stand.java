import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Created by 741638 on 5/16/2014.
 */
public class Stand {
    public static void main(String[] args) {
        // TODO code application logic here
        MarioStand panel = new   MarioStand(300,90);


        JFrame application = new JFrame();                            // the program itself
        application.setBackground(Color.WHITE);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // set frame to exit
        // when it is closed
        application.add(panel);


        application.setSize(800, 800);         // window is 500 pixels wide, 400 high
        application.setVisible(true);
    }




}
class MarioStand  extends JPanel{
    int i = 0, x, y;


    MarioStand(int x, int y) {

        setBackground(Color.WHITE);


        this.x = x;
        this.y = y;


    }

    public void paintComponent(Graphics g) {


    }
}
