package lec05;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.util.Random;

public class Page31
{
	public static void main(String[] args) throws Exception
	{
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("D:\\My Zone\\Downloads\\tempfile.txt")));	
		
		Random random = new Random();
		writer.write("col1\tcol\t");
		
		for (int x=0; x<10; x++)
		{
			writer.write(x + "\t" + random.nextFloat() + "\n");
		}
		writer.flush(); writer.close();
	}
}
	
