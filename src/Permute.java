public class Permute {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Permute pm = new Permute();
        pm.permute("ABCD");
    }

    public void permute(String word) {
        int c1 = 0;

        char[] wd = word.toCharArray();

        while (c1 < word.length()) {            
            char tmp = wd[word.length() - 1];
            System.out.println(wd);
            int c2 = word.length() - 1;

            while (c2 > 0) {
                wd[c2] = wd[c2 - 1];
                c2--;
            }

            wd[c2] = tmp;
            c1++;
        }
    }
    
    public void perm(char wd[])
    {
    	int l=wd.length;
    	if(l==1)
    	{
    		return;
    	}
    	
    }
}
