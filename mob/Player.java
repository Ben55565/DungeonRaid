package mob;

import keyInput.KeyBoard;
import myGameGraphics.Screen;
import myGameGraphics.Sprite;

public class Player extends Mob {
	
	private KeyBoard key;
	
	
	public Player(KeyBoard key) {
		
		this.key = key; 
		
	}
	
	public Player(int x, int y, KeyBoard key) { // setting the placing of the player according to x,y
		
		this.x = x;
		this.y = y;
		this.key = key;
		
	}
	
	public void update() { // update the movement of the player according to the key pressed.
		
		int xa = 0, ya = 0; // note the direction the player needs to move
		if(key.up) ya--;
		if(key.down) ya++;
		if(key.left) xa--;
		if(key.right) xa++;
		
		if(xa !=0 || ya != 0) move(xa, ya); // their value if not 0 can be only 1 or -1(indicating the direction where 0 is stay in place) so if there is any movement from the key, make it.
		
	}
	
	public void render(Screen screen) {
		int xx = x - 8; // making the player centered
		int yy = y - 8;
		screen.renderPlayer(xx, yy, Sprite.player0);
		screen.renderPlayer(xx + 8, yy, Sprite.player1);
		screen.renderPlayer(xx + 16, yy, Sprite.player2);
		screen.renderPlayer(xx, yy + 8, Sprite.player3);
		screen.renderPlayer(xx + 8, yy + 8, Sprite.player4);
		screen.renderPlayer(xx + 16, yy + 8, Sprite.player5);
		screen.renderPlayer(xx, yy + 16, Sprite.player6);
		screen.renderPlayer(xx + 8, yy + 16, Sprite.player7);
		screen.renderPlayer(xx + 16, yy + 16, Sprite.player8);
	}
	
}
