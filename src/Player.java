import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Player extends GameObject{
	boolean up = false;
	boolean down = false;
	boolean right = false;
	boolean left = false;

	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	 Player( int x, int y, int width, int height) {
		super(x,y,width,height);
		speed = 5;
		if (needImage) {
		    loadImage ("2.png");
		}
	}
	 void draw(Graphics g) {
	     if (gotImage) {
	    		g.drawImage(image, x, y, width, height, null);
	    	} else {
	    		g.setColor(Color.BLUE);
	    		g.fillRect(x, y, width, height);
	    	}
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
}
