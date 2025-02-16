package projet.tp5.version2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class MainSnakeGame {
	static int a = 250;
	static SnakeGamePanel game;
	static GameOverPanel gameover = new GameOverPanel();
	static JFrame frame = new JFrame("Mon magnifique Serpent");
	static MainMenuPanel MainMenupanel = new MainMenuPanel();
	public static void main(String[] args) throws InterruptedException {
		JButton btn = new JButton();
		JButton dtn = new JButton();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setSize(1000, 630);
		MainMenupanel.add(btn);
		MainMenupanel.add(dtn);
		btn.setBounds(377, 397, 250, 50);
		btn.setOpaque(false);
		btn.setBorderPainted(false);
		btn.setContentAreaFilled(false);
		dtn.setBounds(377, 487, 250, 50);
		dtn.setOpaque(false);
		dtn.setBorderPainted(false);
		dtn.setContentAreaFilled(false);
		frame.add(MainMenupanel);
		frame.setVisible(true);
		frame.setResizable(false);
		game = new SnakeGamePanel();
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
					btn.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							game = new SnakeGamePanel();
							frame.setContentPane(game);
							frame.revalidate();
							frame.repaint();
					        game.requestFocusInWindow();
					        game.started =2;
						}
					});
					if(game.snakeGame.gameover) {
						frame.setContentPane(gameover);
						gameover.requestFocusInWindow();
						frame.revalidate();
						frame.repaint();
						game = new SnakeGamePanel();
					} 
					dtn.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
					        DifficultyPanel diff = new DifficultyPanel();
					        frame.setContentPane(diff);
					        frame.revalidate();
					        frame.repaint();
					        frame.setLayout(new FlowLayout());
					        JButton btn1 = new JButton("Facile");
					        JButton btn2 = new JButton("Normal");
					        JButton btn3 = new JButton("Difficile");
					        JButton btn4 = new JButton("Retour");

					        btn1.addActionListener(event -> handleButtonClick(event));
					        btn2.addActionListener(event -> handleButtonClick(event));
					        btn3.addActionListener(event -> handleButtonClick(event));
					        btn4.addActionListener(event -> handleButtonClick(event));

					        diff.add(btn1);
					        diff.add(btn2);
					        diff.add(btn3);
					        diff.add(btn4);
					        btn1.setBounds(0, 0, 100, 100);
					        btn2.setBounds(0, 100, 100, 100);
					        btn3.setBounds(0, 200, 100, 100);
					        btn4.setBounds(0, 300, 100, 100);
					        

						}
					});
			}
		}, 1000, 1000);
	



		
		// menu wiki, credits, background et minijeu et son au menu
		//menu edit vitesse & difficulté -> gui et qlq detail si possible
		//finir coté blanc (avec vrai stats)
		//multiplayer?
		//refactoring
		
	}


    private static void handleButtonClick(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source.getText().equals("Facile")) {
        	a = 500;
        } else if (source.getText().equals("Normal")) {
        	a = 250;
        } else if (source.getText().equals("Difficile")) {
        	a= 100;
        } else if(source.getText().equals("Retour")) {
        	frame.setContentPane(MainMenupanel);
        }
    }
	public static Container getpanel() {
		return frame.getContentPane();
	}
}