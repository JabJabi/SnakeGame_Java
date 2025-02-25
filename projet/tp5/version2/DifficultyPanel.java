package projet.tp5.version2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DifficultyPanel extends JPanel{
	
	DifficultyPanel() {
	this.setLayout(new BorderLayout());
	repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 630);
		easy(g);
		normal(g);
		hard(g);
		retour(g);
	}
	
	void easy(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((getWidth()/4)+130, getHeight()/2-100, 250, 50);
		g.setColor(Color.black);
		g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString("Facile  ★",(getWidth()/4)+225, (getHeight()/2)-70);
	}
	void normal(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((getWidth()/4)+130, getHeight()/2, 250, 50);
		g.setColor(Color.black);
		g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString("Normal  ★★",(getWidth()/4)+220, (getHeight()/2)+30);
	}
	void hard(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((getWidth()/4)+130, getHeight()/2+100, 250, 50);
		g.setColor(Color.black);
		g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString("Difficile ★★★",(getWidth()/4)+210, (getHeight()/2)+130);
	}
	
	void retour(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(50, 50, 100, 25);
		g.setColor(Color.black);
		g.fillRoundRect(20, 25, 35, 35, 17, 45);
		g.fillRoundRect(20, 65, 35, 35, 17, 45);
		g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString("Retour",70, 68);
		//g.fillRoundRect(ALLBITS, ABORT, WIDTH, HEIGHT, WIDTH, HEIGHT);
	}
}
