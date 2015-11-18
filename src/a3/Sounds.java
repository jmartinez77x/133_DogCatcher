package a3;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;

public class Sounds{
	private static Sounds gameSounds;
	
	private AudioClip catCollision;
	private AudioClip fightCollision;
	private AudioClip scoopNet;
	private AudioClip backGround;
	
	private Sounds(){
		String soundFolder = "." + File.separator + "src" + File.separator + "sounds" + File.separator;
		String fileName, filePath;
		
		File file;
		
		fileName = "CatCollision.wav";
		filePath = soundFolder + fileName;
		try{
			file = new File(filePath);
			if(file.exists()){
				catCollision = Applet.newAudioClip(new File(filePath).toURI().toURL() );
			}else{
				throw new RuntimeException("Sound: File not found: " + filePath);
			}
		} catch(MalformedURLException e){
			throw new RuntimeException("Sound: malformed URL: " + e);
		}
		
		fileName = "FightCollision.wav";
		filePath = soundFolder + fileName;
		try{
			file = new File(filePath);
			if(file.exists()){
				fightCollision = Applet.newAudioClip(new File(filePath).toURI().toURL() );
			}else{
				throw new RuntimeException("Sound: File not found: " + filePath);
			}
		} catch(MalformedURLException e){
			throw new RuntimeException("Sound: malformed URL: " + e);
		}
		
		fileName = "ScoopNet.wav";
		filePath = soundFolder + fileName;
		try{
			file = new File(filePath);
			if(file.exists()){
				scoopNet = Applet.newAudioClip(new File(filePath).toURI().toURL() );
			}else{
				throw new RuntimeException("Sound: File not found: " + filePath);
			}
		} catch(MalformedURLException e){
			throw new RuntimeException("Sound: malformed URL: " + e);
		}
		
		fileName = "BackGround.wav";
		filePath = soundFolder + fileName;
		try{
			file = new File(filePath);
			if(file.exists()){
				backGround = Applet.newAudioClip(new File(filePath).toURI().toURL() );
			}else{
				throw new RuntimeException("Sound: File not found: " + filePath);
			}
		} catch(MalformedURLException e){
			throw new RuntimeException("Sound: malformed URL: " + e);
		}

	}
	public static Sounds getInstance(){
		if(gameSounds == null)
			gameSounds = new Sounds();
		return gameSounds;
	}
	public void playCatCollisionClip(){
		catCollision.play();
	}
	public void playFightCollisionClip(){
		fightCollision.play();
	}
	public void playScoopNetClip(){
		scoopNet.play();
	}
	public void playBackGroundClip(){
		backGround.loop();
	}
	public void stopBackGroundClip(){
		backGround.stop();
	}
}
