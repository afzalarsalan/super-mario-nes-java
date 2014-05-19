package com.mario;

import java.awt.Color;
import java.awt.Graphics;


public class ImageHelper {
	
	int size;
	Color[][] ca;
	Color[][] ca2;
	
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
	
	public void flip(){
		ca2 = new Color[ca.length][ca[0].length];
		for(int r = 0; r < ca2.length; r++){
			for(int c = 0; c < ca2[r].length; c++)
			{
				//Color temp = ca[r][c];
				ca2[r][c] = ca[r][ca[r].length-1-c];
				//ca2[r][ca2[r].length-1-c] = temp;
			}
		}
	}
	
}
