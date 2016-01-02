package gettothecastle.gfx;

import java.awt.image.BufferedImage;

public class Spritesheet {
	private BufferedImage image;
	
	public Spritesheet(BufferedImage i) {
		image = i;
	}
	
	public BufferedImage crop(int col, int row) {
		return image.getSubimage(col * 8, row * 8, 8, 8);
	}
}
