package lab04;

public class Rectangle
{

			private final double width;
			private final double height;
			
			public Rectangle(double width, double height)
			{
				this.width = width;
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
				double a = 10d;
				double b = 5d;
				Rectangle r = new Rectangle (a,b);
				System.out.println(r.getArea());
				System.out.println(r.getPerimeter());
			}
}


