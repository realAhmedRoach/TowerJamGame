package gettothecastle.gfx;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class Tile {
	public static final int DRAW_SIZE = 32;
	public BufferedImage sprite;
	
	public static final Tile GRASS = new Tile(Spritesheet.SHEET.crop(0, 0));
	public static final Tile ROCK = new Tile(Spritesheet.SHEET.crop(1, 0));
	public static final Tile WATER = new Tile(Spritesheet.SHEET.crop(2, 0));
	public static final Tile CONCRETE = new Tile(Spritesheet.SHEET.crop(3,0));
	public static final Tile CONCRETE_TOP = new Tile(Spritesheet.SHEET.crop(4, 0));
	public static final Tile SWORD = new Tile(Spritesheet.SHEET.crop(5,0));
	public static final Tile PICK = new Tile(Spritesheet.SHEET.crop(6,0));
	public static final Tile COAL = new Tile(Spritesheet.SHEET.crop(7,0));
	public static final Tile IRON = new Tile(Spritesheet.SHEET.crop(8,0));
	public static final Tile PLAYER_WALK1 = new Tile(Spritesheet.SHEET.crop(3, 2));
	public static final Tile PLAYER_WALK2 = new Tile(Spritesheet.SHEET.crop(4, 2));
	public static final Tile PLAYER_WALK1FLIP = flip(PLAYER_WALK1);
	public static final Tile PLAYER_WALK2FLIP = flip(PLAYER_WALK2);
	public static final Tile PLAYER_DOWN1 = new Tile(Spritesheet.SHEET.crop(5, 2));
	public static final Tile PLAYER_DOWN2 = new Tile(Spritesheet.SHEET.crop(6, 2));
	public static final Tile PLAYER_UP1 = new Tile(Spritesheet.SHEET.crop(7, 2));
	public static final Tile PLAYER_UP2 = new Tile(Spritesheet.SHEET.crop(8, 2));

	public Tile(BufferedImage s) {
		sprite = s;
	}
	
	public void renderAt(Graphics g, int x, int y) {
		g.drawImage(sprite, x, y, DRAW_SIZE, DRAW_SIZE, null);
	}
	
	public BufferedImage getImage() {
		return sprite;
	}

	public void setSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}

	public static Tile flip(Tile orig) {
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		tx.translate(-orig.sprite.getWidth(null), 0);
		op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		BufferedImage newImage =  op.filter(orig.sprite, null);
		return new Tile(newImage);
	}
	
	public boolean solid() {
		return false;
	}
}
