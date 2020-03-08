import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class Path extends GameObject{
boolean hasdot = true;
	Path(int x, int y, int width, int height){
		super(x,y,width,height);

	}
	 void draw(Graphics g) {
		 if(hasdot) {
	    		g.setColor(Color.blue);
	    		g.fillOval(x+5, y+5, width/4, height/4);
		 }
	    	}
}
