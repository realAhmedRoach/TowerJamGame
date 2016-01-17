package dev.thetechnokid.gather;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import dev.thetechnokid.gather.gfx.Screen;
import dev.thetechnokid.gather.input.Keyboard;
import dev.thetechnokid.gather.logic.LogicManager;
import dev.thetechnokid.gather.util.Sound;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;

	public static final String NAME = "Gather";

	private static Game currGame;

	public static Game getCurrentGame() {
		return currGame;
	}

	public static void setCurrentGame(Game currGame) {
		Game.currGame = currGame;
	}

	private JFrame frame;
	private Screen screen;
	private LogicManager logicManager;
	private Keyboard key;
	private Sound bg;

	public boolean running = false;
	public int tickCount = 0;

	public Game() {
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));
		setPreferredSize(new Dimension(WIDTH, HEIGHT));

		key = new Keyboard();
		logicManager = new LogicManager();
		bg = new Sound("res/music/gather_bg.wav");

		frame = new JFrame(NAME);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.add(this, BorderLayout.CENTER);

		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		addKeyListener(key);
		requestFocus();
	}

	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}

	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;
		// long lastTimer = System.currentTimeMillis();
		double delta = 0;

		screen = new Screen(WIDTH, HEIGHT);
		
		bg.loop();

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			while (delta >= 1) {
				tick();
				delta--;
			}
			render();

			// if (System.currentTimeMillis() - lastTimer >= 1000) {
			// lastTimer += 1000;
			// System.out.println(ticks + " ticks, " + frames + " frames");
			// frames = 0;
			// ticks = 0;
			// }
		}
		bg.stop();
	}

	public void tick() {
		key.tick();
		screen.tick();
		logicManager.tick();
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.clearRect(0, 0, getWidth(), getHeight());

		getScreen().render(g);

		g.dispose();
		bs.show();
	}

	public static void main(String[] args) {
		Game s = new Game();
		setCurrentGame(s);
		s.start();
	}

	public Screen getScreen() {
		return screen;
	}

	public LogicManager getLogicManager() {
		return logicManager;
	}

	public Keyboard getKeyboard() {
		return key;
	}
}