package projet.tp5.version2;


public class Apple implements Obstacle{
	Position apple;
	
	public Apple(Position apple) {
		this.apple = apple;
	}
	
	
	public boolean isCell(Position pos) {
		if(apple.equals(pos)) return true;
		return false;
	}
	
	public Position Get() {
		return apple;
	}
	
	@Override
	public void Touched(Position pos) {
		if(this.apple.equals(pos)) {
			this.apple.Line = (int)(Math.random()*20);
			this.apple.Column = (int)(Math.random()*30);
			SnakeGamePanel.score++;
			Position newsnake = new Position(MainSnakeGame.game.snakeGame.snake.get(MainSnakeGame.game.snakeGame.snake.size()-1).Line, MainSnakeGame.game.snakeGame.snake.get(MainSnakeGame.game.snakeGame.snake.size()-1).Column);
			MainSnakeGame.game.snakeGame.snake.add(MainSnakeGame.game.snakeGame.snake.size()-1, newsnake);
		}
	}
	

	@Override
	public void SnakeBodyTeleport() {
		for(int i = 0; i<MainSnakeGame.game.snakeGame.snake.size(); i++) {
			if(this.apple.equals(MainSnakeGame.game.snakeGame.snake.get(i))) {
				this.apple.Line = (int)(Math.random()*20);
				this.apple.Column = (int)(Math.random()*30);
			}
		}		
	}

}
