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
	int timer = time;
	int ope = 1;
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
				}	
			}
		});
		
		
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
					if(started == 2) {
						snakeGame.moveForward();
					} 
					timer+=time;
					repaint();	
			}
		}, 1000,time);
		
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				if(snakeGame.hunter.Get().Line >= snakeGame.nbLines || snakeGame.hunter.Get().Column >= snakeGame.nbColumns || snakeGame.hunter.Get().Line < 0|| snakeGame.hunter.Get().Column < 0) {
					ope=-ope;
				} 
				snakeGame.hunter.Get().Line +=ope;
				snakeGame.hunter.Get().Column +=ope;	
			}
		}, 1000,time*15);
	
}
	int score = 0;
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
				if(time == 500) g.drawString("Facile", 920, 242);
				if(time == 250)	g.drawString("Normal", 920, 242);
				if(time == 100) g.drawString("Difficile", 920, 242);
				 g.drawString("Timer:", 920, 267);
				 int min = (timer/1000)/60;
				 g.drawString(min + ":" + ((timer/1000)-min*60) + ":" + timer%1000, 920, 280);
				g.setFont(new Font("", Font.PLAIN, 10));
			//	g.setFont(new Font("", Font.PLAIN, 18));
			//	g.drawString("Pseudo: ", 910, 100);
			}
		}

	}
	
	
	void drawCell(Graphics g, int line, int column) {
		Position pos = new Position(line, column);
		Color green_ground = new Color(50,168,92);
		Color dgreen_ground = new Color(50,168,52);
		if(snakeGame.isBlackCell(pos)) {
			g.setColor(green_ground);
		} else {
			g.setColor(dgreen_ground);
		}

		if(snakeGame.isGameOver()) score =0;
		if(snakeGame.isSnakeCell(pos)) {
			g.setColor(Color.green);
		} 
		snakeGame.water.Cell(pos, g, Color.blue);
		snakeGame.hunter.Cell(pos, g, Color.orange);
		snakeGame.apple1.Cell(pos,g,Color.red);
		snakeGame.apple2.Cell(pos,g, Color.red);
		snakeGame.apple3.Cell(pos,g, Color.red);
		snakeGame.apple4.Cell(pos,g, Color.red);
		g.fillRect(this.getCellX(pos)*30, this.getCellY(pos)*30, this.getCellWidth(), this.getCellHeight());
		g.setColor(Color.white);
		g.fillRect(snakeGame.nbLines*20, snakeGame.nbColumns*30, 1000, 660);
		for(int i=0; i<snakeGame.obstacles.size();i++) {
			snakeGame.obstacles.get(i).NoOver();
		}
		
		
	}
	
	
	//methodes
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
