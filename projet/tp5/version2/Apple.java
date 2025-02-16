package projet.tp5.version2;

import java.awt.Color;
import java.awt.Graphics;

public class Apple {
	Position apple;
	
	public Apple(Position apple) {
		this.apple = apple;
	}
	
	boolean isAppleCell(Position pos) {
		if(apple.equals(pos)) return true;
		return false;
	}
	
	void AppleCell(Position pos, Graphics g) {
		if(apple.equals(pos)) g.setColor(Color.red);
	}
}
