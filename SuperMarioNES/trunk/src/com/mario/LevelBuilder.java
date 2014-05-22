package com.mario;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

public class LevelBuilder {
	
	int rows;
	int cols;
	String[][] lvl;
	//there are 28 rows and 39 cols

    public LevelBuilder(String filename) throws IOException {
        Scanner sc = new Scanner(getClass().getResourceAsStream(filename));
        rows = sc.nextInt();
        cols = sc.nextInt();
        lvl = new String[rows][cols];
        sc.nextLine();
        for(int i = 0; i < rows; i++){
            String line = sc.nextLine();
            for(int a = 0; a < line.length(); a++)
                lvl[i][a] = ""+line.charAt(a);
        }
    }

/*	public static void importLvl(String filename,LevelBuilder obj){
		try{
		Scanner sc = new Scanner(new File(filename));
		obj.rows = sc.nextInt();
		obj.cols = sc.nextInt();
		obj.lvl = new String[obj.rows][obj.cols];
		sc.nextLine();
		for(int i = 0; i < obj.rows; i++){
			String line = sc.nextLine();
			for(int a = 0; a < line.length(); a++)
				obj.lvl[i][a] = ""+line.charAt(a);
		}
		}catch(IOException e){
			System.out.println("Failed to import " + filename);
		}
	}*/
}
