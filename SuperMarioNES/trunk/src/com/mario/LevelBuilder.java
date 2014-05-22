package com.mario;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

public class LevelBuilder {
	
	String[][] lvl;
	//there are 28 rows and 39 cols

	public static void importLvl(String filename,LevelBuilder obj){
		try{
		Scanner sc = new Scanner(new File(filename));
		obj.lvl = new String[sc.nextInt()][sc.nextInt()];
		int numLines = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < numLines; i++){
			String line = sc.nextLine();
			for(int a = 0; a < line.length(); a++)
				obj.lvl[i][a] = ""+line.charAt(a);
		}
		}catch(IOException e){
			System.out.println("Failed to import " + filename);
		}
	}
}
