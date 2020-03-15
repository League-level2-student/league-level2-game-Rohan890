import java.awt.Color;
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
	
	public void paintComponent(Graphics g){
		 drawGameState(g);
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
		o.update();
	}
	void drawGameState(Graphics g) { 
    	o.draw(g);
    	for (int i = 0; i < o.paths.size(); i++) {
			
		}
    	
    	
	}
	GamePanel(){
		frameDraw = new Timer(1000/60,this);
        frameDraw.start();
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

