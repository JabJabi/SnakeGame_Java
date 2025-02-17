package projet.tp5.version2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

public class MainMenuPanel extends JPanel {
	
	MainMenuPanel() {
	this.setLayout(null); 
	repaint();
	}
	int width = -280;
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 1000, 630);
		g.setColor(Color.white);
		g.setFont(new Font("", Font.PLAIN, 100));
		g.drawString("SnakeGame ", (getWidth()/4)-30, getHeight()/2);
		g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString("Par Jab (continuité ProjetTP5)",width, (getHeight()/2)+50);
		play(g);
		Difficulty(g);
		g.setColor(Color.green);
		g.fillRect(250, 195, 435, 10);
		g.setColor(Color.red);
		g.fillRect(700, 188, 25, 25);
		
		
		new Timer().schedule(new TimerTask(){
			@Override
			public void run() {
				movetxt();
				repaint();
				
			}
			
		},1000);
		
	}
	
	void background() {

	}
	
	void movetxt() {
		if(width >= getWidth()) {
			width = -280;
		}else {
			width+=100;
		}
	}
	
	void play(Graphics g) {
		g.fillRect((getWidth()/4)+130, getHeight()/2+100, 250, 50);
		g.setColor(Color.black);
		g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString("Jouer",(getWidth()/4)+230, (getHeight()/2)+130);
		
	}
	
	void Difficulty(Graphics g) {
		g.setColor(Color.white);
		g.fillRect((getWidth()/4)+130, getHeight()/2+190, 250, 50);
		g.setColor(Color.black);
		g.setFont(new Font("", Font.PLAIN, 20));
		g.drawString("Difficulté",(getWidth()/4)+215, (getHeight()/2)+225);
	}
	
	

}
