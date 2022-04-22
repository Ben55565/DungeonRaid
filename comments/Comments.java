package comments;

public class Comments {
	/* here i will enter comments about changes iv made with my code, in case i need need to debug
	 
	 	
	 
	 	for the switch from rendering 9 pieces of the player to one these are the changes:
		from Sprite class:
	 	public static Sprite playerFront0 = new Sprite(8, 0, 18, Spritesheet.tiles); // 19 is the y position in the sprite, multiplying by 8 cause the size of each one is 8
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
		
	 Saved comments for myself to learn from:
	
	int tileIndex = ((xx >> 4) & MAP_SIZE-1) + ((yy >> 4) & MAP_SIZE-1) * MAP_SIZE; // find the correct tile matching for the specific pixel its on, using size of 16 *note to self - lower it when im more advanced.
	>> - instead of dividing by 16, which is power of 2, >> is shifting the bits 4 places  right, so the division action achieved but in a faster way - using bits
	& - creating some kind of loop, if we try to go beyond the 63 tile, it will return to the tile index 0
	
	
	 	
	 
	 */
}
