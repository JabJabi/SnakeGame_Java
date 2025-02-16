
package projet.tp5.version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SnakeGamePanel extends JPanel{
	
	SnakeGame snakeGame = new SnakeGame();
	int started = 0;
	int time = MainSnakeGame.a;
	SnakeGamePanel() {
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					snakeGame.setDirection(new Position(-1,0));
					
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					snakeGame.setDirection(new Position(1,0)); 
					
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					snakeGame.setDirection(new Position(0, -1));
					
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					snakeGame.setDirection(new Position(0,1));
				}	if (e.getKeyCode() == KeyEvent.VK_B) {
					if(started ==2 && MainSnakeGame.getpanel() == MainSnakeGame.game) {
						started = 2;
					}
			}
			}
		});
		
		
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
					snakeGame.isGameOver();
					if(started == 2) {
						snakeGame.moveForward();
					} 
					repaint();	
			}
		}, 10,time);
	}
	
	
	static int score = 0;
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int line = 0; line <= snakeGame.nbLines; line++) {
			for (int column = 0; column <= snakeGame.nbColumns; column++) {
				drawCell(g, line, column);
				g.setColor(Color.white);
				g.fillRect(900,0 ,1000,1000);
				g.setFont(new Font("", Font.PLAIN, 15));
				g.setColor(Color.black);
				g.drawString("Score: " + score, 920, 200);
				g.drawString("Niveau: ", 920, 230);
				g.drawString(""+ time, 920, 242);
				g.setFont(new Font("", Font.PLAIN, 18));
				g.drawString("Pseudo: ", 910, 100);
			}
		}

	}
	
	
	void drawCell(Graphics g, int line, int column) {
		// Début de la méthode drawCell
		Position pos = new Position(line, column);
		if(snakeGame.isBlackCell(pos)) {
			g.setColor(Color.black);
		} else {
			g.setColor(Color.gray);
		}
	if(snakeGame.isGameOver()) score =0;
	 if(snakeGame.isSnakeCell(pos)) {
		g.setColor(Color.green);
	} 
	 if(snakeGame.isWaterCell(pos)) {
		 g.setColor(Color.blue);
	 }

	 snakeGame.apple1.AppleCell(pos,g);
	 snakeGame.apple2.AppleCell(pos,g);
	 snakeGame.apple3.AppleCell(pos,g);
	 snakeGame.apple4.AppleCell(pos,g);
	if(snakeGame.apple1.isAppleCell(snakeGame.snake.get(0))) {
		snakeGame.apple1.apple.Line = (int)(Math.random()*20);
		snakeGame.apple1.apple.Column = (int)(Math.random()*30);
		score++;
		Position newsnake = new Position(snakeGame.snake.get(snakeGame.snake.size()-1).Line, snakeGame.snake.get(snakeGame.snake.size()-1).Column);
		snakeGame.snake.add(snakeGame.snake.size()-1, newsnake);
	}
	if(snakeGame.isWaterCell(snakeGame.apple1.apple)) {
		snakeGame.water.Line = (int)(Math.random()*20);
		snakeGame.water.Column = (int)(Math.random()*30);
	}
	

	if(snakeGame.apple2.isAppleCell(snakeGame.snake.get(0))) {
		snakeGame.apple2.apple.Line = (int)(Math.random()*20);
		snakeGame.apple2.apple.Column = (int)(Math.random()*30);
		score++;
		Position newsnake = new Position(snakeGame.snake.get(snakeGame.snake.size()-1).Line, snakeGame.snake.get(snakeGame.snake.size()-1).Column);
		snakeGame.snake.add(snakeGame.snake.size()-1, newsnake);
	}
	if(snakeGame.isWaterCell(snakeGame.apple2.apple)) {
		snakeGame.water.Line = (int)(Math.random()*20);
		snakeGame.water.Column = (int)(Math.random()*30);
	}
	
	if(snakeGame.apple3.isAppleCell(snakeGame.snake.get(0))) {
		snakeGame.apple3.apple.Line = (int)(Math.random()*20);
		snakeGame.apple3.apple.Column = (int)(Math.random()*30);
		score++;
		Position newsnake = new Position(snakeGame.snake.get(snakeGame.snake.size()-1).Line, snakeGame.snake.get(snakeGame.snake.size()-1).Column);
		snakeGame.snake.add(snakeGame.snake.size()-1, newsnake);
	}
	if(snakeGame.isWaterCell(snakeGame.apple3.apple)) {
		snakeGame.water.Line = (int)(Math.random()*20);
		snakeGame.water.Column = (int)(Math.random()*30);
	}
	
	if(snakeGame.apple4.isAppleCell(snakeGame.snake.get(0))) {
		snakeGame.apple4.apple.Line = (int)(Math.random()*20);
		snakeGame.apple4.apple.Column = (int)(Math.random()*30);
		score++;
		Position newsnake = new Position(snakeGame.snake.get(snakeGame.snake.size()-1).Line, snakeGame.snake.get(snakeGame.snake.size()-1).Column);
		snakeGame.snake.add(snakeGame.snake.size()-1, newsnake);
	}
	if(snakeGame.isWaterCell(snakeGame.apple4.apple)) {
		snakeGame.water.Line = (int)(Math.random()*20);
		snakeGame.water.Column = (int)(Math.random()*30);
	}
	if(snakeGame.isWaterCell(snakeGame.snake.get(0))) {
		snakeGame.water.Line = (int)(Math.random()*20);
		snakeGame.water.Column = (int)(Math.random()*30);
		score--;
	}
		g.fillRect(this.getCellX(pos)*30, this.getCellY(pos)*30, this.getCellWidth(), this.getCellHeight());
		// Fin de la méthode drawCell
		g.setColor(Color.white);
		g.fillRect(snakeGame.nbLines*20, snakeGame.nbColumns*30, 1000, 660);
	}
	
	void Reset() {
		snakeGame = new SnakeGame();
	}
	int getBorderSize() {
		return snakeGame.nbLines + snakeGame.nbColumns;
	}
	
	int getCellWidth() {
		return snakeGame.nbColumns * 30;
	}
	
	int getCellHeight() {
		return snakeGame.nbLines*30;
	}
	
	int getCellX(Position position) {
		return position.Column;
	}
	
	int getCellY(Position position) {
		return position.Line;
	}
	
	
}
