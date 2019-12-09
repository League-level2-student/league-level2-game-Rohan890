import javax.swing.JFrame;

public class PacMan {
	public static final int WIDTH = 700;
	public static final int HEIGHT = 300;
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

	}
	void setup() {
		
	}
}

