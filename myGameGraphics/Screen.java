package myGameGraphics;

public class Screen {
	private int width, height;
	public int[] pixels;

	int time = 0; // temp
	int counter = 0; // temp
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}

	
	public void clear() {
		for(int i = 0; i < pixels.length; i++) {
			pixels[i] = 0;
		}
	}
	
	public void render() {
		counter++;
		if(counter % 100 == 0)
			time++;
		for(int y = 0; y < height; y++) {
			for(int x = 0; x < width; x++) {
				pixels[time + (time * width)] = 0xff00ff; //0x is prefix for hexa in java. this function made for coloring each pixel
				
			}
		}
	}
}
