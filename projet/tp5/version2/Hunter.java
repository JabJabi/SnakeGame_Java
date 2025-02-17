package projet.tp5.version2;

import java.awt.Color;
import java.awt.Graphics;

public class Hunter implements Obstacle {
	Position hunter;
	
	public Hunter(Position apple) {
		this.hunter = apple;
	}
	
	@Override
	public boolean isCell(Position pos) {
		if(hunter.equals(pos)) return true;
		return false;
	}
	
	void HunterCell(Position pos, Graphics g) {
		if(isCell(pos)) g.setColor(Color.orange);
	}
	
	@Override
	public void Touched(Position pos) {
		if(isCell(pos)) {
		this.hunter.Line = (int)(Math.random()*20);
		this.hunter.Column = (int)(Math.random()*30);
		}
	}

	@Override
	public void SnakeBodyTeleport() {
		for(int i = 0; i<MainSnakeGame.game.snakeGame.snake.size(); i++) {
			if(this.hunter.equals(MainSnakeGame.game.snakeGame.snake.get(i))) {
				this.hunter.Line = (int)(Math.random()*20);
				this.hunter.Column = (int)(Math.random()*30);
			}
		}		
	}


	@Override
	public Position Get() {
		return hunter;
	}
	
	
}
