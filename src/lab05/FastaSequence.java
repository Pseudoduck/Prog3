package lab05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;

public class FastaSequence 
{	
	public static void main(String[] args) throws Exception
	{
		List<FastaSequence> fastaList = 
				FastaSequence.readFastaFile("D:\\Programming\\Cygwin64\\home\\Lei Zhao\\sample.fasta");

		for( FastaSequence fs : fastaList)
		{
			System.out.println(fs.getHeader());
			System.out.println(fs.getSequence());
			System.out.println(fs.getGCRatio());
		}
	}
	
	public static List<FastaSequence>readFastaFile(String filepath) throws Exception
	{
		List<FastaSequence> headerList = new ArrayList<FastaSequence>();
		List<FastaSequence> sequenceList = new ArrayList<FastaSequence>();
		double numC = 0;
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		String nextLine1 = reader.readLine();
		String nextLine2 = reader.readLine();
		String nextLine3 = reader.readLine();
		
		while (nextLine1 != null) 
			{
			if (nextLine1.charAt(0) == '>')
				headerList.add(nextLine1.substring(1));
				nextLine1 = reader.readLine();
			}
			return headerList;
				
		while (nextLine2 != null) 	
			{
				if (!(nextLine1.charAt(0) == '>'))
				sequenceList.add(nextLine2);
				nextLine2 = reader.readLine();
			}
			return sequenceList;
		
		while (nextLine3 != null)
			
			for (int x =0; x < nextLine3.length();x++)
				
				if (!(nextLine3.charAt(0) == '>') && nextLine3.charAt(x)=='G' ||nextLine3.charAt(x)=='C' )
				{
					numC += 1;	
				}
			double ratio = numC/nextLine3.length();
			return ratio;
			
		public String getHeader()
		{
			return headerList; 
		}
		
		public String getSequence()
		{
			return sequenceList; 
		}
		
		public String getGCRatio()
		{
			return ratio; 
		}
		
		}

}