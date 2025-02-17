package projet.tp5.version2;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainSnakeGame {
	static int a = 250;
	static SnakeGamePanel game;
	static GameOverPanel gameover = new GameOverPanel();
	static JFrame frame = new JFrame("Mon magnifique Serpent");
	static MainMenuPanel MainMenupanel = new MainMenuPanel();
	public static void main(String[] args) {
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
					if(game.snakeGame.isGameOver()) {
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
					        JButton btn1 = new JButton(" ");
					        JButton btn2 = new JButton("  ");
					        JButton btn3 = new JButton("   ");
					        JButton btn4 = new JButton("    ");

					        btn1.addActionListener(event -> handleButtonClick(event));
					        btn2.addActionListener(event -> handleButtonClick(event));
					        btn3.addActionListener(event -> handleButtonClick(event));
					        btn4.addActionListener(event -> handleButtonClick(event));

					        diff.add(btn1);
					        diff.add(btn2);
					        diff.add(btn3);
					        diff.add(btn4);
					        btn1.setOpaque(false);
					        btn1.setContentAreaFilled(false);
					        btn2.setOpaque(false);
					        btn2.setContentAreaFilled(false);
					        btn3.setOpaque(false);
					        btn3.setContentAreaFilled(false);
					        btn4.setOpaque(false);
					        btn4.setContentAreaFilled(false);
					        btn1.setBounds((diff.getWidth()/4)+130, (diff.getHeight()/2)-100, 250, 50);
					        btn2.setBounds((diff.getWidth()/4)+130, diff.getHeight()/2, 250, 50);
					        btn3.setBounds((diff.getWidth()/4)+130, diff.getHeight()/2+100, 250, 50);
					        btn4.setBounds(50, 50, 100, 25);
					        
					        

						}
					});
			}
		},1000,1000);
		
	}


    private static void handleButtonClick(ActionEvent e) {
        JButton source = (JButton) e.getSource();

        if (source.getText().equals(" ")) {
        	a = 500;
        } else if (source.getText().equals("  ")) {
        	a = 250;
        } else if (source.getText().equals("   ")) {
        	a= 100;
        } else if(source.getText().equals("    ")) {
        	frame.setContentPane(MainMenupanel);
        }
    }
	public static Container getpanel() {
		return frame.getContentPane();
	}
}		
// menu wiki, credits, background et minijeu et son au menu
//menu edit vitesse & difficulté -> gui et qlq detail si possible
//finir coté blanc (avec vrai stats)
//multiplayer?
//refactoring