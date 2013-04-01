import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class StringSort {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        StringSort st = new StringSort();
        st.findingAnagramsInArray();
    }

    public void findingAnagramsInArray() {
        String[] st = new String[5];
        st[0] = "ABC";
        st[1] = "MNO";
        st[2] = "PQR";
        st[3] = "ONM";
        st[4] = "BCA";

        HashMap mp = new HashMap();

        for (int i = 0; i < st.length; i++) {
            String value = st[i];
            String key = sortAlpha(st[i]);

            if (!mp.containsKey(key)) {
                ArrayList lt = new ArrayList();
                lt.add(value);
                mp.put(key, lt);
            } else {
            	ArrayList lt = (ArrayList) mp.get(key);
                lt.add(value);
                mp.put(key, lt);
            }
        }
       Iterator it =mp.keySet().iterator();
       
       while(it.hasNext())
       {
    	   String key=(String)it.next();
    	   ArrayList res=(ArrayList)mp.get(key);
    	   System.out.println(res);
    	   
       }
        
    }

    private String sortAlpha(String st) {
        char[] res = mergeSort(st.toCharArray());

        StringBuffer result = new StringBuffer();

        for (int i = 0; i < res.length; i++) {
            result.append(res[i]);
        }

        return result.toString();
    }

    private char[] mergeSort(char[] st) {
        int l = st.length;

        if (l == 1) {
            return st;
        }

        char[] st1 = new char[(l / 2) - 0];
        char[] st2 = new char[l - (l / 2)];

        for (int i = 0; i < st1.length; i++) {
            st1[i] = st[i];
        }

        for (int j = 0; j < st2.length; j++) {
            st2[j] = st[j + (l / 2)];
        }

        char[] tmp1 = mergeSort(st1);
        char[] tmp2 = mergeSort(st2);

        char[] res = merge(tmp1, tmp2);

        return res;
    }

    public char[] merge(char[] c1, char[] c2) {
        int l1 = c1.length;
        int l2 = c2.length;
        char[] res = new char[l1 + l2];
        int i = 0;
        int j = 0;
        int k = 0;

        while ((i < l1) && (j < l2)) {
            int c1a = (int) c1[i];
            int c2a = (int) c2[j];

            if (c1a < c2a) {
                res[k++] = c1[i++];
            } else {
                res[k++] = c2[j++];
            }
        }

        while (j < l2) {
            res[k++] = c2[j++];
        }

        while (i < l1) {
            res[k++] = c1[i++];
        }

        return res;
    }
}
