package projet.tp5.version1;

public class Position {
	int Line;
	int Column;
	
	public Position() {
		
	}
	public Position(int Line, int Column) {
		this.Line = Line;
		this.Column = Column;
	}
	
	public int getPosLine() {
		return this.Line;
	}
	
	public int getPosColumn() {
		return this.Column;
	}
	public void setPosLine(int l) {
		this.Line = l;
	}
	
	public void setPosColumn(int c) {
		this.Column = c;
	}
	
	public boolean equals(Position other) {
		if(this.Line == other.Line && this.Column == other.Column) {
			return true;
		} else {
			return false;
		}
	}
}
