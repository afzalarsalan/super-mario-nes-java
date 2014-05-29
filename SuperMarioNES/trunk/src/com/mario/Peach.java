package com.mario;

import java.awt.Graphics;

public class Peach {
	
	int x, y;
	ImageHelper im = new ImageHelper();
	
	public Peach(int x1, int y1){
		im.setDim(32,19,1);
		im.parse("null, null, null, null, null, null, null, null, (0:0:0), null, (0:0:0), null, (0:0:0), null, null, null, null, null, null, null, null, null, null, null, null, null, (0:0:0), (107:100:21), (0:0:0), (107:100:21), (0:0:0), (107:100:21), (0:0:0), null, null, null, null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (107:100:21), (107:100:21), (107:100:21), (107:100:21), (107:100:21), (0:0:0), (0:0:0), null, null, null, null, null, null, null, null, (0:0:0), (0:0:0), (255:255:0), (255:255:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:255:0), (0:0:0), null, null, null, null, null, null, null, (0:0:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (0:0:0), null, null, null, null, (0:0:0), (0:0:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (0:0:0), null, null, null, null, (0:0:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (0:0:0), (0:0:0), (255:255:0), (255:255:0), (0:0:0), (0:0:0), (255:255:0), (255:255:0), (0:0:0), null, null, null, null, (0:0:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (0:0:0), (0:0:0), (227:142:45), (0:0:0), (0:0:0), (227:142:45), (0:0:0), (255:255:0), (255:255:0), (0:0:0), null, null, null, (0:0:0), (255:255:0), (255:255:0), (0:0:0), (0:0:0), (0:0:0), (227:142:45), (227:142:45), (0:0:0), (227:142:45), (227:142:45), (0:0:0), (227:142:45), (0:0:0), (0:0:0), null, null, null, null, null, (0:0:0), (255:255:0), (0:0:0), (227:142:45), (0:0:0), (227:142:45), (227:142:45), (0:0:0), (227:142:45), (227:142:45), (0:0:0), (227:142:45), (0:0:0), null, null, null, null, null, null, (0:0:0), (255:255:0), (0:0:0), (40:95:222), (227:142:45), (227:142:45), (227:142:45), (227:142:45), (227:142:45), (227:142:45), (227:142:45), (227:142:45), (0:0:0), null, null, null, null, null, (0:0:0), (255:255:0), (255:255:0), (255:255:0), (255:255:0), (0:0:0), (227:142:45), (227:142:45), (227:142:45), (0:0:0), (0:0:0), (227:142:45), (227:142:45), (0:0:0), (0:0:0), null, null, null, (0:0:0), (255:255:0), (255:255:0), (0:0:0), (255:255:0), (255:255:0), (255:255:0), (0:0:0), (227:142:45), (227:142:45), (227:142:45), (227:142:45), (227:142:45), (0:0:0), (255:255:0), (0:0:0), null, null, null, null, (0:0:0), (0:0:0), (255:255:0), (255:255:0), (255:255:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (213:32:230), (213:32:230), (0:0:0), (0:0:0), (0:0:0), null, null, null, null, null, null, (0:0:0), (255:255:0), (255:255:0), (0:0:0), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (0:0:0), (0:0:0), (0:0:0), null, null, (0:0:0), (255:255:0), (255:255:0), (0:0:0), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (0:0:0), null, (0:0:0), (255:255:0), (255:255:0), (0:0:0), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (0:0:0), null, null, (0:0:0), (255:255:0), (255:255:0), (0:0:0), (0:0:0), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (0:0:0), null, null, null, (0:0:0), (255:255:0), (255:255:0), (0:0:0), (255:255:255), (255:255:255), (0:0:0), (213:32:230), (213:32:230), (213:32:230), (213:32:230), (0:0:0), (255:255:255), (255:255:255), (0:0:0), null, null, null, (0:0:0), (255:255:0), (255:255:0), (255:255:0), (0:0:0), (255:255:255), (255:255:255), (0:0:0), (213:32:230), (213:32:230), (213:32:230), (0:0:0), (0:0:0), (255:255:255), (255:255:255), (0:0:0), null, null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (255:255:255), (255:255:255), (255:255:255), (0:0:0), (213:32:230), (213:32:230), (0:0:0), (255:255:255), (255:255:255), (0:0:0), null, null, null, null, null, null, null, (0:0:0), (100:30:186), (0:0:0), (255:255:255), (255:255:255), (255:255:255), (0:0:0), (0:0:0), (255:255:255), (255:255:255), (0:0:0), null, null, null, null, null, null, null, null, (0:0:0), (100:30:186), (100:30:186), (0:0:0), (255:255:255), (255:255:255), (0:0:0), (255:255:255), (255:255:255), (255:255:255), (0:0:0), null, null, null, null, null, null, null, (0:0:0), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (0:0:0), (255:255:255), (0:0:0), (255:255:255), (255:255:255), (0:0:0), (0:0:0), null, null, null, null, null, null, null, (0:0:0), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (100:30:186), (100:30:186), (0:0:0), null, null, null, null, null, (0:0:0), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (0:0:0), null, null, null, null, null, (0:0:0), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (0:0:0), null, null, null, null, null, (0:0:0), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (0:0:0), (0:0:0), null, null, null, (0:0:0), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (0:0:0), null, null, null, (0:0:0), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (0:0:0), null, null, null, (0:0:0), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (100:30:186), (0:0:0), null, null, null, (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), (0:0:0), null");
		x=x1; y=y1;
	}
	
	public void draw(Graphics g){
		im.paint(g, im.ca, x, y);
	}
}
