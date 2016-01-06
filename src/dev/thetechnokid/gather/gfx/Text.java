package dev.thetechnokid.gather.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Text {

	private static BufferedImage[] letters;
	private static BufferedImage[] numbers;

	public static final BufferedImage A = Spritesheet.SHEET.crop(8, 0);
	public static final BufferedImage B = Spritesheet.SHEET.crop(9, 0);
	public static final BufferedImage C = Spritesheet.SHEET.crop(10, 0);
	public static final BufferedImage D = Spritesheet.SHEET.crop(11, 0);
	public static final BufferedImage E = Spritesheet.SHEET.crop(12, 0);
	public static final BufferedImage F = Spritesheet.SHEET.crop(13, 0);
	public static final BufferedImage G = Spritesheet.SHEET.crop(14, 0);
	public static final BufferedImage H = Spritesheet.SHEET.crop(15, 0);
	public static final BufferedImage I = Spritesheet.SHEET.crop(0, 1);
	public static final BufferedImage J = Spritesheet.SHEET.crop(1, 1);
	public static final BufferedImage K = Spritesheet.SHEET.crop(2, 1);
	public static final BufferedImage L = Spritesheet.SHEET.crop(3, 1);
	public static final BufferedImage M = Spritesheet.SHEET.crop(4, 1);
	public static final BufferedImage N = Spritesheet.SHEET.crop(5, 1);
	public static final BufferedImage O = Spritesheet.SHEET.crop(6, 1);
	public static final BufferedImage P = Spritesheet.SHEET.crop(7, 1);
	public static final BufferedImage Q = Spritesheet.SHEET.crop(8, 1);
	public static final BufferedImage R = Spritesheet.SHEET.crop(9, 1);
	public static final BufferedImage S = Spritesheet.SHEET.crop(10, 1);
	public static final BufferedImage T = Spritesheet.SHEET.crop(11, 1);
	public static final BufferedImage U = Spritesheet.SHEET.crop(12, 1);
	public static final BufferedImage V = Spritesheet.SHEET.crop(13, 1);
	public static final BufferedImage W = Spritesheet.SHEET.crop(14, 1);
	public static final BufferedImage X = Spritesheet.SHEET.crop(15, 1);
	public static final BufferedImage Y = Spritesheet.SHEET.crop(0, 2);
	public static final BufferedImage Z = Spritesheet.SHEET.crop(1, 2);
	public static final BufferedImage ZERO = Spritesheet.SHEET.crop(9, 2);
	public static final BufferedImage ONE = Spritesheet.SHEET.crop(10, 2);
	public static final BufferedImage TWO = Spritesheet.SHEET.crop(11, 2);
	public static final BufferedImage THREE = Spritesheet.SHEET.crop(12, 2);
	public static final BufferedImage FOUR = Spritesheet.SHEET.crop(13, 2);
	public static final BufferedImage FIVE = Spritesheet.SHEET.crop(14, 2);
	public static final BufferedImage SIX = Spritesheet.SHEET.crop(15, 2);
	public static final BufferedImage SEVEN = Spritesheet.SHEET.crop(0, 3);
	public static final BufferedImage EIGHT = Spritesheet.SHEET.crop(1, 3);
	public static final BufferedImage NINE = Spritesheet.SHEET.crop(2, 3);

	static {
		letters = new BufferedImage[] { A, B, C, D, E, F, G, H, I, J, K, L, M,
				N, O, P, Q, R, S, T, U, V, W, X, Y, Z };
		numbers = new BufferedImage[] { ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX,
				SEVEN, EIGHT, NINE };
	}

	// This code works perfectly:
	// I gotta never ever ever ever,
	// touch this code again, forever.
	public static void render(String msg, Graphics g, int x, int y) {
		msg = msg.toUpperCase();
		char[] msgArray = msg.toCharArray();
		for (char c : msgArray) {
			if (c == ' ') {
				x += Tile.DRAW_SIZE;
				continue;
			}
			if (!(c <= 90 && c >= 48))
				continue;
			
			if (c >= 48 && c <= 57) {
				g.drawImage(numbers[c - 48], x, y, Tile.DRAW_SIZE,
						Tile.DRAW_SIZE, null);
				x += Tile.DRAW_SIZE;
				continue;
			}

			g.drawImage(letters[c - 64], x, y, Tile.DRAW_SIZE, Tile.DRAW_SIZE,
					null);
			x += Tile.DRAW_SIZE + 2;
		}
	}
}
