package gettothecastle.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	private BufferedImage image;

	public static Spritesheet SHEET;
	
	private static int SIZE = 8;
	
	static {
		try {
			SHEET = new Spritesheet(ImageIO.read(Spritesheet.class.getResource("/spritesheet.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Spritesheet(BufferedImage i) {
		image = i;
	}

	public BufferedImage crop(int col, int row, int w, int h) {
		return image.getSubimage(col * SIZE, row * SIZE, w, h);
	}

	public BufferedImage crop(int col, int row) {
		return crop(col, row, SIZE, SIZE);
	}

}
