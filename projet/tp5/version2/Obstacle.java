package projet.tp5.version2;

import java.awt.Color;
import java.awt.Graphics;

public interface Obstacle {
	
	
	Position Get();
		
	default boolean isCell(Position pos) {
		if(this.Get().equals(pos)) return true;
		return false;
	}
	
	default void Cell(Position pos, Graphics g, Color color) {
		if(isCell(pos)) g.setColor(color);
	}
	

	default void NoOver() {
		for(int j = 0; j<MainSnakeGame.game.snakeGame.snake.size(); j++) {
			if(this.Get().equals(MainSnakeGame.game.snakeGame.snake.get(j))) {
				if(this.getClass().getName() == "projet.tp5.version2.Apple" && j == 0) {
					MainSnakeGame.game.score++;
					Position newsnake = new Position(MainSnakeGame.game.snakeGame.snake.get(MainSnakeGame.game.snakeGame.snake.size()-1).Line, MainSnakeGame.game.snakeGame.snake.get(MainSnakeGame.game.snakeGame.snake.size()-1).Column);
					MainSnakeGame.game.snakeGame.snake.add(MainSnakeGame.game.snakeGame.snake.size()-1, newsnake);
				} if(this.getClass().getName() == "projet.tp5.version2.Water" && j == 0) {
					if(MainSnakeGame.game.snakeGame.snake.size() > 3) {
						MainSnakeGame.game.score--;
						MainSnakeGame.game.snakeGame.snake.remove(MainSnakeGame.game.snakeGame.snake.size()-1);
					}
				} if(this.getClass().getName() == "projet.tp5.version2.Hunter" && j ==0) {

				}
				this.Get().Line = (int)(Math.random()*20);
				this.Get().Column = (int)(Math.random()*30);
			}
		}
		for(int i=0;i<MainSnakeGame.game.snakeGame.obstacles.size();i++) {
		if(this.getClass() != MainSnakeGame.game.snakeGame.obstacles.get(i).getClass()) {
			if(this.Get().equals(MainSnakeGame.game.snakeGame.obstacles.get(i).Get())){				
				this.Get().Line = (int)(Math.random()*20);
				this.Get().Column = (int)(Math.random()*30);
			}

		}
	}
	}
}
