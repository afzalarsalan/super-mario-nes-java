package com.mario;

import java.io.IOException;
import java.io.InputStream;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class SoundEffect {

	
	String file = "";
	AudioStream as = null;
	
	public SoundEffect(String file){
		this.file = file;
		InputStream test = getClass().getResourceAsStream("/com/mario/"+file);
		try {
			as = new AudioStream(test);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void play(){
		AudioPlayer.player.start(as);
	}
	
	public void stop(){
		AudioPlayer.player.stop(as);
	}
}
