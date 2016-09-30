package lab05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class FastaSequence 
{	
	private String header;
	private String sequence;
	
	public FastaSequence(String header, String sequence)
	{
		this.header = header;
		this.sequence = sequence;
	}
	
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
		List<FastaSequence> fList = new ArrayList<FastaSequence>();
		BufferedReader reader = new BufferedReader(new FileReader(new File(filepath)));
		String line = reader.readLine();
		String fastaHeader ="";
		String fastaSeq="";
		
		while (line != null) 
			{
			if (line.charAt(0) == '>')
				fastaHeader = line.substring(1);
			else
				fastaSeq = line;
				fList.add(new FastaSequence(fastaHeader,fastaSeq));
			reader.close();
			}
		return fList;
				
	}	
		
	public String getHeader()
	{
		return header; 
	}
		
	public String getSequence()
	{
		return sequence; 
	}
		
	public float getGCRatio()
	{
		float numC = 0;
		float ratio;
		for (int i = 0; i < sequence.length(); i++)
		{
			if (sequence.charAt(i) == 'G' || sequence.charAt(i) == 'C')
			{
				numC++;
			}
		}
		ratio = numC/sequence.length();
		return ratio;
	}
		
	
}