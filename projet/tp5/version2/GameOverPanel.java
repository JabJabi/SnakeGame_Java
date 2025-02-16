package projet.tp5.version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class GameOverPanel extends JPanel{
	
	GameOverPanel() {
		setFocusable(true);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_B) {
					MainSnakeGame.frame.setContentPane(MainSnakeGame.MainMenupanel);
					MainSnakeGame.frame.revalidate();
					MainSnakeGame.frame.repaint();
					MainSnakeGame.game.snakeGame.gameover= false;
					
			}
			}
		});
		
	repaint();
	}
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 630);
		g.setColor(Color.white);
		g.setFont(new Font("", Font.PLAIN, 100));
		g.drawString("Game Over !", (getWidth()/4)-30, getHeight()/2);
		g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString("Appuyez sur le bouton B du clavier pour retourner au menu principal",(getWidth()/4)-60, (getHeight()/2)+50);
	}
}
