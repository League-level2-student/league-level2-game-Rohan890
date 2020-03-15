import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
public class Path extends GameObject{
int hasdot = 1;
	Path(int x, int y, int width, int height){
		super(x,y,width,height);

	}
	 void draw(Graphics g) {
		 if(hasdot == 1) {
	    		g.setColor(Color.blue);
	    		g.fillOval(x+5, y+5, width/4, height/4);
		 }
		 else if(hasdot == 2) {
	    		g.setColor(Color.red);
	    		g.fillOval(x+5, y+5, width/3, height/3); 
		 }
	    	}
	public void setHasDot(int x) {
		hasdot = x;
	}
}
