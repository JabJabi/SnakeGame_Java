package projet.tp5.version2;

import java.awt.Color;
import java.awt.Graphics;

public class Water implements Obstacle {
	Position water;
	
	public Water(Position apple) {
		this.water = apple;
	}
	
	
	void WaterCell(Position pos, Graphics g) {
		if(isCell(pos)) g.setColor(Color.blue);
	}
	
	@Override
	public void Touched(Position pos) {
		if(this.water.equals(pos)) {
			if(pos.equals(MainSnakeGame.game.snakeGame.getSnakeHead())) {
				if(MainSnakeGame.game.snakeGame.snake.size() > 3) {
					MainSnakeGame.game.score--;
					MainSnakeGame.game.snakeGame.snake.remove(MainSnakeGame.game.snakeGame.snake.size()-1);
				}
			}
		this.water.Line = (int)(Math.random()*20);
		this.water.Column = (int)(Math.random()*30);
		}
	}

	@Override
	public void SnakeBodyTeleport() {
		for(int i = 0; i<MainSnakeGame.game.snakeGame.snake.size(); i++) {
			if(this.water.equals(MainSnakeGame.game.snakeGame.snake.get(i))) {
				this.water.Line = (int)(Math.random()*20);
				this.water.Column = (int)(Math.random()*30);
			}
		}
	}

	@Override
	public boolean isCell(Position pos) {
		if(water.equals(pos)) return true;
		return false;
	}

	@Override
	public Position Get() {
		return water;
	}
	
}
