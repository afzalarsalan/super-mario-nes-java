package com.mario;

/**
 * Created by arsalan on 5/18/14. Made for Comp Sci II project
 */
public class Screen {

    private int width, height;
    public int[] pixels;

    public int[] tiles = new int[64*64];

    public Screen(int width,int height){
        this.width = width;
        this.height = height;
        pixels = new int[width*height];
    }

    public void render(){
        for(int y=0;y<height;y++){
            for(int x = 0; x<width;x++){
                int tileIndex = (x >> 3) + (y >> 3) * 64;
                pixels[x+y*width] = tiles[tileIndex];

            }
        }
    }

    public void clear(){
        for(int i =0; i<pixels.length;i++){
            pixels[i] = 0;
        }

    }
}
