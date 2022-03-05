package myGame;

import javax.swing.JFrame;

public class Game {

	
	public static void main(String[] args) {
		DisplayWindow game = new DisplayWindow();
		game.getWindow().setResizable(false);
		game.getWindow().setTitle(DisplayWindow.title); // setting the title of the window
		game.getWindow().add(game); // adding the game itself to the window
		game.getWindow().pack(); // setting the game size by the definition of dimension size
		game.getWindow().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // terminate the process if it has been closed by the X button
		game.getWindow().setLocationRelativeTo(null); // set the default location of the window
		game.getWindow().setVisible(true); // set the window as visible
		
		game.start();

	}
}
