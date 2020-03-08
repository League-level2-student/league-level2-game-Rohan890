import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Wall extends GameObject{


	Wall(int x, int y, int width, int height){
		super(x,y,width,height);

	}
	 void draw(Graphics g) {
	    		g.setColor(Color.BLACK);
	    		g.fillRect(x, y, width, height);
	    		
	    	}

}


