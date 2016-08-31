package lab02;

import java.util.Random;

public class Page03
{

	public static void main (String[] args)
	
	{
		for (int x = 0; x < 10; x++)
		{
			Random random = new Random();
		
			System.out.println(random.nextInt(444));
		}
	}
	
}
