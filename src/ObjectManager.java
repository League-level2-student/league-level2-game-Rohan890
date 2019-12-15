import java.awt.Graphics;

public class ObjectManager {
Player pl;
ObjectManager(Player pl) {
	this.pl = pl;
}
void draw(Graphics g) {
	pl.draw(g);
}
void update() {
	pl.update();
}
}
