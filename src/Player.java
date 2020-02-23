import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Timer;

public class Player extends GameObject implements ActionListener{
	Timer t = new Timer(100, this);
	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	static ArrayList<Player> pacman = new ArrayList<Player>();
	Player pl;
	Player pl2;
	Player pl3;
	 Player( int x, int y, int width, int height) {
		super(x,y,width,height);
		speed = 1;
		if (needImage) {
		    loadImage ("2.png");
		}
	}
	 void draw(Graphics g) {
	     if (gotImage) {
	    		g.drawImage(image, x, y, width, height, null);
	    	} else {
	    		g.setColor(Color.yellow);
	    		g.fillRect(x, y, width, height);
	    		g.setColor(Color.black);
	    		g.drawRect(x, y, width, height);
	    	}
	 }
	 void addPlayers() {
		 pacman.add(pl);
		 pacman.add(pl2);
		 pacman.add(pl3);
	 }

	 void update() {
		 int xx = this.x;
		 int yy = this.y;
		 if(up == true) {
			 yy-= speed;
		 }
		 if(down == true) {
			 yy+= speed;
		 }
		 if(right == true) {
			 xx+= speed;
		 }
		 if(left == true) {
			 xx-= speed;
		 }
		 if(ObjectManager.checkCollision(xx,yy,width,height) == false) {
			 x = xx;
			 y = yy;
		 }
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
	@Override
	public void actionPerformed(ActionEvent e) {

	}
}
