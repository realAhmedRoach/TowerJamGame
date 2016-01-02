package gettothecastle.gfx;

public class Sprite {
	final int SIZE;
	private int x, y;
	private Spritesheet sheet;
	public int[] pixels;

	public static Sprite GRASS = new Sprite(8, 0, 0, Spritesheet.TILES);

	public Sprite(int size, int x, int y, Spritesheet sheet) {
		SIZE = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * SIZE;
		this.y = y * SIZE;
		this.sheet = sheet;
		load();
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x)
						+ (y + this.y) * sheet.SIZE];
			}
		}
	}
}
