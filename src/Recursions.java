
public class Recursions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Recursions rs=new Recursions();
		int array[]={1,2,3,4,5,6,10};
		//rs.binarySearch(array, array.length, 0, 0  );
		
		//rs.permute(null, "ABCD".length()-2, "ABCD".length()-1, "ABCD");
		//rs.permute("ABCD", "ABCD",1);
		//rs.reverseUsingRec("ABCD", "ABCD".length()-1);
		//rs.permutation("ABCD");
		rs.perm("ABCD");

	}
	
	public Integer binarySearch(int[] array, int high, int low ,int target )
	{    

	    if(low<0 || high>=array.length)
	    {
	      return null;
	    } 

	    int mid=(high+low)/2;
	    int val=array[mid];

	    if(val==target)
	    {
	      System.out.println(mid);	
	      return mid; 
	    }
	    else if (val<target)
	    {
	        low=mid+1;
	        binarySearch(array,high,low ,target);  
	    }
	    else if (val>target)
	    {
	        high=mid-1;
	        binarySearch(array,high,low ,target);  
	    }
	    return null;
	}
	
	public void permute(String temp, int first, int last,String word)
	{
	 
	   if(temp!=null && temp.equalsIgnoreCase(word))
	   {
	      //System.out.println(word);
	      return;   
	   }
	   else
	   {
	      if(last==0)
	      {
	         last=word.length()-1;
	         first=last-1;
	      }
	      if(temp==null)
	      temp=word;	  
	      char c1=temp.charAt(first);
	      char c2=temp.charAt(last);
	      char []tmp=temp.toCharArray();
	      tmp[first]=c2;
	      tmp[last]=c1;
	      temp=covertToString(tmp);
	      System.out.println(temp);
	      if(first>0)
	      {
	        first--;
	      }
	      else if(first==0 && last!=first)
	      {
	         last--;
	      }
	      permute(temp,first,last,word);
	  
	   }
	     
	}
	public String permute(String secondHalf,String firstHalf,int divideFrm)
	{
	   int len=secondHalf.length();
	   
	   if(len==2)
	   {
		   char array[]=secondHalf.toCharArray();
		   char c0=array[0];
		   char c1=array[1];
		   array[0]=c1;
		   array[1]=c0;
		   String temp= covertToString(array);
		   firstHalf=firstHalf.concat(temp);
		   return firstHalf;
	   }
	   else
	   {
		   //secondHalf=firstHalf;
		   firstHalf=secondHalf.substring(0,divideFrm);
		   secondHalf=secondHalf.substring(divideFrm);
		   String res= permute(secondHalf,firstHalf,divideFrm++);
		   System.out.println(res);
	   }
	   return null;
		     
	}

	private String covertToString(char[] tmp) {
		// TODO Auto-generated method stub
		
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<tmp.length;i++)
		{
			char c=tmp[i]; 
			sb.append(c);
		}
		return sb.toString();
	}
	StringBuffer sb=new StringBuffer();
	public String reverseUsingRec(String word, int pos)
	{
	   
	   if(pos<0)
	   {
		 System.out.println(sb.toString());  
	     return sb.toString();
	   }
	   else
	   {
	      char c=word.charAt(pos);
	      sb.append(c);
	      pos--;
	      return reverseUsingRec(word,pos);  
	   }
	             
	}
	
	public  static void permutation(String str) { 
	    permutation("", str); 
	 }

	 private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	        {	
	        	
	           permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
		           //permutation(prefix + str.charAt(i), str.substring(i+1, n));
	           
	        }  
	    }

	    
	}
	   StringBuffer sb1=new StringBuffer(4);
	    public void perm(String word)
	    {
	    
	    	int len=word.length();
	    	if(sb.length()==4)
	    	{
	    		System.out.println(sb.toString());
	    		sb1=new StringBuffer();
	    		return ;
	    	}
	    	
	    	for(int i=0;i<len;i++)
	    	{
	    		String str1=String.valueOf(word.charAt(i));
	    		sb.append(str1);
	    		String str2=word.substring(i+1);
	    		perm(str2);
	    	}
	    }
	 
	

}
