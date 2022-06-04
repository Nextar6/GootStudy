package edu.java.string03;

class Point{
	private double x;
	private double y;
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public String toString() {
		
		return "(" + x + "," + y + ")";
	}
	
	@Override
	public boolean equals(Object obj) { // object : 모든 클래스의 super 클래스
		boolean result = false;
		
		
		if(obj instanceof Point) {
			Point pt = (Point) obj; // 강제 형변환
			if(x== pt.x && y == pt.y) {
				result = true;
			}
			
		}
		return result;
	}
}// end point
public class StringMain03 {

	public static void main(String[] args) {
		Point pt1 = new Point(1, 2);
		System.out.println(pt1);
		
		Point pt2 = new Point(1, 2);
		System.out.println(pt2);
		
		if(pt1.equals(pt2)) { // 두개의 좌표가 같은지 비교
			System.out.println("같은 좌표");
		} else {
			System.out.println("다른 좌표");
			
		}
				

	} // end main()

} // end StringMain03
