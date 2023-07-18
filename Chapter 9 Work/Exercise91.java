

public class Exercise91 {
	private Double width;
	private Double height;

	public static void main(String[] args) {
		  Exercise91 rect1 = new Exercise91(4, 40);
		  Exercise91 rect2 = new Exercise91(3.5, 35.9);

	        System.out.println("Rectangle 1:");
	        System.out.println("Width: " + rect1.width);
	        System.out.println("Height: " + rect1.height);
	        System.out.println("Area: " + rect1.getArea());
	        System.out.println("Perimeter: " + rect1.getPerimeter());
	        
	        System.out.println("Rectangle 2:");
	        System.out.println("Width: " + rect2.width);
	        System.out.println("Height: " + rect2.height);
	        System.out.println("Area: " + rect2.getArea());
	        System.out.println("Perimeter: " + rect2.getPerimeter());
	    }
	
	public Exercise91() {	
		width = 1.0;
		height = 1.0;
	}
	Exercise91(double newWidth, double newHeight){
		width = newWidth;
		height = newHeight;
	}
	double getArea() {
		double area = width * height;
		return area;
	}
	double getPerimeter() {
		double perimeter = 2 * (width * height);
		return perimeter;
	}
	void setWidth(double newWidth) {
		width = newWidth;
	}
	void setHeight(double newHeight) {
		height = newHeight;
	}
}