
public class lineSegment {
	//properties that all LineSegment
	//objects have values for go at the top of the class defination
	//<modifier> <type> <name>;
	//modifier should be public or private
	
	public int x1;
	public int y1;
	public int x2;
	public int y2;
	
	//0 , 0 , 50, 100
	public lineSegment (int x1, int y1, int x2, int y2) {
		if (x2 == x1 || y2 == y1) {
			//throw "Cannot be Zero";
		}
		this.x1 = x1; //take included parameter and apply to previous public int
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	//Go to source, go to toString() to generate to string 
	@Override
	public String toString() {
		return "lineSegment [x1=" + x1 + ", y1=" 
				+ y1 + ", x2=" + x2 + ", y2=" + y2 + "]";
	}
	
	/*
	 * Slope() returns rise over run
	 * returns the rate of change of the linesegment
	 */
	public double slope() {
		if (x2 == x1) {
			throw new ArithmeticException("Slope of a vertical line is undefined");
		}
		double xDiff = x2 - x1;
		double yDiff = y2 - y1;
		
		return yDiff / xDiff;
	}
	
	public double length() {
		double xDiff = x2 - x1;
		double yDiff = y2 - y1;
		
		return (Math.sqrt((xDiff * xDiff) + (yDiff * yDiff)));
	}
	
	
}
