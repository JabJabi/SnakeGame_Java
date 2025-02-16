package projet.tp5.version2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class DifficultyPanel extends JPanel{
	
	DifficultyPanel() {
	this.setLayout(null);
	repaint();
	}
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 630);
	}
}
