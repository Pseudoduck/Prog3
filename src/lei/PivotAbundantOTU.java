package lei;

import java.util.HashMap;

import parser.AbundOTUClustParser;

public class PivotAbundantOTU
{

	public static HashMap<String, HashMap<String,Integer>> getCountMap( HashMap<String, String> inMap ) throws Exception{
		HashMap<String, HashMap<String,Integer>> map = new HashMap<String, HashMap<String,Integer>>();
		
		for(String s : inMap.keySet())
		{
			String[] splits = s.split("_");
			
			if( splits.length != 2)
				throw new Exception(s);
			
			String fileName = splits[1];
			
			HashMap<String, Integer> innerMap = map.get(fileName);
			
			if( innerMap == null)
			{
				innerMap = new HashMap<String,Integer>();
				map.put(fileName, innerMap);
			}
			
			String otuName = "Consensus" + inMap.get(s);
			
			Integer count = innerMap.get(otuName);
			
			if(count == null)
				count =0;
			
			count++;
			
			//System.out.println("Putting  " + otuName +" " + count);
			innerMap.put(otuName, count);
		}
		
		return map;
	}
	
	public static void main(String[] args) throws Exception
	{
		HashMap<String,String> map = 
		AbundOTUClustParser.getSequenceToOtuMap("D:\\Programming\\Cygwin64\\home\\Lei Zhao\\outputC.clust");
		
		System.out.println(map.size());
		
		int x =0;
		for(String s : map.keySet())
				{
					if(++x <10)
					System.out.println(s +" " + map.get(s));
				
				}
		
		// outer key is sample; inner key is abundantOTU identifier
		HashMap<String, HashMap<String,Integer>>  countMap= getCountMap(map);
		
		for(String s : countMap.keySet())
		{
			System.out.println(s);

			HashMap<String,Integer> innerMap = countMap.get(s);
			
			for(String s2 : innerMap.keySet())		
			{
				System.out.println("\t"+ s2 +" " + innerMap.get(s2));
			}
		}

	}
}
