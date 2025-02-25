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
				} 
				if(this.getClass().getName() == "projet.tp5.version2.Hunter" && j ==0) {
					break;
				} else {
				this.Get().Line = (int)(Math.random()*20);
				this.Get().Column = (int)(Math.random()*30);
				} //repère pour moi: le else agit seulement sur le if hunter, pas le reste
			}
		}
		for(Obstacle obs : MainSnakeGame.game.snakeGame.obstacles) {
			if(this == obs);
			else if(this.Get().equals(obs.Get())){				
					this.Get().Line = (int)(Math.random()*20);
					this.Get().Column = (int)(Math.random()*30);
				}

			}

	}


	
	public static void Moove() {
		for(Obstacle obs : MainSnakeGame.game.snakeGame.obstacles) {
		if(obs.getClass().getName() == "projet.tp5.version2.Hunter") {
			if(obs.Get().Line > MainSnakeGame.game.snakeGame.nbLines || obs.Get().Column > MainSnakeGame.game.snakeGame.nbColumns || obs.Get().Line < 0|| obs.Get().Column < 0) {
				MainSnakeGame.game.ope= - MainSnakeGame.game.ope;
			}	
			
			obs.Get().Line +=MainSnakeGame.game.ope;
			obs.Get().Column +=MainSnakeGame.game.ope;
		}
		}
	}
	
}

