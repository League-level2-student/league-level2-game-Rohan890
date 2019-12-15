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
	Player pl = new Player(200,100,50,50);
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	ObjectManager o = new ObjectManager(pl);
	
	public void paintComponent(Graphics g){
		 drawGameState(g);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==KeyEvent.VK_UP) {
			
		    pl.up = true;
		    pl.down = false;
		    pl.right = false;
		    pl.left = false;
			
		}
		if (e.getKeyCode()==KeyEvent.VK_DOWN) {

		    pl.down = true;
		    pl.up = false;
		    pl.right = false;
		    pl.left = false;
			
		}
		if (e.getKeyCode()==KeyEvent.VK_RIGHT) {

		    pl.right = true;
		    pl.down = false;
		    pl.up = false;
		    pl.left = false;
			
		}
		if (e.getKeyCode()==KeyEvent.VK_LEFT) {

		    pl.left = true;
		    pl.down = false;
		    pl.right = false;
		    pl.up = false;
			
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
    	
		g.setColor(Color.BLACK);
    	o.draw(g);
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

