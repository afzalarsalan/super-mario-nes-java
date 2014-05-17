package com.mario;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;


public class ImageHelper {
	
	int size;
	Color[][] ca;
	
	public void setDim(int dimX, int dimY, int size){
		ca = new Color[dimX][dimY];
		this.size = size;
	}
	
	public void parse(String s){
		int tempr, tempc;
		tempr = tempc = 0;
		String[] s1 = s.split(", ");
		for(int i = 0; i < s1.length; i++)
		{
			if(tempc >= ca[0].length){
				tempr++;
				tempc = 0;
			}
			if(!s1[i].equals("null")){
				String s2 = s1[i].substring(1, s1[i].length()-1);
				String s3[] = s2.split(":");
				ca[tempr][tempc] = new Color(Integer.parseInt(s3[0]), Integer.parseInt(s3[1]), Integer.parseInt(s3[2]));
			}
			tempc++;
		}
	}

	public void paint(Graphics g, Color[][] ca, int x, int y){
		int tempx = 0;
		int tempy = 0;
		for(int r = 0; r < ca.length; r++){
			for(int c = 0; c < ca[0].length; c++){
				if(ca[r][c] != null){
					g.setColor(ca[r][c]);
					g.fillRect(x+tempx, y+tempy, size, size);
				}
				tempx+=size;
			}
			tempx = 0;
			tempy+=size;
		}
	}
	
}
