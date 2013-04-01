public class ReverseAString {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new ReverseAString().reverse("RRRR"));
        int a[]={1,2,3,4,5,6};
        int b[]={2,3,6,9,10};
        int tmp[]=new ReverseAString().merge(a, b);
        System.out.println(tmp);
        Object word[]={'a','B','B','B','A','A','a','a','a'};
        new ReverseAString().compute(word);
      }

    public String reverse(String s) {
        if (s.length() <= 1) {
            return s;
        }

        return reverse(s.substring(1)) + s.charAt(0);
        
    }

    public void compute(Object[] a)
    {
       int l=a.length;

       int ptr1=0;
       int ptr2=1;
       int count=0;
       char c=(Character)a[ptr1++];
       while(true)
       {         
         count=1;
         while(ptr1<l && c==(Character)a[ptr1++])
        	 count++;
         if(ptr1>=l)
         break;	 
         c=(Character)a[ptr1];
         a[ptr2]=count;
         ptr2=ptr2+2;         
       }
       a[ptr2++]=count;
       
       while(ptr2<l)
    	 a[ptr2++]=null;  
    }
    public int[] merge(int[] a, int[] b) {
        int la = a.length;
        int lb = b.length;
        int i = 0;
        int j = 0;
        int[] tmp = new int[la + lb];
        int pos = 0;

        while ((i < la) && (j < lb)) {
            if (a[i] < b[j]) {
                tmp[pos++] = a[i++];
            } else {
                tmp[pos++] = b[j++];
            }
        }

        while (i < la)
            tmp[pos++] = a[i++];

        while (j < lb)
            tmp[pos++] = b[j++];

        return tmp;
    }
}
