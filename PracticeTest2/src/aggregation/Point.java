package aggregation;

public class Point {
	
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals (Object obj) {
		if(this == obj) { 
			return true; 
		}
		
		if (obj == null | this.getClass() != obj.getClass()) {
			return false;
		}

		Point other = (Point) obj;
		return this.x == other.x && this.y == other.y; 
	} 

	public Point(Point point) {
		this (point.x, point.y);
	}

	public int getX() {
		return this.x;
	}

	public void setX(int i) {
		this.x = i;
		
	}
	
	

}
