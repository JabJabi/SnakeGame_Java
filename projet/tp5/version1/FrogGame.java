package projet.tp5.version1;
import java.util.ArrayList;

public class FrogGame {
	int nbLines;
	int nbColumns;
	ArrayList<Position> snake;
	Position fly;
	Position direction;
	public FrogGame() {
		this.nbLines = 20;
		this.nbColumns = 30;
		this.snake = new ArrayList<Position>();
		snake.add(new Position(10,15));
		snake.add(new Position(10,16));
		snake.add(new Position(10,17));
		this.fly = new Position(5,10);
		this.direction = new Position(1,0);
	}
	
	void setDirectionLeft() {
		this.direction.setPosLine(0);
		this.direction.setPosColumn(-1);
		
	}
	void setDirectionRight() {
		this.direction.setPosLine(0);
		this.direction.setPosColumn(1);
		
	}
	void setDirectionUp() {
		this.direction.setPosLine(-1);
		this.direction.setPosColumn(0);
		
	}
	void setDirectionDown() {
		this.direction.setPosLine(1);
		this.direction.setPosColumn(0);
		
	}
	
	void moveForward() {
		Position newhead = new Position(snake.get(0).Line + direction.Line, snake.get(0).Column + direction.Column);
		snake.add(0, newhead);
		int taille = (int)snake.size();
		snake.remove(taille-1);
		//this.snake.setPosLine(this.snake.getPosLine()+this.direction.getPosLine());
		//this.snake.setPosColumn(this.snake.getPosColumn()+this.direction.getPosColumn());
	}
	
	Position getSnakeHead() {
		return snake.get(0);
	}
	
	boolean isSnakeHead(Position pos) {
		if(pos.equals(getSnakeHead())) {
			return true;
		}
		return false;
	}
	boolean isSnakeCell(Position position) {
		for(int i =0; i <snake.size(); i++) {
			if(this.snake.get(i).equals(position)) {
				return true;  
			} 
		} 
		return false;
	}
	
	boolean isFlyCell(Position pos) {
		if(this.fly.equals(pos)) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean isBlackCell(Position position) {
		if((position.getPosLine()+position.getPosColumn())%2 ==0) {
			return true;
		} else {
			return false;
		}
	}
	
	boolean isGrayCell(Position position) {
		if((position.getPosLine()+position.getPosColumn())%2 ==0) {
			return false;
		} else {
			return true;
		}
	}
	
}
