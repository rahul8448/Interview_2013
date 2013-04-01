public class SortingAndSearching {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	
    	SortingAndSearching sas=new SortingAndSearching();
    	int a1[]=new int[8];
    	a1[0]=1;
    	a1[1]=2;
    	a1[2]=3;
    	a1[3]=4;
    	a1[4]=5;
    	
    	int a2[]=new int[3];
    	a2[0]=3;
    	a2[1]=4;
    	a2[2]=5;
    	
    	sas.sortTwoArrays(a1, a2,5,3); 
    	
    	
    }

    public void sortTwoArrays(int[] a1, int[] a2,int numberOFElementsInFirstArray,int numberOFElementsInSecondArray) {
        //int len1 = numberOFElementsInFirstArray;
       
        int ptr1 = numberOFElementsInFirstArray-1;
        int ptr2 = numberOFElementsInSecondArray-1;
        int ptr3=numberOFElementsInFirstArray+numberOFElementsInSecondArray-1;
        
        while(ptr1>=0 && ptr2>=0)
        {
        	if(a1[ptr1]>a2[ptr2])
        	{
        		a1[ptr3--]=a1[ptr1--];
        	}
        	else
        	{
        		a1[ptr3--]=a2[ptr2--];
        	}
        }
        
        while(ptr2>=0)
        {
        	a1[ptr3--]=a2[ptr2--];
        }
        
        System.out.println(a1);

    }
}
