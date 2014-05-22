package com.mario;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LevelBuilder {
	
	String[][] lvl;
	//there are 28 rows and 39 cols

	public void importLvl(String filename){
		try{
		Scanner sc = new Scanner(new File(filename));
		int rows = sc.nextInt();
		int cols = sc.nextInt();
		lvl = new String[rows][cols];
		sc.nextLine();
		for(int i = 0; i < rows; i++){
			String line = sc.nextLine();
			for(int a = 0; a < line.length(); a++)
				lvl[i][a] = ""+line.charAt(a);
		}
		}catch(IOException e){
			System.out.println("Failed to import " + filename);
		}
	}
}
