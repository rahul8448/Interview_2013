public class Recursion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Recursion rs=new Recursion();
		//System.out.println(rs.fiboNum(6));
		
		rs.subStringPrint("ABCD", 1, 0);

	}

	public int fiboNum(int nth) {
		
		if (nth == 0)
			return 0;
		else if (nth == 1)
			return 1;
		else {
			
			return fiboNum(nth-1)+fiboNum(nth-2); 
		}
		
	}
	
	public String subStringPrint(String word,int end,int start)
	{
	    if(end>word.length())
	    	return null;
	    	
		String tmp1=word.substring(start, end);
		System.out.println(tmp1);
		end++; 
		int pos=end;
		//char c=word.charAt(end);	
		return subStringPrint(word,end,start);
		
	   
	}
}
