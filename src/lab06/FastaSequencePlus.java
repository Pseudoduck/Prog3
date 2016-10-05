package lab06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Comparator;
import java.util.LinkedHashMap;;

public class FastaSequencePlus
{
	private String header;
	private String sequence;

	public FastaSequencePlus(String header, String sequence)
	{
		this.header = header;
		this.sequence = sequence;
	}

	public static List <FastaSequencePlus> readFastaFile(File file) throws Exception
	{
		List<FastaSequencePlus> fList = new ArrayList<FastaSequencePlus>();
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line="";
		String fastaHeader ="";
		String fastaSeq="";
		
		while ((line=reader.readLine()) != null)
		{	
			if (line.charAt(0)== '>')
				{
					fastaHeader = line.substring(1);
				}
			else
				{
					fastaSeq = line;
					fList.add(new FastaSequencePlus(fastaHeader,fastaSeq));
				}
		}
		reader.close();
		return fList;			
	}	
		
	public String getHeader()
	{
		return this.header; 
	}
		
	public String getSequence()
	{
		return this.sequence; 
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
	
	public static void writeUnique(File inFile, File outFile) throws Exception
	{
		List <FastaSequencePlus> fList = FastaSequencePlus.readFastaFile(inFile);
		HashMap<String, Integer> uniSeq = new HashMap<String, Integer>();
		for (FastaSequencePlus fs:fList)
		{
			Integer count = uniSeq.get(fs.getSequence());
			if (count == null)
			{
				count = 0;
			}
			count ++;
			uniSeq.put(fs.getSequence(),count);
		}
		
		Map<String,Integer> uniSeqSorted = mapSorted(uniSeq);
		BufferedWriter writeFile = new BufferedWriter(new FileWriter(outFile));
		for (Map.Entry<String, Integer> a : uniSeqSorted.entrySet())
		{
			String key = a.getKey();
			Integer value = a.getValue();
			writeFile.write("\n" + ">" + value + "\n" + key + "\n");
			writeFile.flush();
		}
		writeFile.close();
	}
	
	private static HashMap mapSorted (HashMap map)
	{
		List myList = new LinkedList(map.entrySet());
		Collections.sort
		(
			myList, new Comparator()
			{
				public int compare (Object ob1, Object ob2)
				{
					return ( (Comparable) ((Map.Entry)(ob1)).getValue()).compareTo(((Map.Entry)(ob2)).getValue());
				}
			}
		);
		
		HashMap hashMapSorted = new LinkedHashMap();
		for (Iterator a = myList.iterator(); a.hasNext();)
		{
			Map.Entry myEntry = (Map.Entry)a.next();
			hashMapSorted.put(myEntry.getKey(), myEntry.getValue());
		}
		return hashMapSorted;
	}
		
	public static void main(String[] args) throws Exception
	{
		File inFile = new File ("D:\\Programming\\Cygwin64\\home\\Lei Zhao\\labSixSampleInput.fasta");
		File outFile = new File ("D:\\Programming\\Cygwin64\\home\\Lei Zhao\\labSixOutput.txt");
		List<FastaSequencePlus> fastaList = FastaSequencePlus.readFastaFile(inFile);
		
		for( FastaSequencePlus fs : fastaList)
		{
			System.out.println(fs.getHeader());
			System.out.println(fs.getSequence());
			System.out.println(fs.getGCRatio());
		}
		writeUnique(inFile,outFile);
	}
	
}