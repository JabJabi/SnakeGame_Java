package projet.tp5.version2;

public class Apple implements Obstacle{
	Position apple;
	
	public Apple(Position apple) {
		this.apple = apple;
	}
	
	public Position Get() {
		return apple;
	}

}
