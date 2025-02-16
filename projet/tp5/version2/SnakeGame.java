package projet.tp5.version2;

import java.lang.Math;
import java.util.ArrayList;

public class SnakeGame {
	int nbLines;
	int nbColumns;
	ArrayList<Position> snake;
	Position direction;
	boolean gameover;
	Apple apple1;
	Apple apple2;
	Apple apple3;
	Apple apple4;
	Position water;
	Position reverse;
	Position hunter;
	
	public SnakeGame() {
		this.nbLines = 20;
		this.nbColumns = 30;
		this.snake = new ArrayList<Position>();
		snake.add(new Position(10,15));
		snake.add(new Position(10,16));
		snake.add(new Position(10,17));
		this.apple1 = new Apple(new Position((int)(Math.random()*20),(int)(Math.random()*30)));
		this.apple2 = new Apple(new Position((int)(Math.random()*20),(int)(Math.random()*30)));
		this.apple3 = new Apple(new Position((int)(Math.random()*20),(int)(Math.random()*30)));
		this.apple4 = new Apple(new Position((int)(Math.random()*20),(int)(Math.random()*30)));
		this.water = new Position((int)(Math.random()*20),(int)(Math.random()*30));
		this.direction = new Position(1,0);
		gameover = false;
	}
	
	//Mouvements
	void setDirection(Position pos){
		if(pos.Line+snake.get(0).Line == getSnakeNeck().Line && pos.Column+snake.get(0).Column  == getSnakeNeck().Column) {
			
		} else {
				this.direction.Line = pos.Line;
				this.direction.Column = pos.Column;
		}
	}
	
	void moveForward() {
		if(gameover == true) return;
		Position newhead = new Position(snake.get(0).Line + direction.Line, snake.get(0).Column + direction.Column);
		snake.add(0, newhead);
		int taille = (int)snake.size();
		snake.remove(taille-1);
	}
	
	//Get
	
	Position getSnakeNeck() {
		return snake.get(1);
	}
	
	
	Position getSnakeHead() {
		return snake.get(0);
	}
	
	//Checker

	boolean isGameOver() {
		for(int i=2;i<snake.size(); i++) {
			if(getSnakeHead().Line == snake.get(i).Line && snake.get(i).Column == getSnakeNeck().Column) {
				gameover = true;
				return true;
			}
		}
		if(getSnakeHead().Line >= nbLines || getSnakeHead().Column >= nbColumns || getSnakeHead().Line < 0 || getSnakeHead().Column < 0) {
			gameover = true;
			return true;
		}
		else {
			gameover = false;
			return false;
		}
	
	}
	
	boolean isSnakeHead(Position pos) {
		if(pos.equals(getSnakeHead())) return true;
		return false;
	}
	boolean isSnakeCell(Position position) {
		for(int i =0; i <snake.size(); i++) {
			if(this.snake.get(i).equals(position)) return true;  
		} 
		return false;
	}
	
	boolean isWaterCell(Position pos) {
		if(this.water.equals(pos)) return true;
		return false;
		
	}
	
	boolean isBlackCell(Position position) {
		if((position.Line+position.Column)%2 ==0) return true;
			return false;
		
	}
	
	boolean isGrayCell(Position position) {
		if((position.Line+position.Column)%2 ==0) return false;
			return true;
		
	}
	
	
}
