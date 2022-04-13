package mob;

import keyInput.KeyBoard;
import keyInput.Mouse;
import myGame.DisplayWindow;
import myGameGraphics.Screen;
import myGameGraphics.Sprite;

public class Player extends Mob {

	private KeyBoard key;
	private Sprite sprite;
	private int anime = 0;
	private boolean walking = false;

	public Player(KeyBoard key) {

		this.key = key;
		sprite = Sprite.playerDown; // just making sure i wont get null pointer exception

	}

	public Player(int x, int y, KeyBoard key) { // setting the placing of the player according to x,y

		this.x = x;
		this.y = y;
		this.key = key;

	}

	public void update() { // update the movement of the player according to the key pressed.

		int xa = 0, ya = 0; // note the direction the player needs to move
		if (anime < 7500)
			anime++; // avoid crushing if the game is open with no input, should be going up by 60 each second
		else
			anime = 0;

		if (key.up)
			ya--;
		if (key.down)
			ya++;
		if (key.left)
			xa--;
		if (key.right)
			xa++;
		if (xa != 0 || ya != 0) {
			move(xa, ya); // their value if not 0 can be only 1 or -1(indicating the direction where 0 is stay in place) so if there is any movement from the key, make it.
			walking = true;
		} else {
			walking = false;
		}

		updateShooting();
	}

	private void updateShooting() {
		// to calculate the direction the player shoots at:  get a triangle between the mouse position(x,y) and the player position(x,y)
		//  calculate both edges(dy = y2 - y1, dx = x2 - x1), and performing atan2(a/b) to find the degree the player should shoot at.

		if (Mouse.getMouseB() == 1) {
			double dx = Mouse.getMouseX() - (DisplayWindow.width * DisplayWindow.scale) / 2; // calculation using the center of the screen, as the location of the player on the window
			double dy = Mouse.getMouseY() - (DisplayWindow.height * DisplayWindow.scale) / 2;
			double dir = Math.atan2(dy, dx); // atan2 - handles division by zero instead of crushing the program. 
			shoot(x, y, dir);
		}
	}

	public void render(Screen screen) {
		if (dir == 0) {
			sprite = Sprite.playerUp;
			if (walking) {
				if (anime % 25 > 10) { // the higher the modulo, the slower the animation
					sprite = Sprite.playerWUp1;
				} else {
					sprite = Sprite.playerWUp2;
				}
			}
		}
		if (dir == 1) {
			sprite = Sprite.playerRight;
			if (walking) {
				if (anime % 25 > 10) {
					sprite = Sprite.playerWRight1;
				} else {
					sprite = Sprite.playerWRight2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.playerDown;
			if (walking) {
				if (anime % 25 > 10) {
					sprite = Sprite.playerWDown1;
				} else {
					sprite = Sprite.playerWDown2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.playerLeft;
			if (walking) {
				if (anime % 25 > 10) {
					sprite = Sprite.playerWLeft1;
				} else {
					sprite = Sprite.playerWLeft2;
				}
			}
		}
		screen.renderPlayer(x - 8, y - 8, sprite);
	}

}
