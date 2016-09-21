package lab04;

public class Rectangle
{
	double width;
	double height;
	
	public Rectangle(double width, double height)
	{
		this.width = width;       //cannot calculate without these two
		this.height = height;  
	}

	public double getArea()
	{
		return width * height;
	}
	
	public double getPerimeter()
	{
		return 2 * width + 2 * height;
	}

	public static void main(String[] args) throws Exception
	{
		Rectangle r = new Rectangle(10,5);
		System.out.println(r.getArea());
		System.out.println(r.getPerimeter());
	}
}


