import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class PacMan {
	public static final int WIDTH = 495;
	public static final int HEIGHT = 545;
	GamePanel g;
	public static void main(String[] args) {
		PacMan p = new PacMan();
		p.createGUI();
		

	}
	PacMan(){
		g = new GamePanel();
	}
	void createGUI() {
		JFrame frame = new JFrame();
		frame.add(g);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(g);
		g.setBackground(Color.WHITE);

	}
	void setup() {

	}
}

