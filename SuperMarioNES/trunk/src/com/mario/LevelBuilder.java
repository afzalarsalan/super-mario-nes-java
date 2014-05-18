package com.mario;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LevelBuilder {
	
	String[][] lvl;

	public void importLvl(String filename){
		try{
		Scanner sc = new Scanner(new File(filename));
		lvl = new String[sc.nextInt()][sc.nextInt()];
		int numLines = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < numLines; i++){
			String line = sc.nextLine();
			for(int a = 0; a < line.length(); a++)
				lvl[i][a] = ""+line.charAt(a);
		}
		}catch(IOException e){
			System.out.println("Failed to import " + filename + ".lvl");
		};
	}
}
