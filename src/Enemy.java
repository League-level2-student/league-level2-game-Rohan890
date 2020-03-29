import java.util.Random;

public class Enemy extends GameObject{
	Path target;
	
	Enemy(int x,int y,int width, int height){
		super(x,y,width,height);
	}
void draw() {
	
}
void update() {
	if(x<target.x) {
		x++;
	}
	else if(x>target.x){
		x--;
	}
	else if(y<target.y){
		y++;
	}
	else if(y>target.y){
		y--;
	}
	else {
		Random rand = new Random(); 
		int r = rand.nextInt(target.neighbors.size());
		target = target.neighbors.get(r);
	}
}
}
