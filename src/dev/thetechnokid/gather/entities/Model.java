package dev.thetechnokid.gather.entities;

import java.awt.*;
import java.io.*;
import java.util.HashMap;

import dev.thetechnokid.gather.gfx.Tile;

public class Model {

	private HashMap<Point, Tile> tiles = new HashMap<Point, Tile>();

	private String file;

	public static final String ROCK = "ROCK";
	public static final String CONCRETE = "CONCRETE";
	public static final String CONCRETE_TOP = "CONCRETE_TOP";
	public static final String CONCRETE_SIDE = "CONCRETE_SIDE";
	public static final String CONCRETE_SIDEFLIP = "CONCRETE_SIDEFLIP";
	public static final String COAL = "COAL";
	public static final String IRON = "IRON";

	public Model(String file) {
		this.file = "res/" + file + ".model";
		load();
	}

	private synchronized void load() {
		BufferedReader r = null;
		try {
			r = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			String line;
			while ((line = r.readLine()) != null) {
				String[] currLine = line.split(" ");
				String[] coords = currLine[0].split(",");
				Point p = new Point();
				p.x = Integer.parseInt(coords[0]);
				p.y = Integer.parseInt(coords[1]);

				Tile t = null;

				if (currLine[1].equalsIgnoreCase(ROCK)) {
					t = Tile.ROCK;
				} else if (currLine[1].equalsIgnoreCase(CONCRETE)) {
					t = Tile.CONCRETE;
				} else if (currLine[1].equalsIgnoreCase(CONCRETE_TOP)) {
					t = Tile.CONCRETE_TOP;
				} else if (currLine[1].equalsIgnoreCase(CONCRETE_SIDE)) {
					t = Tile.CONCRETE_SIDE;
				} else if (currLine[1].equalsIgnoreCase(CONCRETE_SIDEFLIP)) {
					t = Tile.CONCRETE_SIDEFLIP;
				} else if (currLine[1].equalsIgnoreCase(COAL)) {
					t = Tile.COAL;
				} else if (currLine[1].equalsIgnoreCase(IRON)) {
					t = Tile.IRON;
				}

				tiles.put(p, t);
			}
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void render(Graphics g, int x, int y) {
		for (Point p : tiles.keySet()) {
			tiles.get(p).renderAt(g, (p.x * Tile.DRAW_SIZE) + x,
					(p.y * Tile.DRAW_SIZE) + y);
		}
	}
}
