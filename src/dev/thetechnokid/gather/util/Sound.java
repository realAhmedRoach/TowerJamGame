package dev.thetechnokid.gather.util;

import java.net.URL;

import javax.sound.sampled.*;

import dev.thetechnokid.gather.Game;

public class Sound implements Runnable {

	private Thread thread;
	private URL sound;
	private Clip clip;

	public Sound(String name) {
		this.sound = Game.class.getResource("res/music/gather_"+name+".wav");
		thread = new Thread(this, "Sound");
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() throws Exception {
		AudioInputStream ais = AudioSystem.getAudioInputStream(sound);
		clip = AudioSystem.getClip();
		clip.open(ais);
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}

	public void start() {
		thread.start();
	}

	@Override
	public void run() {
		clip.start();
	}

}
