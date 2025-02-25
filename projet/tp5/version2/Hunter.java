package projet.tp5.version2;


public class Hunter implements Obstacle {
	Position hunter;
	
	public Hunter(Position hunter) {
		this.hunter = hunter;
	}
	

	public Position Get() {
		return hunter;
	}
	
	//peut etre ajouter le code de mouvement & de gameover ici? à voir plus tard 
	
	
}
