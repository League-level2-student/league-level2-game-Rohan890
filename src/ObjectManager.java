import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
static Player pl;
static ArrayList<Wall> walls = new ArrayList<Wall>();
Wall w = new Wall(150,100,20,70);
Wall e = new Wall(300,150,20,70);
Wall r = new Wall(100,25,20,70);
ObjectManager(Player pl) {
	this.pl = pl;
	addWalls();
}
void addWalls() {
	walls.add(w);
	walls.add(e);
	walls.add(r);
}
void draw(Graphics g) {
	pl.draw(g);
	for (int i = 0; i < walls.size(); i++) {
		walls.get(i).draw(g);
	}
}
void update() {
	pl.update();
	for (int i = 0; i < walls.size(); i++) {
		walls.get(i).update();
	}
}
public static boolean checkCollision(){
	for (int i = 0; i < walls.size(); i++) {
		if (pl.collisionBox.intersects(walls.get(i).collisionBox)) {
			return true;
		}
	
	}
	return false;
	
}
}
