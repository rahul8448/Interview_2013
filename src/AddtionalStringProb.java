import java.util.HashMap;

import org.apache.poi.hssf.record.formula.functions.Char;

public class AddtionalStringProb {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddtionalStringProb asp = new AddtionalStringProb();
		// System.out.println(asp.uniqueChar(null));
		//char word[] = { 'R', 'A', 'H', 'U', 'L', '\0' };
		//asp.reverse(word);
		//asp.removeDuplicatesNoMemory("RAHULL");
		//System.out.println(asp.checkAnagrams("RAHULN", "LUHARM"));
		System.out.println(asp.replaceSpaces("RAHUL SHRAMA"));
	}

	public boolean uniqueChar(String word) {

		if (word == null)
			return true;

		HashMap map = new HashMap();
		for (int i = 0; i < word.length(); i++) {

			char c = word.charAt(i);
			int acii = (int) c;
			// Integer integer=new Integer(ascii);
			if (map.containsKey(c)) {
				return false;
			}

			else {
				map.put(c, acii);
			}
		}
		return true;
	}

	public String reverse(char str[]) {
		int len = 0;
		int pos = 0;
		while (true) {
			char c = str[pos];
			if (c == '\0')
				break;
			len++;
			pos++;

		}

		for (int i = 0; i <= len - 1; i++) {
			char tmp = str[i];
			str[i] = str[len - 1 - i];
			str[len - 1 - i] = tmp;

		}
		System.out.println(str);
		return str.toString();
	}

	public void removeDuplicatesNoMemory(String word) {
		int len = word.length();
        char tmp[]=new char[len];
        boolean dup[]=new boolean[len];
        int count=0;
        for (int i = 0; i < len; i++) {
        	if(dup[i]==true)
        	 continue;
        	char c1 = word.charAt(i);
			tmp[count]=c1;
			count++;
			for (int j = i + 1; j < len; j++) {
				char c2 = word.charAt(j);
				if (c2 == c1) {
				  dup[j]=true;
				}
			}

		}
        System.out.println(tmp);
		

	}
	
	public boolean checkAnagrams(String word1, String word2)
	{
	   if(word1.length()!=word2.length())
	   {
	       return false;
	   }
	   int tmp[]=new int[256];
	   

	   for(int i=0;i<word1.length();i++)
	   {
	       char c1=word1.charAt(i);
	       int pos=(char)c1;
	       int val=tmp[pos]; 
	       tmp[pos]=val+1;      
	   }

	   for(int j=0;j<word2.length();j++)
	   {
	        char c1=word2.charAt(j);
	        int pos1=(char)c1;
	        int val_1=tmp[pos1];
	        if(val_1==0)
	        {
	          return false;
	        }
	        else
	        {
	           val_1=val_1-1;
	           tmp[pos1]=val_1;  
	        }        
	   } 
	   return true;
	}
	
	public char[] replaceSpaces(String word)
	{
	   char tmp[]=word.toCharArray();
	   
	   int numOfSpaces=0;
	   
	   for(int i=0;i<word.length();i++)
	   {
	       char c=word.charAt(i);
	       if(c==' ')
	       {
	          numOfSpaces++; 
	       }
	   } 
	   if(numOfSpaces==0)
	    return tmp; 

	   char temp[]=new char[numOfSpaces*2+word.length()];
	   int k=0;
	   for(int j=0;j<word.length();j++)
	   {
	       
	       char c1=word.charAt(j);
	       if(c1==' ')
	       {
	          temp[k]='%';
	          temp[k+1]='2';
	          temp[k+2]='0';
	          k=k+3;         
	       }
	       else
	       {
	          temp[k]=tmp[j];
	          k++;  
	       }
	              
	   }
	   return temp;
	 
	}
}
