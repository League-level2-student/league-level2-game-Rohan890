import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class ObjectManager {
	static Player pl;
	static BufferedImage level1;
	static ArrayList<Wall> walls = new ArrayList<Wall>();
	static ArrayList<Path> paths = new ArrayList<Path>();
	int wallsize = 20;
	static int score = 0;
	ObjectManager(Player pl) {
		this.pl = pl;
		level1 = loadImage("map.png");
		createLevel(level1);
	}

	void createLevel(BufferedImage image) {
		for (int x = 0; x < image.getWidth(); x++) {
			for (int y = 0; y < image.getHeight(); y++) {
				System.out.println(image.getRGB(x, y));
				if (image.getRGB(x, y) == -16777216) {
					walls.add(new Wall(x * wallsize, y * wallsize, wallsize, wallsize));
				}

				if (image.getRGB(x, y) == -328966) {
					pl = new Player(x * wallsize, y * wallsize, 16, 16);
				}
				if(image.getRGB(x, y) == -1) {
					paths.add(new Path(x * wallsize, y * wallsize, wallsize, wallsize));
				}
				if(image.getRGB(x, y) == -15271418) {
					Path p = new Path(x * wallsize, y * wallsize, wallsize, wallsize);
					p.setHasDot(2);
					paths.add(p);
					
				}
			}
		}
		linkPaths();
	}
	void linkPaths() {
		for(int i = 0; i<paths.size(); i++) {
			checkCollision(paths.get(i));
		}
	}
	void checkCollision(Path p){
		ArrayList<Path> neighbors = new ArrayList<Path>();
		for (int j = 0; j < wallsize+2; j++) {
			int x = p.x+j;
			for (int i = 0; i < paths.size(); i++) {
				if(paths.get(i).doesCollide(x, p.y)== true) {
					neighbors.add(paths.get(i));
				}
			}
		}
		for (int j = 0; j < wallsize+2; j++) {
			int x = p.x-j;
			for (int i = 0; i < paths.size(); i++) {
				if(paths.get(i).doesCollide(x, p.y)== true) {
					neighbors.add(paths.get(i));
				}
			}
		}
		for (int j = 0; j < wallsize+2; j++) {
			int y = p.y+j;
			for (int i = 0; i < paths.size(); i++) {
				if(paths.get(i).doesCollide(p.x, y)== true) {
					neighbors.add(paths.get(i));
				}
			}
		}
		for (int j = 0; j < wallsize+2; j++) {
			int y = p.y-j;
			for (int i = 0; i < paths.size(); i++) {
				if(paths.get(i).doesCollide(p.x, y)== true) {
					neighbors.add(paths.get(i));
				}
			}
		}
		p.setNeighbor(neighbors);
	}

	void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, PacMan.WIDTH, PacMan.HEIGHT);
		for (int i = 0; i < walls.size(); i++) {
			walls.get(i).draw(g);
			
		}
		for (int i = 0; i < paths.size(); i++) {
			paths.get(i).draw(g);
			
		}

		pl.draw(g);
		g.setColor(Color.WHITE);
		g.drawString(score + "", 10, 10);
	}

	void update() {
		pl.update();
		for (int i = 0; i < walls.size(); i++) {
			walls.get(i).update();
		}
	}


	public static boolean checkWallCollision(int x, int y, int width, int height) {
		Rectangle r = new Rectangle(x, y, width, height);
		for (int i = 0; i < walls.size(); i++) {
			if (r.intersects(walls.get(i).collisionBox)) {
				return true;
			}

		}
		return false;
	}
	public static void checkPathCollision(int x, int y, int width, int height) {
		Rectangle r = new Rectangle(x, y, width, height);
		for (int i = 0; i < paths.size(); i++) {
			if (r.intersects(paths.get(i).collisionBox) && paths.get(i).hasdot > 0) {
				paths.get(i).hasdot = 0;
				score+=1;
				
			}
			
		}

	}

	BufferedImage loadImage(String imageFile) {

		try {
			return ImageIO.read(this.getClass().getResourceAsStream(imageFile));

		} catch (Exception e) {

		}
		return null;

	}
}
