package myGameGraphics;

import entity.Projectile;
import tile.Tile;

public class Screen {
	private final int MAP_SIZE = 64;

	// tiles are full block map. so when the game starts what shown on the screen is one tile.

	public int width, height;
	public int[] pixels;
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE]; // making the screen as 64*64 tiles

	public int xOffset, yOffset;

	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];

	}

	public void clear() {
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}

	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) { 
		if (fixed) { // if the position is fixed do the fix for the position
			xp -= xOffset;
			yp -= yOffset;
		}
		for(int y = 0; y < sprite.getHeight(); y++) {
			int ya =y + yp;
			for(int x = 0; x < sprite.getWidth(); x++) {
				int xa = x + xp;
				if(xa < 0 || xa >= width || ya < 0 || ya >= height)
					continue;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.getWidth()];
			}
		}

	}

	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset; // because right now the control is for moving the screen not the player. that corrects it, the sprite wont move with the map
		yp -= yOffset;
		for (int y = 0; y < tile.sprite.SIZE; y++) {
			int ya = yp + y;
			for (int x = 0; x < tile.sprite.SIZE; x++) {
				int xa = xp + x;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) // xa can be lower the size of a tile to handle the render of the black bar on the left
					break;
				if (xa < 0)
					xa = 0; // handle out of bounds exception
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE]; // set the current offset pixel to be the tile pixel(simulate the moving background)

			}

		}

	}

	public void renderProjectile(int xp, int yp, Projectile p) {
		xp -= xOffset; // cause right now the control is for moving the screen not the player. that corrects it
		yp -= yOffset;
		for (int y = 0; y < p.getSprite().SIZE; y++) {
			int ya = yp + y;
			for (int x = 0; x < p.getSprite().SIZE; x++) {
				int xa = xp + x;
				if (xa < -p.getSprite().SIZE || xa >= width || ya < 0 || ya >= height) // xa can be lower the size of a tile to handle the render of the black bar on the left
					break;
				if (xa < 0)
					xa = 0; // handle out of bounds exception
				int col = p.getSprite().pixels[x + y * p.getSprite().SIZE];
				if (col != 0xff000000) {
					pixels[xa + ya * width] = col; // set the current offset pixel to be the tile pixel(simulate the moving background)
				}
			}

		}

	}

	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset; // cause right now the control is for moving the screen not the player. that corrects it
		yp -= yOffset;
		for (int y = 0; y < 32; y++) {
			int ya = yp + y;
			for (int x = 0; x < 32; x++) {
				int xa = xp + x;
				if (xa < -32 || xa >= width || ya < 0 || ya >= height) // xa can be lower the size of a tile to handle the render of the black bar on the left
					break;
				if (xa < 0)
					xa = 0; // handle out of bounds exception
				int color = sprite.pixels[x + (y * 32)]; // variable to define the color to render
				if (color != 0xff000000) // dont render black - dont render the back background of the character
					pixels[xa + ya * width] = color; // set the current offset pixel to be the tile pixel(simulate the moving background)

			}

		}
	}

	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

}
