
/*// Created by 741638 on 5/19/2014.

import com.mario.ImageHelper;

import java.awt.*;

public class MushroomPowerUp {

    // @param args the command line arguments

    public static void main(String[] args) {

        MushroomPower obj=new MushroomPower();


    }

}
class MushroomPower {


    ImageHelper m1 = new ImageHelper();

    MushroomPower() {


    }

    public void loadImages() {

        m1.setDim(16, 13, 2);
        m1.parse("null, null, null, null, null, (240:62:70), (240:62:70), (240:62:70), (240:62:70)" + ", (240:62:70), (240:62:70), (240:62:70), null, null, null, null, null, null, null" +
                "l, null, null, (240:62:70), (240:62:70), (240:62:70), (226:226:226), (226:226:22" +
                "6), (226:226:226), (240:62:70), (240:62:70), (240:62:70), null, null, null, null" +
                ", null, null, (240:62:70), (240:62:70), (240:62:70), (240:62:70), (226:226:226)," +
                " (226:226:226), (226:226:226), (226:226:226), (226:226:226), (240:62:70), (240:6" +
                "2:70), (240:62:70), (240:62:70), null, null, null, (240:62:70), (240:62:70), (24" +
                "0:62:70), (240:62:70), (226:226:226), (226:226:226), (226:226:226), (226:226:226" +
                "), (226:226:226), (226:226:226), (226:226:226), (240:62:70), (240:62:70), (240:6" +
                "2:70), (240:62:70), null, (240:62:70), (226:226:226), (240:62:70), (240:62:70),  " +
                "(240:62:70), (226:226:226), (226:226:226), (226:226:226), (226:226:226), (226:22  " +
                "6:226), (226:226:226), (226:226:226), (240:62:70), (240:62:70), (240:62:70), (22  " +
                "6:226:226), (240:62:70), (226:226:226), (226:226:226), (226:226:226), (240:62:70  " +
                "), (240:62:70), (226:226:226), (226:226:226), (226:226:226), (226:226:226), (226  " +
                ":226:226), (226:226:226), (226:226:226), (240:62:70), (240:62:70), (226:226:226)  " +
                ", (226:226:226), (226:226:226), (226:226:226), (226:226:226), (226:226:226), (24  " +
                "0:62:70), (240:62:70), (226:226:226), (226:226:226), (226:226:226), (226:226:226  " +
                "), (226:226:226), (226:226:226), (226:226:226), (240:62:70), (240:62:70), (226:2  " +
                "26:226), (226:226:226), (226:226:226), (226:226:226), (226:226:226), (226:226:22  " +
                "6), (240:62:70), (240:62:70), (240:62:70), (226:226:226), (226:226:226), (226:22  " +
                "6:226), (226:226:226), (226:226:226), (240:62:70), (240:62:70), (240:62:70), (22  " +
                "6:226:226), (226:226:226), (226:226:226), (226:226:226), (226:226:226), (240:62:  " +
                "70), (240:62:70), (240:62:70), (240:62:70), (240:62:70), (226:226:226), (226:226  " +
                ":226), (226:226:226), (240:62:70), (240:62:70), (240:62:70), (240:62:70), (240:6  " +
                "2:70), (226:226:226), (226:226:226), (226:226:226), (240:62:70), (240:62:70), (1  " +
                "23:9:14), (123:9:14), (123:9:14), (123:9:14), (123:9:14), (123:9:14), (123:9:14)  " +
                ", (123:9:14), (123:9:14), (123:9:14), (123:9:14), (240:62:70), (240:62:70), (226  " +
                ":226:226), (240:62:70), (240:62:70), (123:9:14), (123:9:14), (123:9:14), (123:9:  " +
                "14), (123:9:14), (123:9:14), (123:9:14), (123:9:14), (123:9:14), (123:9:14), (12  " +
                "3:9:14), (123:9:14), (123:9:14), (240:62:70), (240:62:70), (240:62:70), (123:9:1  " +
                "4), (123:9:14), (123:9:14), (123:9:14), (123:9:14), (197:156:92), (197:156:92),  " +
                "(197:156:92), (197:156:92), (197:156:92), (123:9:14), (123:9:14), (123:9:14), (1  " +
                "23:9:14), (123:9:14), (240:62:70), null, (123:9:14), (123:9:14), (123:9:14), (19  " +
                "7:156:92), (197:156:92), (92:92:92), (197:156:92), (197:156:92), (197:156:92), (  " +
                "92:92:92), (197:156:92), (197:156:92), (123:9:14), (123:9:14), (123:9:14), null,  " +
                " null, null, (123:9:14), (197:156:92), (197:156:92), (197:156:92), (32:32:32), (  " +
                "197:156:92), (197:156:92), (197:156:92), (32:32:32), (197:156:92), (197:156:92),  " +
                " (197:156:92), (123:9:14), null, null, null, null, null, (197:156:92), (197:156:  " +
                "92), (197:156:92), (32:32:32), (197:156:92), (197:156:92), (197:156:92), (32:32:  " +
                "32), (197:156:92), (197:156:92), (197:156:92), null, null, null, null, null, nul  " +
                "l, null, (197:156:92), (197:156:92), (197:156:92), (197:156:92), (197:156:92),(  " +
                "197:156:92), (197:156:92), (197:156:92), (197:156:92), null, null, null, null, n  " +
                "ull, null, null, null, null, (197:156:92), (197:156:92), (197:156:92), (197:156:  " +
                "92), (197:156:92), (197:156:92), (197:156:92), null, null, null, null, null");
    }

    public void draw(Graphics g) {
        m1.paint(g, m1, 100, 100);

    }
}*/

