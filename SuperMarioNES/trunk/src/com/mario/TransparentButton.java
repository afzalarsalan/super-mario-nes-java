package com.mario;

import javax.swing.*;

/**
 * Created by arsalan on 5/10/14. Made for Comp Sci II project
 */
public class TransparentButton extends JButton{
    public TransparentButton(String text){
        super(text);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setOpaque(false);
    }
}
