package projet.tp5.version2;

public class Position {
	int Line;
	int Column;
	
	public Position() {
		
	}
	public Position(int Line, int Column) {
		this.Line = Line;
		this.Column = Column;
	}
		
	public boolean equals(Position other) {
		if(this.Line == other.Line && this.Column == other.Column) return true;
		return false;
	}
}
