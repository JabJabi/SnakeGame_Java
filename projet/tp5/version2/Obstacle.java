package projet.tp5.version2;

import java.awt.Color;
import java.awt.Graphics;

public interface Obstacle {
	
	void SnakeBodyTeleport();
	default void Eated(Position pos) {
		
	}
	boolean isCell(Position pos);
	
	default void Cell(Position pos, Graphics g, Color color) {
		if(isCell(pos)) g.setColor(color);
	}
	
	void Touched(Position pos);
	
	Position Get();
}
