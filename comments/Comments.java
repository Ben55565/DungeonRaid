package comments;



public class Comments {
		/* here i will enter comments about changes iv made with my code, in case i need need to debug
		 * 
		 * 	 i made each tile more detailed, check ahead that no problem accrue, if so, change back the file directory on Sprite sheet class,
		 *	 and every class that shifting bits change from 3 to 4, and change sprite size from 8 to 16, and change MAP_SIZE from 128 to 64
		 *
		 *	for the switch from rendering 9 pieces of the player to one these are the changes:
		 *	from Sprite class:
		 *	public static Sprite playerFront0 = new Sprite(8, 0, 18, Spritesheet.tiles); // 19 is the y position in the sprite, multiplying by 8 cause the size of each one is 8
			public static Sprite playerFront1 = new Sprite(8, 1, 18, Spritesheet.tiles);
			public static Sprite playerFront2 = new Sprite(8, 2, 18, Spritesheet.tiles);
			public static Sprite playerFront3 = new Sprite(8, 0, 19, Spritesheet.tiles);
			public static Sprite playerFront4 = new Sprite(8, 1, 19, Spritesheet.tiles);
			public static Sprite playerFront5 = new Sprite(8, 2, 19, Spritesheet.tiles);
			public static Sprite playerFront6 = new Sprite(8, 0, 20, Spritesheet.tiles);
			public static Sprite playerFront7 = new Sprite(8, 1, 20, Spritesheet.tiles);
		    public static Sprite playerFront8 = new Sprite(8, 2, 20, Spritesheet.tiles); // the player on my sprite takes 9 tiles, so i had to do that to get all the pieces
		    
		    deleted from player class in player render function:
		    int xx = x - 8; // making the player centered
			int yy = y - 8;
			screen.renderPlayer(xx, yy, Sprite.playerFront0);
			screen.renderPlayer(xx + 8, yy, Sprite.playerFront1);
			screen.renderPlayer(xx + 16, yy, Sprite.playerFront2);
			screen.renderPlayer(xx, yy + 8, Sprite.playerFront3);
			screen.renderPlayer(xx + 8, yy + 8, Sprite.playerFront4);
			screen.renderPlayer(xx + 16, yy + 8, Sprite.playerFront5);
			screen.renderPlayer(xx, yy + 16, Sprite.playerFront6);
			screen.renderPlayer(xx + 8, yy + 16, Sprite.playerFront7);
			screen.renderPlayer(xx + 16, yy + 16, Sprite.playerFront8);
			
			in screen class, render player function changed all the values from 8 to 24
		 *	
		 *
		 */
}
