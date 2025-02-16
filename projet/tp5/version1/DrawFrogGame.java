package projet.tp5.version1;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class DrawFrogGame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("La petite grenouille ...");
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(2000, 2000);
		frame.add(new FrogGamePanel());
		frame.setVisible(true);
	}
	

}