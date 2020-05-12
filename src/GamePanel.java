import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{
	Timer frameDraw;
	static Player pl = new Player(2000,1000,18,18);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	ObjectManager o = new ObjectManager(pl);
	final int MENU = 0;
    final int GAME = 1;
    final int END = 2;
    int currentState = 0;
    Font titleFont;
    Font menuFont;
    int countDown = 60;
    Timer countdownTimer;
	public void paintComponent(Graphics g){
		if(currentState == MENU) {
			drawMenuState(g);
		} 
		if(currentState == GAME) {
			drawGameState(g);
		} 
		if(currentState == END) {
			drawEndGame(g);
		} 
		
		 
	}
	public static void setPl(Player pl2) {
		pl = pl2;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(currentState == END) {
				currentState = MENU;
			}
			else {
			currentState++;
			countdownTimer.start();	
				}
			}
		if (e.getKeyCode()==KeyEvent.VK_UP ) {
			
		    o.pl.up = true;
		    o.pl.down = false;
		    o.pl.right = false;
		    o.pl.left = false;
			
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {

		    o.pl.down = true;
		    o.pl.up = false;
		    o.pl.right = false;
		    o.pl.left = false;
			
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {

		    o.pl.right = true;
		    o.pl.down = false;
		    o.pl.up = false;
		    o.pl.left = false;
			
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {

		    o.pl.left = true;
		    o.pl.down = false;
		    o.pl.right = false;
		    o.pl.up = false;
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		if(currentState == GAME && e.getSource() == frameDraw) {
			o.update();
		}
		if(e.getSource() == countdownTimer) {
			countDown--;
		}
		if(countDown == 0) {
			currentState = END;
		}
	}
	void drawMenuState(Graphics g) {
		 g.setColor(Color.BLUE);
		    g.fillRect(0, 0, PacMan.WIDTH, PacMan.HEIGHT);
		    g.setFont(titleFont);
		    g.setColor(Color.WHITE);
		    g.drawString("LEAGUE INVADERS", 100, 200);
		    g.setFont(menuFont);
		    g.drawString("Press ENTER to start", 120, 300);
		    g.drawString("Press SPACE for instructions", 100, 380);
	}
	void drawEndGame(Graphics g) {
		g.setColor(Color.RED);
    	g.fillRect(0, 0, PacMan.WIDTH, PacMan.HEIGHT);
        g.setFont(titleFont);
        g.setColor(Color.WHITE);
        g.drawString("GAME OVER", 140, 200);
        g.setFont(menuFont);
        g.drawString("Score = " + ObjectManager.score, 175, 300);
        g.drawString("Press ENTER to Restart", 120, 380);
	}
	void drawGameState(Graphics g) { 
    	o.draw(g);
    	g.drawString("Timer : " + countDown, 400, 15);
    	for (int i = 0; i < o.paths.size(); i++) {
		
		}
    
    	
	}
	GamePanel(){
		frameDraw = new Timer(1000/60,this);
        frameDraw.start();
        countdownTimer = new Timer(1000, this);
        titleFont = new Font("Arial", Font.PLAIN, 35);
        menuFont = new Font("Arial", Font.PLAIN, 25);
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}

