package projet.tp5.version1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class FrogGamePanel extends JPanel{
	
	FrogGame froggame = new FrogGame();
	int score = 0;
	
	FrogGamePanel() {
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
		/*		int nœewLine = froggame.snake.Line; commentaire et rappel à moi meme: utilise position de la tête du snake
				int newColumn = froggame.snake.Column;*/
				
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					System.out.println("Changement de direction UP");
					froggame.setDirectionUp();; // changement de direction
					
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
					System.out.println("Changement de direction DOWN");
					froggame.setDirectionDown(); // changement de direction
					
				} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					System.out.println("Changement de direction LEFT");
					froggame.setDirectionLeft();; // changement de direction
					
				} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					System.out.println("Changement de direction RIGHT");
					froggame.setDirectionRight(); // changement de direction
				}
				
/*				if (newLine >= 0 && newLine < froggame.nbLines && newColumn >= 0 && newColumn < froggame.nbColumns) {
					froggame.snake.setPosLine(newLine);
					froggame.snake.setPosColumn(newColumn);
				}*/
			}
		});
		
		
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				//correction par rapport au projettp3 : remplacement du - par +, pour simplifier et se standardiser au projettp
				if(froggame.snake.get(0).Column + froggame.direction.getPosColumn() > froggame.nbColumns-1){ // definition de bordure pour la grenouille, afin qu'elle ne disparaisse pas au délà du damier
					System.out.println("Limite du damier atteint");
					repaint();
				} 
				else if(froggame.snake.get(0).Column + froggame.direction.getPosColumn() < 0){
					System.out.println("Limite du damier atteint");
					repaint();
				}
				else if(froggame.snake.get(0).Line + froggame.direction.getPosLine() > froggame.nbLines-1){
					System.out.println("Limite du damier atteint");
					repaint();
				}
				else if(froggame.snake.get(0).Line + froggame.direction.getPosLine() < 0){
					System.out.println("Limite du damier atteint");
					repaint();
				}
				else{// si la grenouille est bien sur les dimensions du damier, alors la grenouille peut avancer normalement
					System.out.println("La grenouille avance");
					froggame.moveForward();
					repaint();
				}
			}
		}, 1000, 400);
	}
	
	int getBorderSize() {
		return froggame.nbLines + froggame.nbColumns;
	}
	
	int getCellWidth() {
		return froggame.nbColumns * 30;
	}
	
	int getCellHeight() {
		return froggame.nbLines*30;
	}
	
	int getCellX(Position position) {
		return position.getPosColumn();
	}
	
	int getCellY(Position position) {
		return position.getPosLine();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int line = 0; line <= froggame.nbLines; line++) {
			for (int column = 0; column <= froggame.nbColumns; column++) {
				drawCell(g, line, column);
			}
		}
		g.setColor(Color.BLACK);
		g.drawString("score: " + score, getWidth() - 1080, getHeight() - 1500); //compteur de score

	}
	
	
	void drawCell(Graphics g, int line, int column) {
		// Début de la méthode drawCell
		Position pos = new Position(line, column);
		if(froggame.isBlackCell(pos)) {
			g.setColor(Color.black);
		} else {
			g.setColor(Color.gray);
		}
		
	 if(froggame.isSnakeCell(pos)) {
		g.setColor(Color.green);
	} 
	 if(froggame.isFlyCell(pos)) {
		g.setColor(Color.red);
	}

	if(froggame.isAppleCell(froggame.snake.get(0))) {
		froggame.fly.setPosLine((int)(Math.random()*20));
		froggame.fly.setPosColumn((int)(Math.random()*30));
		score++;
		Position newsnake = new Position(froggame.snake.get(froggame.snake.size()-1).Line, froggame.snake.get(froggame.snake.size()-1).Column+1);
		froggame.snake.add(froggame.snake.size()-1, newsnake);
		System.out.println("votre score: " + score);
	}
	 
		g.fillRect(this.getCellX(pos)*30, this.getCellY(pos)*30, this.getCellWidth(), this.getCellHeight());
		// Fin de la méthode drawCell
		/*g.setColor(Color.white);
		g.fillRect(this.getBorderSize()*2, this.getBorderSize()*2, this.getCellWidth(), this.getCellHeight());
		g.fillRect(0, this.getBorderSize()*2, this.getCellWidth(), this.getCellHeight());
		g.fillRect(this.getBorderSize()*2, 0, this.getCellWidth(), this.getCellHeight());*/
	}
	
	
}
