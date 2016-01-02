package gettothecastle.gfx;

import java.util.Random;

public class Screen {
	private int width, height;

	private static final int MAP_SIZE = 64;
	private static final int MAP_SIZE_MASK = MAP_SIZE - 1;

	public int[] pixels;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

		for (int i = 0; i < tiles.length; i++) {
			tiles[i] = new Random().nextInt(0xffffff);
		}
	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++)
			pixels[i] = 0;
	}

	public void render(int xOffset, int yOffset) {
		for (int y = 0; y < height; y++) {
			int yp = y + yOffset;
			if (yp < 0 || yp >= height)
				continue;
			for (int x = 0; x < width; x++) {
				int xp = x + xOffset;
				if (xp < 0 || xp >= width)
					continue;
				pixels[xp + yp * width] = Sprite.GRASS.pixels[(x & 7)
						+ (y & 7) * Sprite.GRASS.SIZE];
			}
		}
	}
}
