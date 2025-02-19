package projet.tp5.version2;


public class Water implements Obstacle {
	Position water;
	
	public Water(Position apple) {
		this.water = apple;
	}
	
	public Position Get() {
		return water;
	}
	
}
